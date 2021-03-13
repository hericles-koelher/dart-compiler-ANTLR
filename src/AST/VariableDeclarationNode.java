package AST;

public class VariableDeclarationNode implements BaseNode{
    //TODO: mudar esse esquema de tipo?
    public String type;
    public String name;
    public ExpressionNode value;

    public VariableDeclarationNode(String type, String name){
        this.type = type;
        this.name = name;
    }

    public VariableDeclarationNode(String type, String name, ExpressionNode varValue){
        this.type = type;
        this.name = name;
        this.value = varValue;
    }

    @Override
    public String toString() {
        return "VariableDeclarationNode{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", varValue='" + value + '\'' +
                '}';
    }
}
