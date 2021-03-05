// Copyright (c) 2017, the Dart project authors.  Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

// CHANGES:
//
// v0.12 (82403371ac00ddf004be60fa7b705474d2864509) Cf. language issue #1341:
// correct `metadata`. Change `qualifiedName` such that it only includes the
// cases with a DOT; the remaining case is added where `qualifiedName` is used.
//
// v0.11 (67c703063d5b68c9e132edbaf34dfe375851f5a6) Corrections, mainly:
// `fieldFormalParameter` now allows `?` on the parameter type; cascade was
// reorganized in the spec, it is now reorganized similarly here; `?` was
// removed from argumentPart (null-aware invocation was never added).
//
// v0.10 (8ccdb9ae796d543e4ad8f339c847c02b09018d2d) Simplify grammar by making
// `constructorInvocation` an alternative in `primary`.
//
// v0.9 (f4d7951a88e1b738e22b768c3bc72bf1a1062365) Introduce abstract and
// external variables.
//
// v0.8 (a9ea9365ad8a3e3b59115bd889a55b6aa2c5a5fa) Change null-aware
// invocations of `operator []` and `operator []=` to not have a period.
//
// v0.7 (6826faf583f6a543b1a0e2e85bd6a8042607ce00) Introduce extension and
// mixin declarations. Revise rules about string literals and string
// interpolation. Reorganize "keywords" (built-in identifiers, reserved words,
// other words that are specified in the grammar and not parsed as IDENTIFIER)
// into explicitly marked groups. Change the cascade syntax to be
// compositional.
//
// v0.6 (a58052974ec2b4b334922c5227b043ed2b9c2cc5) Introduce syntax associated
// with null safety.
//
// v0.5 (56793b3d4714d4818d855a72074d5295489aef3f) Stop treating `ASYNC` as a
// conditional reserved word (only `AWAIT` and `YIELD` get this treatment).
//
// v0.4 Added support for 'unified collections' (spreads and control flow
// in collection literals).
//
// v0.3 Updated to use ANTLR v4 rather than antlr3.
//
// v0.2 Changed top level variable declarations to avoid redundant and
// misleading occurrence of (FINAL|CONST).
//
// v0.1 First version available in the SDK github repository. Covers the
// Dart language as specified in the language specification based on the
// many grammar rule snippets. That grammar was then adjusted to remove
// known issues (e.g., misplaced metadata) and to resolve ambiguities.

grammar Dart;

@parser::header{
import java.util.Stack;
}

@lexer::header{
import java.util.Stack;
}

@parser::members {
  static String filePath = null;
  static boolean errorHasOccurred = false;

  /// Must be invoked before the first error is reported for a library.
  /// Will print the name of the library and indicate that it has errors.
  static void prepareForErrors() {
    errorHasOccurred = true;
    System.err.println("Syntax error in " + filePath + ":");
  }

  /// Parse library, return true if success, false if errors occurred.
  public boolean parseLibrary(String filePath) throws RecognitionException {
    this.filePath = filePath;
    errorHasOccurred = false;
    libraryDefinition();
    return !errorHasOccurred;
  }

  // Enable the parser to treat AWAIT/YIELD as keywords in the body of an
  // `async`, `async*`, or `sync*` function. Access via methods below.
  private Stack<Boolean> asyncEtcAreKeywords = new Stack<Boolean>();
  { asyncEtcAreKeywords.push(false); }

  // Use this to indicate that we are now entering an `async`, `async*`,
  // or `sync*` function.
  void startAsyncFunction() { asyncEtcAreKeywords.push(true); }

  // Use this to indicate that we are now entering a function which is
  // neither `async`, `async*`, nor `sync*`.
  void startNonAsyncFunction() { asyncEtcAreKeywords.push(false); }

  // Use this to indicate that we are now leaving any funciton.
  void endFunction() { asyncEtcAreKeywords.pop(); }

  // Whether we can recognize AWAIT/YIELD as an identifier/typeIdentifier.
  boolean asyncEtcPredicate(int tokenId) {
    if (tokenId == AWAIT || tokenId == YIELD) {
      return !asyncEtcAreKeywords.peek();
    }
    return false;
  }
}

@lexer::members{
  public static final int BRACE_NORMAL = 1;
  public static final int BRACE_SINGLE = 2;
  public static final int BRACE_DOUBLE = 3;
  public static final int BRACE_THREE_SINGLE = 4;
  public static final int BRACE_THREE_DOUBLE = 5;

  // Enable the parser to handle string interpolations via brace matching.
  // The top of the `braceLevels` stack describes the most recent unmatched
  // '{'. This is needed in order to enable/disable certain lexer rules.
  //
  //   NORMAL: Most recent unmatched '{' was not string literal related.
  //   SINGLE: Most recent unmatched '{' was `'...${`.
  //   DOUBLE: Most recent unmatched '{' was `"...${`.
  //   THREE_SINGLE: Most recent unmatched '{' was `'''...${`.
  //   THREE_DOUBLE: Most recent unmatched '{' was `"""...${`.
  //
  // Access via functions below.
  private Stack<Integer> braceLevels = new Stack<Integer>();

  // Whether we are currently in a string literal context, and which one.
  boolean currentBraceLevel(int braceLevel) {
    if (braceLevels.empty()) return false;
    return braceLevels.peek() == braceLevel;
  }

  // Use this to indicate that we are now entering a specific '{...}'.
  // Call it after accepting the '{'.
  void enterBrace() {
    braceLevels.push(BRACE_NORMAL);
  }
  void enterBraceSingleQuote() {
    braceLevels.push(BRACE_SINGLE);
  }
  void enterBraceDoubleQuote() {
    braceLevels.push(BRACE_DOUBLE);
  }
  void enterBraceThreeSingleQuotes() {
    braceLevels.push(BRACE_THREE_SINGLE);
  }
  void enterBraceThreeDoubleQuotes() {
    braceLevels.push(BRACE_THREE_DOUBLE);
  }

  // Use this to indicate that we are now exiting a specific '{...}',
  // no matter which kind. Call it before accepting the '}'.
  void exitBrace() {
      // We might raise a parse error here if the stack is empty, but the
      // parsing rules should ensure that we get a parse error anyway, and
      // it is not a big problem for the spec parser even if it misinterprets
      // the brace structure of some programs with syntax errors.
      if (!braceLevels.empty()) braceLevels.pop();
  }
}

