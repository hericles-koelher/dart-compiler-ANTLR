package AST;

import Types.Type;

import static Types.TypeUnify.UnifyOther;

public class MultiplicationNode extends AbstractTwoChildNode {
    public MultiplicationNode(AbstractExpressionNode left, AbstractExpressionNode right) {
        super(left, right);
    }

    // TODO: esse daqui tem que retornar a unificação dos tipos de left e right...
    @Override
    public Type getType() throws Exception {
        return UnifyOther(this.left.getType(), this.right.getType()).type;
    }


    @Override
    public String toString() {
        return "PlusNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
