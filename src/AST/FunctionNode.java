package AST;

import Types.Type;

import java.util.LinkedList;

public class FunctionNode extends AbstractExpressionNode {
    public Type type;
    public String name;
    public LinkedList<ParameterNode> parameters;
    public AbstractNode body;

    public FunctionNode(String name, LinkedList<ParameterNode> parameters, AbstractNode body) {
        this.type = Types.TypeManager.getType("dynamic");
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public FunctionNode(Type type, String name, LinkedList<ParameterNode> parameters, AbstractNode body) {
        this.type = type;
        this.name = name;
        this.parameters = parameters;
        // Aqui adicionar um nó de unificação se necessário
        this.body = body;
    }

    @Override
    public String toString() {
        return "FunctionNode{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", parameters=" + parameters +
                ", body=" + body +
                '}';
    }

    @Override
    public Type getType() throws Exception {
        return type;
    }
}
