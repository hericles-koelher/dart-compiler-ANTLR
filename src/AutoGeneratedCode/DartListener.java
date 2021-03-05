// Generated from /home/hericles/IdeaProjects/dart-compiler-ANTLR/src/Dart.g4 by ANTLR 4.9.1
package AutoGeneratedCode;
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
	 * Enter a parse tree produced by {@link DartParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(DartParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(DartParser.TypeContext ctx);
}