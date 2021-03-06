grammar Dart;

start: topLevelDefinition* EOF;

// ------------------------------- Grammar Rules -------------------------------

// Chapter 8 - Variables

declaredIdentifier:
		COVARIANT? finalConstVarOrType identifier
	;

finalConstVarOrType:
		LATE? FINAL type?
	|	CONST type?
	|	LATE? varOrType
	;

// Usado em Declaration (Classes)
/*finalVarOrType:
		FINAL type?
	|	varOrType
	;*/

varOrType:
		VAR
	|	type
	;

initializedVariableDeclaration:
	declaredIdentifier ('=' expression)? (',' initializedIdentifier)*
	;

initializedIdentifier:
		identifier ('=' expression)?
	;

initializedIdentifierList:
		initializedIdentifier (',' initializedIdentifier)*
	;

// Chapter 9 - Functions

functionSignature:
	metadata type? identifierNotFUNCTION formalParameterPart
	;

formalParameterPart:
	typeParameters? formalParameterList
	;

// OBS: não coloquei functionBodyPrefix (regra no SDK) pois não era usada em nenhum lugar

functionBody:
		'=>' expression
	|	ASYNC? '=>' expression ';'
	|	(ASYNC | ASYNC '*' | SYNC '*')? block
	;

block:
		LBRACE statements  RBRACE
	;

// Chapter 9.2 - Formal Parameters

formalParameterList:
		'(' ')'
	|	'(' normalFormalParameters ','? ')'
	|	'(' normalFormalParameters ',' optionalOrNamedFormalParameters ')'
	|	'(' optionalOrNamedFormalParameters ')'
	;

normalFormalParameters:
		normalFormalParameter (',' normalFormalParameter)*
	;

optionalOrNamedFormalParameters:
		optionalPositionalFormalParameters
	|	namedFormalParameters
	;

optionalPositionalFormalParameters:
		'[' defaultFormalParameter (',' defaultFormalParameter)* ','? ']'
	;

namedFormalParameters:
		LBRACE defaultNamedParameter (',' defaultNamedParameter)* ','? RBRACE
	;

// Chapter 9.2.1 - Required Formals

// "Simplifiquei" a regra do manual.
normalFormalParameter:
		metadata functionFormalParameter
	|	metadata fieldFormalParameter
	|	metadata simpleFormalParameter
	;

functionFormalParameter:
		COVARIANT? type? identifierNotFUNCTION formalParameterPart '?'?
	;

simpleFormalParameter:
		declaredIdentifier
	|	COVARIANT? identifier
	;

fieldFormalParameter:
		finalConstVarOrType? THIS '.' identifier (formalParameterPart '?'?)?
	;

defaultFormalParameter:
		normalFormalParameter ('=' expression)?
	;

defaultNamedParameter:
		REQUIRED? normalFormalParameter ((':' | '=') expression)?
	;

// Usado com classe e mixin
/* typeWithParameters
	   :	typeIdentifier typeParameters?
	   ;*/

// Chapter 13 - Enums

enumType:
		ENUM typeIdentifier LBRACE enumEntry (',' enumEntry)* (',')? RBRACE
	;

// Chapter 14 - Generics

typeParameter:
		metadata typeIdentifier (EXTENDS typeNotVoid)?
	;

typeParameters:
		'<' typeParameter (',' typeParameter)* '>'
	;

enumEntry:
		metadata identifier
	;

// Chapter 15 - Metadata

metadata:
		('@' metadatum)*
	;

metadatum:
		constructorDesignation arguments
	|	identifier
	|	qualifiedName
	;

// Chapter 16 - Expressions

//TODO: Descomentar trechos dessa seção.
expression:
		functionExpression
	|	throwExpression
	|	assignableExpression assignmentOperator expression
	|	conditionalExpression // Essa parte tbm identifica o lado direito de uma atribuição, chamada de funções...
	|	cascade
	;

expressionWithoutCascade
	:	functionExpressionWithoutCascade
	|	throwExpressionWithoutCascade
	|	assignableExpression assignmentOperator expressionWithoutCascade
	|	conditionalExpression
	;

expressionList
	:	expression (',' expression)*
	;

primary:
		thisExpression
	|	SUPER unconditionalAssignableSelector
	|	constObjectExpression
	|	newExpression
	// |	constructorInvocation
	|	functionPrimary
	|	'(' expression ')'
	|	literal
	|	identifier
	;

