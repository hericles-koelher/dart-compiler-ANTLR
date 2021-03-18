package AST;

import java.util.LinkedList;

public class BlockNode extends AbstractNode{
    public LinkedList<AbstractStatementNode> children;

    public BlockNode(LinkedList<AbstractStatementNode> statements) {
        this.children = statements;
    }

    @Override
    public String toString() {
        return "BlockNode{" +
                "statements=" + children +
                '}';
    }
}
