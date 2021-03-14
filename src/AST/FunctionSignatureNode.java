package AST;

import java.util.LinkedList;

public class FunctionSignatureNode extends AbstractNode{

    //TODO: definir tipo como um nó?
    // PS: Acho uma boa ideia
    public AbstractNode type;
    public String name;
    //TODO: definir os tipos de parametros
    // (posicional, opcional nomeado e opcional posicional (e mais tipos se tiver))?
    public LinkedList<AbstractNode> parameters;

    public FunctionSignatureNode(AbstractNode type, String name,
                                 LinkedList<AbstractNode> parameters){
        this.type = type;
        this.name = name;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "FunctionSignatureNode{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
