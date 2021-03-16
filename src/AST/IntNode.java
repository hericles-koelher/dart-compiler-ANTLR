package AST;

import Types.Type;
import Types.TypeManager;

public class IntNode extends AbstractExpressionNode{
    public String stringValue;

    public IntNode(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "IntNode{" +
                "stringValue='" + stringValue + '\'' +
                '}';
    }

    @Override
    public Type getType() {
        return TypeManager.getType("int");
    }
}
