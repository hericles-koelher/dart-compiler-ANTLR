package AST;

import Types.Type;
import SymbolTable.*;

public class VariableNode extends AbstractExpressionNode{
    public String name;
    public Integer scopeId;

    public VariableNode(String name){
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
    // chato vai ser bolar um esquema pro escopo...
    @Override
    public Type getType() {
        return null;
    }
}
