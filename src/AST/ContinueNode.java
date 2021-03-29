package AST;

public class ContinueNode extends AbstractStatementNode{
    public static final ContinueNode INSTANCE = new ContinueNode();

    private ContinueNode(){}

    @Override
    public String toString() {
        return "ContinueNode";
    }
}

