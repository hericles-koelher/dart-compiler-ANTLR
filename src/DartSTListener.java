// Só uns testes.

public class DartSTListener extends DartBaseListener{
    @Override
    public void exitLocalVariableDeclaration(DartParser.LocalVariableDeclarationContext ctx) {
        super.exitLocalVariableDeclaration(ctx);

        String type = ctx.initializedVariableDeclaration().declaredIdentifier().finalConstVarOrType().getText();

        System.out.println(type + " : " + ctx.initializedVariableDeclaration()
                .declaredIdentifier().identifier().getText());

        for(var i : ctx.initializedVariableDeclaration().initializedIdentifier()){
            System.out.println(type + " : " + i.identifier().getText());
        }
    }

    @Override
    public void exitFormalParameterPart(DartParser.FormalParameterPartContext ctx) {
        super.exitFormalParameterPart(ctx);
        System.out.println(ctx.getText());
    }
}
