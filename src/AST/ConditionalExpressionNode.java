package AST;

public class ConditionalExpressionNode extends ExpressionNode{
    public BaseNode evaluableExpression;
    public ExpressionNode firstOption;
    public ExpressionNode secondOption;

    ConditionalExpressionNode(BaseNode evalExp, ExpressionNode firstOption, ExpressionNode secondOption){
        this.evaluableExpression = evalExp;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
    }
}