// ---------------------------------------- Grammar rules.

libraryDefinition
    :    FEFF? SCRIPT_TAG?
         libraryName?
         importOrExport*
         partDirective*
         (metadata topLevelDefinition)*
         EOF
    ;

topLevelDefinition
    :    classDeclaration
    |    mixinDeclaration
    |    extensionDeclaration
    |    enumType
    |    typeAlias
    |    EXTERNAL functionSignature SEMICOLON
    |    EXTERNAL getterSignature SEMICOLON
    |    EXTERNAL setterSignature SEMICOLON
    |    EXTERNAL finalVarOrType identifierList SEMICOLON
    |    getterSignature functionBody
    |    setterSignature functionBody
    |    functionSignature functionBody
    |    (FINAL | CONST) type? staticFinalDeclarationList SEMICOLON
    |    LATE FINAL type? initializedIdentifierList SEMICOLON
    |    LATE? varOrType identifier (ASSIGN expression)?
         (COMMA initializedIdentifier)* SEMICOLON
    ;

declaredIdentifier
    :    COVARIANT? finalConstVarOrType identifier
    ;

finalConstVarOrType
    :    LATE? FINAL type?
    |    CONST type?
    |    LATE? varOrType
    ;

finalVarOrType
    :    FINAL type?
    |    varOrType
    ;

varOrType
    :    VAR
    |    type
    ;

initializedIdentifier
    :    identifier (ASSIGN expression)?
    ;

initializedIdentifierList
    :    initializedIdentifier (COMMA initializedIdentifier)*
    ;

functionSignature
    :    type? identifierNotFUNCTION formalParameterPart
    ;

functionBodyPrefix
    :    ASYNC? FAT_ARROW
    |    (ASYNC | ASYNC TIMES | SYNC TIMES)? LBRACE
    ;

functionBody
    :    FAT_ARROW { startNonAsyncFunction(); } expression { endFunction(); } SEMICOLON
    |    { startNonAsyncFunction(); } block { endFunction(); }
    |    ASYNC FAT_ARROW
         { startAsyncFunction(); } expression { endFunction(); } SEMICOLON
    |    (ASYNC | ASYNC TIMES | SYNC TIMES)
         { startAsyncFunction(); } block { endFunction(); }
    ;

block
    :    LBRACE statements RBRACE
    ;

formalParameterPart
    :    typeParameters? formalParameterList
    ;

formalParameterList
    :    OPEN_PAR CLOSE_PAR
    |    OPEN_PAR normalFormalParameters COMMA? CLOSE_PAR
    |    OPEN_PAR normalFormalParameters COMMA optionalOrNamedFormalParameters CLOSE_PAR
    |    OPEN_PAR optionalOrNamedFormalParameters CLOSE_PAR
    ;

normalFormalParameters
    :    normalFormalParameter (COMMA normalFormalParameter)*
    ;

optionalOrNamedFormalParameters
    :    optionalPositionalFormalParameters
    |    namedFormalParameters
    ;

optionalPositionalFormalParameters
    :    OPEN_SQUARE_BRACKET defaultFormalParameter (COMMA defaultFormalParameter)* COMMA? CLOSE_SQUARE_BRACKET
    ;

namedFormalParameters
    :    LBRACE defaultNamedParameter (COMMA defaultNamedParameter)* COMMA? RBRACE
    ;

normalFormalParameter
    :    metadata normalFormalParameterNoMetadata
    ;

normalFormalParameterNoMetadata
    :    functionFormalParameter
    |    fieldFormalParameter
    |    simpleFormalParameter
    ;

// NB: It is an anomaly that a functionFormalParameter cannot be FINAL.
functionFormalParameter
    :    COVARIANT? type? identifierNotFUNCTION formalParameterPart QUESTION?
    ;

simpleFormalParameter
    :    declaredIdentifier
    |    COVARIANT? identifier
    ;

// NB: It is an anomaly that VAR can be a return type (`var this.x()`).
fieldFormalParameter
    :    finalConstVarOrType? THIS DOT identifier (formalParameterPart QUESTION?)?
    ;

defaultFormalParameter
    :    normalFormalParameter (ASSIGN expression)?
    ;

defaultNamedParameter
    :    REQUIRED? normalFormalParameter ((COLON | ASSIGN) expression)?
    ;

typeWithParameters
    :    typeIdentifier typeParameters?
    ;

classDeclaration
    :    ABSTRACT? CLASS typeWithParameters superclass? mixins? interfaces?
         LBRACE (metadata classMemberDefinition)* RBRACE
    |    ABSTRACT? CLASS mixinApplicationClass
    ;

superclass
    :    EXTENDS typeNotVoidNotFunction
    ;

mixins
    :    WITH typeNotVoidNotFunctionList
    ;

interfaces
    :    IMPLEMENTS typeNotVoidNotFunctionList
    ;

classMemberDefinition
    :    methodSignature functionBody
    |    declaration SEMICOLON
    ;

mixinApplicationClass
    :    typeWithParameters ASSIGN mixinApplication SEMICOLON
    ;

mixinDeclaration
    :    MIXIN typeIdentifier typeParameters?
         (ON typeNotVoidNotFunctionList)? interfaces?
         LBRACE (metadata mixinMemberDefinition)* RBRACE
    ;

// TODO: We will probably want to make this more strict.
mixinMemberDefinition
    :    classMemberDefinition
    ;

extensionDeclaration
    :    EXTENSION identifier? typeParameters? ON type
         LBRACE (metadata extensionMemberDefinition)* RBRACE
    ;

// TODO: We might want to make this more strict.
extensionMemberDefinition
    :    classMemberDefinition
    ;

methodSignature
    :    constructorSignature initializers
    |    factoryConstructorSignature
    |    STATIC? functionSignature
    |    STATIC? getterSignature
    |    STATIC? setterSignature
    |    operatorSignature
    |    constructorSignature
    ;

// https://github.com/dart-lang/sdk/issues/29501 reports on the problem which
// was solved by adding a case for redirectingFactoryConstructorSignature.
// TODO(eernst): Close that issue when this is integrated into the spec.

