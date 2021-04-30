package AST;

import AST.operations.Operation;

import java.io.FileWriter;

public class OperationNode extends AbstractTwoChildNode{
	public Operation operation;

	public OperationNode(AbstractExpressionNode left, Operation operation, AbstractExpressionNode right) {
		super(left, right);
		this.operation = operation;
	}

	@Override
	protected String nodeInfo() {
		return String.format("%s operation: %s", this.getClass().getSimpleName(), this.operation);
	}

	protected int printNode(FileWriter writer) throws Exception {
		Integer my_nr = Node.nr++;

		writer.write(String.format("node%d[label=\"", my_nr));

		writer.write(this.nodeInfo());

		writer.write("\"];\n");

		Integer child_left = left.printNode(writer);
		writer.write(String.format("node%d -> node%d;\n", my_nr, child_left));

		Integer child_right = right.printNode(writer);
		writer.write(String.format("node%d -> node%d;\n", my_nr, child_right));

		return my_nr;
	}
}
