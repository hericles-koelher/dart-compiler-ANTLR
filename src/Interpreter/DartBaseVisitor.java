// Generated from /home/otavio/IdeaProjects/dart-compiler-ANTLR/src/Dart.g4 by ANTLR 4.9.1
package Interpreter;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link DartVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class DartBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements DartVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStart(DartParser.StartContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpression(DartParser.ExpressionContext ctx) { return visitChildren(ctx); }
}