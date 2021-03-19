package AST;

import Types.Type;
import Types.TypeManager;

public class GreaterNode extends AbstractTwoChildNode{
    public GreaterNode(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "GreaterNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
