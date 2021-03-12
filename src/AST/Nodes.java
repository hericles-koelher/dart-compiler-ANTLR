package AST;

import java.util.LinkedList;

public class Nodes {

    public abstract class AbstractNode {
        public LinkedList<AbstractNode> children;
    }

    private abstract class NumberNode extends AbstractNode{}

    public class IntNode extends NumberNode{}

    public class DoubleNode extends NumberNode{}

    public class StringNode extends AbstractNode{}

    public class BoolNode extends AbstractNode{}

    public class NullNode extends AbstractNode{}

    public class ExpressionNode extends AbstractNode{
        ExpressionNode(AbstractNode child){
            children = new LinkedList<AbstractNode>();
            children.add(child);
        }
    }

    //TODO: analisar como resolver isso aqui depois.

    // public class ListNode extends AbstractNode{}

    // public class MapNode extends AbstractNode{}

    // public class SetNode extends AbstractNode{}
}
