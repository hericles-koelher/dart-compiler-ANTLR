package AST;

import Types.Type;

public class ParameterNode extends AbstractExpressionNode{
    public final ParameterType paramType;
    public final Type type;
    public final String name;
    public final AbstractExpressionNode initializer;

    public enum ParameterType{
        Positional, OptionalNamed, OptionalPositional
    }

    public ParameterNode(ParameterType paramType, Type type, String name) {
        this.paramType = paramType;
        this.type = type;
        this.name = name;
        initializer = null;
    }

    public ParameterNode(ParameterType paramType, Type type, String name, AbstractExpressionNode initializer) {
        this.paramType = paramType;
        this.type = type;
        this.name = name;
        this.initializer = initializer;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return null;
    }
}
