import AST3.*;
import AST3.exceptions.IncompleteRuleException;
import AST3.exceptions.NodeNotImplmentedException;
import AST3.operations.Operation;
import AST3.operations.OperationManager;
import Dart.DartBaseVisitor;
import Dart.DartParser;
import SymbolTable.*;
import Types.Type;
import Types.TypeManager;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

public class Visitor3 extends DartBaseVisitor<Node> {

    private final StringTable st;
    private final VarSymbolTable vt;
    private final FunctionSymbolTable ft;

    public Visitor3(StringTable st, VarSymbolTable vt, FunctionSymbolTable ft) {
        this.st = st;
        this.vt = vt;
        this.ft = ft;
        ScopeManager.init();
    }

    @Override
    public Node visitChildren(RuleNode node) {
        throw new NodeNotImplmentedException(node);
    }

    @Override
    public Node visitTerminal(TerminalNode node) {
        throw new NodeNotImplmentedException(node);
    }

    @Override
    public Node visitStart(DartParser.StartContext ctx) {
        Node node = new ProgramNode();

        for (DartParser.TopLevelDefinitionContext c : ctx.topLevelDefinition()) {
            node.addChild(c.accept(this));
        }

        return node;
    }

    @Override
    public Node visitDeclaredIdentifier(DartParser.DeclaredIdentifierContext ctx) {
        if (ctx.COVARIANT() != null) {
            throw new NodeNotImplmentedException();
        }

        IdentifierNode typeIdentifier = (IdentifierNode) ctx.finalConstVarOrType().accept(this);
        IdentifierNode variableNode = (IdentifierNode) ctx.identifier().accept(this);

        Type type = TypeManager.getType(typeIdentifier.identifier);
        String identifier = variableNode.identifier;
        Integer line = variableNode.line;
        Variable var = new Variable(type, identifier, ScopeManager.getScopeId(), line);
        this.vt.addVar(var);


        return new DeclaredIdentifierNode(type, identifier, 0);
    }

    @Override
    public Node visitFinalConstVarOrType(DartParser.FinalConstVarOrTypeContext ctx) {
        if (ctx.FINAL() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.CONST() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.varOrType() != null) {
            return ctx.varOrType().accept(this);
        }

        return null;
    }

    @Override
    public Node visitFinalVarOrType(DartParser.FinalVarOrTypeContext ctx) {
        return super.visitFinalVarOrType(ctx);
    }

    @Override
    public Node visitVarOrType(DartParser.VarOrTypeContext ctx) {
        if (ctx.VAR() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.type() != null) {
            return ctx.type().accept(this);
        }

        return null;
    }

    @Override
    public Node visitInitializedVariableDeclaration(DartParser.InitializedVariableDeclarationContext ctx) {
        if (ctx.initializedIdentifier().size() > 0) {
            throw new NodeNotImplmentedException();
        }

        DeclaredIdentifierNode identifierNode = (DeclaredIdentifierNode) ctx.declaredIdentifier().accept(this);

        ExpressionNode expressionNode = new ExpressionNode();
        InitializedVariableNode varialbleNode = new InitializedVariableNode(
                identifierNode.type, identifierNode.identifier, identifierNode.position
        );
        if (ctx.expression() != null) {
            expressionNode.primaryNode0 = (PrimaryNode) ctx.expression().accept(this);
            expressionNode.operation = Operation.Assignment;
            expressionNode.variableNode0 = varialbleNode;

            return expressionNode;
        }

        return varialbleNode;
    }

    @Override
    public Node visitInitializedIdentifier(DartParser.InitializedIdentifierContext ctx) {
        return super.visitInitializedIdentifier(ctx);
    }

    @Override
    public Node visitInitializedIdentifierList(DartParser.InitializedIdentifierListContext ctx) {
        return super.visitInitializedIdentifierList(ctx);
    }

    @Override
    public Node visitFunctionSignature(DartParser.FunctionSignatureContext ctx) {
        if (ctx.type() != null) {
            throw new NodeNotImplmentedException();
        }

        ctx.metadata().accept(this);
        ctx.formalParameterPart().accept(this);

        return ctx.identifierNotFUNCTION().accept(this);
    }

    @Override
    public Node visitFormalParameterPart(DartParser.FormalParameterPartContext ctx) {
        if (ctx.typeParameters() != null) {
            throw new NodeNotImplmentedException();
        }

        return ctx.formalParameterList().accept(this);
    }

