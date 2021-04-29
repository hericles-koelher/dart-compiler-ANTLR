package AST;

import Types.Type;
import Types.TypeManager;

public class LogicalAndNode extends AbstractTwoChildNode {
    public LogicalAndNode(AbstractExpressionNode left, AbstractExpressionNode right) {
        super(left, right);
    }

    @Override
    public Type getType() throws Exception {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "LogicalAndNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
