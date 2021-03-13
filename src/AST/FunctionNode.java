package AST;

import java.util.LinkedList;

public class FunctionNode implements BaseNode{
    LinkedList<BaseNode> signature;
    LinkedList<BaseNode> body;

    public FunctionNode(LinkedList<BaseNode> signatureNode, LinkedList<BaseNode> functionBody){
        this.body = functionBody;
        this.signature = signatureNode;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName()+"{" +
                "signature" + signature + " body "
                + body + '}';
    }
}
