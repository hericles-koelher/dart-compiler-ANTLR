package AST;

public class DoWhileNode extends AbstractStatementNode{
    public AbstractExpressionNode conditionalExpression;
    public AbstractStatementNode child;

    public DoWhileNode(AbstractExpressionNode expr, AbstractStatementNode child){
        conditionalExpression = expr;
        this.child = child;
    }

    public DoWhileNode(AbstractExpressionNode expr){
        conditionalExpression = expr;
        child = ConstantNode.NullNode;
    }

    @Override
    public String toString() {
        return "DoWhileNode{" +
                "conditionalExpression=" + conditionalExpression +
                ", child=" + child +
                '}';
    }
}
