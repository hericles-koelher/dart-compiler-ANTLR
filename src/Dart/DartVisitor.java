// Generated from src/Dart.g4 by ANTLR 4.9.1
package Dart;

import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DartParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DartVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DartParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(DartParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#declaredIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaredIdentifier(DartParser.DeclaredIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#finalConstVarOrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalConstVarOrType(DartParser.FinalConstVarOrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#finalVarOrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalVarOrType(DartParser.FinalVarOrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#varOrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarOrType(DartParser.VarOrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#initializedVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedVariableDeclaration(DartParser.InitializedVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#initializedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedIdentifier(DartParser.InitializedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#initializedIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedIdentifierList(DartParser.InitializedIdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSignature(DartParser.FunctionSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#formalParameterPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterPart(DartParser.FormalParameterPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(DartParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DartParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(DartParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#normalFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFormalParameters(DartParser.NormalFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#optionalOrNamedFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalOrNamedFormalParameters(DartParser.OptionalOrNamedFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#optionalPositionalFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalPositionalFormalParameters(DartParser.OptionalPositionalFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#namedFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedFormalParameters(DartParser.NamedFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#normalFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFormalParameter(DartParser.NormalFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionFormalParameter(DartParser.FunctionFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#simpleFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleFormalParameter(DartParser.SimpleFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#fieldFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldFormalParameter(DartParser.FieldFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#defaultFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultFormalParameter(DartParser.DefaultFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#defaultNamedParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultNamedParameter(DartParser.DefaultNamedParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeWithParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeWithParameters(DartParser.TypeWithParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(DartParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#classMemberDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDefinition(DartParser.ClassMemberDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#methodSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSignature(DartParser.MethodSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(DartParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#staticFinalDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticFinalDeclarationList(DartParser.StaticFinalDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#staticFinalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticFinalDeclaration(DartParser.StaticFinalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#operatorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorSignature(DartParser.OperatorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(DartParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#binaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperator(DartParser.BinaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#getterSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetterSignature(DartParser.GetterSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#setterSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetterSignature(DartParser.SetterSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#constructorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorSignature(DartParser.ConstructorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#constructorName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorName(DartParser.ConstructorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#redirection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedirection(DartParser.RedirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#initializers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializers(DartParser.InitializersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#initializerListEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerListEntry(DartParser.InitializerListEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#fieldInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldInitializer(DartParser.FieldInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#initializerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerExpression(DartParser.InitializerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#factoryConstructorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactoryConstructorSignature(DartParser.FactoryConstructorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#redirectingFactoryConstructorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedirectingFactoryConstructorSignature(DartParser.RedirectingFactoryConstructorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#constantConstructorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantConstructorSignature(DartParser.ConstantConstructorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#superclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclass(DartParser.SuperclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#mixins}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixins(DartParser.MixinsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#interfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaces(DartParser.InterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#mixinApplicationClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinApplicationClass(DartParser.MixinApplicationClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#mixinApplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinApplication(DartParser.MixinApplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#mixinDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinDeclaration(DartParser.MixinDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#enumType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(DartParser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(DartParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(DartParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#enumEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumEntry(DartParser.EnumEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#metadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetadata(DartParser.MetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#metadatum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetadatum(DartParser.MetadatumContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DartParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#expressionWithoutCascade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithoutCascade(DartParser.ExpressionWithoutCascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(DartParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(DartParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(DartParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#nullLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(DartParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(DartParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(DartParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(DartParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#symbolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolLiteral(DartParser.SymbolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(DartParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#setOrMapLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOrMapLiteral(DartParser.SetOrMapLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#elements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElements(DartParser.ElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(DartParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#expressionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionElement(DartParser.ExpressionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#mapElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapElement(DartParser.MapElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#spreadElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpreadElement(DartParser.SpreadElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#ifElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElement(DartParser.IfElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#forElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForElement(DartParser.ForElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#throwExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowExpression(DartParser.ThrowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#throwExpressionWithoutCascade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowExpressionWithoutCascade(DartParser.ThrowExpressionWithoutCascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(DartParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionExpressionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpressionBody(DartParser.FunctionExpressionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionExpressionWithoutCascade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpressionWithoutCascade(DartParser.FunctionExpressionWithoutCascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionExpressionWithoutCascadeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpressionWithoutCascadeBody(DartParser.FunctionExpressionWithoutCascadeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPrimary(DartParser.FunctionPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionPrimaryBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPrimaryBody(DartParser.FunctionPrimaryBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#thisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(DartParser.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(DartParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#constObjectExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstObjectExpression(DartParser.ConstObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(DartParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(DartParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#namedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArgument(DartParser.NamedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#cascade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascade(DartParser.CascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#cascadeSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascadeSection(DartParser.CascadeSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#cascadeSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascadeSelector(DartParser.CascadeSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#cascadeSectionTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascadeSectionTail(DartParser.CascadeSectionTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#cascadeAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascadeAssignment(DartParser.CascadeAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(DartParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#compoundAssignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundAssignmentOperator(DartParser.CompoundAssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(DartParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#ifNullExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNullExpression(DartParser.IfNullExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(DartParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(DartParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(DartParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#equalityOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOperator(DartParser.EqualityOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(DartParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#relationalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalOperator(DartParser.RelationalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#bitwiseOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrExpression(DartParser.BitwiseOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#bitwiseXorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseXorExpression(DartParser.BitwiseXorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#bitwiseAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(DartParser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOperator(DartParser.BitwiseOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(DartParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#shiftOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOperator(DartParser.ShiftOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(DartParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#additiveOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOperator(DartParser.AdditiveOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(DartParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeOperator(DartParser.MultiplicativeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(DartParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#prefixOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOperator(DartParser.PrefixOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#minusOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusOperator(DartParser.MinusOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#negationOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationOperator(DartParser.NegationOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#tildeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTildeOperator(DartParser.TildeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#awaitExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAwaitExpression(DartParser.AwaitExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(DartParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#postfixOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOperator(DartParser.PostfixOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#constructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorInvocation(DartParser.ConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(DartParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#argumentPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentPart(DartParser.ArgumentPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#incrementOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementOperator(DartParser.IncrementOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#assignableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableExpression(DartParser.AssignableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#assignableSelectorPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableSelectorPart(DartParser.AssignableSelectorPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#unconditionalAssignableSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnconditionalAssignableSelector(DartParser.UnconditionalAssignableSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#assignableSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableSelector(DartParser.AssignableSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#identifierNotFUNCTION}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierNotFUNCTION(DartParser.IdentifierNotFUNCTIONContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(DartParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(DartParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(DartParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTest(DartParser.TypeTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#isOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOperator(DartParser.IsOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeCast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCast(DartParser.TypeCastContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#asOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsOperator(DartParser.AsOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(DartParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DartParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#nonLabelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonLabelledStatement(DartParser.NonLabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(DartParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(DartParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#localFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalFunctionDeclaration(DartParser.LocalFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(DartParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(DartParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#forLoopParts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopParts(DartParser.ForLoopPartsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#forInitializerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitializerStatement(DartParser.ForInitializerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(DartParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(DartParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(DartParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#switchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCase(DartParser.SwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#defaultCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultCase(DartParser.DefaultCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#rethrowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRethrowStatement(DartParser.RethrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(DartParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#onPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnPart(DartParser.OnPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#catchPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchPart(DartParser.CatchPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#finallyPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyPart(DartParser.FinallyPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(DartParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(DartParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(DartParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(DartParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(DartParser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#yieldEachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldEachStatement(DartParser.YieldEachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(DartParser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(DartParser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#topLevelDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelDefinition(DartParser.TopLevelDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(DartParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(DartParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeNotVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotVoid(DartParser.TypeNotVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeNotFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotFunction(DartParser.TypeNotFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeNotVoidNotFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotVoidNotFunction(DartParser.TypeNotVoidNotFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(DartParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(DartParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(DartParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeNotVoidNotFunctionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotVoidNotFunctionList(DartParser.TypeNotVoidNotFunctionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionTypeTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeTail(DartParser.FunctionTypeTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionTypeTails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeTails(DartParser.FunctionTypeTailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(DartParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#parameterTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterTypeList(DartParser.ParameterTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#normalParameterTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalParameterTypes(DartParser.NormalParameterTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#normalParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalParameterType(DartParser.NormalParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#optionalParameterTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalParameterTypes(DartParser.OptionalParameterTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#optionalPositionalParameterTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalPositionalParameterTypes(DartParser.OptionalPositionalParameterTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#namedParameterTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedParameterTypes(DartParser.NamedParameterTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#namedParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedParameterType(DartParser.NamedParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedIdentifier(DartParser.TypedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#constructorDesignation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDesignation(DartParser.ConstructorDesignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#typeAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAlias(DartParser.TypeAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionTypeAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeAlias(DartParser.FunctionTypeAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#functionPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPrefix(DartParser.FunctionPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link DartParser#singleLineString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleLineString(DartParser.SingleLineStringContext ctx);
}