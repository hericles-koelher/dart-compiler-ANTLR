package AST;

import Types.Type;

public class PlusNode extends AbstractTwoChildNode{
    public PlusNode(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
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
