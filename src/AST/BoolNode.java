package AST;

import Types.Type;
import Types.TypeManager;

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

    @Override
    public Type getType() {
        return TypeManager.getType("bool");
    }
}