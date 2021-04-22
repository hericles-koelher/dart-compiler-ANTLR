package AST3;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class Node {
    protected static Integer nr;
    private final List<Node> children = new ArrayList<>();

    public void addChild(Node node) {
        if (node != null) {
            this.children.add(node);
        }
    }

    public Node getChild(int i) {
        return this.children.get(i);
    }

    public void addChildren(List<Node> nodes) {
        this.children.addAll(nodes);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public void print(FileWriter writer) throws Exception {
        Node.nr = 0;
        writer.write("digraph {\ngraph [ordering=\"out\"];\n");
        printNode(writer);
        writer.write("}\n");
    }

    protected int printNode(FileWriter writer) throws Exception {
        Integer my_nr = Node.nr++;

        writer.write(String.format("node%d[label=\"", my_nr));

        writer.write(this.nodeInfo());

        writer.write("\"];\n");

        for (Node child : this.getChildren()) {
            Integer child_nr = child.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }

        return my_nr;
    }

    protected String nodeInfo() {
        return String.format("%s ", this.getClass().getSimpleName());
    }
}