// Chapter 16.3 - Constants

literal
	:	nullLiteral
	|	booleanLiteral
	|	numericLiteral
	|	stringLiteral
	/*|	symbolLiteral
	|	setOrMapLiteral
	|	listLiteral*/
	;

// Chapter 16.4 - Null

nullLiteral:
		NULL
	;

// Chapter 16.5 - Numbers

numericLiteral:
		NUMBER
	|	HEX_NUMBER
	;

// Chapter 16.6 - Booleans

booleanLiteral:
		TRUE
	|	FALSE
	;

// Chapter 16.7 - Strings

stringLiteral:
		(multiLineString | singleLineString)+
	;

// Chapter 16.8 - Symbols
// TODO: Descomentar
/*symbolLiteral
	:	'#' (operator | (identifier ('.' identifier)*))
	;*/

// Chapter 16.9 - Lists
// TODO: Descomentar
/*listLiteral
	: CONST? typeArguments? '[' elements? ']'
	;*/

// Chapter 16.10 - Maps
// Maps & Sets são tratados da mesma maneira no SDK :|
// TODO: Descomentar
/*setOrMapLiteral
	: CONST? typeArguments? LBRACE elements? RBRACE
	;

element
	: expressionElement
	| mapElement
	| spreadElement
	| ifElement
	| forElement
	;

expressionElement
	: expression
	;

mapElement
	: expression ':' expression
	;

spreadElement
	: ('...' | '...?') expression
	;

ifElement
	: IF '(' expression ')' element (ELSE element)?
	;

forElement
	: AWAIT? FOR '(' forLoopParts ')' element
	;*/

// Chapter 16.12 - Throw

throwExpression:
		THROW expression
	;

throwExpressionWithoutCascade:
		THROW expressionWithoutCascade
	;

// Chapter 16.13 - Function Expressions

functionExpression:
		formalParameterPart functionExpressionBody
	;

functionExpressionBody:
		'=>' { startNonAsyncFunction(); } expression { endFunction(); }
	|	ASYNC '=>' { startAsyncFunction(); } expression { endFunction(); }
	;

// functionExpressionBodyPrefix não era usada por nenhuma regra
// functionExpressionBodyPrefix:
// 	ASYNC? '=>'
//	 ;

functionExpressionWithoutCascade:
		formalParameterPart functionExpressionWithoutCascadeBody
	;

functionExpressionWithoutCascadeBody:
		'=>' { startNonAsyncFunction(); }
		expressionWithoutCascade { endFunction(); }
	|	ASYNC '=>' { startAsyncFunction(); }
		expressionWithoutCascade { endFunction(); }
	;


// 	TODO: Qual seria um exemplo de functionPrimary?
functionPrimary:
		formalParameterPart functionPrimaryBody
	;

functionPrimaryBody:
		{ startNonAsyncFunction(); } block { endFunction(); }
	|	(ASYNC | ASYNC '*' | SYNC '*')
		 { startAsyncFunction(); } block { endFunction(); }
	;

// functionPrimaryBodyPrefix não era usada por nenhuma regra
// functionPrimaryBodyPrefix
//	 : (ASYNC | ASYNC '*' | SYNC '*')? LBRACE
//	 ;

// Chapter 16.14 - This

thisExpression:
		THIS
	;

// Chapter 16.15.1 - New

newExpression:
		NEW constructorDesignation arguments
	;

// Chapter 16.15.2 - Const

constObjectExpression:
		CONST constructorDesignation arguments
	;

// Chapter 16.17.1 - Actual Arguments Lists

arguments
	:	'(' (argumentList ','?)? ')'
	;

argumentList
	:	namedArgument (',' namedArgument)*
	|	expressionList (',' namedArgument)*
	;

namedArgument
	:	label expression
	;

// Chapter 16.21.2 - Cascaded Invocations

cascade
	:	 cascade '..' cascadeSection
	|	 conditionalExpression ('?..' | '..') cascadeSection
	;

cascadeSection
	:	cascadeSelector cascadeSectionTail
	;

cascadeSelector
	:	'[' expression ']'
	|	identifier
	;

cascadeSectionTail
	:	cascadeAssignment
	|	selector* (assignableSelector cascadeAssignment)?
	;

cascadeAssignment
	:	assignmentOperator expressionWithoutCascade
	;

// Chapter 16.23 - Assignment

