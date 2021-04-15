package AST;

import Types.Type;

public abstract class AbstractExpressionNode extends AbstractStatementNode{
    public abstract Type getType() throws Exception;
}