    @Override
    public Node visitFunctionBody(DartParser.FunctionBodyContext ctx) {
        if ((ctx.ASYNC() != null || ctx.SYNC() != null) && ctx.block() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.block() != null) {
            return ctx.block().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitBlock(DartParser.BlockContext ctx) {
        return ctx.statements().accept(this);
    }

    @Override
    public Node visitFormalParameterList(DartParser.FormalParameterListContext ctx) {
        if (ctx.normalFormalParameters() != null || ctx.optionalOrNamedFormalParameters() != null) {
            throw new NodeNotImplmentedException();
        }

        return null;
    }

    @Override
    public Node visitNormalFormalParameters(DartParser.NormalFormalParametersContext ctx) {
        return super.visitNormalFormalParameters(ctx);
    }

    @Override
    public Node visitOptionalOrNamedFormalParameters(DartParser.OptionalOrNamedFormalParametersContext ctx) {
        return super.visitOptionalOrNamedFormalParameters(ctx);
    }

    @Override
    public Node visitOptionalPositionalFormalParameters(DartParser.OptionalPositionalFormalParametersContext ctx) {
        return super.visitOptionalPositionalFormalParameters(ctx);
    }

    @Override
    public Node visitNamedFormalParameters(DartParser.NamedFormalParametersContext ctx) {
        return super.visitNamedFormalParameters(ctx);
    }

    @Override
    public Node visitNormalFormalParameter(DartParser.NormalFormalParameterContext ctx) {
        return super.visitNormalFormalParameter(ctx);
    }

    @Override
    public Node visitFunctionFormalParameter(DartParser.FunctionFormalParameterContext ctx) {
        return super.visitFunctionFormalParameter(ctx);
    }

    @Override
    public Node visitSimpleFormalParameter(DartParser.SimpleFormalParameterContext ctx) {
        return super.visitSimpleFormalParameter(ctx);
    }

    @Override
    public Node visitFieldFormalParameter(DartParser.FieldFormalParameterContext ctx) {
        return super.visitFieldFormalParameter(ctx);
    }

    @Override
    public Node visitDefaultFormalParameter(DartParser.DefaultFormalParameterContext ctx) {
        return super.visitDefaultFormalParameter(ctx);
    }

    @Override
    public Node visitDefaultNamedParameter(DartParser.DefaultNamedParameterContext ctx) {
        return super.visitDefaultNamedParameter(ctx);
    }

    @Override
    public Node visitTypeWithParameters(DartParser.TypeWithParametersContext ctx) {
        return super.visitTypeWithParameters(ctx);
    }

    @Override
    public Node visitClassDeclaration(DartParser.ClassDeclarationContext ctx) {
        return super.visitClassDeclaration(ctx);
    }

    @Override
    public Node visitClassMemberDefinition(DartParser.ClassMemberDefinitionContext ctx) {
        return super.visitClassMemberDefinition(ctx);
    }

    @Override
    public Node visitMethodSignature(DartParser.MethodSignatureContext ctx) {
        return super.visitMethodSignature(ctx);
    }

    @Override
    public Node visitDeclaration(DartParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    @Override
    public Node visitStaticFinalDeclarationList(DartParser.StaticFinalDeclarationListContext ctx) {
        return super.visitStaticFinalDeclarationList(ctx);
    }

    @Override
    public Node visitStaticFinalDeclaration(DartParser.StaticFinalDeclarationContext ctx) {
        return super.visitStaticFinalDeclaration(ctx);
    }

    @Override
    public Node visitOperatorSignature(DartParser.OperatorSignatureContext ctx) {
        return super.visitOperatorSignature(ctx);
    }

    @Override
    public Node visitOperator(DartParser.OperatorContext ctx) {
        return super.visitOperator(ctx);
    }

    @Override
    public Node visitBinaryOperator(DartParser.BinaryOperatorContext ctx) {
        return super.visitBinaryOperator(ctx);
    }

    @Override
    public Node visitGetterSignature(DartParser.GetterSignatureContext ctx) {
        return super.visitGetterSignature(ctx);
    }

    @Override
    public Node visitSetterSignature(DartParser.SetterSignatureContext ctx) {
        return super.visitSetterSignature(ctx);
    }

    @Override
    public Node visitConstructorSignature(DartParser.ConstructorSignatureContext ctx) {
        return super.visitConstructorSignature(ctx);
    }

    @Override
    public Node visitConstructorName(DartParser.ConstructorNameContext ctx) {
        return super.visitConstructorName(ctx);
    }

    @Override
    public Node visitRedirection(DartParser.RedirectionContext ctx) {
        return super.visitRedirection(ctx);
    }

    @Override
    public Node visitInitializers(DartParser.InitializersContext ctx) {
        return super.visitInitializers(ctx);
    }

    @Override
    public Node visitInitializerListEntry(DartParser.InitializerListEntryContext ctx) {
        return super.visitInitializerListEntry(ctx);
    }

    @Override
    public Node visitFieldInitializer(DartParser.FieldInitializerContext ctx) {
        return super.visitFieldInitializer(ctx);
    }

    @Override
    public Node visitInitializerExpression(DartParser.InitializerExpressionContext ctx) {
        return super.visitInitializerExpression(ctx);
    }

    @Override
    public Node visitFactoryConstructorSignature(DartParser.FactoryConstructorSignatureContext ctx) {
        return super.visitFactoryConstructorSignature(ctx);
    }

    @Override
    public Node visitRedirectingFactoryConstructorSignature(DartParser.RedirectingFactoryConstructorSignatureContext ctx) {
        return super.visitRedirectingFactoryConstructorSignature(ctx);
    }

    @Override
    public Node visitConstantConstructorSignature(DartParser.ConstantConstructorSignatureContext ctx) {
        return super.visitConstantConstructorSignature(ctx);
    }

    @Override
    public Node visitSuperclass(DartParser.SuperclassContext ctx) {
        return super.visitSuperclass(ctx);
    }

    @Override
    public Node visitMixins(DartParser.MixinsContext ctx) {
        return super.visitMixins(ctx);
    }

    @Override
    public Node visitInterfaces(DartParser.InterfacesContext ctx) {
        return super.visitInterfaces(ctx);
    }

    @Override
    public Node visitMixinApplicationClass(DartParser.MixinApplicationClassContext ctx) {
        return super.visitMixinApplicationClass(ctx);
    }

    @Override
    public Node visitMixinApplication(DartParser.MixinApplicationContext ctx) {
        return super.visitMixinApplication(ctx);
    }

    @Override
    public Node visitMixinDeclaration(DartParser.MixinDeclarationContext ctx) {
        return super.visitMixinDeclaration(ctx);
    }

    @Override
    public Node visitEnumType(DartParser.EnumTypeContext ctx) {
        return super.visitEnumType(ctx);
    }

    @Override
    public Node visitTypeParameter(DartParser.TypeParameterContext ctx) {
        return super.visitTypeParameter(ctx);
    }

    @Override
    public Node visitTypeParameters(DartParser.TypeParametersContext ctx) {
        return super.visitTypeParameters(ctx);
    }

    @Override
    public Node visitEnumEntry(DartParser.EnumEntryContext ctx) {
        return super.visitEnumEntry(ctx);
    }

    @Override
    public Node visitMetadata(DartParser.MetadataContext ctx) {
        if (ctx.metadatum().size() > 0) {
            throw new NodeNotImplmentedException();
        }

        return null;
    }

    @Override
    public Node visitMetadatum(DartParser.MetadatumContext ctx) {
        return super.visitMetadatum(ctx);
    }

    @Override
    public Node visitExpression(DartParser.ExpressionContext ctx) {
        if (ctx.conditionalExpression() != null) {
            Node node = ctx.conditionalExpression().accept(this);
            if (node instanceof PrimaryNode) {
                if (node instanceof LiteralNode) {
                    return node;
                }
                if (node instanceof IdentifierNode) {
                    IdentifierNode identifierNode = (IdentifierNode) node;
                    Variable v = this.vt.getVar(identifierNode.identifier, ScopeManager.getScopeId());

                    return new InitializedVariableNode(v.type, v.name, 0);
                }

                throw new NodeNotImplmentedException();
            }
            if (node instanceof ExpressionNode) {
                //TODO OLHAR
                return node;
            }

            throw new NodeNotImplmentedException();
        }
        if (ctx.assignableExpression() != null && ctx.assignmentOperator() != null && ctx.expression() != null) {
            ctx.assignmentOperator().accept(this);
            Node node = ctx.expression().accept(this);

            String identifier = ((IdentifierNode) ctx.assignableExpression().accept(this)).identifier;
            Variable v = this.vt.getVar(identifier, ScopeManager.getScopeId());
            InitializedVariableNode variableNode = new InitializedVariableNode(v.type, v.name, 0);

            if (node instanceof ExpressionNode) {
                return new ExpressionNode(variableNode, (ExpressionNode) node, Operation.Assignment);
            }
            if (node instanceof PrimaryNode) {
                return new ExpressionNode(variableNode, (PrimaryNode) node, Operation.Assignment);
            }

            throw new NodeNotImplmentedException();
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitExpressionWithoutCascade(DartParser.ExpressionWithoutCascadeContext ctx) {
        return super.visitExpressionWithoutCascade(ctx);
    }

    @Override
    public Node visitExpressionList(DartParser.ExpressionListContext ctx) {
        if (ctx.expression().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.expression(0).accept(this);
    }

    @Override
    public Node visitPrimary(DartParser.PrimaryContext ctx) {
        if (ctx.identifier() != null) {
            return ctx.identifier().accept(this);
        }
        if (ctx.literal() != null) {
            return ctx.literal().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitLiteral(DartParser.LiteralContext ctx) {
        if (ctx.numericLiteral() != null) {
            return ctx.numericLiteral().accept(this);
        }
        if (ctx.stringLiteral() != null) {
            return ctx.stringLiteral().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitNullLiteral(DartParser.NullLiteralContext ctx) {
        return super.visitNullLiteral(ctx);
    }

    @Override
    public Node visitNumericLiteral(DartParser.NumericLiteralContext ctx) {
        if (ctx.NUMBER() != null) {
            return new NumericLiteralNode(Integer.parseInt(ctx.NUMBER().getText()), ctx.NUMBER().getSymbol().getLine());
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitBooleanLiteral(DartParser.BooleanLiteralContext ctx) {
        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitStringLiteral(DartParser.StringLiteralContext ctx) {
        if (ctx.singleLineString().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.singleLineString(0).accept(this);
    }

    @Override
    public Node visitSymbolLiteral(DartParser.SymbolLiteralContext ctx) {
        return super.visitSymbolLiteral(ctx);
    }

    @Override
    public Node visitListLiteral(DartParser.ListLiteralContext ctx) {
        return super.visitListLiteral(ctx);
    }

    @Override
    public Node visitSetOrMapLiteral(DartParser.SetOrMapLiteralContext ctx) {
        return super.visitSetOrMapLiteral(ctx);
    }

    @Override
    public Node visitElements(DartParser.ElementsContext ctx) {
        return super.visitElements(ctx);
    }

    @Override
    public Node visitElement(DartParser.ElementContext ctx) {
        return super.visitElement(ctx);
    }

    @Override
    public Node visitExpressionElement(DartParser.ExpressionElementContext ctx) {
        return super.visitExpressionElement(ctx);
    }

    @Override
    public Node visitMapElement(DartParser.MapElementContext ctx) {
        return super.visitMapElement(ctx);
    }

    @Override
    public Node visitSpreadElement(DartParser.SpreadElementContext ctx) {
        return super.visitSpreadElement(ctx);
    }

    @Override
    public Node visitIfElement(DartParser.IfElementContext ctx) {
        return super.visitIfElement(ctx);
    }

    @Override
    public Node visitForElement(DartParser.ForElementContext ctx) {
        return super.visitForElement(ctx);
    }

    @Override
    public Node visitThrowExpression(DartParser.ThrowExpressionContext ctx) {
        return super.visitThrowExpression(ctx);
    }

    @Override
    public Node visitThrowExpressionWithoutCascade(DartParser.ThrowExpressionWithoutCascadeContext ctx) {
        return super.visitThrowExpressionWithoutCascade(ctx);
    }

    @Override
    public Node visitFunctionExpression(DartParser.FunctionExpressionContext ctx) {
        return super.visitFunctionExpression(ctx);
    }

    @Override
    public Node visitFunctionExpressionBody(DartParser.FunctionExpressionBodyContext ctx) {
        return super.visitFunctionExpressionBody(ctx);
    }

    @Override
    public Node visitFunctionExpressionWithoutCascade(DartParser.FunctionExpressionWithoutCascadeContext ctx) {
        return super.visitFunctionExpressionWithoutCascade(ctx);
    }

    @Override
    public Node visitFunctionExpressionWithoutCascadeBody(DartParser.FunctionExpressionWithoutCascadeBodyContext ctx) {
        return super.visitFunctionExpressionWithoutCascadeBody(ctx);
    }

    @Override
    public Node visitFunctionPrimary(DartParser.FunctionPrimaryContext ctx) {
        return super.visitFunctionPrimary(ctx);
    }

    @Override
    public Node visitFunctionPrimaryBody(DartParser.FunctionPrimaryBodyContext ctx) {
        return super.visitFunctionPrimaryBody(ctx);
    }

    @Override
    public Node visitThisExpression(DartParser.ThisExpressionContext ctx) {
        return super.visitThisExpression(ctx);
    }

    @Override
    public Node visitNewExpression(DartParser.NewExpressionContext ctx) {
        return super.visitNewExpression(ctx);
    }

    @Override
    public Node visitConstObjectExpression(DartParser.ConstObjectExpressionContext ctx) {
        return super.visitConstObjectExpression(ctx);
    }

    @Override
    public Node visitArguments(DartParser.ArgumentsContext ctx) {
        if (ctx.argumentList() != null) {
            return ctx.argumentList().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitArgumentList(DartParser.ArgumentListContext ctx) {
        if (ctx.namedArgument().size() > 0) {
            throw new NodeNotImplmentedException();
        }

        return ctx.expressionList().accept(this);
    }

    @Override
    public Node visitNamedArgument(DartParser.NamedArgumentContext ctx) {
        return super.visitNamedArgument(ctx);
    }

    @Override
    public Node visitCascade(DartParser.CascadeContext ctx) {
        return super.visitCascade(ctx);
    }

    @Override
    public Node visitCascadeSection(DartParser.CascadeSectionContext ctx) {
        return super.visitCascadeSection(ctx);
    }

    @Override
    public Node visitCascadeSelector(DartParser.CascadeSelectorContext ctx) {
        return super.visitCascadeSelector(ctx);
    }

    @Override
    public Node visitCascadeSectionTail(DartParser.CascadeSectionTailContext ctx) {
        return super.visitCascadeSectionTail(ctx);
    }

    @Override
    public Node visitCascadeAssignment(DartParser.CascadeAssignmentContext ctx) {
        return super.visitCascadeAssignment(ctx);
    }

    @Override
    public Node visitAssignmentOperator(DartParser.AssignmentOperatorContext ctx) {
        if (ctx.compoundAssignmentOperator() != null) {
            throw new NodeNotImplmentedException();
        }

        return null;
    }

    @Override
    public Node visitCompoundAssignmentOperator(DartParser.CompoundAssignmentOperatorContext ctx) {
        return super.visitCompoundAssignmentOperator(ctx);
    }

    @Override
    public Node visitConditionalExpression(DartParser.ConditionalExpressionContext ctx) {
        if (ctx.expressionWithoutCascade().size() > 0) {
            throw new NodeNotImplmentedException();
        }

        return ctx.ifNullExpression().accept(this);
    }

    @Override
    public Node visitIfNullExpression(DartParser.IfNullExpressionContext ctx) {
        if (ctx.logicalOrExpression().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.logicalOrExpression().get(0).accept(this);
    }

    @Override
    public Node visitLogicalOrExpression(DartParser.LogicalOrExpressionContext ctx) {
        if (ctx.logicalAndExpression().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.logicalAndExpression().get(0).accept(this);
    }

    @Override
    public Node visitLogicalAndExpression(DartParser.LogicalAndExpressionContext ctx) {
        if (ctx.equalityExpression().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.equalityExpression().get(0).accept(this);
    }

    @Override
    public Node visitEqualityExpression(DartParser.EqualityExpressionContext ctx) {
        if (ctx.SUPER() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.equalityOperator() != null) {
            throw new NodeNotImplmentedException();
        }

        return ctx.relationalExpression(0).accept(this);
    }

    @Override
    public Node visitEqualityOperator(DartParser.EqualityOperatorContext ctx) {
        return super.visitEqualityOperator(ctx);
    }

    @Override
    public Node visitRelationalExpression(DartParser.RelationalExpressionContext ctx) {
        if (ctx.SUPER() != null) {
            throw new NodeNotImplmentedException();
        }
        if ((ctx.typeTest() != null || ctx.typeCast() != null || ctx.relationalOperator() != null)) {
            throw new NodeNotImplmentedException();
        }

        return ctx.bitwiseOrExpression(0).accept(this);
    }

    @Override
    public Node visitRelationalOperator(DartParser.RelationalOperatorContext ctx) {
        return super.visitRelationalOperator(ctx);
    }

    @Override
    public Node visitBitwiseOrExpression(DartParser.BitwiseOrExpressionContext ctx) {
        if (ctx.SUPER() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.bitwiseXorExpression().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.bitwiseXorExpression(0).accept(this);
    }

    @Override
    public Node visitBitwiseXorExpression(DartParser.BitwiseXorExpressionContext ctx) {
        if (ctx.SUPER() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.bitwiseAndExpression().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.bitwiseAndExpression(0).accept(this);
    }

    @Override
    public Node visitBitwiseAndExpression(DartParser.BitwiseAndExpressionContext ctx) {
        if (ctx.SUPER() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.shiftExpression().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.shiftExpression(0).accept(this);
    }

    @Override
    public Node visitBitwiseOperator(DartParser.BitwiseOperatorContext ctx) {
        return super.visitBitwiseOperator(ctx);
    }

    @Override
    public Node visitShiftExpression(DartParser.ShiftExpressionContext ctx) {
        if (ctx.SUPER() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.additiveExpression().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.additiveExpression(0).accept(this);
    }

    @Override
    public Node visitShiftOperator(DartParser.ShiftOperatorContext ctx) {
        return super.visitShiftOperator(ctx);
    }

    @Override
    public Node visitAdditiveExpression(DartParser.AdditiveExpressionContext ctx) {
        if (ctx.SUPER() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.children.size() > 1) {
            ExpressionNode expressionNode = new ExpressionNode();

            Node n = ctx.children.get(0).accept(this);
            if(n instanceof PrimaryNode) {
                expressionNode.primaryNode0 = (PrimaryNode) n;
            }
            if(n instanceof ExpressionNode) {
                expressionNode.expressionNode0 = (ExpressionNode) n;
            }
            if(n instanceof InitializedVariableNode) {
                expressionNode.variableNode0 = (InitializedVariableNode) n;
            }

            for (int i = 1; i < ctx.children.size(); i += 2) {
                String token = ((TokenNode) ctx.children.get(i).accept(this)).token;
                expressionNode.operation = OperationManager.getOperation(token);

                Node node = ctx.children.get(i + 1).accept(this);
                if (node instanceof LiteralNode) {
                    if(expressionNode.primaryNode0 == null) {
                        expressionNode.primaryNode0 = (LiteralNode) node;
                    } else {
                        expressionNode.primaryNode1 = (LiteralNode) node;
                    }

                    ExpressionNode newExpressionNode = new ExpressionNode();
                    newExpressionNode.expressionNode0 = expressionNode;
                    expressionNode = newExpressionNode;
                }
                if (node instanceof ExpressionNode) {
                    if(expressionNode.expressionNode0 == null) {
                        expressionNode.expressionNode0 = (ExpressionNode) node;
                    } else {
                        expressionNode.expressionNode1 = (ExpressionNode) node;
                    }

                    ExpressionNode newExpressionNode = new ExpressionNode();
                    newExpressionNode.expressionNode0 = expressionNode;
                    expressionNode = newExpressionNode;
                }
            }

            return expressionNode.operation == null ? expressionNode.expressionNode0 : expressionNode;
        }


        return ctx.multiplicativeExpression(0).accept(this);
    }

    @Override
    public Node visitAdditiveOperator(DartParser.AdditiveOperatorContext ctx) {
        TerminalNode terminal = (TerminalNode) ctx.children.get(0);

        return new TokenNode(terminal.getText(), terminal.getSymbol().getLine());
    }

    @Override
    public Node visitMultiplicativeExpression(DartParser.MultiplicativeExpressionContext ctx) {
        if (ctx.SUPER() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.children.size() > 1) {
            ExpressionNode expressionNode = new ExpressionNode();

            Node n = ctx.children.get(0).accept(this);
            if(n instanceof PrimaryNode) {
                expressionNode.primaryNode0 = (PrimaryNode) n;
            }
            if(n instanceof ExpressionNode) {
                expressionNode.expressionNode0 = (ExpressionNode) n;
            }
            if(n instanceof InitializedVariableNode) {
                expressionNode.variableNode0 = (InitializedVariableNode) n;
            }

            for (int i = 1; i < ctx.children.size(); i += 2) {
                String token = ((TokenNode) ctx.children.get(i).accept(this)).token;
                expressionNode.operation = OperationManager.getOperation(token);

                Node node = ctx.children.get(i + 1).accept(this);
                if (node instanceof LiteralNode) {
                    if(expressionNode.primaryNode0 == null) {
                        expressionNode.primaryNode0 = (LiteralNode) node;
                    } else {
                        expressionNode.primaryNode1 = (LiteralNode) node;
                    }

                    ExpressionNode newExpressionNode = new ExpressionNode();
                    newExpressionNode.expressionNode0 = expressionNode;
                    expressionNode = newExpressionNode;
                }
                if (node instanceof ExpressionNode) {
                    if(expressionNode.expressionNode0 == null) {
                        expressionNode.expressionNode0 = (ExpressionNode) node;
                    } else {
                        expressionNode.expressionNode1 = (ExpressionNode) node;
                    }

                    ExpressionNode newExpressionNode = new ExpressionNode();
                    newExpressionNode.expressionNode0 = expressionNode;
                    expressionNode = newExpressionNode;
                }
            }

            return expressionNode.operation == null ? expressionNode.expressionNode0 : expressionNode;
        }

        return ctx.unaryExpression(0).accept(this);
    }

    @Override
    public Node visitMultiplicativeOperator(DartParser.MultiplicativeOperatorContext ctx) {
        TerminalNode terminal = (TerminalNode) ctx.children.get(0);

        return new TokenNode(terminal.getText(), terminal.getSymbol().getLine());    }

    @Override
    public Node visitUnaryExpression(DartParser.UnaryExpressionContext ctx) {
        if (ctx.postfixExpression() != null) {
            return ctx.postfixExpression().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitPrefixOperator(DartParser.PrefixOperatorContext ctx) {
        return super.visitPrefixOperator(ctx);
    }

    @Override
    public Node visitMinusOperator(DartParser.MinusOperatorContext ctx) {
        return super.visitMinusOperator(ctx);
    }

    @Override
    public Node visitNegationOperator(DartParser.NegationOperatorContext ctx) {
        return super.visitNegationOperator(ctx);
    }

    @Override
    public Node visitTildeOperator(DartParser.TildeOperatorContext ctx) {
        return super.visitTildeOperator(ctx);
    }

    @Override
    public Node visitAwaitExpression(DartParser.AwaitExpressionContext ctx) {
        return super.visitAwaitExpression(ctx);
    }

    @Override
    public Node visitPostfixExpression(DartParser.PostfixExpressionContext ctx) {
        if (ctx.primary() != null) {
            if (ctx.selector().size() == 0) {
                return ctx.primary().accept(this);
            }
            if (ctx.selector().size() > 1) {
                throw new NodeNotImplmentedException();
            }

            IdentifierNode primary = (IdentifierNode) ctx.primary().accept(this);
            InitializedVariableNode variableNode = (InitializedVariableNode) ctx.selector(0).accept(this);

            return new ExpressionNode(variableNode, OperationManager.getOperation(primary.identifier));
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitPostfixOperator(DartParser.PostfixOperatorContext ctx) {
        return super.visitPostfixOperator(ctx);
    }

    @Override
    public Node visitConstructorInvocation(DartParser.ConstructorInvocationContext ctx) {
        return super.visitConstructorInvocation(ctx);
    }

    @Override
    public Node visitSelector(DartParser.SelectorContext ctx) {
        if (ctx.argumentPart() != null) {
            return ctx.argumentPart().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitArgumentPart(DartParser.ArgumentPartContext ctx) {
        if (ctx.arguments() != null) {
            return ctx.arguments().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitIncrementOperator(DartParser.IncrementOperatorContext ctx) {
        return super.visitIncrementOperator(ctx);
    }

    @Override
    public Node visitAssignableExpression(DartParser.AssignableExpressionContext ctx) {
        if (ctx.identifier() != null) {
            return ctx.identifier().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitAssignableSelectorPart(DartParser.AssignableSelectorPartContext ctx) {
        return super.visitAssignableSelectorPart(ctx);
    }

    @Override
    public Node visitUnconditionalAssignableSelector(DartParser.UnconditionalAssignableSelectorContext ctx) {
        return super.visitUnconditionalAssignableSelector(ctx);
    }

    @Override
    public Node visitAssignableSelector(DartParser.AssignableSelectorContext ctx) {
        return super.visitAssignableSelector(ctx);
    }

    @Override
    public Node visitIdentifierNotFUNCTION(DartParser.IdentifierNotFUNCTIONContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return new IdentifierNode(ctx.IDENTIFIER().getText(), ctx.IDENTIFIER().getSymbol().getLine());
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitIdentifier(DartParser.IdentifierContext ctx) {
        if (ctx.identifierNotFUNCTION() != null) {
            return ctx.identifierNotFUNCTION().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitQualifiedName(DartParser.QualifiedNameContext ctx) {
        return super.visitQualifiedName(ctx);
    }

    @Override
    public Node visitTypeIdentifier(DartParser.TypeIdentifierContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return new IdentifierNode(ctx.IDENTIFIER().getText(), ctx.IDENTIFIER().getSymbol().getLine());
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitTypeTest(DartParser.TypeTestContext ctx) {
        return super.visitTypeTest(ctx);
    }

    @Override
    public Node visitIsOperator(DartParser.IsOperatorContext ctx) {
        return super.visitIsOperator(ctx);
    }

    @Override
    public Node visitTypeCast(DartParser.TypeCastContext ctx) {
        return super.visitTypeCast(ctx);
    }

    @Override
    public Node visitAsOperator(DartParser.AsOperatorContext ctx) {
        return super.visitAsOperator(ctx);
    }

    @Override
    public Node visitStatements(DartParser.StatementsContext ctx) {
        StatementsNode statements = new StatementsNode();
        for (DartParser.StatementContext c : ctx.statement()) {
            statements.addChild(c.accept(this));
        }

        return statements;
    }

    @Override
    public Node visitStatement(DartParser.StatementContext ctx) {
        if (ctx.label().size() > 0) {
            throw new NodeNotImplmentedException();
        }

        return ctx.nonLabelledStatement().accept(this);
    }

    @Override
    public Node visitNonLabelledStatement(DartParser.NonLabelledStatementContext ctx) {
        if (ctx.localVariableDeclaration() != null) {
            return ctx.localVariableDeclaration().accept(this);
        }
        if (ctx.expressionStatement().accept(this) != null) {
            return ctx.expressionStatement().accept(this);
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitExpressionStatement(DartParser.ExpressionStatementContext ctx) {
        if (ctx.expression() == null) {
            throw new IncompleteRuleException();
        }

        return ctx.expression().accept(this);
    }

    @Override
    public Node visitLocalVariableDeclaration(DartParser.LocalVariableDeclarationContext ctx) {
        ctx.metadata().accept(this);
        return ctx.initializedVariableDeclaration().accept(this);
    }

    @Override
    public Node visitLocalFunctionDeclaration(DartParser.LocalFunctionDeclarationContext ctx) {
        return super.visitLocalFunctionDeclaration(ctx);
    }

    @Override
    public Node visitIfStatement(DartParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public Node visitForStatement(DartParser.ForStatementContext ctx) {
        return super.visitForStatement(ctx);
    }

    @Override
    public Node visitForLoopParts(DartParser.ForLoopPartsContext ctx) {
        return super.visitForLoopParts(ctx);
    }

    @Override
    public Node visitForInitializerStatement(DartParser.ForInitializerStatementContext ctx) {
        return super.visitForInitializerStatement(ctx);
    }

    @Override
    public Node visitWhileStatement(DartParser.WhileStatementContext ctx) {
        return super.visitWhileStatement(ctx);
    }

    @Override
    public Node visitDoStatement(DartParser.DoStatementContext ctx) {
        return super.visitDoStatement(ctx);
    }

    @Override
    public Node visitSwitchStatement(DartParser.SwitchStatementContext ctx) {
        return super.visitSwitchStatement(ctx);
    }

    @Override
    public Node visitSwitchCase(DartParser.SwitchCaseContext ctx) {
        return super.visitSwitchCase(ctx);
    }

    @Override
    public Node visitDefaultCase(DartParser.DefaultCaseContext ctx) {
        return super.visitDefaultCase(ctx);
    }

    @Override
    public Node visitRethrowStatement(DartParser.RethrowStatementContext ctx) {
        return super.visitRethrowStatement(ctx);
    }

    @Override
    public Node visitTryStatement(DartParser.TryStatementContext ctx) {
        return super.visitTryStatement(ctx);
    }

    @Override
    public Node visitOnPart(DartParser.OnPartContext ctx) {
        return super.visitOnPart(ctx);
    }

    @Override
    public Node visitCatchPart(DartParser.CatchPartContext ctx) {
        return super.visitCatchPart(ctx);
    }

    @Override
    public Node visitFinallyPart(DartParser.FinallyPartContext ctx) {
        return super.visitFinallyPart(ctx);
    }

    @Override
    public Node visitReturnStatement(DartParser.ReturnStatementContext ctx) {
        return super.visitReturnStatement(ctx);
    }

    @Override
    public Node visitLabel(DartParser.LabelContext ctx) {
        return super.visitLabel(ctx);
    }

    @Override
    public Node visitBreakStatement(DartParser.BreakStatementContext ctx) {
        return super.visitBreakStatement(ctx);
    }

    @Override
    public Node visitContinueStatement(DartParser.ContinueStatementContext ctx) {
        return super.visitContinueStatement(ctx);
    }

    @Override
    public Node visitYieldStatement(DartParser.YieldStatementContext ctx) {
        return super.visitYieldStatement(ctx);
    }

    @Override
    public Node visitYieldEachStatement(DartParser.YieldEachStatementContext ctx) {
        return super.visitYieldEachStatement(ctx);
    }

    @Override
    public Node visitAssertStatement(DartParser.AssertStatementContext ctx) {
        return super.visitAssertStatement(ctx);
    }

    @Override
    public Node visitAssertion(DartParser.AssertionContext ctx) {
        return super.visitAssertion(ctx);
    }

    @Override
    public Node visitTopLevelDefinition(DartParser.TopLevelDefinitionContext ctx) {
        if (ctx.functionSignature() != null && ctx.functionBody() != null) {
            IdentifierNode signature = (IdentifierNode) ctx.functionSignature().accept(this);
            StatementsNode body = (StatementsNode) ctx.functionBody().accept(this);

            Type type = TypeManager.getType("null");
            String identifier = signature.identifier;
            Integer line = signature.line;

            FunctionDefinitionNode fn = new FunctionDefinitionNode(type, identifier, body.getChildren());
            Function function = new Function(ScopeManager.getScopeId(), line, type, identifier, new ArrayList<>(), new ArrayList<>());

            try {
                this.ft.addFunction(function);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return fn;
        }

        throw new NodeNotImplmentedException();
    }

    @Override
    public Node visitIdentifierList(DartParser.IdentifierListContext ctx) {
        return super.visitIdentifierList(ctx);
    }

    @Override
    public Node visitType(DartParser.TypeContext ctx) {
        if (ctx.functionType() != null) {
            throw new NodeNotImplmentedException();
        }
        if (ctx.typeNotFunction() != null) {
            return ctx.typeNotFunction().accept(this);
        }

        return null;
    }

    @Override
    public Node visitTypeNotVoid(DartParser.TypeNotVoidContext ctx) {
        return super.visitTypeNotVoid(ctx);
    }

    @Override
    public Node visitTypeNotFunction(DartParser.TypeNotFunctionContext ctx) {
        if (ctx.typeNotVoidNotFunction() != null) {
            return ctx.typeNotVoidNotFunction().accept(this);
        }
        if (ctx.VOID() != null) {
            throw new NodeNotImplmentedException();
        }

        return null;
    }

    @Override
    public Node visitTypeNotVoidNotFunction(DartParser.TypeNotVoidNotFunctionContext ctx) {
        if (ctx.typeName() != null) {
            if (ctx.typeArguments() != null) {
                throw new NodeNotImplmentedException();
            }

            return ctx.typeName().accept(this);
        }
        if (ctx.FUNCTION() != null) {
            throw new NodeNotImplmentedException();
        }
        return null;
    }

    @Override
    public Node visitTypeName(DartParser.TypeNameContext ctx) {
        if (ctx.typeIdentifier().size() > 1) {
            throw new NodeNotImplmentedException();
        }

        return ctx.typeIdentifier().get(0).accept(this);
    }

    @Override
    public Node visitTypeArguments(DartParser.TypeArgumentsContext ctx) {
        return super.visitTypeArguments(ctx);
    }

    @Override
    public Node visitTypeList(DartParser.TypeListContext ctx) {
        return super.visitTypeList(ctx);
    }

    @Override
    public Node visitTypeNotVoidNotFunctionList(DartParser.TypeNotVoidNotFunctionListContext ctx) {
        return super.visitTypeNotVoidNotFunctionList(ctx);
    }

    @Override
    public Node visitFunctionTypeTail(DartParser.FunctionTypeTailContext ctx) {
        return super.visitFunctionTypeTail(ctx);
    }

    @Override
    public Node visitFunctionTypeTails(DartParser.FunctionTypeTailsContext ctx) {
        return super.visitFunctionTypeTails(ctx);
    }

    @Override
    public Node visitFunctionType(DartParser.FunctionTypeContext ctx) {
        return super.visitFunctionType(ctx);
    }

    @Override
    public Node visitParameterTypeList(DartParser.ParameterTypeListContext ctx) {
        return super.visitParameterTypeList(ctx);
    }

    @Override
    public Node visitNormalParameterTypes(DartParser.NormalParameterTypesContext ctx) {
        return super.visitNormalParameterTypes(ctx);
    }

    @Override
    public Node visitNormalParameterType(DartParser.NormalParameterTypeContext ctx) {
        return super.visitNormalParameterType(ctx);
    }

    @Override
    public Node visitOptionalParameterTypes(DartParser.OptionalParameterTypesContext ctx) {
        return super.visitOptionalParameterTypes(ctx);
    }

    @Override
    public Node visitOptionalPositionalParameterTypes(DartParser.OptionalPositionalParameterTypesContext ctx) {
        return super.visitOptionalPositionalParameterTypes(ctx);
    }

    @Override
    public Node visitNamedParameterTypes(DartParser.NamedParameterTypesContext ctx) {
        return super.visitNamedParameterTypes(ctx);
    }

    @Override
    public Node visitNamedParameterType(DartParser.NamedParameterTypeContext ctx) {
        return super.visitNamedParameterType(ctx);
    }

    @Override
    public Node visitTypedIdentifier(DartParser.TypedIdentifierContext ctx) {
        return super.visitTypedIdentifier(ctx);
    }

    @Override
    public Node visitConstructorDesignation(DartParser.ConstructorDesignationContext ctx) {
        return super.visitConstructorDesignation(ctx);
    }

    @Override
    public Node visitTypeAlias(DartParser.TypeAliasContext ctx) {
        return super.visitTypeAlias(ctx);
    }

    @Override
    public Node visitFunctionTypeAlias(DartParser.FunctionTypeAliasContext ctx) {
        return super.visitFunctionTypeAlias(ctx);
    }

    @Override
    public Node visitFunctionPrefix(DartParser.FunctionPrefixContext ctx) {
        return super.visitFunctionPrefix(ctx);
    }

    @Override
    public Node visitSingleLineString(DartParser.SingleLineStringContext ctx) {
        if (ctx.SINGLE_LINE_STRING_DQ_BEGIN_END() != null) {
            return new StringLiteralNode(
                    ctx.SINGLE_LINE_STRING_DQ_BEGIN_END().getText().replace("\"", "\\\""),
                    ctx.SINGLE_LINE_STRING_DQ_BEGIN_END().getSymbol().getLine()
            );
        }

        throw new NodeNotImplmentedException();
    }
}
