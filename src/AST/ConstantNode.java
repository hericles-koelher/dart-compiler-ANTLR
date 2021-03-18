package AST;

import Types.Type;

public class ConstantNode extends AbstractExpressionNode{
    public Type type;
    public String value;

    public ConstantNode(Type type, String value){
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConstantNode{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public Type getType() {
        return type;
    }
}
