package AST;

import Types.Type;

import java.util.List;

public class FunctionDefinitionNode extends Node {
    public final Type type;
    public final String name;

    public FunctionDefinitionNode(Type type, String name, List<Node> nodes) {
        this.type = type;
        this.name = name;
        this.addChildren(nodes);
    }

    @Override
    protected String nodeInfo() {
        return String.format("%s (%s) %s ", this.getClass().getSimpleName(), this.type, this.name);
    }
}
