import AST.*;
import SymbolTable.FunctionSymbolTable;
import SymbolTable.StringTable;
import SymbolTable.VarSymbolTable;
import Types.Type;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;

public class AstVisitor {
	private final ClassWriter _cw;
	private final Node _ast;
	private final VarSymbolTable _varSymbolTable;
	private final FunctionSymbolTable _functionSymbolTable;
	private final StringTable _stringTable;

	public AstVisitor(Node ast, VarSymbolTable varSymbolTable,
					  FunctionSymbolTable functionSymbolTable,
					  StringTable stringTable){
		_cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		_ast = ast;
		_varSymbolTable = varSymbolTable;
		_functionSymbolTable = functionSymbolTable;
		_stringTable = stringTable;
	}

	private String dartTypeToJvmType(Type type) throws Exception {
		// FIXME:
		return switch (type.name) {
			case Type.INT_NAME -> "I";
			case Type.DOUBLE_NAME -> "D";
			case Type.BOOL_NAME -> "Z";
			case Type.STRING_NAME -> org.objectweb.asm.Type.getDescriptor(String.class);
			// case Type.DYNAMIC_NAME ->  // Nem sei como fazer isso na JVM
			// Pequena gambiarra temporaria
			case Type.DYNAMIC_NAME -> "V";
			// No dart uma função de retorno void retorna um objeto do tipo Null
			// case Type.NULL_NAME ->
			default -> throw new Exception("Erro de conversão de tipos para JVM");
		};
	}

	public void visit(){
		_cw.visit(V1_5, ACC_PUBLIC, "Main", null, null, null);

		for (var childNode: _ast.getChildren()) {
			String className = childNode.getClass().getSimpleName();
			if(className.equals("FunctionDefinitionNode")){
				visitFunctionDefinition((FunctionDefinitionNode) childNode);
			}

			// TODO: Implementar isso aqui depois
			if(className.equals("GlobalVariableNode")){
				visit(childNode);
			}
		}

		// Como o nome do metodo já indica, sinaliza o final da classe.
		_cw.visitEnd();
	}

	private void visit(Node node){
		System.out.println("Ops, não era pra rodar isso!");
		System.out.println(node.getClass());
	}

	private void visitAssign(AssignNode node){
		System.out.println("Assign");
	}

	private void visitFunctionCall(FunctionCallNode node){
		System.out.println("Function Call");
	}

	// Responsavel por gerar o codigo de cada função
	private void visitFunctionDefinition(FunctionDefinitionNode node){
		//TODO: aprender como definir "descriptor list"
		// Link: https://asm.ow2.io/faq.html#Q7
		MethodVisitor mv = null;

		try {
			// Por enquanto assumindo que a função não possui parametros
			mv = _cw.visitMethod(
					ACC_PUBLIC + ACC_STATIC,
					node.name,"()"+dartTypeToJvmType(node.type),
					null, null);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			System.exit(1);
		}

		mv.visitCode();

		for (var childNode: node.getChildren()) {
			switch (childNode.getClass().getSimpleName()){
				case "AssignNode" -> visitAssign((AssignNode) childNode);
				case "FunctionCallNode" -> visitFunctionCall((FunctionCallNode) childNode);
				case "VariableDefinitionNode" -> visitVariableDefinition((VariableDefinitionNode) childNode);
				case "VariableDeclarationNode" -> visitVariableDeclaration((VariableDeclarationNode) childNode);
				default -> visit(childNode);
			}
		}

		// Chamando só por obrigação, pq o tamanho necessário para
		// stack, variaveis e mais já é calculado, pois a classe Main
		// foi definida utilizando a flag COMPUTE_FRAMES.
		mv.visitMaxs(0,0);
		mv.visitEnd();
	}

	private void visitVariableDeclaration(VariableDeclarationNode node){
		System.out.println("Variable Declaration");
	}

	private void visitVariableDefinition(VariableDefinitionNode node){
		System.out.println("Variable Definition");
	}

	public void write(FileOutputStream fileOutputStream){
		try {
			fileOutputStream.write(_cw.toByteArray());
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("\nDeu Ruim :)\n");
		}
	}
}
