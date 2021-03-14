package AST;

import Types.Type;

public class VariableDeclarationNode extends AbstractStatementNode{
    public Type type;
    public String name;
    public AbstractExpressionNode initializer;

    //TODO: lembrar de testar unificação de tipos aqui

    public VariableDeclarationNode(Type type, String name){
        this.type = type;
        this.name = name;
    }

    public VariableDeclarationNode(Type type, String name,
                                   AbstractExpressionNode initializer){
        this.type = type;
        this.name = name;
        this.initializer = initializer;
    }

    @Override
    public String toString() {
        return "VariableDeclarationNode{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", varValue='" + initializer + '\'' +
                '}';
    }
}
