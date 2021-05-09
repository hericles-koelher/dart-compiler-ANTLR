package AST;

import AST.operations.Operation;
import Types.TypeUnify;

import java.io.FileWriter;

public class OperationNode extends AbstractTwoChildNode{
	public Operation operation;

	public OperationNode(AbstractExpressionNode left, Operation operation, AbstractExpressionNode right) {
		super(left, right);
		// Não fizemos a unificação de tipos, só pegamos o da esquerda.
		TypeUnify resultingType;
		switch(operation) {
			case Addition -> {
				resultingType = TypeUnify.UnifyPlus(left.type, right.type);
			}
			case Equals, NotEquals, Greater, GreaterOrEqual, Less, LessOrEqual  -> {
				resultingType = TypeUnify.UnifyComparison(left.type, right.type);
			}
			default -> {
				resultingType = TypeUnify.UnifyOther(left.type, right.type);
			}
		}

		System.out.printf("Esquerda: %s, Direita: %s, Resultado: %s", left.type, right.type, resultingType.type);

		this.type = resultingType.type;
		this.operation = operation;
	}

	public OperationNode(Operation operation) {
		this.operation = operation;
	}

	@Override
	protected String nodeInfo() {
		return String.format("%s operation: %s", this.getClass().getSimpleName(), this.operation);
	}

	protected int printNode(FileWriter writer) throws Exception {
		Integer my_nr = nr++;

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
