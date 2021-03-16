package AST;

import Types.Type;

public class FunctionNode extends AbstractExpressionNode{
    public FunctionSignatureNode signature;
    public AbstractNode body;

    public FunctionNode(FunctionSignatureNode signatureNode, AbstractNode body){
        // Aqui fazer uma unificação se necessário
        this.body = body;
        this.signature = signatureNode;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName()+"{" +
                "signature" + signature + " body "
                + body + '}';
    }

    @Override
    public Type getType() {
        Type funcReturnType = signature.getFunctionType();
        Type bodyReturnType = null;

        if(body instanceof AbstractExpressionNode){
            bodyReturnType = ((AbstractExpressionNode) body).getType();
        } else{
            // Aqui seria necessário ver o tipo do statement return...
        }



        return null;
    }
}
