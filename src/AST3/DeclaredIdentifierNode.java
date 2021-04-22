package AST3;

import Types.Type;

public class DeclaredIdentifierNode extends Node {
    public final Type type;
    public final String identifier;
    public final Integer position;

    public DeclaredIdentifierNode(Type type, String identifier, Integer position) {
        this.type = type;
        this.identifier = identifier;
        this.position = position;
    }

    @Override
    protected String nodeInfo() {
        return String.format("%s (%s) %s@%d", this.getClass().getSimpleName(), this.type, this.identifier, this.position);
    }
}