// https://github.com/dart-lang/sdk/issues/29502 reports on the problem that
// than external const factory constructor declaration cannot be derived by
// the spec grammar (and also not by this grammar). The following fixes were
// introduced for that: Added the 'factoryConstructorSignature' case below in
// 'declaration'; also added 'CONST?' in the 'factoryConstructorSignature'
// rule, such that const factories in general are allowed.
// TODO(eernst): Close that issue when this is integrated into the spec.

// TODO(eernst): Note that `EXTERNAL? STATIC? functionSignature` includes
// `STATIC functionSignature`, but a static function cannot be abstract.
// We might want to make that a syntax error rather than a static semantic
// check.

declaration
    :    EXTERNAL factoryConstructorSignature
    |    EXTERNAL constantConstructorSignature
    |    EXTERNAL constructorSignature
    |    (EXTERNAL STATIC?)? getterSignature
    |    (EXTERNAL STATIC?)? setterSignature
    |    (EXTERNAL STATIC?)? functionSignature
    |    EXTERNAL (STATIC? finalVarOrType | COVARIANT varOrType) identifierList
    |    ABSTRACT (finalVarOrType | COVARIANT varOrType) identifierList
    |    EXTERNAL? operatorSignature
    |    STATIC (FINAL | CONST) type? staticFinalDeclarationList
    |    STATIC LATE FINAL type? initializedIdentifierList
    |    (STATIC | COVARIANT) LATE? varOrType initializedIdentifierList
    |    LATE? (FINAL type? | varOrType) initializedIdentifierList
    |    redirectingFactoryConstructorSignature
    |    constantConstructorSignature (redirection | initializers)?
    |    constructorSignature (redirection | initializers)?
    ;

staticFinalDeclarationList
    :    staticFinalDeclaration (COMMA staticFinalDeclaration)*
    ;

staticFinalDeclaration
    :    identifier ASSIGN expression
    ;

operatorSignature
    :    type? OPERATOR operator formalParameterList
    ;

operator
    :    TILDE
    |    binaryOperator
    |    OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    |    OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET ASSIGN
    ;

binaryOperator
    :    multiplicativeOperator
    |    additiveOperator
    |    shiftOperator
    |    relationalOperator
    |    EQUAL
    |    bitwiseOperator
    ;

getterSignature
    :    type? GET identifier
    ;

setterSignature
    :    type? SET identifier formalParameterList
    ;

constructorSignature
    :    constructorName formalParameterList
    ;

constructorName
    :    typeIdentifier (DOT identifier)?
    ;

redirection
    :    COLON THIS (DOT identifier)? arguments
    ;

initializers
    :    COLON initializerListEntry (COMMA initializerListEntry)*
    ;

initializerListEntry
    :    SUPER arguments
    |    SUPER DOT identifier arguments
    |    fieldInitializer
    |    assertion
    ;

fieldInitializer
    :    (THIS DOT)? identifier ASSIGN initializerExpression
    ;

initializerExpression
    :    conditionalExpression
    |    cascade
    ;

factoryConstructorSignature
    :    CONST? FACTORY constructorName formalParameterList
    ;

redirectingFactoryConstructorSignature
    :    CONST? FACTORY constructorName formalParameterList ASSIGN
         constructorDesignation
    ;

constantConstructorSignature
    :    CONST constructorName formalParameterList
    ;

mixinApplication
    :    typeNotVoidNotFunction mixins interfaces?
    ;

enumType
    :    ENUM typeIdentifier LBRACE enumEntry (COMMA enumEntry)* (COMMA)? RBRACE
    ;

enumEntry
    :    metadata identifier
    ;

typeParameter
    :    metadata typeIdentifier (EXTENDS typeNotVoid)?
    ;

typeParameters
    :    LESS typeParameter (COMMA typeParameter)* GREATER
    ;

metadata
    :    (AT metadatum)*
    ;

metadatum
    :    constructorDesignation arguments
    |    identifier
    |    qualifiedName
    ;

expression
    :    functionExpression
    |    throwExpression
    |    assignableExpression assignmentOperator expression
    |    conditionalExpression
    |    cascade
    ;

expressionWithoutCascade
    :    functionExpressionWithoutCascade
    |    throwExpressionWithoutCascade
    |    assignableExpression assignmentOperator expressionWithoutCascade
    |    conditionalExpression
    ;

expressionList
    :    expression (COMMA expression)*
    ;

primary
    :    thisExpression
    |    SUPER unconditionalAssignableSelector
    |    constObjectExpression
    |    newExpression
    |    constructorInvocation
    |    functionPrimary
    |    OPEN_PAR expression CLOSE_PAR
    |    literal
    |    identifier
    ;

constructorInvocation
    :    typeName typeArguments DOT identifier arguments
    ;

literal
    :    nullLiteral
    |    booleanLiteral
    |    numericLiteral
    |    stringLiteral
    |    symbolLiteral
    |    setOrMapLiteral
    |    listLiteral
    ;

nullLiteral
    :    NULL
    ;

numericLiteral
    :    NUMBER
    |    HEX_NUMBER
    ;

booleanLiteral
    :    TRUE
    |    FALSE
    ;

stringLiteral
    :    (multiLineString | singleLineString)+
    ;

// Not used in the specification (needed here for <uri>).
stringLiteralWithoutInterpolation
    :    singleLineStringWithoutInterpolation+
    ;

setOrMapLiteral
    : CONST? typeArguments? LBRACE elements? RBRACE
    ;

listLiteral
    : CONST? typeArguments? OPEN_SQUARE_BRACKET elements? CLOSE_SQUARE_BRACKET
    ;

elements
    : element (COMMA element)* COMMA?
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
    : expression COLON expression
    ;

spreadElement
    : (SPREAD | NULL_AWARE_SPREAD) expression
    ;

ifElement
    : IF OPEN_PAR expression CLOSE_PAR element (ELSE element)?
    ;

forElement
    : AWAIT? FOR OPEN_PAR forLoopParts CLOSE_PAR element
    ;

throwExpression
    :    THROW expression
    ;

throwExpressionWithoutCascade
    :    THROW expressionWithoutCascade
    ;

functionExpression
    :    formalParameterPart functionExpressionBody
    ;

