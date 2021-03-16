package AST;

import Types.Type;
import Types.TypeManager;

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

    @Override
    public Type getType() {
        return TypeManager.getType("double");
    }
}