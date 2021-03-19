package AST;

import Types.Type;
import Types.TypeManager;

public class IsNode extends AbstractExpressionNode{
    // left pode ser de uma variavel ou uma constante...
    public final AbstractExpressionNode left;
    public final Type right;

    public IsNode(AbstractExpressionNode left, Type right){
        this.left = left;
        this.right = right;
    }

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "IsNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
