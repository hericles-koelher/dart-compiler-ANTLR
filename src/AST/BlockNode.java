package AST;

import java.util.LinkedList;

public class BlockNode implements BaseNode{
    public LinkedList<BaseNode> statements;

    public BlockNode(LinkedList<BaseNode> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "BlockNode{" +
                "statements=" + statements +
                '}';
    }
}
