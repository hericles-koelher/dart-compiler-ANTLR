package AST;

import Types.Type;

public class AsNode extends AbstractExpressionNode{
    // left pode ser de uma variavel ou uma constante...
    public final AbstractExpressionNode left;
    public final Type right;

    public AsNode(AbstractExpressionNode left, Type right){
        this.left = left;
        this.right = right;
    }

    @Override
    public Type getType() throws Exception{
        return right;
    }

    @Override
    public String toString() {
        return "AsNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
