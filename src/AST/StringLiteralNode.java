package AST;

public class StringLiteralNode extends LiteralNode {
    public final Integer line;

    public StringLiteralNode(String literal, Integer line) {
        this.literal = literal;
        this.line = line;
    }

    @Override
    protected String nodeInfo() {
        // TODO: tirar isso depois, pois só corrige um problema do Graphviz
        String filteredString = this.literal.toString().replace("\"", "");
        return String.format("%s literal: %s", this.getClass().getSimpleName(), filteredString);
    }
}
