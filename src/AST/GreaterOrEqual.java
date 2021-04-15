package AST;

import Types.Type;
import Types.TypeManager;

import static Types.TypeUnify.UnifyComparison;
import static Types.TypeUnify.UnifyOther;

public class GreaterOrEqual extends AbstractTwoChildNode{
    public GreaterOrEqual(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    @Override
    public Type getType() throws Exception {
        //TODO: usar função de unificação quando estiver pronta...
        Type type = UnifyComparison(this.left.getType(), this.right.getType()).type;
        if (type.equals(Type.TYPE_BOOL)) {
            return type;
        } else {
            throw new Exception("Cannot do comparison between types '"
                    + this.left.getType().toString()
                    + "' and '" + this.right.getType().toString() + "' ");
        }
    }



    @Override
    public String toString() {
        return "GreaterOrEqualNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
