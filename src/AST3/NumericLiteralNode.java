package AST3;

public class NumericLiteralNode extends LiteralNode {
    public Integer literal;
    public Integer line;

    public NumericLiteralNode(Integer literal, Integer line) {
        this.literal = literal;
        this.line = line;
    }

    @Override
    protected String nodeInfo() {
        return String.format("%s literal: %d", this.getClass().getSimpleName(), this.literal);
    }
}