functionExpressionBody
    :    FAT_ARROW { startNonAsyncFunction(); } expression { endFunction(); }
    |    ASYNC FAT_ARROW { startAsyncFunction(); } expression { endFunction(); }
    ;

functionExpressionBodyPrefix
    :    ASYNC? FAT_ARROW
    ;

functionExpressionWithoutCascade
    :    formalParameterPart functionExpressionWithoutCascadeBody
    ;

functionExpressionWithoutCascadeBody
    :    FAT_ARROW { startNonAsyncFunction(); }
         expressionWithoutCascade { endFunction(); }
    |    ASYNC FAT_ARROW { startAsyncFunction(); }
         expressionWithoutCascade { endFunction(); }
    ;

functionPrimary
    :    formalParameterPart functionPrimaryBody
    ;

functionPrimaryBody
    :    { startNonAsyncFunction(); } block { endFunction(); }
    |    (ASYNC | ASYNC TIMES | SYNC TIMES)
         { startAsyncFunction(); } block { endFunction(); }
    ;

functionPrimaryBodyPrefix
    : (ASYNC | ASYNC TIMES | SYNC TIMES)? LBRACE
    ;

thisExpression
    :    THIS
    ;

newExpression
    :    NEW constructorDesignation arguments
    ;

constObjectExpression
    :    CONST constructorDesignation arguments
    ;

arguments
    :    OPEN_PAR (argumentList COMMA?)? CLOSE_PAR
    ;

argumentList
    :    namedArgument (COMMA namedArgument)*
    |    expressionList (COMMA namedArgument)*
    ;

namedArgument
    :    label expression
    ;

cascade
    :     cascade CASCADE cascadeSection
    |     conditionalExpression (NULL_AWARE_CASCADE | CASCADE) cascadeSection
    ;

cascadeSection
    :    cascadeSelector cascadeSectionTail
    ;

cascadeSelector
    :    OPEN_SQUARE_BRACKET expression CLOSE_SQUARE_BRACKET
    |    identifier
    ;

cascadeSectionTail
    :    cascadeAssignment
    |    selector* (assignableSelector cascadeAssignment)?
    ;

cascadeAssignment
    :    assignmentOperator expressionWithoutCascade
    ;

assignmentOperator
    :    ASSIGN
    |    compoundAssignmentOperator
    ;

compoundAssignmentOperator
    :    TIMES_ASSIGN
    |    OVER_ASSIGN
    |    OVER_TR_ASSIGN
    |    PERCENT_ASSIGN
    |    PLUS_ASSIGN
    |    MINUS_ASSIGN
    |    SHIFT_L_ASSIGN
    |    GREATER GREATER GREATER ASSIGN
    |    GREATER GREATER ASSIGN
    |    BITWISE_AND_ASSIGN
    |    BITWISE_XOR_ASSIGN
    |    BITWISE_OR_ASSIGN
    |    IF_NULL_ASSIGN
    ;

conditionalExpression
    :    ifNullExpression
         (QUESTION expressionWithoutCascade COLON expressionWithoutCascade)?
    ;

ifNullExpression
    :    logicalOrExpression (IF_NULL logicalOrExpression)*
    ;

logicalOrExpression
    :    logicalAndExpression (OR logicalAndExpression)*
    ;

logicalAndExpression
    :    equalityExpression (AND equalityExpression)*
    ;

equalityExpression
    :    relationalExpression (equalityOperator relationalExpression)?
    |    SUPER equalityOperator relationalExpression
    ;

equalityOperator
    :    EQUAL
    |    NOT_EQUAL
    ;

relationalExpression
    :    bitwiseOrExpression
         (typeTest | typeCast | relationalOperator bitwiseOrExpression)?
    |    SUPER relationalOperator bitwiseOrExpression
    ;

relationalOperator
    :    GREATER ASSIGN
    |    GREATER
    |    LESS_OR_EQUAL
    |    LESS
    ;

bitwiseOrExpression
    :    bitwiseXorExpression (BITWISE_OR bitwiseXorExpression)*
    |    SUPER (BITWISE_OR bitwiseXorExpression)+
    ;

bitwiseXorExpression
    :    bitwiseAndExpression (BITWISE_XOR bitwiseAndExpression)*
    |    SUPER (BITWISE_XOR bitwiseAndExpression)+
    ;

bitwiseAndExpression
    :    shiftExpression (BITWISE_AND shiftExpression)*
    |    SUPER (BITWISE_AND shiftExpression)+
    ;

bitwiseOperator
    :    BITWISE_AND
    |    BITWISE_XOR
    |    BITWISE_OR
    ;

shiftExpression
    :    additiveExpression (shiftOperator additiveExpression)*
    |    SUPER (shiftOperator additiveExpression)+
    ;

shiftOperator
    :    SHIFT_L
    |    GREATER GREATER GREATER
    |    GREATER GREATER
    ;

additiveExpression
    :    multiplicativeExpression (additiveOperator multiplicativeExpression)*
    |    SUPER (additiveOperator multiplicativeExpression)+
    ;

additiveOperator
    :    PLUS
    |    MINUS
    ;

multiplicativeExpression
    :    unaryExpression (multiplicativeOperator unaryExpression)*
    |    SUPER (multiplicativeOperator unaryExpression)+
    ;

multiplicativeOperator
    :    TIMES
    |    OVER
    |    PERCENT
    |    OVER_TR
    ;

unaryExpression
    :    prefixOperator unaryExpression
    |    awaitExpression
    |    postfixExpression
    |    (minusOperator | tildeOperator) SUPER
    |    incrementOperator assignableExpression
    ;

prefixOperator
    :    minusOperator
    |    negationOperator
    |    tildeOperator
    ;

minusOperator
    :    MINUS
    ;

negationOperator
    :    NOT
    ;

tildeOperator
    :    TILDE
    ;

awaitExpression
    :    AWAIT unaryExpression
    ;

postfixExpression
    :    assignableExpression postfixOperator
    |    primary selector*
    ;

postfixOperator
    :    incrementOperator
    ;

selector
    :    NOT
    |    assignableSelector
    |    argumentPart
    ;

argumentPart
    :    typeArguments? arguments
    ;

incrementOperator
    :    PLUSPLUS
    |    MINUSMINUS
    ;

