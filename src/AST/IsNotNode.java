package AST;

import Types.Type;
import Types.TypeManager;

public class IsNotNode extends AbstractExpressionNode{
    // left pode ser de uma variavel ou uma constante...
    public final AbstractExpressionNode left;
    public final Type right;

    public IsNotNode(AbstractExpressionNode left, Type right){
        this.left = left;
        this.right = right;
    }

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "IsNotNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
