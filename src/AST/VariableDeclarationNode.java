package AST;

import Types.Type;

public class VariableDeclarationNode extends VariableDefinitionNode{

	public VariableDeclarationNode(Integer scopeId, Type type, String name, Integer position) {
		super(scopeId, type, name, null, position);
	}
}
