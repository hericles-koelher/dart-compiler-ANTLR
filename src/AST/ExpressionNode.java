package AST;

import AST.operations.Operation;

import java.io.FileWriter;

public class ExpressionNode extends StatementsNode {
    public PrimaryNode primaryNode0;
    public PrimaryNode primaryNode1;
    public InitializedVariableNode variableNode0;
    public InitializedVariableNode variableNode1;
    public ExpressionNode expressionNode0;
    public ExpressionNode expressionNode1;
    public Operation operation;

    public ExpressionNode() {
    }

    public ExpressionNode(PrimaryNode primaryNode0, ExpressionNode expressionNode0, Operation operation) {
        this.primaryNode0 = primaryNode0;
        this.expressionNode0 = expressionNode0;
        this.operation = operation;
    }

    public ExpressionNode(InitializedVariableNode variableNode0, ExpressionNode expressionNode0, Operation operation) {
        this.variableNode0 = variableNode0;
        this.expressionNode0 = expressionNode0;
        this.operation = operation;
    }

    public ExpressionNode(ExpressionNode expressionNode0, Operation operation) {
        this.expressionNode0 = expressionNode0;
        this.operation = operation;
    }

    public ExpressionNode(InitializedVariableNode variableNode0, Operation operation) {
        this.variableNode0 = variableNode0;
        this.operation = operation;
    }

    public ExpressionNode(InitializedVariableNode variableNode0, PrimaryNode primaryNode0, Operation operation) {
        this.variableNode0 = variableNode0;
        this.primaryNode0 = primaryNode0;
        this.operation = operation;
    }

    @Override
    protected int printNode(FileWriter writer) throws Exception {
        Integer my_nr = Node.nr++;

        writer.write(String.format("node%d[label=\"", my_nr));

        writer.write(this.nodeInfo());

        writer.write("\"];\n");

        if (this.variableNode0 != null) {
            Integer child_nr = this.variableNode0.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }
        if (this.variableNode1 != null) {
            Integer child_nr = this.variableNode1.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }
        if (this.primaryNode0 != null) {
            Integer child_nr = this.primaryNode0.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }
        if (this.primaryNode1 != null) {
            Integer child_nr = this.primaryNode1.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }
        if (this.expressionNode0 != null) {
            Integer child_nr = this.expressionNode0.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }
        if (this.expressionNode1 != null) {
            Integer child_nr = this.expressionNode1.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }

        return my_nr;
    }

    @Override
    protected String nodeInfo() {
        return String.format("%s operation: %s", this.getClass().getSimpleName(), this.operation);
    }
}