assignmentOperator:
		'='
	|	compoundAssignmentOperator
	;

compoundAssignmentOperator:
		'*='
	|	'/='
	|	'~/='
	|	'%='
	|	'+='
	|	'-='
	|	'<<='
	|	'>' '>' '>' '='
	|	'>' '>' '='
	|	'&='
	|	'^='
	|	'|='
	|	'??='
	;

// Chapter 16.24 - Conditional

conditionalExpression:
		ifNullExpression
		('?' expressionWithoutCascade ':' expressionWithoutCascade)?
	;

// Chapter 16.25 - If-null Expressions

ifNullExpression:
		logicalOrExpression ('??' logicalOrExpression)*
	;

// Chapter 16.26 - Logical Boolean Expressions

logicalOrExpression:
		logicalAndExpression ('||' logicalAndExpression)*
	;

logicalAndExpression:
		equalityExpression ('&&' equalityExpression)*
	;

// Chapter 16.27 - Equality

equalityExpression:
		relationalExpression (equalityOperator relationalExpression)?
	|	SUPER equalityOperator relationalExpression
	;

equalityOperator:
		'=='
	|	'!='
	;

// Chapter 16.28 - Relational Expressions

// TODO: Descomentar
relationalExpression:
		bitwiseOrExpression
		(typeTest | typeCast | relationalOperator bitwiseOrExpression)?
	|	SUPER relationalOperator bitwiseOrExpression
	;

// TODO: Pq foi definido assim?
relationalOperator:
		'>' '='
	|	'>'
	|	'<='
	|	'<'
	;

// Chapter 16.29 - Bitwise Expressions

bitwiseOrExpression:
		bitwiseXorExpression ('|' bitwiseXorExpression)*
	|	SUPER ('|' bitwiseXorExpression)+
	;

bitwiseXorExpression:
		bitwiseAndExpression ('^' bitwiseAndExpression)*
	|	SUPER ('^' bitwiseAndExpression)+
	;

bitwiseAndExpression:
		shiftExpression ('&' shiftExpression)*
	|	SUPER ('&' shiftExpression)+
	;

bitwiseOperator:
		'&'
	|	'^'
	|	'|'
	;

// Chapter 16.30 - Shift

shiftExpression:
		additiveExpression (shiftOperator additiveExpression)*
	|	SUPER (shiftOperator additiveExpression)+
	;

shiftOperator:
		'<<'
	|	'>' '>' '>'
	|	'>' '>'
	;

// Chapter 16.31 - Additive Expressions

additiveExpression:
		multiplicativeExpression (additiveOperator multiplicativeExpression)*
	|	SUPER (additiveOperator multiplicativeExpression)+
	;

additiveOperator:
		'+'
	|	'-'
	;

// Chapter 16.32 - Multiplicative Expressions

multiplicativeExpression:
		unaryExpression (multiplicativeOperator unaryExpression)*
	|	SUPER (multiplicativeOperator unaryExpression)+
	;

multiplicativeOperator:
		'*'
	|	'/'
	|	'%'
	|	'~/'
	;

// Chapter 16.33 - Unary Expressions

// TODO: Descomentar
unaryExpression:
		prefixOperator unaryExpression
	|	awaitExpression
	|	postfixExpression
	|	(minusOperator | tildeOperator) SUPER
	|	incrementOperator assignableExpression
	;

prefixOperator:
		minusOperator
	|	negationOperator
	|	tildeOperator
	;

minusOperator:
		'-'
	;

negationOperator:
		'!'
	;

tildeOperator:
		'~'
	;

// Chapter 16.34 - Await Expressions

awaitExpression:
		AWAIT unaryExpression
	;

// Chapter 16.35 - Postfix Expressions

// Chamada de função passa especificamente por aqui
postfixExpression
	:	assignableExpression postfixOperator
	|	primary selector*
	;

postfixOperator
	:	incrementOperator
	;

selector
	:	'!'
	|	assignableSelector
	|	argumentPart
	;

argumentPart
	:	typeArguments? arguments
	;

incrementOperator
	:	'++'
	|	'--'
	;


// Chapter 16.36 - Assignable Expressions

assignableExpression:
		SUPER unconditionalAssignableSelector
	|	primary assignableSelectorPart
	|	identifier
	;

assignableSelectorPart:
		selector* assignableSelector
	;

unconditionalAssignableSelector:
		'[' expression ']'
	|	'.' identifier
	;

