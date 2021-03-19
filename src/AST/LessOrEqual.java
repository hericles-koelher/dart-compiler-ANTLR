package AST;

import Types.Type;
import Types.TypeManager;

public class LessOrEqual extends AbstractTwoChildNode{
    public LessOrEqual(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "LessOrEqualNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
