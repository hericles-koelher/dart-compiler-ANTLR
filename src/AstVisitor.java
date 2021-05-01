import AST.*;
import SymbolTable.FunctionSymbolTable;
import SymbolTable.StringTable;
import SymbolTable.VarSymbolTable;
import Types.Type;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import static org.objectweb.asm.Opcodes.*;

public class AstVisitor {
	private final ClassWriter _cw;
	private final Node _ast;
	private final VarSymbolTable _varSymbolTable;
	private final FunctionSymbolTable _functionSymbolTable;
	private final StringTable _stringTable;
	private int newLocalVariableIndex = 0;

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
			// Uma array de char
			case Type.STRING_NAME -> "[C";
			// case Type.DYNAMIC_NAME ->  // Nem sei como fazer isso na JVM
			// Pequena gambiarra temporaria
			case Type.DYNAMIC_NAME -> "V";
			// No dart uma função de retorno void retorna um objeto do tipo Null
			// case Type.NULL_NAME ->
			default -> throw new Exception("Erro de conversão de tipos para JVM");
		};
	}

	public void visit(){
		_cw.visit(V14, ACC_PUBLIC, "Main", null, "java/lang/Object", null);

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

	private void visitAssign(AssignNode node,
							 MethodVisitor mv, HashMap<String, Integer> varIndex){
		System.out.println("Assign");
	}

	private void visitFunctionCall(FunctionCallNode node,
								   MethodVisitor mv, HashMap<String, Integer> varIndex){
		System.out.println("Function Call");
	}

	// Responsavel por gerar o codigo de cada função
	// Não sei o motivo, mas se o corpo da função main for vazio da erro de execução
	private void visitFunctionDefinition(FunctionDefinitionNode node){
		//TODO: aprender como definir "descriptor list"
		// Link: https://asm.ow2.io/faq.html#Q7

		HashMap<String, Integer> localVarIndex = new HashMap<>();
		this.newLocalVariableIndex = 0;

		MethodVisitor mv = null;

		try {
			// Por enquanto assumindo que a função não possui parametros
			String descriptor = "()"+dartTypeToJvmType(node.type);

			if(node.name.equals("main")){
				// TODO: arrumar isso aqui dps
				//  tenho que descobrir como chamar a jvm sem passar pelo java...
				descriptor = "([Ljava/lang/String;)V";
				// O indice 0 será para o array de args
				newLocalVariableIndex = 1;
			}

			mv = _cw.visitMethod(
					ACC_PUBLIC + ACC_STATIC,
					node.name, descriptor,
					null, null);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			System.exit(1);
		}

		mv.visitCode();

		for (var childNode: node.getChildren()) {
			try{
				switch (childNode.getClass().getSimpleName()){
					case "AssignNode" -> visitAssign((AssignNode) childNode, mv, localVarIndex);
					case "FunctionCallNode" -> visitFunctionCall((FunctionCallNode) childNode, mv, localVarIndex);
					case "VariableDefinitionNode" -> visitVariableDefinition((VariableDefinitionNode) childNode, mv, localVarIndex);
					case "VariableDeclarationNode" -> visitVariableDeclaration((VariableDeclarationNode) childNode, mv, localVarIndex);
					default -> visit(childNode);
				}
			}catch (Exception e){
				System.out.println("Erro: " + e.getMessage());
			}
		}

		// Gambiarra temporaria
		mv.visitInsn(RETURN);

		// Chamando só por obrigação, pq o tamanho necessário para
		// stack, variaveis e mais já é calculado, pois a classe Main
		// foi definida utilizando a flag COMPUTE_FRAMES.
		mv.visitMaxs(-1,-1);
		mv.visitEnd();
	}

	private void visitVariableDeclaration(VariableDeclarationNode node,
										  MethodVisitor mv, HashMap<String,
											Integer> varIndex) throws Exception {
		System.out.println("Variable Declaration");
		int index = newLocalVariableIndex++;

		varIndex.put(node.name, index);

		switch (node.type.name) {
			case Type.BOOL_NAME, Type.INT_NAME -> {
				mv.visitLdcInsn(0);
				mv.visitVarInsn(ISTORE, index);
			}
			case Type.DOUBLE_NAME -> {
				mv.visitLdcInsn(0.0);
				mv.visitVarInsn(DSTORE, index);
			}
			case Type.STRING_NAME -> {
				mv.visitInsn(ACONST_NULL);
				mv.visitVarInsn(ASTORE, index);
			}
			default -> System.out.println("Não defini as instruções para o tipo " + node.type.name);
		}
	}

	private void visitVariableDefinition(VariableDefinitionNode node,
										 MethodVisitor mv, HashMap<String, Integer> varIndex){
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