assignableSelector:
		unconditionalAssignableSelector
	|	'?.' identifier
	|	'?' '[' expression ']'
	;

// TODO: O que é uri?
// Not used in the specification (needed here for <uri>).
stringLiteralWithoutInterpolation:
		singleLineStringWithoutInterpolation+
	;

// Chapter 16.37 - Identifier Reference

identifierNotFUNCTION:
		IDENTIFIER
	|	ABSTRACT // Built-in identifier.
	|	AS // Built-in identifier.
	|	COVARIANT // Built-in identifier.
	|	DEFERRED // Built-in identifier.
	|	DYNAMIC // Built-in identifier.
	|	EXPORT // Built-in identifier.
	|	EXTERNAL // Built-in identifier.
	|	FACTORY // Built-in identifier.
	|	GET // Built-in identifier.
	|	IMPLEMENTS // Built-in identifier.
	|	IMPORT // Built-in identifier.
	|	INTERFACE // Built-in identifier.
	|	LATE // Built-in identifier.
	|	LIBRARY // Built-in identifier.
	|	MIXIN // Built-in identifier.
	|	OPERATOR // Built-in identifier.
	|	PART // Built-in identifier.
	|	REQUIRED // Built-in identifier.
	|	SET // Built-in identifier.
	|	STATIC // Built-in identifier.
	|	TYPEDEF // Built-in identifier.
	|	ASYNC // Not a built-in identifier.
	|	HIDE // Not a built-in identifier.
	|	OF // Not a built-in identifier.
	|	ON // Not a built-in identifier.
	|	SHOW // Not a built-in identifier.
	|	SYNC // Not a built-in identifier.
	|	/*{ asyncEtcPredicate(getCurrentToken().getType()) }?*/ (AWAIT|YIELD)
	;

identifier:
		identifierNotFUNCTION
	|	FUNCTION  // Built-in identifier that can be used as a type.
	;

qualifiedName:
		typeIdentifier '.' identifier
	|	typeIdentifier '.' typeIdentifier '.' identifier
	;

typeIdentifier
	:	IDENTIFIER
	|	DYNAMIC // Built-in identifier that can be used as a type.
	|	ASYNC // Not a built-in identifier.
	|	HIDE // Not a built-in identifier.
	|	OF // Not a built-in identifier.
	|	ON // Not a built-in identifier.
	|	SHOW // Not a built-in identifier.
	|	SYNC // Not a built-in identifier.
	|	/*{ asyncEtcPredicate(getCurrentToken().getType()) }?*/ (AWAIT|YIELD)
	;

// Chapter 16.38 - Type Test

typeTest:
		isOperator typeNotVoid
	;

isOperator:
		IS '!'?
	;

// Chapter 16.39 - Type Cast

typeCast:
		asOperator typeNotVoid
	;

asOperator:
		AS
	;

// Chapter 17 - Statements

statements:
		statement*
	;

statement:
		label* nonLabelledStatement
	;

//TODO: FALTA OTAVIO AJEITAR
nonLabelledStatement:
		block
	|	localVariableDeclaration
	|	forStatement
	|	whileStatement
	|	doStatement
	|	switchStatement
	|	ifStatement
	|	rethrowStatement
	|	tryStatement
	|	breakStatement
	|	continueStatement
	|	returnStatement
	|	localFunctionDeclaration
	|	assertStatement
	|	yieldStatement
	|	yieldEachStatement
	|	expressionStatement
	;

// Chapter 17.2 - Expression Statements

expressionStatement:
		expression? ';'
	;

// Chapter 17.3 - Local Variable Declaration

//TODO: RETIRAR METADATA?
localVariableDeclaration
	:	metadata initializedVariableDeclaration ';'
	;

// Chapter 17.4 - Local Function Declaration

//TODO: RETIRAR METADATA?
localFunctionDeclaration
    :    metadata functionSignature functionBody
    ;

// Chapter 17.5 - If

ifStatement:
		IF '(' expression ')' statement (ELSE statement)?
	;

// Chapter 17.6 - For

forStatement
    :    AWAIT? FOR '(' forLoopParts ')' statement
    ;

forLoopParts
    :    metadata declaredIdentifier IN expression
    |    metadata identifier IN expression
    |    forInitializerStatement expression? ';' expressionList?
    ;

