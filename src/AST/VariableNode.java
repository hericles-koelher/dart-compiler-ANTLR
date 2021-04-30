package AST;

import Types.Type;

import java.io.FileWriter;

public class VariableNode extends AbstractExpressionNode{
	public Integer position;
	public Integer scopeId;
	public String name;

	public VariableNode(Integer position, Integer scopeId, String name){
		this.position = position;
		this.scopeId = scopeId;
		this.name = name;
	}

	protected String nodeInfo() {
		return String.format("%s %s@%d", this.getClass().getSimpleName(), name, position);
	}

	protected int printNode(FileWriter writer) throws Exception {
		Integer my_nr = Node.nr++;

		writer.write(String.format("node%d[label=\"", my_nr));

		writer.write(this.nodeInfo());

		writer.write("\"];\n");

		return my_nr;
	}
}
