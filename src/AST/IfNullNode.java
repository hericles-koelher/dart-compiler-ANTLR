package AST;

import Types.Type;

public class IfNullNode extends AbstractTwoChildNode{
    public IfNullNode(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    // TODO: esse daqui tem que retornar a unificação dos tipos de left e right...
    @Override
    public Type getType() {
        return null;
    }

    @Override
    public String toString() {
        return "IfNullNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