assignableExpression
    :    SUPER unconditionalAssignableSelector
    |    primary assignableSelectorPart
    |    identifier
    ;

assignableSelectorPart
    :    selector* assignableSelector
    ;

unconditionalAssignableSelector
    :    OPEN_SQUARE_BRACKET expression CLOSE_SQUARE_BRACKET
    |    DOT identifier
    ;

assignableSelector
    :    unconditionalAssignableSelector
    |    CONDITIONAL_PROPERTY_ACCESS identifier
    |    QUESTION OPEN_SQUARE_BRACKET expression CLOSE_SQUARE_BRACKET
    ;

identifierNotFUNCTION
    :    IDENTIFIER
    |    ABSTRACT // Built-in identifier.
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
    |    { asyncEtcPredicate(getCurrentToken().getType()) }? (AWAIT|YIELD)
    ;

identifier
    :    identifierNotFUNCTION
    |    FUNCTION // Built-in identifier that can be used as a type.
    ;

qualifiedName
    :    typeIdentifier DOT identifier
    |    typeIdentifier DOT typeIdentifier DOT identifier
    ;

typeIdentifier
    :    IDENTIFIER
    |    DYNAMIC // Built-in identifier that can be used as a type.
    |    ASYNC // Not a built-in identifier.
    |    HIDE // Not a built-in identifier.
    |    OF // Not a built-in identifier.
    |    ON // Not a built-in identifier.
    |    SHOW // Not a built-in identifier.
    |    SYNC // Not a built-in identifier.
    |    { asyncEtcPredicate(getCurrentToken().getType()) }? (AWAIT|YIELD)
    ;

typeTest
    :    isOperator typeNotVoid
    ;

isOperator
    :    IS NOT?
    ;

typeCast
    :    asOperator typeNotVoid
    ;

asOperator
    :    AS
    ;

statements
    :    statement*
    ;

statement
    :    label* nonLabelledStatement
    ;

// Exception in the language specification: An expressionStatement cannot
// start with LBRACE. We force anything that starts with LBRACE to be a block,
// which will prevent an expressionStatement from starting with LBRACE, and
// which will not interfere with the recognition of any other case. If we
// add another statement which can start with LBRACE we must adjust this
// check.
nonLabelledStatement
    :    block
    |    localVariableDeclaration
    |    forStatement
    |    whileStatement
    |    doStatement
    |    switchStatement
    |    ifStatement
    |    rethrowStatement
    |    tryStatement
    |    breakStatement
    |    continueStatement
    |    returnStatement
    |    localFunctionDeclaration
    |    assertStatement
    |    yieldStatement
    |    yieldEachStatement
    |    expressionStatement
    ;

expressionStatement
    :    expression? SEMICOLON
    ;

localVariableDeclaration
    :    metadata initializedVariableDeclaration SEMICOLON
    ;

initializedVariableDeclaration
    :    declaredIdentifier (ASSIGN expression)? (COMMA initializedIdentifier)*
    ;

localFunctionDeclaration
    :    metadata functionSignature functionBody
    ;

ifStatement
    :    IF OPEN_PAR expression CLOSE_PAR statement (ELSE statement)?
    ;

forStatement
    :    AWAIT? FOR OPEN_PAR forLoopParts CLOSE_PAR statement
    ;

forLoopParts
    :    metadata declaredIdentifier IN expression
    |    metadata identifier IN expression
    |    forInitializerStatement expression? SEMICOLON expressionList?
    ;

// The localVariableDeclaration cannot be CONST, but that can
// be enforced in a later phase, and the grammar allows it.
forInitializerStatement
    :    localVariableDeclaration
    |    expression? SEMICOLON
    ;

whileStatement
    :    WHILE OPEN_PAR expression CLOSE_PAR statement
    ;

doStatement
    :    DO statement WHILE OPEN_PAR expression CLOSE_PAR SEMICOLON
    ;

switchStatement
    :    SWITCH OPEN_PAR expression CLOSE_PAR LBRACE switchCase* defaultCase? RBRACE
    ;

switchCase
    :    label* CASE expression COLON statements
    ;

defaultCase
    :    label* DEFAULT COLON statements
    ;

rethrowStatement
    :    RETHROW SEMICOLON
    ;

tryStatement
    :    TRY block (onParts finallyPart? | finallyPart)
    ;

onPart
    :    catchPart block
    |    ON typeNotVoid catchPart? block
    ;

onParts
    :    onPart onParts
    |    onPart
    ;

catchPart
    :    CATCH OPEN_PAR identifier (COMMA identifier)? CLOSE_PAR
    ;

finallyPart
    :    FINALLY block
    ;

returnStatement
    :    RETURN expression? SEMICOLON
    ;

label
    :    identifier COLON
    ;

breakStatement
    :    BREAK identifier? SEMICOLON
    ;

continueStatement
    :    CONTINUE identifier? SEMICOLON
    ;

yieldStatement
    :    YIELD expression SEMICOLON
    ;

yieldEachStatement
    :    YIELD TIMES expression SEMICOLON
    ;

assertStatement
    :    assertion SEMICOLON
    ;

assertion
    :    ASSERT OPEN_PAR expression (COMMA expression)? COMMA? CLOSE_PAR
    ;

libraryName
    :    metadata LIBRARY dottedIdentifierList SEMICOLON
    ;

dottedIdentifierList
    :    identifier (DOT identifier)*
    ;

importOrExport
    :    libraryImport
    |    libraryExport
    ;

libraryImport
    :    metadata importSpecification
    ;

importSpecification
    :    IMPORT configurableUri (DEFERRED? AS identifier)? combinator* SEMICOLON
    ;

combinator
    :    SHOW identifierList
    |    HIDE identifierList
    ;

identifierList
    :    identifier (COMMA identifier)*
    ;

libraryExport
    :    metadata EXPORT uri combinator* SEMICOLON
    ;

partDirective
    :    metadata PART uri SEMICOLON
    ;

partHeader
    :    metadata PART OF identifier (DOT identifier)* SEMICOLON
    ;

partDeclaration
    :    partHeader topLevelDefinition* EOF
    ;

// In the specification a plain <stringLiteral> is used.
// TODO(eernst): Check whether it creates ambiguities to do that.
uri
    :    stringLiteralWithoutInterpolation
    ;

