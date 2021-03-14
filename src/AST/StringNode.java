package AST;

import Types.Type;
import Types.Types;

public class StringNode extends AbstractExpressionNode{
    public String stringValue;

    public StringNode(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "StringNode{" +
                "stringValue='" + stringValue + '\'' +
                '}';
    }

    @Override
    public Type getType() {
        return Types.getType("String");
    }
}
