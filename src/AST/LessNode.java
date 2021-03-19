package AST;

import Types.Type;
import Types.TypeManager;

public class LessNode extends AbstractTwoChildNode{
    public LessNode(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "LessNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
