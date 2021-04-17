package AST;

import Types.Type;

public class ConditionalExpressionNode extends AbstractExpressionNode {
    //TODO: forçar evaluableExpression a ser booleana
    public AbstractExpressionNode evaluableExpression;
    public AbstractExpressionNode firstOption;
    public AbstractExpressionNode secondOption;

    ConditionalExpressionNode(AbstractExpressionNode evalExp, AbstractExpressionNode firstOption, AbstractExpressionNode secondOption) {
        this.evaluableExpression = evalExp;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
    }

    @Override
    public String toString() {
        return "ConditionalExpressionNode{" +
                "evaluableExpression=" + evaluableExpression +
                ", firstOption=" + firstOption +
                ", secondOption=" + secondOption +
                '}';
    }

    @Override
    public Type getType() {
        //TODO: usar função de unificação quando estiver pronta...
        return null;
    }
}
