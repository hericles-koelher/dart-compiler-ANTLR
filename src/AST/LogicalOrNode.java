package AST;

import Types.Type;
import Types.TypeManager;

public class LogicalOrNode extends AbstractTwoChildNode{
    public LogicalOrNode(AbstractExpressionNode left, AbstractExpressionNode right){
        super(left, right);
    }

    @Override
    public Type getType() throws Exception{
        return TypeManager.getType("bool");
    }

    @Override
    public String toString() {
        return "LogicalOrNode{"+
                "left="+left+
                ", right="+right+
                '}';
    }
}
