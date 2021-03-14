package AST;

public class FunctionNode extends AbstractNode{
    public FunctionSignatureNode signature;
    public AbstractNode body;

    public FunctionNode(FunctionSignatureNode signatureNode, AbstractNode body){
        this.body = body;
        this.signature = signatureNode;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName()+"{" +
                "signature" + signature + " body "
                + body + '}';
    }
}