// The localVariableDeclaration cannot be CONST, but that can
// be enforced in a later phase, and the grammar allows it.
forInitializerStatement
    :    localVariableDeclaration
    |    expression? ';'
    ;

// Chapter 17.7 - While

whileStatement
    :    WHILE '(' expression ')' statement
    ;

// Chapter 17.8 - Do

doStatement
    :    DO statement WHILE '(' expression ')' ';'
    ;

// Chapter 17.9 - Switch

switchStatement
    :    SWITCH '(' expression ')' LBRACE switchCase* defaultCase? RBRACE
    ;

switchCase
    :    label* CASE expression ':' statements
    ;

defaultCase
    :    label* DEFAULT ':' statements
    ;

// Chapter 17.10 - Rethrow

rethrowStatement
    :    RETHROW ';'
    ;

// Chapter 17.11 - Try

tryStatement
    :    TRY block (onPart+ finallyPart? | finallyPart)
    ;

onPart
    :    catchPart block
    |    ON typeNotVoid catchPart? block
    ;

catchPart
    :    CATCH '(' identifier (',' identifier)? ')'
    ;

finallyPart
    :    FINALLY block
    ;

// Chapter 17.12 - Return

returnStatement:
		RETURN expression? ';'
	;

// Chapter 17.13 - Labels

label:
		identifier ':'
	;

// 17.14 - Break

breakStatement
  : 'break' identifier? ';'
  ;

// 17.13 - Continue

continueStatement
  : 'continue' identifier? ';'
  ;

// 17.16 - Yield and Yield-Each

yieldStatement
  : 'yield' expression ';'
  ;

yieldEachStatement
  : 'yield*' expression ';'
  ;

// 17.17 Assert

assertStatement
  : assertion ';'
  ;

assertion
  : 'assert' '(' expression (',' expression )? ','? ')'
  ;

// Chapter 18 - Libraries

topLevelDefinition:
		 /*classDeclaration
	|	mixinDeclaration
	|	extensionDeclaration*/
	|	enumType
	|	typeAlias
	/*|	EXTERNAL functionSignature ';'
	|	EXTERNAL getterSignature ';'
	|	EXTERNAL setterSignature ';'
	|	EXTERNAL finalVarOrType identifierList ';'
	|	getterSignature functionBody
	|	setterSignature functionBody*/
	functionSignature functionBody
	//|	(FINAL | CONST) type? staticFinalDeclarationList ';'
	|	LATE FINAL type? initializedIdentifierList ';' // TODO: Variavel global deu ruim.
	|	LATE? varOrType identifier ('=' expression)?
		 (',' initializedIdentifier)* ';'
	;

// Chapter 19.1 - Static Types
//TODO: Completar essa seção dps.

type:
		functionType '?'?
	|	typeNotFunction
	;

typeNotVoid:
		functionType '?'?
	|	typeNotVoidNotFunction
	;

typeNotFunction:
		typeNotVoidNotFunction
	|	VOID
	;

typeNotVoidNotFunction:
		typeName typeArguments? '?'?
	|	FUNCTION '?'?
	;

typeName:
		typeIdentifier ('.' typeIdentifier)?
	;

typeArguments:
		'<' typeList '>'
	;

typeList:
		type (',' type)*
	;

typeNotVoidNotFunctionList:
		typeNotVoidNotFunction (',' typeNotVoidNotFunction)*
	;

//TODO: Testar essa regra.
typeAlias:
		TYPEDEF typeIdentifier typeParameters? '=' functionType ';'
	|	TYPEDEF functionTypeAlias
	;

functionTypeAlias:
		functionPrefix formalParameterPart ';'
	;

functionPrefix:
		type identifier
	|	identifier
	;

functionTypeTail:
		FUNCTION typeParameters? parameterTypeList
	;

functionTypeTails:
		functionTypeTail '?'? functionTypeTails
	|	functionTypeTail
	;

functionType:
		functionTypeTails
	|	typeNotFunction functionTypeTails
	;

parameterTypeList:
		'(' ')'
	|	'(' normalParameterTypes ',' optionalParameterTypes ')'
	|	'(' normalParameterTypes ','? ')'
	|	'(' optionalParameterTypes ')'
	;

normalParameterTypes:
		normalParameterType (',' normalParameterType)*
	;

normalParameterType:
		typedIdentifier
	|	type
	;

optionalParameterTypes:
		optionalPositionalParameterTypes
	|	namedParameterTypes
	;