configurableUri
    :    uri configurationUri*
    ;

configurationUri
    :    IF OPEN_PAR uriTest CLOSE_PAR uri
    ;

uriTest
    :    dottedIdentifierList (EQUAL stringLiteral)?
    ;

type
    :    functionType QUESTION?
    |    typeNotFunction
    ;

typeNotVoid
    :    functionType QUESTION?
    |    typeNotVoidNotFunction
    ;

typeNotFunction
    :    typeNotVoidNotFunction
    |    VOID
    ;

typeNotVoidNotFunction
    :    typeName typeArguments? QUESTION?
    |    FUNCTION QUESTION?
    ;

typeName
    :    typeIdentifier (DOT typeIdentifier)?
    ;

typeArguments
    :    LESS typeList GREATER
    ;

typeList
    :    type (COMMA type)*
    ;

typeNotVoidNotFunctionList
    :    typeNotVoidNotFunction (COMMA typeNotVoidNotFunction)*
    ;

typeAlias
    :    TYPEDEF typeIdentifier typeParameters? ASSIGN functionType SEMICOLON
    |    TYPEDEF functionTypeAlias
    ;

functionTypeAlias
    :    functionPrefix formalParameterPart SEMICOLON
    ;

functionPrefix
    :    type identifier
    |    identifier
    ;

functionTypeTail
    :    FUNCTION typeParameters? parameterTypeList
    ;

functionTypeTails
    :    functionTypeTail QUESTION? functionTypeTails
    |    functionTypeTail
    ;

functionType
    :    functionTypeTails
    |    typeNotFunction functionTypeTails
    ;

parameterTypeList
    :    OPEN_PAR CLOSE_PAR
    |    OPEN_PAR normalParameterTypes COMMA optionalParameterTypes CLOSE_PAR
    |    OPEN_PAR normalParameterTypes COMMA? CLOSE_PAR
    |    OPEN_PAR optionalParameterTypes CLOSE_PAR
    ;

normalParameterTypes
    :    normalParameterType (COMMA normalParameterType)*
    ;

normalParameterType
    :    typedIdentifier
    |    type
    ;

optionalParameterTypes
    :    optionalPositionalParameterTypes
    |    namedParameterTypes
    ;

optionalPositionalParameterTypes
    :    OPEN_SQUARE_BRACKET normalParameterTypes COMMA? CLOSE_SQUARE_BRACKET
    ;

namedParameterTypes
    :    LBRACE namedParameterType (COMMA namedParameterType)* COMMA? RBRACE
    ;

namedParameterType
    :    REQUIRED? typedIdentifier
    ;

typedIdentifier
    :    type identifier
    ;

constructorDesignation
    :    typeIdentifier
    |    qualifiedName
    |    typeName typeArguments (DOT identifier)?
    ;

symbolLiteral
    :    HASHTAG (operator | (identifier (DOT identifier)*))
    ;

// Not used in the specification (needed here for <uri>).
singleLineStringWithoutInterpolation
    :    RAW_SINGLE_LINE_STRING
    |    SINGLE_LINE_STRING_DQ_BEGIN_END
    |    SINGLE_LINE_STRING_SQ_BEGIN_END
    ;

singleLineString
    :    RAW_SINGLE_LINE_STRING
    |    SINGLE_LINE_STRING_SQ_BEGIN_END
    |    SINGLE_LINE_STRING_SQ_BEGIN_MID expression
         (SINGLE_LINE_STRING_SQ_MID_MID expression)*
         SINGLE_LINE_STRING_SQ_MID_END
    |    SINGLE_LINE_STRING_DQ_BEGIN_END
    |    SINGLE_LINE_STRING_DQ_BEGIN_MID expression
         (SINGLE_LINE_STRING_DQ_MID_MID expression)*
         SINGLE_LINE_STRING_DQ_MID_END
    ;

multiLineString
    :    RAW_MULTI_LINE_STRING
    |    MULTI_LINE_STRING_SQ_BEGIN_END
    |    MULTI_LINE_STRING_SQ_BEGIN_MID expression
         (MULTI_LINE_STRING_SQ_MID_MID expression)*
         MULTI_LINE_STRING_SQ_MID_END
    |    MULTI_LINE_STRING_DQ_BEGIN_END
    |    MULTI_LINE_STRING_DQ_BEGIN_MID expression
         (MULTI_LINE_STRING_DQ_MID_MID expression)*
         MULTI_LINE_STRING_DQ_MID_END
    ;

// ---------------------------------------- Lexer rules.
fragment
LETTER
    :    'a' .. 'z'
    |    'A' .. 'Z'
    ;

fragment
DIGIT
    :    '0' .. '9'
    ;

fragment
EXPONENT
    :    ('e' | 'E') (PLUS | MINUS)? DIGIT+
    ;

fragment
HEX_DIGIT
    :    ('a' | 'b' | 'c' | 'd' | 'e' | 'f')
    |    ('A' | 'B' | 'C' | 'D' | 'E' | 'F')
    |    DIGIT
    ;

// Reserved words.
ASSERT
    :    'assert'
    ;

BREAK
    :    'break'
    ;

CASE
    :    'case'
    ;

CATCH
    :    'catch'
    ;

CLASS
    :    'class'
    ;

CONST
    :    'const'
    ;

CONTINUE
    :    'continue'
    ;

DEFAULT
    :    'default'
    ;

DO
    :    'do'
    ;

ELSE
    :    'else'
    ;

ENUM
    :    'enum'
    ;

EXTENDS
    :    'extends'
    ;

FALSE
    :    'false'
    ;

FINAL
    :    'final'
    ;

FINALLY
    :    'finally'
    ;

FOR
    :    'for'
    ;

IF
    :    'if'
    ;

IN
    :    'in'
    ;

IS
    :    'is'
    ;

NEW
    :    'new'
    ;

NULL
    :    'null'
    ;

RETHROW
    :    'rethrow'
    ;

RETURN
    :    'return'
    ;

SUPER
    :    'super'
    ;

SWITCH
    :    'switch'
    ;

THIS
    :    'this'
    ;

THROW
    :    'throw'
    ;

TRUE
    :    'true'
    ;

TRY
    :    'try'
    ;

VAR
    :    'var'
    ;

VOID
    :    'void'
    ;

