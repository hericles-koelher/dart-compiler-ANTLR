package AST;

import Types.Type;

import static Types.TypeUnify.UnifyComparison;

public class LessNode extends AbstractTwoChildNode {
    public LessNode(AbstractExpressionNode left, AbstractExpressionNode right) {
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
        return "LessNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
