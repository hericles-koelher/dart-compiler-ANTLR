package AST;

public class DoubleNode extends AbstractExpressionNode{
    public String stringValue;

    public DoubleNode(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "stringValue='" + stringValue + '\'' +
                '}';
    }
}