WHILE
    :    'while'
    ;

WITH
    :    'with'
    ;

// Built-in identifiers.

ABSTRACT
    :    'abstract'
    ;

AS
    :    'as'
    ;

COVARIANT
    :    'covariant'
    ;

DEFERRED
    :    'deferred'
    ;

DYNAMIC
    :    'dynamic'
    ;

EXPORT
    :    'export'
    ;

EXTENSION
    :    'extension'
    ;

EXTERNAL
    :    'external'
    ;

FACTORY
    :    'factory'
    ;

FUNCTION
    :    'Function'
    ;

GET
    :    'get'
    ;

IMPLEMENTS
    :    'implements'
    ;

IMPORT
    :    'import'
    ;

INTERFACE
    :    'interface'
    ;

LATE
    :    'late'
    ;

LIBRARY
    :    'library'
    ;

OPERATOR
    :    'operator'
    ;

MIXIN
    :    'mixin'
    ;

PART
    :    'part'
    ;

REQUIRED
    :    'required'
    ;

SET
    :    'set'
    ;

STATIC
    :    'static'
    ;

TYPEDEF
    :    'typedef'
    ;

// "Contextual keywords".

AWAIT
    :    'await'
    ;

YIELD
    :    'yield'
    ;

// Other words used in the grammar.

ASYNC
    :    'async'
    ;

HIDE
    :    'hide'
    ;

OF
    :    'of'
    ;

ON
    :    'on'
    ;

SHOW
    :    'show'
    ;

SYNC
    :    'sync'
    ;

// Lexical tokens that are not words.

NUMBER
    :    DIGIT+ DOT DIGIT+ EXPONENT?
    |    DIGIT+ EXPONENT?
    |    DOT DIGIT+ EXPONENT?
    ;

HEX_NUMBER
    :    '0x' HEX_DIGIT+
    |    '0X' HEX_DIGIT+
    ;

RAW_SINGLE_LINE_STRING
    :    'r' '\'' (~('\'' | '\r' | '\n'))* '\''
    |    'r' '"' (~('"' | '\r' | '\n'))* '"'
    ;

RAW_MULTI_LINE_STRING
    :    'r' '"""' (.)*? '"""'
    |    'r' '\'\'\'' (.)*? '\'\'\''
    ;

SEMICOLON
    :    ';'
    ;

COLON
    :    ':'
    ;


fragment
SIMPLE_STRING_INTERPOLATION
    :    '$' IDENTIFIER_NO_DOLLAR
    ;

fragment
ESCAPE_SEQUENCE
    :    '\\n'
    |    '\\r'
    |    '\\b'
    |    '\\t'
    |    '\\v'
    |    '\\x' HEX_DIGIT HEX_DIGIT
    |    '\\u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    |    '\\u{' HEX_DIGIT_SEQUENCE '}'
    ;

fragment
HEX_DIGIT_SEQUENCE
    :    HEX_DIGIT HEX_DIGIT? HEX_DIGIT?
         HEX_DIGIT? HEX_DIGIT? HEX_DIGIT?
    ;

fragment
STRING_CONTENT_COMMON
    :    ~('\\' | '\'' | '"' | '$' | '\r' | '\n')
    |    ESCAPE_SEQUENCE
    |    '\\' ~('n' | 'r' | 'b' | 't' | 'v' | 'x' | 'u' | '\r' | '\n')
    |    SIMPLE_STRING_INTERPOLATION
    ;

fragment
STRING_CONTENT_SQ
    :    STRING_CONTENT_COMMON
    |    '"'
    ;

SINGLE_LINE_STRING_SQ_BEGIN_END
    :    '\'' STRING_CONTENT_SQ* '\''
    ;

SINGLE_LINE_STRING_SQ_BEGIN_MID
    :    '\'' STRING_CONTENT_SQ* '${' { enterBraceSingleQuote(); }
    ;

SINGLE_LINE_STRING_SQ_MID_MID
    :    { currentBraceLevel(BRACE_SINGLE) }?
         { exitBrace(); } '}' STRING_CONTENT_SQ* '${'
         { enterBraceSingleQuote(); }
    ;

SINGLE_LINE_STRING_SQ_MID_END
    :    { currentBraceLevel(BRACE_SINGLE) }?
         { exitBrace(); } '}' STRING_CONTENT_SQ* '\''
    ;

fragment
STRING_CONTENT_DQ
    :    STRING_CONTENT_COMMON
    |    '\''
    ;

SINGLE_LINE_STRING_DQ_BEGIN_END
    :    '"' STRING_CONTENT_DQ* '"'
    ;

SINGLE_LINE_STRING_DQ_BEGIN_MID
    :    '"' STRING_CONTENT_DQ* '${' { enterBraceDoubleQuote(); }
    ;

SINGLE_LINE_STRING_DQ_MID_MID
    :    { currentBraceLevel(BRACE_DOUBLE) }?
         { exitBrace(); } '}' STRING_CONTENT_DQ* '${'
         { enterBraceDoubleQuote(); }
    ;

SINGLE_LINE_STRING_DQ_MID_END
    :    { currentBraceLevel(BRACE_DOUBLE) }?
         { exitBrace(); } '}' STRING_CONTENT_DQ* '"'
    ;

fragment
QUOTES_SQ
    :
    |    '\''
    |    '\'\''
    ;

// Read string contents, which may be almost anything, but stop when seeing
// '\'\'\'' and when seeing '${'. We do this by allowing all other
// possibilities including escapes, simple interpolation, and fewer than
// three '\''.
fragment
STRING_CONTENT_TSQ
    :    QUOTES_SQ
         (STRING_CONTENT_COMMON | '"' | '\r' | '\n' | '\\\r' | '\\\n')
    ;

MULTI_LINE_STRING_SQ_BEGIN_END
    :    '\'\'\'' STRING_CONTENT_TSQ* '\'\'\''
    ;

MULTI_LINE_STRING_SQ_BEGIN_MID
    :    '\'\'\'' STRING_CONTENT_TSQ* QUOTES_SQ '${'
         { enterBraceThreeSingleQuotes(); }
    ;

