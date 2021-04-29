package AST;

import SymbolTable.ScopeManager;
import Types.Type;

public class VariableNode extends AbstractExpressionNode {
    public String name;
    public Integer scopeId;

    public VariableNode(String name) {
        this.name = name;
        scopeId = ScopeManager.getScopeId();
    }

    @Override
    public String toString() {
        return "VariableNode{" +
                "name='" + name + '\'' +
                '}';
    }

    //TODO: recuperar o tipo a partir da tabela de simbolos...
    @Override
    public Type getType() throws Exception {
        return null;
    }
}
