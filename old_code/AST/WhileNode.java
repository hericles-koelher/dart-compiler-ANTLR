package AST;

public class WhileNode extends AbstractStatementNode {
    public AbstractExpressionNode conditionalExpression;
    public AbstractStatementNode child;

    public WhileNode(AbstractExpressionNode expr, AbstractStatementNode child) {
        conditionalExpression = expr;
        this.child = child;
    }

    public WhileNode(AbstractExpressionNode expr) {
        conditionalExpression = expr;
        child = ConstantNode.NullNode;
    }

    @Override
    public String toString() {
        return "WhileNode{" +
                "conditionalExpression=" + conditionalExpression +
                ", child=" + child +
                '}';
    }
}
