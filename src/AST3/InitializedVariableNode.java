package AST3;

import Types.Type;

import java.io.FileWriter;

public class InitializedVariableNode extends Node {
    public Type type;
    public String identifier;
    public Integer position;
    public ExpressionNode expressionNode;

    public InitializedVariableNode(Type type, String identifier, Integer position) {
        this.type = type;
        this.identifier = identifier;
        this.position = position;
    }

    protected int printNode(FileWriter writer) throws Exception {
        Integer my_nr = Node.nr++;

        writer.write(String.format("node%d[label=\"", my_nr));

        writer.write(this.nodeInfo());

        writer.write("\"];\n");

        if (this.expressionNode != null) {
            Integer child_nr = this.expressionNode.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }

        return my_nr;
    }

    protected String nodeInfo() {
        return String.format("%s (%s)%s@%d", this.getClass().getSimpleName(), this.type, this.identifier, this.position);
    }
}
