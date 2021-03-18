package AST;

import Types.Type;

import java.util.LinkedList;

public class FunctionNode extends AbstractExpressionNode{
    public Type type;
    public String name;
    public LinkedList<AbstractNode> parameters;
    public AbstractNode body;

    //TODO: definir os tipos de parametros
    // (posicional, opcional nomeado e opcional posicional (e mais tipos se tiver))?

    //TODO: atualizar a tabela de simbolos aqui.
    public FunctionNode(Type type, String name, LinkedList<AbstractNode> parameters, AbstractNode body){
        this.type = type;
        this.name = name;
        this.parameters = parameters;
        // Aqui adicionar um nó de unificação se necessário
        this.body = body;
    }

    @Override
    public String toString() {
        return "FunctionNode{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", parameters=" + parameters +
                ", body=" + body +
                '}';
    }

    @Override
    public Type getType() {
        return type;
    }
}
