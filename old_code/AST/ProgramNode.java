package AST;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends AbstractNode {

    List<AbstractNode> children = new ArrayList<>();

    public void addChild(AbstractNode node) {
        if (node != null) {
            this.children.add(node);
        }
    }

    public void addChildren(List<AbstractNode> nodes) {
        this.children.addAll(nodes);
    }

    public void print() {

    }
}
