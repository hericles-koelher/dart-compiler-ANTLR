package AST;

import java.util.LinkedList;

public class BlockNode extends AbstractStatementNode{
    public final LinkedList<AbstractStatementNode> children;

    public BlockNode(LinkedList<AbstractStatementNode> children) {
            this.children = children;
    }

    @Override
    public String toString() {
        return "BlockNode{" +
                "statements=" + children +
                '}';
    }
}