MULTI_LINE_STRING_SQ_MID_MID
    :    { currentBraceLevel(BRACE_THREE_SINGLE) }?
         { exitBrace(); } '}' STRING_CONTENT_TSQ* QUOTES_SQ '${'
         { enterBraceThreeSingleQuotes(); }
    ;

MULTI_LINE_STRING_SQ_MID_END
    :    { currentBraceLevel(BRACE_THREE_SINGLE) }?
         { exitBrace(); } '}' STRING_CONTENT_TSQ* '\'\'\''
    ;

fragment
QUOTES_DQ
    :
    |    '"'
    |    '""'
    ;

// Read string contents, which may be almost anything, but stop when seeing
// '"""' and when seeing '${'. We do this by allowing all other possibilities
// including escapes, simple interpolation, and fewer-than-three '"'.
fragment
STRING_CONTENT_TDQ
    :    QUOTES_DQ
         (STRING_CONTENT_COMMON | '\'' | '\r' | '\n' | '\\\r' | '\\\n')
    ;

MULTI_LINE_STRING_DQ_BEGIN_END
    :    '"""' STRING_CONTENT_TDQ* '"""'
    ;

MULTI_LINE_STRING_DQ_BEGIN_MID
    :    '"""' STRING_CONTENT_TDQ* QUOTES_DQ '${'
         { enterBraceThreeDoubleQuotes(); }
    ;

MULTI_LINE_STRING_DQ_MID_MID
    :    { currentBraceLevel(BRACE_THREE_DOUBLE) }?
         { exitBrace(); } '}' STRING_CONTENT_TDQ* QUOTES_DQ '${'
         { enterBraceThreeDoubleQuotes(); }
    ;

MULTI_LINE_STRING_DQ_MID_END
    :    { currentBraceLevel(BRACE_THREE_DOUBLE) }?
         { exitBrace(); } '}' STRING_CONTENT_TDQ* '"""'
    ;

LBRACE
    :    '{' { enterBrace(); }
    ;

RBRACE
    :    { currentBraceLevel(BRACE_NORMAL) }? { exitBrace(); } '}'
    ;

fragment
IDENTIFIER_START_NO_DOLLAR
    :    LETTER
    |    '_'
    ;

fragment
IDENTIFIER_PART_NO_DOLLAR
    :    IDENTIFIER_START_NO_DOLLAR
    |    DIGIT
    ;

fragment
IDENTIFIER_NO_DOLLAR
    :    IDENTIFIER_START_NO_DOLLAR IDENTIFIER_PART_NO_DOLLAR*
    ;

fragment
IDENTIFIER_START
    :    IDENTIFIER_START_NO_DOLLAR
    |    '$'
    ;

fragment
IDENTIFIER_PART
    :    IDENTIFIER_START
    |    DIGIT
    ;

SCRIPT_TAG
    :    '#!' (~('\r' | '\n'))* NEWLINE
    ;

IDENTIFIER
    :    IDENTIFIER_START IDENTIFIER_PART*
    ;

SINGLE_LINE_COMMENT
    :    '//' (~('\r' | '\n'))* NEWLINE?
         -> channel(HIDDEN)
    ;

MULTI_LINE_COMMENT
    :    '/*' (MULTI_LINE_COMMENT | .)*? '*/'
         -> channel(HIDDEN)
    ;

fragment
NEWLINE
    :    ('\r' | '\n' | '\r\n')
    ;

FEFF
    :    '\uFEFF'
    ;

WS : (' ' | '\t' | NEWLINE)+ -> channel(HIDDEN);


// Missing TOKENS

ASSIGN
    :    '='
    ;

OPEN_PAR
    :    '('
    ;

QUESTION
    :    '?'
    ;

CONDITIONAL_PROPERTY_ACCESS
    :    '?.'
    ;

IF_NULL
    :    '??'
    ;

NULL_AWARE_SPREAD
    :    '...?'
    ;

SPREAD
    :    '...'
    ;

CASCADE
    :    '..'
    ;

PLUSPLUS
    :    '++'
    ;

MINUSMINUS
    :    '--'
    ;

OVER_TR
    :    '~/'
    ;

SHIFT_L
    :    '<<'
    ;

SHIFT_R
    :    '>>'
    ;

SHIRT_R_LOGICAL
    :    '>>>'
    ;

GREATER_OR_EQUAL
    :    '>='
    ;

LESS_OR_EQUAL
    :    '<='
    ;

EQUAL
    :    '=='
    ;

NOT_EQUAL
    :    '!='
    ;

AND
    :    '&&'
    ;

OR
    :    '||'
    ;

BITWISE_AND_ASSIGN
    :    '&='
    ;

BITWISE_OR_ASSIGN
    :    '|='
    ;

BITWISE_XOR_ASSIGN
    :    '^='
    ;

IF_NULL_ASSIGN
    :    '??='
    ;

OVER_ASSIGN
    :    '/='
    ;

OVER_TR_ASSIGN
    :    '~/='
    ;

MINUS_ASSIGN
    :    '-='
    ;

TIMES_ASSIGN
    :    '*='
    ;

PERCENT_ASSIGN
    :    '%='
    ;

PLUS_ASSIGN
    :    '+='
    ;

SHIFT_L_ASSIGN
    :    '<<='
    ;

SHIFT_R_ASSIGN
    :    '>>='
    ;

SHIFT_R_LOGICAL_ASSIGN
    :    '>>>='
    ;

LESS
    :    '<'
    ;

GREATER
    :    '>'
    ;

BITWISE_XOR
    :    '^'
    ;

BITWISE_OR
    :    '|'
    ;

BITWISE_AND
    :    '&'
    ;

MINUS
    :    '-'
    ;

PLUS
    :    '+'
    ;

PERCENT
    :    '%'
    ;

TIMES
    :    '*'
    ;

OVER
    :    '/'
    ;

TILDE
    :    '~'
    ;

DOT
    :    '.'
    ;

NOT
    :    '!'
    ;

COMMA
    :    ','
    ;

FAT_ARROW
    :    '=>'
    ;

CLOSE_PAR
    :    ')'
    ;

OPEN_SQUARE_BRACKET
    :    '['
    ;

CLOSE_SQUARE_BRACKET
    :    ']'
    ;

AT
    :    '@'
    ;


NULL_AWARE_CASCADE
    :    '?..'
    ;

HASHTAG
    :    '#'
    ;
