package AST;

import Types.Type;
import Types.TypeManager;

public class EqualNode extends AbstractTwoChildNode{
    public EqualNode(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "EqualNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
