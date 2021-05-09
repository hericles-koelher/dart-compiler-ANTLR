package AST;

import java.io.FileWriter;

public class WhileNode extends Node {
    public AbstractExpressionNode abstractExpressionNode;
    public StatementsNode statementsNode;

    protected int printNode(FileWriter writer) throws Exception {
        Integer my_nr = nr++;

        writer.write(String.format("node%d[label=\"", my_nr));

        writer.write(this.nodeInfo());

        writer.write("\"];\n");

        Integer child_left = abstractExpressionNode.printNode(writer);
        writer.write(String.format("node%d -> node%d;\n", my_nr, child_left));

        Integer child_right = statementsNode.printNode(writer);
        writer.write(String.format("node%d -> node%d;\n", my_nr, child_right));

        return my_nr;
    }
}
