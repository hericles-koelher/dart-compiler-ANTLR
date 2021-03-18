package AST;

import Types.Type;

public class AssignNode extends AbstractTwoChildNode {
    public AssignNode(VariableNode left, AbstractExpressionNode right){
        // TODO: outro lugar pra testar unificação dps
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "AssignNode{" +
                left + " = " + right
                + '}';
    }

    @Override
    public Type getType() {
        return left.getType();
    }
}
