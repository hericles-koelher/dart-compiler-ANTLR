package AST;

import Types.Type;

import java.util.LinkedList;

// Pensando que talvez fosse melhor excluir esse nó e transferir seu conteudo para FunctionNode

public class FunctionSignatureNode extends AbstractNode{

    public Type type;
    public String name;
    //TODO: definir os tipos de parametros
    // (posicional, opcional nomeado e opcional posicional (e mais tipos se tiver))?
    public LinkedList<AbstractNode> parameters;

    public FunctionSignatureNode(String name,
                                 LinkedList<AbstractNode> parameters){
        this.name = name;
        this.parameters = parameters;
    }

    public FunctionSignatureNode(Type type, String name,
                                 LinkedList<AbstractNode> parameters){
        this.type = type;
        this.name = name;
        this.parameters = parameters;
    }

    public Type getFunctionType(){
        return this.type;
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
