package AST;

public class AssignNode extends AbstractTwoChildNode {
    public AssignNode(AbstractNode left, AbstractExpressionNode right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "AssignNode{" +
                left + " = " + right
                + '}';
    }
}
