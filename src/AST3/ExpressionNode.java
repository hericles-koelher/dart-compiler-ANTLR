package AST3;

import AST3.operations.Operation;

import java.io.FileWriter;

public class ExpressionNode extends StatementsNode {
    public PrimaryNode primaryNode0;
    public PrimaryNode primaryNode1;
    public InitializedVariableNode variableNode;
    public ExpressionNode expressionNode;
    public Operation operation;

    public ExpressionNode() {
    }

    public ExpressionNode(PrimaryNode primaryNode0, ExpressionNode expressionNode, Operation operation) {
        this.primaryNode0 = primaryNode0;
        this.expressionNode = expressionNode;
        this.operation = operation;
    }

    public ExpressionNode(InitializedVariableNode variableNode, ExpressionNode expressionNode, Operation operation) {
        this.variableNode = variableNode;
        this.expressionNode = expressionNode;
        this.operation = operation;
    }

    public ExpressionNode(ExpressionNode expressionNode, Operation operation) {
        this.expressionNode = expressionNode;
        this.operation = operation;
    }

    public ExpressionNode(InitializedVariableNode variableNode, Operation operation) {
        this.variableNode = variableNode;
        this.operation = operation;
    }

    public ExpressionNode(InitializedVariableNode variableNode, PrimaryNode primaryNode0, Operation operation) {
        this.variableNode = variableNode;
        this.primaryNode0 = primaryNode0;
        this.operation = operation;
    }

    @Override
    protected int printNode(FileWriter writer) throws Exception {
        Integer my_nr = Node.nr++;

        writer.write(String.format("node%d[label=\"", my_nr));

        writer.write(this.nodeInfo());

        writer.write("\"];\n");

        if (this.variableNode != null) {
            Integer child_nr = this.variableNode.printNode(writer);
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
        if (this.expressionNode != null) {
            Integer child_nr = this.expressionNode.printNode(writer);
            writer.write(String.format("node%d -> node%d;\n", my_nr, child_nr));
        }

        return my_nr;
    }

    @Override
    protected String nodeInfo() {
        return String.format("%s operation: %s", this.getClass().getSimpleName(), this.operation);
    }
}