optionalPositionalParameterTypes:
		'[' normalParameterTypes ','? ']'
	;

namedParameterTypes:
		LBRACE namedParameterType (',' namedParameterType)* ','? RBRACE
	;

namedParameterType:
		REQUIRED? typedIdentifier
	;

typedIdentifier:
		type identifier
	;

constructorDesignation:
		typeIdentifier
	|	qualifiedName
	|	typeName typeArguments ('.' identifier)?
	;

// TODO: O que é uri?
// Not used in the specification (needed here for <uri>).
singleLineStringWithoutInterpolation
	:	RAW_SINGLE_LINE_STRING
	|	SINGLE_LINE_STRING_DQ_BEGIN_END
	|	SINGLE_LINE_STRING_SQ_BEGIN_END
	;
singleLineString
	:	RAW_SINGLE_LINE_STRING
	|	SINGLE_LINE_STRING_SQ_BEGIN_END
	|	SINGLE_LINE_STRING_SQ_BEGIN_MID expression
		(SINGLE_LINE_STRING_SQ_MID_MID expression)*
		SINGLE_LINE_STRING_SQ_MID_END
	|	SINGLE_LINE_STRING_DQ_BEGIN_END
	|	SINGLE_LINE_STRING_DQ_BEGIN_MID expression
		(SINGLE_LINE_STRING_DQ_MID_MID expression)*
		SINGLE_LINE_STRING_DQ_MID_END
	;
multiLineString
	:	RAW_MULTI_LINE_STRING
	|	MULTI_LINE_STRING_SQ_BEGIN_END
	|	MULTI_LINE_STRING_SQ_BEGIN_MID expression
		(MULTI_LINE_STRING_SQ_MID_MID expression)*
		MULTI_LINE_STRING_SQ_MID_END
	|	MULTI_LINE_STRING_DQ_BEGIN_END
	|	MULTI_LINE_STRING_DQ_BEGIN_MID expression
		(MULTI_LINE_STRING_DQ_MID_MID expression)*
		MULTI_LINE_STRING_DQ_MID_END
	;

// ------------------------------- Lexer Rules -------------------------------

fragment
LETTER:
		'a' .. 'z'
	|	'A' .. 'Z'
	;
fragment
DIGIT:
		'0' .. '9'
	;
fragment
EXPONENT:
		('e' | 'E') ('+' | '-')? DIGIT+
	;
fragment
HEX_DIGIT:
		('a' | 'b' | 'c' | 'd' | 'e' | 'f')
	|	('A' | 'B' | 'C' | 'D' | 'E' | 'F')
	|	DIGIT
	;

// Reserved words.

ASSERT:
		'assert'
	;
BREAK:
		'break'
	;
CASE:
		'case'
	;
CATCH:
		'catch'
	;
CLASS:
		'class'
	;
CONST:
		'const'
	;
CONTINUE:
		'continue'
	;
DEFAULT:
		'default'
	;
DO:
		'do'
	;
ELSE:
		'else'
	;
ENUM:
		'enum'
	;
EXTENDS:
		'extends'
	;
FALSE:
		'false'
	;
FINAL:
		'final'
	;
FINALLY:
		'finally'
	;
FOR:
		'for'
	;
IF:
		'if'
	;
IN:
		'in'
	;
IS:
		'is'
	;
NEW:
		'new'
	;
NULL:
		'null'
	;
RETHROW:
		'rethrow'
	;
RETURN:
		'return'
	;
SUPER:
		'super'
	;
SWITCH:
		'switch'
	;
THIS:
		'this'
	;
THROW:
		'throw'
	;
TRUE:
		'true'
	;
TRY:
		'try'
	;
VAR:
		'var'
	;
VOID:
		'void'
	;
WHILE:
		'while'
	;
WITH:
		'with'
	;


// Built-in identifiers.

ABSTRACT:
		'abstract'
	;
AS:
		'as'
	;
COVARIANT:
		'covariant'
	;
DEFERRED:
		'deferred'
	;
DYNAMIC:
		'dynamic'
	;
EXPORT:
		'export'
	;
EXTENSION:
		'extension'
	;
EXTERNAL:
		'external'
	;
FACTORY:
		'factory'
	;
FUNCTION:
		'Function'
	;
GET:
		'get'
	;
IMPLEMENTS:
		'implements'
	;
IMPORT:
		'import'
	;
