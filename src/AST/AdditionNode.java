package AST;

import Types.Type;

import static Types.TypeUnify.UnifyPlus;

public class AdditionNode extends AbstractTwoChildNode {
    public AdditionNode(AbstractExpressionNode left, AbstractExpressionNode right) {
        super(left, right);
    }

    // TODO: esse daqui tem que retornar a unificação dos tipos de left e right...
    @Override
    public Type getType() throws Exception {
        return UnifyPlus(this.left.getType(), this.right.getType()).type;
    }

    @Override
    public String toString() {
        return "PlusNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
