package AST;

public class AssignNode extends ExpressionNode{
    //TODO: decompor o lado esquerdo quando List, Map e Set forem adicionados
    public BaseNode left;
    public ExpressionNode right;

    public AssignNode(BaseNode left, ExpressionNode right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "AssignNode{" +
                left + " = " + right
                + '}';
    }
}
