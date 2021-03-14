package AST;

public class VariableDeclarationNode extends AbstractStatementNode{
    //TODO: mudar esse esquema de tipo?
    public String type;
    public String name;
    public AbstractExpressionNode initializer;

    public VariableDeclarationNode(String type, String name){
        this.type = type;
        this.name = name;
    }

    public VariableDeclarationNode(String type, String name,
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
