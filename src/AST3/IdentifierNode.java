package AST3;

public class IdentifierNode extends PrimaryNode {
    public final String identifier;
    public final Integer line;

    public IdentifierNode(String identifier, Integer line) {
        this.identifier = identifier;
        this.line = line;
    }

    @Override
    protected String nodeInfo() {
        return String.format("%s token: %s line: %d", this.getClass().getSimpleName(), this.identifier, this.line);
    }
}
