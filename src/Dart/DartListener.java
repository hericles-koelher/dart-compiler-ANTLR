// Generated from src/Dart.g4 by ANTLR 4.9.1
package Dart;

import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DartParser}.
 */
public interface DartListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DartParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(DartParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(DartParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#declaredIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclaredIdentifier(DartParser.DeclaredIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#declaredIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclaredIdentifier(DartParser.DeclaredIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#finalConstVarOrType}.
	 * @param ctx the parse tree
	 */
	void enterFinalConstVarOrType(DartParser.FinalConstVarOrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#finalConstVarOrType}.
	 * @param ctx the parse tree
	 */
	void exitFinalConstVarOrType(DartParser.FinalConstVarOrTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#finalVarOrType}.
	 * @param ctx the parse tree
	 */
	void enterFinalVarOrType(DartParser.FinalVarOrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#finalVarOrType}.
	 * @param ctx the parse tree
	 */
	void exitFinalVarOrType(DartParser.FinalVarOrTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#varOrType}.
	 * @param ctx the parse tree
	 */
	void enterVarOrType(DartParser.VarOrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#varOrType}.
	 * @param ctx the parse tree
	 */
	void exitVarOrType(DartParser.VarOrTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#initializedVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInitializedVariableDeclaration(DartParser.InitializedVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#initializedVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInitializedVariableDeclaration(DartParser.InitializedVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#initializedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterInitializedIdentifier(DartParser.InitializedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#initializedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitInitializedIdentifier(DartParser.InitializedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#initializedIdentifierList}.
	 * @param ctx the parse tree
	 */
	void enterInitializedIdentifierList(DartParser.InitializedIdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#initializedIdentifierList}.
	 * @param ctx the parse tree
	 */
	void exitInitializedIdentifierList(DartParser.InitializedIdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionSignature}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSignature(DartParser.FunctionSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionSignature}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSignature(DartParser.FunctionSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#formalParameterPart}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterPart(DartParser.FormalParameterPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#formalParameterPart}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterPart(DartParser.FormalParameterPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(DartParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(DartParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(DartParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(DartParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(DartParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(DartParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#normalFormalParameters}.
	 * @param ctx the parse tree
	 */
	void enterNormalFormalParameters(DartParser.NormalFormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#normalFormalParameters}.
	 * @param ctx the parse tree
	 */
	void exitNormalFormalParameters(DartParser.NormalFormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#optionalOrNamedFormalParameters}.
	 * @param ctx the parse tree
	 */
	void enterOptionalOrNamedFormalParameters(DartParser.OptionalOrNamedFormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#optionalOrNamedFormalParameters}.
	 * @param ctx the parse tree
	 */
	void exitOptionalOrNamedFormalParameters(DartParser.OptionalOrNamedFormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#optionalPositionalFormalParameters}.
	 * @param ctx the parse tree
	 */
	void enterOptionalPositionalFormalParameters(DartParser.OptionalPositionalFormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#optionalPositionalFormalParameters}.
	 * @param ctx the parse tree
	 */
	void exitOptionalPositionalFormalParameters(DartParser.OptionalPositionalFormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#namedFormalParameters}.
	 * @param ctx the parse tree
	 */
	void enterNamedFormalParameters(DartParser.NamedFormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#namedFormalParameters}.
	 * @param ctx the parse tree
	 */
	void exitNamedFormalParameters(DartParser.NamedFormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#normalFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterNormalFormalParameter(DartParser.NormalFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#normalFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitNormalFormalParameter(DartParser.NormalFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionFormalParameter(DartParser.FunctionFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionFormalParameter(DartParser.FunctionFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#simpleFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFormalParameter(DartParser.SimpleFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#simpleFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFormalParameter(DartParser.SimpleFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#fieldFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFieldFormalParameter(DartParser.FieldFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#fieldFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFieldFormalParameter(DartParser.FieldFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#defaultFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterDefaultFormalParameter(DartParser.DefaultFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#defaultFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitDefaultFormalParameter(DartParser.DefaultFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#defaultNamedParameter}.
	 * @param ctx the parse tree
	 */
	void enterDefaultNamedParameter(DartParser.DefaultNamedParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#defaultNamedParameter}.
	 * @param ctx the parse tree
	 */
	void exitDefaultNamedParameter(DartParser.DefaultNamedParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeWithParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeWithParameters(DartParser.TypeWithParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeWithParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeWithParameters(DartParser.TypeWithParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(DartParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(DartParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#classMemberDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDefinition(DartParser.ClassMemberDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#classMemberDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDefinition(DartParser.ClassMemberDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#methodSignature}.
	 * @param ctx the parse tree
	 */
	void enterMethodSignature(DartParser.MethodSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#methodSignature}.
	 * @param ctx the parse tree
	 */
	void exitMethodSignature(DartParser.MethodSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(DartParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(DartParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#staticFinalDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterStaticFinalDeclarationList(DartParser.StaticFinalDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#staticFinalDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitStaticFinalDeclarationList(DartParser.StaticFinalDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#staticFinalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticFinalDeclaration(DartParser.StaticFinalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#staticFinalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticFinalDeclaration(DartParser.StaticFinalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#operatorSignature}.
	 * @param ctx the parse tree
	 */
	void enterOperatorSignature(DartParser.OperatorSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#operatorSignature}.
	 * @param ctx the parse tree
	 */
	void exitOperatorSignature(DartParser.OperatorSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(DartParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(DartParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperator(DartParser.BinaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperator(DartParser.BinaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#getterSignature}.
	 * @param ctx the parse tree
	 */
	void enterGetterSignature(DartParser.GetterSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#getterSignature}.
	 * @param ctx the parse tree
	 */
	void exitGetterSignature(DartParser.GetterSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#setterSignature}.
	 * @param ctx the parse tree
	 */
	void enterSetterSignature(DartParser.SetterSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#setterSignature}.
	 * @param ctx the parse tree
	 */
	void exitSetterSignature(DartParser.SetterSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#constructorSignature}.
	 * @param ctx the parse tree
	 */
	void enterConstructorSignature(DartParser.ConstructorSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#constructorSignature}.
	 * @param ctx the parse tree
	 */
	void exitConstructorSignature(DartParser.ConstructorSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#constructorName}.
	 * @param ctx the parse tree
	 */
	void enterConstructorName(DartParser.ConstructorNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#constructorName}.
	 * @param ctx the parse tree
	 */
	void exitConstructorName(DartParser.ConstructorNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#redirection}.
	 * @param ctx the parse tree
	 */
	void enterRedirection(DartParser.RedirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#redirection}.
	 * @param ctx the parse tree
	 */
	void exitRedirection(DartParser.RedirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#initializers}.
	 * @param ctx the parse tree
	 */
	void enterInitializers(DartParser.InitializersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#initializers}.
	 * @param ctx the parse tree
	 */
	void exitInitializers(DartParser.InitializersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#initializerListEntry}.
	 * @param ctx the parse tree
	 */
	void enterInitializerListEntry(DartParser.InitializerListEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#initializerListEntry}.
	 * @param ctx the parse tree
	 */
	void exitInitializerListEntry(DartParser.InitializerListEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#fieldInitializer}.
	 * @param ctx the parse tree
	 */
	void enterFieldInitializer(DartParser.FieldInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#fieldInitializer}.
	 * @param ctx the parse tree
	 */
	void exitFieldInitializer(DartParser.FieldInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void enterInitializerExpression(DartParser.InitializerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void exitInitializerExpression(DartParser.InitializerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#factoryConstructorSignature}.
	 * @param ctx the parse tree
	 */
	void enterFactoryConstructorSignature(DartParser.FactoryConstructorSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#factoryConstructorSignature}.
	 * @param ctx the parse tree
	 */
	void exitFactoryConstructorSignature(DartParser.FactoryConstructorSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#redirectingFactoryConstructorSignature}.
	 * @param ctx the parse tree
	 */
	void enterRedirectingFactoryConstructorSignature(DartParser.RedirectingFactoryConstructorSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#redirectingFactoryConstructorSignature}.
	 * @param ctx the parse tree
	 */
	void exitRedirectingFactoryConstructorSignature(DartParser.RedirectingFactoryConstructorSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#constantConstructorSignature}.
	 * @param ctx the parse tree
	 */
	void enterConstantConstructorSignature(DartParser.ConstantConstructorSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#constantConstructorSignature}.
	 * @param ctx the parse tree
	 */
	void exitConstantConstructorSignature(DartParser.ConstantConstructorSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#superclass}.
	 * @param ctx the parse tree
	 */
	void enterSuperclass(DartParser.SuperclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#superclass}.
	 * @param ctx the parse tree
	 */
	void exitSuperclass(DartParser.SuperclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#mixins}.
	 * @param ctx the parse tree
	 */
	void enterMixins(DartParser.MixinsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#mixins}.
	 * @param ctx the parse tree
	 */
	void exitMixins(DartParser.MixinsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#interfaces}.
	 * @param ctx the parse tree
	 */
	void enterInterfaces(DartParser.InterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#interfaces}.
	 * @param ctx the parse tree
	 */
	void exitInterfaces(DartParser.InterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#mixinApplicationClass}.
	 * @param ctx the parse tree
	 */
	void enterMixinApplicationClass(DartParser.MixinApplicationClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#mixinApplicationClass}.
	 * @param ctx the parse tree
	 */
	void exitMixinApplicationClass(DartParser.MixinApplicationClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#mixinApplication}.
	 * @param ctx the parse tree
	 */
	void enterMixinApplication(DartParser.MixinApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#mixinApplication}.
	 * @param ctx the parse tree
	 */
	void exitMixinApplication(DartParser.MixinApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#mixinDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMixinDeclaration(DartParser.MixinDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#mixinDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMixinDeclaration(DartParser.MixinDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#enumType}.
	 * @param ctx the parse tree
	 */
	void enterEnumType(DartParser.EnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#enumType}.
	 * @param ctx the parse tree
	 */
	void exitEnumType(DartParser.EnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(DartParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(DartParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(DartParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(DartParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#enumEntry}.
	 * @param ctx the parse tree
	 */
	void enterEnumEntry(DartParser.EnumEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#enumEntry}.
	 * @param ctx the parse tree
	 */
	void exitEnumEntry(DartParser.EnumEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#metadata}.
	 * @param ctx the parse tree
	 */
	void enterMetadata(DartParser.MetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#metadata}.
	 * @param ctx the parse tree
	 */
	void exitMetadata(DartParser.MetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#metadatum}.
	 * @param ctx the parse tree
	 */
	void enterMetadatum(DartParser.MetadatumContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#metadatum}.
	 * @param ctx the parse tree
	 */
	void exitMetadatum(DartParser.MetadatumContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DartParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DartParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#expressionWithoutCascade}.
	 * @param ctx the parse tree
	 */
	void enterExpressionWithoutCascade(DartParser.ExpressionWithoutCascadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#expressionWithoutCascade}.
	 * @param ctx the parse tree
	 */
	void exitExpressionWithoutCascade(DartParser.ExpressionWithoutCascadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(DartParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(DartParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(DartParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(DartParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(DartParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(DartParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(DartParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(DartParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(DartParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(DartParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(DartParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(DartParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(DartParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(DartParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#symbolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSymbolLiteral(DartParser.SymbolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#symbolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSymbolLiteral(DartParser.SymbolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(DartParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(DartParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#setOrMapLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSetOrMapLiteral(DartParser.SetOrMapLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#setOrMapLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSetOrMapLiteral(DartParser.SetOrMapLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#elements}.
	 * @param ctx the parse tree
	 */
	void enterElements(DartParser.ElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#elements}.
	 * @param ctx the parse tree
	 */
	void exitElements(DartParser.ElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(DartParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(DartParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#expressionElement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionElement(DartParser.ExpressionElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#expressionElement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionElement(DartParser.ExpressionElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#mapElement}.
	 * @param ctx the parse tree
	 */
	void enterMapElement(DartParser.MapElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#mapElement}.
	 * @param ctx the parse tree
	 */
	void exitMapElement(DartParser.MapElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#spreadElement}.
	 * @param ctx the parse tree
	 */
	void enterSpreadElement(DartParser.SpreadElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#spreadElement}.
	 * @param ctx the parse tree
	 */
	void exitSpreadElement(DartParser.SpreadElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#ifElement}.
	 * @param ctx the parse tree
	 */
	void enterIfElement(DartParser.IfElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#ifElement}.
	 * @param ctx the parse tree
	 */
	void exitIfElement(DartParser.IfElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#forElement}.
	 * @param ctx the parse tree
	 */
	void enterForElement(DartParser.ForElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#forElement}.
	 * @param ctx the parse tree
	 */
	void exitForElement(DartParser.ForElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#throwExpression}.
	 * @param ctx the parse tree
	 */
	void enterThrowExpression(DartParser.ThrowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#throwExpression}.
	 * @param ctx the parse tree
	 */
	void exitThrowExpression(DartParser.ThrowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#throwExpressionWithoutCascade}.
	 * @param ctx the parse tree
	 */
	void enterThrowExpressionWithoutCascade(DartParser.ThrowExpressionWithoutCascadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#throwExpressionWithoutCascade}.
	 * @param ctx the parse tree
	 */
	void exitThrowExpressionWithoutCascade(DartParser.ThrowExpressionWithoutCascadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(DartParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(DartParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionExpressionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpressionBody(DartParser.FunctionExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionExpressionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpressionBody(DartParser.FunctionExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionExpressionWithoutCascade}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpressionWithoutCascade(DartParser.FunctionExpressionWithoutCascadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionExpressionWithoutCascade}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpressionWithoutCascade(DartParser.FunctionExpressionWithoutCascadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionExpressionWithoutCascadeBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpressionWithoutCascadeBody(DartParser.FunctionExpressionWithoutCascadeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionExpressionWithoutCascadeBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpressionWithoutCascadeBody(DartParser.FunctionExpressionWithoutCascadeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionPrimary}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPrimary(DartParser.FunctionPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionPrimary}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPrimary(DartParser.FunctionPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionPrimaryBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPrimaryBody(DartParser.FunctionPrimaryBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionPrimaryBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPrimaryBody(DartParser.FunctionPrimaryBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#thisExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(DartParser.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#thisExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(DartParser.ThisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(DartParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(DartParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#constObjectExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstObjectExpression(DartParser.ConstObjectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#constObjectExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstObjectExpression(DartParser.ConstObjectExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(DartParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(DartParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(DartParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(DartParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgument(DartParser.NamedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgument(DartParser.NamedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#cascade}.
	 * @param ctx the parse tree
	 */
	void enterCascade(DartParser.CascadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#cascade}.
	 * @param ctx the parse tree
	 */
	void exitCascade(DartParser.CascadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#cascadeSection}.
	 * @param ctx the parse tree
	 */
	void enterCascadeSection(DartParser.CascadeSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#cascadeSection}.
	 * @param ctx the parse tree
	 */
	void exitCascadeSection(DartParser.CascadeSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#cascadeSelector}.
	 * @param ctx the parse tree
	 */
	void enterCascadeSelector(DartParser.CascadeSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#cascadeSelector}.
	 * @param ctx the parse tree
	 */
	void exitCascadeSelector(DartParser.CascadeSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#cascadeSectionTail}.
	 * @param ctx the parse tree
	 */
	void enterCascadeSectionTail(DartParser.CascadeSectionTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#cascadeSectionTail}.
	 * @param ctx the parse tree
	 */
	void exitCascadeSectionTail(DartParser.CascadeSectionTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#cascadeAssignment}.
	 * @param ctx the parse tree
	 */
	void enterCascadeAssignment(DartParser.CascadeAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#cascadeAssignment}.
	 * @param ctx the parse tree
	 */
	void exitCascadeAssignment(DartParser.CascadeAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(DartParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(DartParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#compoundAssignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAssignmentOperator(DartParser.CompoundAssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#compoundAssignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAssignmentOperator(DartParser.CompoundAssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(DartParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(DartParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#ifNullExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfNullExpression(DartParser.IfNullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#ifNullExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfNullExpression(DartParser.IfNullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(DartParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(DartParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(DartParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(DartParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(DartParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(DartParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#equalityOperator}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOperator(DartParser.EqualityOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#equalityOperator}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOperator(DartParser.EqualityOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(DartParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(DartParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#relationalOperator}.
	 * @param ctx the parse tree
	 */
	void enterRelationalOperator(DartParser.RelationalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#relationalOperator}.
	 * @param ctx the parse tree
	 */
	void exitRelationalOperator(DartParser.RelationalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#bitwiseOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(DartParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#bitwiseOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(DartParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#bitwiseXorExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseXorExpression(DartParser.BitwiseXorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#bitwiseXorExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseXorExpression(DartParser.BitwiseXorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#bitwiseAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(DartParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#bitwiseAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(DartParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOperator(DartParser.BitwiseOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOperator(DartParser.BitwiseOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(DartParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(DartParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#shiftOperator}.
	 * @param ctx the parse tree
	 */
	void enterShiftOperator(DartParser.ShiftOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#shiftOperator}.
	 * @param ctx the parse tree
	 */
	void exitShiftOperator(DartParser.ShiftOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(DartParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(DartParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOperator(DartParser.AdditiveOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOperator(DartParser.AdditiveOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(DartParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(DartParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeOperator(DartParser.MultiplicativeOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeOperator(DartParser.MultiplicativeOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(DartParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(DartParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#prefixOperator}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOperator(DartParser.PrefixOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#prefixOperator}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOperator(DartParser.PrefixOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#minusOperator}.
	 * @param ctx the parse tree
	 */
	void enterMinusOperator(DartParser.MinusOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#minusOperator}.
	 * @param ctx the parse tree
	 */
	void exitMinusOperator(DartParser.MinusOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#negationOperator}.
	 * @param ctx the parse tree
	 */
	void enterNegationOperator(DartParser.NegationOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#negationOperator}.
	 * @param ctx the parse tree
	 */
	void exitNegationOperator(DartParser.NegationOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#tildeOperator}.
	 * @param ctx the parse tree
	 */
	void enterTildeOperator(DartParser.TildeOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#tildeOperator}.
	 * @param ctx the parse tree
	 */
	void exitTildeOperator(DartParser.TildeOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#awaitExpression}.
	 * @param ctx the parse tree
	 */
	void enterAwaitExpression(DartParser.AwaitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#awaitExpression}.
	 * @param ctx the parse tree
	 */
	void exitAwaitExpression(DartParser.AwaitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(DartParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(DartParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#postfixOperator}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOperator(DartParser.PostfixOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#postfixOperator}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOperator(DartParser.PostfixOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#constructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterConstructorInvocation(DartParser.ConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#constructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitConstructorInvocation(DartParser.ConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(DartParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(DartParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#argumentPart}.
	 * @param ctx the parse tree
	 */
	void enterArgumentPart(DartParser.ArgumentPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#argumentPart}.
	 * @param ctx the parse tree
	 */
	void exitArgumentPart(DartParser.ArgumentPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#incrementOperator}.
	 * @param ctx the parse tree
	 */
	void enterIncrementOperator(DartParser.IncrementOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#incrementOperator}.
	 * @param ctx the parse tree
	 */
	void exitIncrementOperator(DartParser.IncrementOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#assignableExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignableExpression(DartParser.AssignableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#assignableExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignableExpression(DartParser.AssignableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#assignableSelectorPart}.
	 * @param ctx the parse tree
	 */
	void enterAssignableSelectorPart(DartParser.AssignableSelectorPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#assignableSelectorPart}.
	 * @param ctx the parse tree
	 */
	void exitAssignableSelectorPart(DartParser.AssignableSelectorPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#unconditionalAssignableSelector}.
	 * @param ctx the parse tree
	 */
	void enterUnconditionalAssignableSelector(DartParser.UnconditionalAssignableSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#unconditionalAssignableSelector}.
	 * @param ctx the parse tree
	 */
	void exitUnconditionalAssignableSelector(DartParser.UnconditionalAssignableSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#assignableSelector}.
	 * @param ctx the parse tree
	 */
	void enterAssignableSelector(DartParser.AssignableSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#assignableSelector}.
	 * @param ctx the parse tree
	 */
	void exitAssignableSelector(DartParser.AssignableSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#identifierNotFUNCTION}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierNotFUNCTION(DartParser.IdentifierNotFUNCTIONContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#identifierNotFUNCTION}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierNotFUNCTION(DartParser.IdentifierNotFUNCTIONContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(DartParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(DartParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(DartParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(DartParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(DartParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(DartParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeTest}.
	 * @param ctx the parse tree
	 */
	void enterTypeTest(DartParser.TypeTestContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeTest}.
	 * @param ctx the parse tree
	 */
	void exitTypeTest(DartParser.TypeTestContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#isOperator}.
	 * @param ctx the parse tree
	 */
	void enterIsOperator(DartParser.IsOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#isOperator}.
	 * @param ctx the parse tree
	 */
	void exitIsOperator(DartParser.IsOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeCast}.
	 * @param ctx the parse tree
	 */
	void enterTypeCast(DartParser.TypeCastContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeCast}.
	 * @param ctx the parse tree
	 */
	void exitTypeCast(DartParser.TypeCastContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#asOperator}.
	 * @param ctx the parse tree
	 */
	void enterAsOperator(DartParser.AsOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#asOperator}.
	 * @param ctx the parse tree
	 */
	void exitAsOperator(DartParser.AsOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(DartParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(DartParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DartParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DartParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#nonLabelledStatement}.
	 * @param ctx the parse tree
	 */
	void enterNonLabelledStatement(DartParser.NonLabelledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#nonLabelledStatement}.
	 * @param ctx the parse tree
	 */
	void exitNonLabelledStatement(DartParser.NonLabelledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(DartParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(DartParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(DartParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(DartParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#localFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalFunctionDeclaration(DartParser.LocalFunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#localFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalFunctionDeclaration(DartParser.LocalFunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(DartParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(DartParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(DartParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(DartParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#forLoopParts}.
	 * @param ctx the parse tree
	 */
	void enterForLoopParts(DartParser.ForLoopPartsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#forLoopParts}.
	 * @param ctx the parse tree
	 */
	void exitForLoopParts(DartParser.ForLoopPartsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#forInitializerStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInitializerStatement(DartParser.ForInitializerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#forInitializerStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInitializerStatement(DartParser.ForInitializerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(DartParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(DartParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(DartParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(DartParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(DartParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(DartParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCase(DartParser.SwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCase(DartParser.SwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#defaultCase}.
	 * @param ctx the parse tree
	 */
	void enterDefaultCase(DartParser.DefaultCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#defaultCase}.
	 * @param ctx the parse tree
	 */
	void exitDefaultCase(DartParser.DefaultCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#rethrowStatement}.
	 * @param ctx the parse tree
	 */
	void enterRethrowStatement(DartParser.RethrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#rethrowStatement}.
	 * @param ctx the parse tree
	 */
	void exitRethrowStatement(DartParser.RethrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(DartParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(DartParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#onPart}.
	 * @param ctx the parse tree
	 */
	void enterOnPart(DartParser.OnPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#onPart}.
	 * @param ctx the parse tree
	 */
	void exitOnPart(DartParser.OnPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#catchPart}.
	 * @param ctx the parse tree
	 */
	void enterCatchPart(DartParser.CatchPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#catchPart}.
	 * @param ctx the parse tree
	 */
	void exitCatchPart(DartParser.CatchPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#finallyPart}.
	 * @param ctx the parse tree
	 */
	void enterFinallyPart(DartParser.FinallyPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#finallyPart}.
	 * @param ctx the parse tree
	 */
	void exitFinallyPart(DartParser.FinallyPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(DartParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(DartParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(DartParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(DartParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(DartParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(DartParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(DartParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(DartParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(DartParser.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(DartParser.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#yieldEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldEachStatement(DartParser.YieldEachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#yieldEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldEachStatement(DartParser.YieldEachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(DartParser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(DartParser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#assertion}.
	 * @param ctx the parse tree
	 */
	void enterAssertion(DartParser.AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#assertion}.
	 * @param ctx the parse tree
	 */
	void exitAssertion(DartParser.AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#topLevelDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDefinition(DartParser.TopLevelDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#topLevelDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDefinition(DartParser.TopLevelDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(DartParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(DartParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(DartParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(DartParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeNotVoid}.
	 * @param ctx the parse tree
	 */
	void enterTypeNotVoid(DartParser.TypeNotVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeNotVoid}.
	 * @param ctx the parse tree
	 */
	void exitTypeNotVoid(DartParser.TypeNotVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeNotFunction}.
	 * @param ctx the parse tree
	 */
	void enterTypeNotFunction(DartParser.TypeNotFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeNotFunction}.
	 * @param ctx the parse tree
	 */
	void exitTypeNotFunction(DartParser.TypeNotFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeNotVoidNotFunction}.
	 * @param ctx the parse tree
	 */
	void enterTypeNotVoidNotFunction(DartParser.TypeNotVoidNotFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeNotVoidNotFunction}.
	 * @param ctx the parse tree
	 */
	void exitTypeNotVoidNotFunction(DartParser.TypeNotVoidNotFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(DartParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(DartParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(DartParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(DartParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(DartParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(DartParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeNotVoidNotFunctionList}.
	 * @param ctx the parse tree
	 */
	void enterTypeNotVoidNotFunctionList(DartParser.TypeNotVoidNotFunctionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeNotVoidNotFunctionList}.
	 * @param ctx the parse tree
	 */
	void exitTypeNotVoidNotFunctionList(DartParser.TypeNotVoidNotFunctionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionTypeTail}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTypeTail(DartParser.FunctionTypeTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionTypeTail}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTypeTail(DartParser.FunctionTypeTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionTypeTails}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTypeTails(DartParser.FunctionTypeTailsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionTypeTails}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTypeTails(DartParser.FunctionTypeTailsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(DartParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(DartParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#parameterTypeList}.
	 * @param ctx the parse tree
	 */
	void enterParameterTypeList(DartParser.ParameterTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#parameterTypeList}.
	 * @param ctx the parse tree
	 */
	void exitParameterTypeList(DartParser.ParameterTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#normalParameterTypes}.
	 * @param ctx the parse tree
	 */
	void enterNormalParameterTypes(DartParser.NormalParameterTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#normalParameterTypes}.
	 * @param ctx the parse tree
	 */
	void exitNormalParameterTypes(DartParser.NormalParameterTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#normalParameterType}.
	 * @param ctx the parse tree
	 */
	void enterNormalParameterType(DartParser.NormalParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#normalParameterType}.
	 * @param ctx the parse tree
	 */
	void exitNormalParameterType(DartParser.NormalParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#optionalParameterTypes}.
	 * @param ctx the parse tree
	 */
	void enterOptionalParameterTypes(DartParser.OptionalParameterTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#optionalParameterTypes}.
	 * @param ctx the parse tree
	 */
	void exitOptionalParameterTypes(DartParser.OptionalParameterTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#optionalPositionalParameterTypes}.
	 * @param ctx the parse tree
	 */
	void enterOptionalPositionalParameterTypes(DartParser.OptionalPositionalParameterTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#optionalPositionalParameterTypes}.
	 * @param ctx the parse tree
	 */
	void exitOptionalPositionalParameterTypes(DartParser.OptionalPositionalParameterTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#namedParameterTypes}.
	 * @param ctx the parse tree
	 */
	void enterNamedParameterTypes(DartParser.NamedParameterTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#namedParameterTypes}.
	 * @param ctx the parse tree
	 */
	void exitNamedParameterTypes(DartParser.NamedParameterTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#namedParameterType}.
	 * @param ctx the parse tree
	 */
	void enterNamedParameterType(DartParser.NamedParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#namedParameterType}.
	 * @param ctx the parse tree
	 */
	void exitNamedParameterType(DartParser.NamedParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypedIdentifier(DartParser.TypedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypedIdentifier(DartParser.TypedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#constructorDesignation}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDesignation(DartParser.ConstructorDesignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#constructorDesignation}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDesignation(DartParser.ConstructorDesignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#typeAlias}.
	 * @param ctx the parse tree
	 */
	void enterTypeAlias(DartParser.TypeAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#typeAlias}.
	 * @param ctx the parse tree
	 */
	void exitTypeAlias(DartParser.TypeAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionTypeAlias}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTypeAlias(DartParser.FunctionTypeAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionTypeAlias}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTypeAlias(DartParser.FunctionTypeAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#functionPrefix}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPrefix(DartParser.FunctionPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#functionPrefix}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPrefix(DartParser.FunctionPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link DartParser#singleLineString}.
	 * @param ctx the parse tree
	 */
	void enterSingleLineString(DartParser.SingleLineStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#singleLineString}.
	 * @param ctx the parse tree
	 */
	void exitSingleLineString(DartParser.SingleLineStringContext ctx);
}