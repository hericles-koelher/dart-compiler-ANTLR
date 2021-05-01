package AST;

import java.util.LinkedList;

public class FunctionCallNode extends AbstractExpressionNode {
    public String name;

    public FunctionCallNode(String name, LinkedList<Node> args) {
        this.name = name;
        addChildren(args);
    }

    protected String nodeInfo() {
        return String.format("%s %s", this.getClass().getSimpleName(), this.name);
    }
}
