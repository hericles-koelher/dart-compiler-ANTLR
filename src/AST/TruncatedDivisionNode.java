package AST;

import Types.Type;
import Types.TypeManager;

public class TruncatedDivisionNode extends AbstractTwoChildNode{
    public TruncatedDivisionNode(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    // TODO: esse daqui tem que retornar a unificação dos tipos de left e right...
    @Override
    public Type getType() throws Exception{
        return TypeManager.getType("int");
    }

    @Override
    public String toString() {
        return "PlusNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
