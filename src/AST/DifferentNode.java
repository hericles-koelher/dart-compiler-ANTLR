package AST;

import Types.Type;
import Types.TypeManager;

public class DifferentNode extends AbstractTwoChildNode{
    public DifferentNode(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "DifferentNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
