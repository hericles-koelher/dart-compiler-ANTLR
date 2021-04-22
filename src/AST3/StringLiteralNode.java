package AST3;

public class StringLiteralNode extends LiteralNode {
    public final String literal;
    public final Integer line;

    public StringLiteralNode(String literal, Integer line) {
        this.literal = literal;
        this.line = line;
    }

    @Override
    protected String nodeInfo() {
        return String.format("%s literal: %s", this.getClass().getSimpleName(), this.literal);
    }
}