INTERFACE:
		'interface'
	;
LATE:
		'late'
	;
LIBRARY:
		'library'
	;
OPERATOR:
		'operator'
	;
MIXIN:
		'mixin'
	;
PART:
		'part'
	;
REQUIRED:
		'required'
	;
SET:
		'set'
	;
STATIC:
		'static'
	;
TYPEDEF:
		'typedef'
	;
// "Contextual keywords".
AWAIT:
		'await'
	;
YIELD:
		'yield'
	;

// Other words used in the grammar.

ASYNC:
		'async'
	;
HIDE:
		'hide'
	;
OF:
		'of'
	;
ON:
		'on'
	;
SHOW:
		'show'
	;
SYNC:
		'sync'
	;

// Lexical tokens that are not words.
NUMBER:
		DIGIT+ '.' DIGIT+ EXPONENT?
	|	DIGIT+ EXPONENT?
	|	'.' DIGIT+ EXPONENT?
	;
HEX_NUMBER:
		'0x' HEX_DIGIT+
	|	'0X' HEX_DIGIT+
	;
RAW_SINGLE_LINE_STRING:
		'r' '\'' (~('\'' | '\r' | '\n'))* '\''
	|	'r' '"' (~('"' | '\r' | '\n'))* '"'
	;
RAW_MULTI_LINE_STRING:
		'r' '"""' (.)*? '"""'
	|	'r' '\'\'\'' (.)*? '\'\'\''
	;

fragment
SIMPLE_STRING_INTERPOLATION:
		'$' IDENTIFIER_NO_DOLLAR
	;

fragment
ESCAPE_SEQUENCE:
		'\\n'
	|	'\\r'
	|	'\\b'
	|	'\\t'
	|	'\\v'
	|	'\\x' HEX_DIGIT HEX_DIGIT
	|	'\\u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
	|	'\\u{' HEX_DIGIT_SEQUENCE '}'
	;

fragment
HEX_DIGIT_SEQUENCE:
		HEX_DIGIT HEX_DIGIT? HEX_DIGIT?
		 HEX_DIGIT? HEX_DIGIT? HEX_DIGIT?
	;

fragment
STRING_CONTENT_COMMON:
		~('\\' | '\'' | '"' | '$' | '\r' | '\n')
	|	ESCAPE_SEQUENCE
	|	'\\' ~('n' | 'r' | 'b' | 't' | 'v' | 'x' | 'u' | '\r' | '\n')
	|	SIMPLE_STRING_INTERPOLATION
	;

fragment
STRING_CONTENT_SQ:
		STRING_CONTENT_COMMON
	|	'"'
	;

SINGLE_LINE_STRING_SQ_BEGIN_END:
		'\'' STRING_CONTENT_SQ* '\''
	;

SINGLE_LINE_STRING_SQ_BEGIN_MID:
		'\'' STRING_CONTENT_SQ* '${' /*{ enterBraceSingleQuote(); }*/
	;

SINGLE_LINE_STRING_SQ_MID_MID:
		/*{ currentBraceLevel(BRACE_SINGLE) }?
		 { exitBrace(); }*/ '}' STRING_CONTENT_SQ* '${'
		 /*{ enterBraceSingleQuote(); }*/
	;

SINGLE_LINE_STRING_SQ_MID_END:
		/*{ currentBraceLevel(BRACE_SINGLE) }?
		 { exitBrace(); }*/ '}' STRING_CONTENT_SQ* '\''
	;

fragment
STRING_CONTENT_DQ:
		STRING_CONTENT_COMMON
	|	'\''
	;

SINGLE_LINE_STRING_DQ_BEGIN_END:
		'"' STRING_CONTENT_DQ* '"'
	;

SINGLE_LINE_STRING_DQ_BEGIN_MID:
		'"' STRING_CONTENT_DQ* '${' /*{ enterBraceDoubleQuote(); }*/
	;

SINGLE_LINE_STRING_DQ_MID_MID:
		/*{ currentBraceLevel(BRACE_DOUBLE) }?
		 { exitBrace(); }*/ '}' STRING_CONTENT_DQ* '${'
		 /*{ enterBraceDoubleQuote(); }*/
	;

SINGLE_LINE_STRING_DQ_MID_END:
		/*{ currentBraceLevel(BRACE_DOUBLE) }?
		 { exitBrace(); }*/ '}' STRING_CONTENT_DQ* '"'
	;

