package AST;

public class IfNode extends AbstractStatementNode{
    public AbstractExpressionNode conditionalExpression;
    public AbstractStatementNode child;
    public AbstractStatementNode elseChild;

    // if-else
    public IfNode(AbstractExpressionNode expr,
                  AbstractStatementNode child,
                  AbstractStatementNode elseChild){
        conditionalExpression = expr;
        this.child = child;
        this.elseChild = elseChild;
    }

    // if
    public IfNode(AbstractExpressionNode expr, AbstractStatementNode child){
        conditionalExpression = expr;
        this.child = child;
    }

    // if without body
    public IfNode(AbstractExpressionNode expr){
        conditionalExpression = expr;
        child = ConstantNode.NullNode;
    }

    @Override
    public String toString() {
        return "IfNode{" +
                "conditionalExpression=" + conditionalExpression +
                ", child=" + child +
                ", elseChild=" + elseChild +
                '}';
    }
}
