package AST;

import Types.Type;

import java.util.LinkedList;

public class FunctionCallNode extends AbstractExpressionNode{
    public String name;
    public LinkedList<AbstractNode> args;

    public FunctionCallNode(String name, LinkedList<AbstractNode> args){
        this.name = name;
        this.args = args;
        // TODO: verificar se os tipo, nome e posição dos args batem
    }

    // TODO: buscar tipo na tabela de simbolos
    @Override
    public Type getType() {
        return null;
    }

    @Override
    public String toString() {
        return "FunctionCallNode{" +
                "name='" + name + '\'' +
                ", args=" + args +
                '}';
    }
}