fragment
QUOTES_SQ:

	|	'\''
	|	'\'\''
	;

// Read string contents, which may be almost anything, but stop when seeing
// '\'\'\'' and when seeing '${'. We do this by allowing all other
// possibilities including escapes, simple interpolation, and fewer than
// three '\''.
fragment
STRING_CONTENT_TSQ:
		QUOTES_SQ
		 (STRING_CONTENT_COMMON | '"' | '\r' | '\n' | '\\\r' | '\\\n')
	;

MULTI_LINE_STRING_SQ_BEGIN_END:
		'\'\'\'' STRING_CONTENT_TSQ* '\'\'\''
	;

MULTI_LINE_STRING_SQ_BEGIN_MID:
		'\'\'\'' STRING_CONTENT_TSQ* QUOTES_SQ '${'
		 /*{ enterBraceThreeSingleQuotes(); }*/
	;

MULTI_LINE_STRING_SQ_MID_MID:
		/*{ currentBraceLevel(BRACE_THREE_SINGLE) }?
		 { exitBrace(); }*/ '}' STRING_CONTENT_TSQ* QUOTES_SQ '${'
		 /*{ enterBraceThreeSingleQuotes(); }*/
	;

MULTI_LINE_STRING_SQ_MID_END:
		/*{ currentBraceLevel(BRACE_THREE_SINGLE) }?
		 { exitBrace(); }*/ '}' STRING_CONTENT_TSQ* '\'\'\''
	;

fragment
QUOTES_DQ:

	|	'"'
	|	'""'
	;

// Read string contents, which may be almost anything, but stop when seeing
// '"""' and when seeing '${'. We do this by allowing all other possibilities
// including escapes, simple interpolation, and fewer-than-three '"'.
fragment
STRING_CONTENT_TDQ:
		QUOTES_DQ
		 (STRING_CONTENT_COMMON | '\'' | '\r' | '\n' | '\\\r' | '\\\n')
	;

MULTI_LINE_STRING_DQ_BEGIN_END:
		'"""' STRING_CONTENT_TDQ* '"""'
	;

MULTI_LINE_STRING_DQ_BEGIN_MID:
		'"""' STRING_CONTENT_TDQ* QUOTES_DQ '${'
		 /*{ enterBraceThreeDoubleQuotes(); }*/
	;

MULTI_LINE_STRING_DQ_MID_MID:
		/*{ currentBraceLevel(BRACE_THREE_DOUBLE) }?
		 { exitBrace(); }*/ '}' STRING_CONTENT_TDQ* QUOTES_DQ '${'
		 /*{ enterBraceThreeDoubleQuotes(); }*/
	;

MULTI_LINE_STRING_DQ_MID_END:
		/*{ currentBraceLevel(BRACE_THREE_DOUBLE) }?
		 { exitBrace(); }*/ '}' STRING_CONTENT_TDQ* '"""'
	;

LBRACE:
		'{' /*{ enterBrace(); }*/
	;

RBRACE:
		/*{ currentBraceLevel(BRACE_NORMAL) }? { exitBrace(); }*/ '}'
	;

fragment
IDENTIFIER_START_NO_DOLLAR:
		LETTER
	|	'_'
	;

fragment
IDENTIFIER_PART_NO_DOLLAR:
		IDENTIFIER_START_NO_DOLLAR
	|	DIGIT
	;

fragment
IDENTIFIER_NO_DOLLAR:
		IDENTIFIER_START_NO_DOLLAR IDENTIFIER_PART_NO_DOLLAR*
	;

fragment
IDENTIFIER_START:
		IDENTIFIER_START_NO_DOLLAR
	|	'$'
	;

fragment
IDENTIFIER_PART:
		IDENTIFIER_START
	|	DIGIT
	;

SCRIPT_TAG:
		'#!' (~('\r' | '\n'))* NEWLINE
	;

IDENTIFIER:
		IDENTIFIER_START IDENTIFIER_PART*
	;

SINGLE_LINE_COMMENT:
		'//' (~('\r' | '\n'))* NEWLINE?
		 -> skip
	;

MULTI_LINE_COMMENT:
		'/*' (MULTI_LINE_COMMENT | .)*? '*/'
		 -> skip
	;

fragment
NEWLINE:
		('\r' | '\n' | '\r\n')
	;

WS:
		(' ' | '\t' | '\r' | '\n')+
		-> skip
	;
