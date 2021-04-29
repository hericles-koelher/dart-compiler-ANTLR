package AST;

import Types.Type;

import java.util.LinkedList;

public class FunctionNode extends AbstractExpressionNode {
    public String name;
    public Integer scopeId;
    public AbstractNode body;

    public FunctionNode(Integer scopeId, String name, AbstractNode body) {
        this.name = name;
        this.scopeId = scopeId;
        this.body = body;
    }

    public FunctionNode(Integer scopeId, String name, LinkedList<ParameterNode> parameters, AbstractNode body) {
        this.name = name;
        this.scopeId = scopeId;
        // Aqui adicionar um nó de unificação se necessário
        this.body = body;
    }

    @Override
    public Type getType() throws Exception {
        // TODO: recuperar tipo da tabela
        return null;
    }
}
