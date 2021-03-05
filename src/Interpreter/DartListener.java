// Generated from /home/otavio/IdeaProjects/dart-compiler-ANTLR/src/Dart.g4 by ANTLR 4.9.1
package Interpreter;
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
	 * Enter a parse tree produced by {@link DartParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DartParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DartParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DartParser.ExpressionContext ctx);
}