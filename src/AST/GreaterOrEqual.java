package AST;

import Types.Type;
import Types.TypeManager;

public class GreaterOrEqual extends AbstractTwoChildNode{
    public GreaterOrEqual(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "GreaterOrEqualNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
