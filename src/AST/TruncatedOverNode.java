package AST;

import Types.Type;

public class TruncatedOverNode extends AbstractTwoChildNode{
    public TruncatedOverNode(AbstractExpressionNode left, AbstractExpressionNode right){
        this.left = left;
        this.right = right;
    }

    // TODO: esse daqui tem que retornar a unificação dos tipos de left e right...
    @Override
    public Type getType() {
        return null;
    }

    @Override
    public String toString() {
        return "PlusNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
