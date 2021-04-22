package AST3;

import Types.Type;

import java.util.List;

public class FunctionDefinitionNode extends Node {
    public final Type type;
    public final String identifier;

    public FunctionDefinitionNode(Type type, String identifier, List<Node> nodes) {
        this.type = type;
        this.identifier = identifier;
        this.addChildren(nodes);
    }

    @Override
    protected String nodeInfo() {
        return String.format("%s (%s) %s ", this.getClass().getSimpleName(), this.type, this.identifier);
    }
}
