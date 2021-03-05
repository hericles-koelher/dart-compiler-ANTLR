// Generated from /home/otavio/IdeaProjects/dart-compiler-ANTLR/src/Dart.g4 by ANTLR 4.9.1
package Interpreter;
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
	 * Visit a parse tree produced by {@link DartParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DartParser.ExpressionContext ctx);
}