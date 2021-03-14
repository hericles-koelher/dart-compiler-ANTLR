package AST;

public class IntNode extends AbstractExpressionNode{
    public String stringValue;

    public IntNode(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return null;
    }
}
