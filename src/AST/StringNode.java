package AST;

public class StringNode extends AbstractExpressionNode{
    public String stringValue;

    public StringNode(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return null;
    }
}
