package AST;

import java.util.LinkedList;

public class BlockNode extends AbstractMultChildNode{
    public BlockNode(LinkedList<AbstractNode> statements) {
        this.children = statements;
    }

    @Override
    public String toString() {
        return "BlockNode{" +
                "statements=" + children +
                '}';
    }
}
