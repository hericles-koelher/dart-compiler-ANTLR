import AST.*;

import java.util.LinkedList;

// OBS: Esse código é só pra testes...
// ignorem toda e qualquer gambiarra eheueheuhee

class GlobalVisitor extends DartBaseVisitor<BaseNode>{
    @Override
    public BaseNode visitTopLevelDefinition(DartParser.TopLevelDefinitionContext ctx) {
        //Visitando somente funções.

        if(ctx.functionSignature() != null && ctx.functionBody() != null){
            var body = new LinkedList<BaseNode>();

            if (ctx.functionBody().expression() != null){
                //body.add(new ExpressionNode(visitExpression(ctx.functionBody().expression())));
            }else{
                for (var st: ctx.functionBody().block().statements().statement()) {
                    body.add(visitNonLabelledStatement(st.nonLabelledStatement()));
                }
            }

            return new FunctionNode(null, body);

        }

        return super.visitTopLevelDefinition(ctx);
    }

    @Override
    public BaseNode visitNonLabelledStatement(DartParser.NonLabelledStatementContext ctx) {
        if(ctx.localVariableDeclaration() != null){
            var x = ctx.localVariableDeclaration()
                    .initializedVariableDeclaration()
                            .declaredIdentifier();


            return new VariableDeclarationNode(x.finalConstVarOrType().getText(),x.identifier().getText());
        }

        return null;
    }
}