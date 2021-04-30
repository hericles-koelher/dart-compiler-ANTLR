package AST;

import Types.Type;

import java.io.FileWriter;
import java.util.LinkedList;

public class FunctionCallNode extends AbstractExpressionNode {
    public String name;
    public LinkedList<AbstractExpressionNode> args;

    public FunctionCallNode(String name, LinkedList<AbstractExpressionNode> args) {
        this.name = name;
        this.args = args;
    }

    protected String nodeInfo() {
        return String.format("%s %s(%s)", this.getClass().getSimpleName(), this.name, args.toString());
    }

    protected int printNode(FileWriter writer) throws Exception {
        Integer my_nr = Node.nr++;

        writer.write(String.format("node%d[label=\"", my_nr));

        writer.write(this.nodeInfo());

        writer.write("\"];\n");

        return my_nr;
    }
}
