grammar Dart;

start: topLevelDefinition EOF;

// ------------------------------- Grammar Rules -------------------------------

// Chapter 8 - Variables

declaredIdentifier:
		COVARIANT? finalConstVarOrType identifier
	;

finalConstVarOrType:
		/*LATE?*/ FINAL type?
	|	CONST type?
	|	/*LATE?*/ varOrType
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

initializedIdentifier:
		identifier ('=' expression)?
	;

initializedIdentifierList:
		initializedIdentifier (',' initializedIdentifier)*
	;

// Chapter 9 - Functions

functionSignature:
	/*metadata*/ type? identifierNotFUNCTION formalParameterPart
	;

formalParameterPart:
	/*typeParameters?*/ formalParameterList
	;

//TODO: functionBodyPrefix

functionBody:
		/* '=>' expression */
	/*|	async?*/ '=>' expression ';'
	|	/*(async | async '*' | sync '*')?*/ block
	;

// TODO: Completar
block:
		'{' /* epsilon */  '}'
	;

// Chapter 9.2 - Formal Parameters

formalParameterList:
		'(' ')'
	|	'(' normalFormalParameters ','? ')'
	/*|	'(' normalFormalParameters ',' optionalOrNamedFormalParameters ')'
	|	'(' optionalOrNamedFormalParameters ')'*/
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
		/*metadata*/ functionFormalParameter
	|	/*metadata*/ fieldFormalParameter
	|	/*metadata*/ simpleFormalParameter
	;

functionFormalParameter:
		/*COVARIANT?*/ type? identifierNotFUNCTION formalParameterPart '?'?
    ;

simpleFormalParameter:
		declaredIdentifier
	|	/*COVARIANT?*/ identifier
	;

fieldFormalParameter
    :    finalConstVarOrType? THIS '.' identifier (formalParameterPart '?'?)?
    ;

defaultFormalParameter:
		normalFormalParameter ('=' expression)?
	;

defaultNamedParameter:
		/*REQUIRED?*/ normalFormalParameter ((':' | '=') expression)?
	;

// Usado com classe e mixin
/* typeWithParameters
       :    typeIdentifier typeParameters?
       ;*/

// Chapter 16 - Expressions

//TODO: Completar essa seção dps.
expression:
		/* epsilon */
	;

// Chapter 16.37 - Identifier Reference
// TODO: Completar essa seção dps.

identifierNotFUNCTION:
		IDENTIFIER
    /*|    ABSTRACT // Built-in identifier.
    |    AS // Built-in identifier.
    |    COVARIANT // Built-in identifier.
    |    DEFERRED // Built-in identifier.
    |    DYNAMIC // Built-in identifier.
    |    EXPORT // Built-in identifier.
    |    EXTERNAL // Built-in identifier.
    |    FACTORY // Built-in identifier.
    |    GET // Built-in identifier.
    |    IMPLEMENTS // Built-in identifier.
    |    IMPORT // Built-in identifier.
    |    INTERFACE // Built-in identifier.
    |    LATE // Built-in identifier.
    |    LIBRARY // Built-in identifier.
    |    MIXIN // Built-in identifier.
    |    OPERATOR // Built-in identifier.
    |    PART // Built-in identifier.
    |    REQUIRED // Built-in identifier.
    |    SET // Built-in identifier.
    |    STATIC // Built-in identifier.
    |    TYPEDEF // Built-in identifier.
    |    ASYNC // Not a built-in identifier.
    |    HIDE // Not a built-in identifier.
    |    OF // Not a built-in identifier.
    |    ON // Not a built-in identifier.
    |    SHOW // Not a built-in identifier.
    |    SYNC // Not a built-in identifier.
    |    { asyncEtcPredicate(getCurrentToken().getType()) }? (AWAIT|YIELD)*/
    ;

identifier:
		identifierNotFUNCTION
	/*|	FUNCTION */ // Built-in identifier that can be used as a type.
	;

// Chapter 18 - Libraries

topLevelDefinition:
         /*classDeclaration
    |    mixinDeclaration
    |    extensionDeclaration
    |    enumType
    |    typeAlias
    |    EXTERNAL functionSignature SEMICOLON
    |    EXTERNAL getterSignature SEMICOLON
    |    EXTERNAL setterSignature SEMICOLON
    |    EXTERNAL finalVarOrType identifierList SEMICOLON
    |    getterSignature functionBody
    |    setterSignature functionBody*/
	functionSignature functionBody
    /*|    (FINAL | CONST) type? staticFinalDeclarationList SEMICOLON
    |    LATE FINAL type? initializedIdentifierList SEMICOLON
    |    LATE? varOrType identifier (ASSIGN expression)?
         (COMMA initializedIdentifier)* SEMICOLON*/
    ;

// Chapter 19.1 - Static Types
//TODO: Completar essa seção dps.

type:
		/* epsilon */
	;

// ------------------------------- Lexer Rules -------------------------------

// TODO: Fazer essa seção apropriadamente. (A versão atual é só para testes simples)

// Reserved Words

CONST:
		'const'
	;

FINAL:
		'final'
	;

THIS:
		'this'
	;

VAR:
		'var'
	;

// Built-in identifiers

COVARIANT:
		'covariant'
	;

// Lexical tokens that are not words.

fragment
LETTER:
		'a' .. 'z'
	|	'A' .. 'Z'
	;

IDENTIFIER:
		LETTER+
	;

LBRACE:
		'{'
	;

RBRACE:
		'}'
	;

// TODO: entender essa bruxaria do channel(HIDDEN)
WS:
		(' ' | '\t' | '\r' | '\n')+
    	-> channel(HIDDEN)
    	/*{ skip(); }*/
	;
