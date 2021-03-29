package AST;

public class BreakNode extends AbstractStatementNode{
    public static final BreakNode INSTANCE = new BreakNode();

    private BreakNode(){}

    @Override
    public String toString() {
        return "BreakNode";
    }
}
