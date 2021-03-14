package AST;

public class BoolNode extends AbstractExpressionNode{
    public String stringValue;

    public BoolNode(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "BoolNode{" +
                "stringValue='" + stringValue + '\'' +
                '}';
    }
}