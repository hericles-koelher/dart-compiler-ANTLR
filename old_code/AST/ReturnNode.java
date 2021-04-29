package AST;

public class ReturnNode extends AbstractStatementNode {
    public AbstractExpressionNode child;

    // return;
    public ReturnNode() {
        this.child = ConstantNode.NullNode;
    }

    public ReturnNode(AbstractExpressionNode child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "ReturnNode{" +
                "child=" + child +
                '}';
    }
}
