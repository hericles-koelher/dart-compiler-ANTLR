import AST.*;
import DartTypes.*;
import SymbolTable.FunctionSymbolTable;
import SymbolTable.VarSymbolTable;
import Types.Type;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import static org.objectweb.asm.Opcodes.*;

// O CODIGO TÁ CONFUSO PRA CARALHO, MAS É PQ AINDA TÕ PEGANDO O JEITO
// COM A JVM E O ASM, LAMENTO MAS VOU GAMBIARRAR COM FORÇA.
// ASS: Bruno

public class AstVisitor {
	private final ClassWriter _cw;
	private final Node _ast;
	private final VarSymbolTable _varSymbolTable;
	private final FunctionSymbolTable _functionSymbolTable;
	private int newLocalVariableIndex = 0;
	private final HashMap<String, String> typeDescriptorMap;
	private final HashMap<String, String> dartArgTypeDescriptorMap;
	private final HashMap<String, String> internalNameMap;
	private final HashMap<String, String> dartArgInternalNameMap;
	private final HashMap<String, String> dartTypeToJavaPrimitiveMap;

	public AstVisitor(Node ast, VarSymbolTable varSymbolTable,
					  FunctionSymbolTable functionSymbolTable){
		_cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		_ast = ast;
		_varSymbolTable = varSymbolTable;
		_functionSymbolTable = functionSymbolTable;

		// Determinando os descriptors dos tipos existentes...
		typeDescriptorMap = new HashMap<>();
		typeDescriptorMap.put(Type.INT_NAME, org.objectweb.asm.Type.getDescriptor(DartInt.class));
		typeDescriptorMap.put(Type.DOUBLE_NAME, org.objectweb.asm.Type.getDescriptor(DartDouble.class));
		typeDescriptorMap.put(Type.BOOL_NAME, org.objectweb.asm.Type.getDescriptor(DartBool.class));
		typeDescriptorMap.put(Type.STRING_NAME, org.objectweb.asm.Type.getDescriptor(DartString.class));
		typeDescriptorMap.put(Type.NULL_NAME, org.objectweb.asm.Type.getDescriptor(DartNull.class));
		typeDescriptorMap.put("DartType", org.objectweb.asm.Type.getDescriptor(DartType.class));

		// Determinando os descriptors dos tipos argumentos utilizados para criar
		// os tipos do dart...
		dartArgTypeDescriptorMap = new HashMap<>();
		dartArgTypeDescriptorMap.put(Type.INT_NAME, org.objectweb.asm.Type.getDescriptor(Integer.class));
		dartArgTypeDescriptorMap.put(Type.DOUBLE_NAME, org.objectweb.asm.Type.getDescriptor(Double.class));
		dartArgTypeDescriptorMap.put(Type.BOOL_NAME, org.objectweb.asm.Type.getDescriptor(Boolean.class));
		dartArgTypeDescriptorMap.put(Type.STRING_NAME, org.objectweb.asm.Type.getDescriptor(String.class));

		// Determinando internal name dos tipos existentes...
		internalNameMap = new HashMap<>();
		internalNameMap.put(Type.INT_NAME, org.objectweb.asm.Type.getInternalName(DartInt.class));
		internalNameMap.put(Type.DOUBLE_NAME, org.objectweb.asm.Type.getInternalName(DartDouble.class));
		internalNameMap.put(Type.BOOL_NAME, org.objectweb.asm.Type.getInternalName(DartBool.class));
		internalNameMap.put(Type.STRING_NAME, org.objectweb.asm.Type.getInternalName(DartString.class));
		internalNameMap.put(Type.NULL_NAME, org.objectweb.asm.Type.getInternalName(DartNull.class));
		internalNameMap.put("DartFunctions", org.objectweb.asm.Type.getInternalName(DartFunctions.class));

		// Determinando os internal names dos tipos argumentos utilizados para criar
		// os tipos do dart...
		dartArgInternalNameMap = new HashMap<>();
		dartArgInternalNameMap.put(Type.INT_NAME, org.objectweb.asm.Type.getInternalName(Integer.class));
		dartArgInternalNameMap.put(Type.DOUBLE_NAME, org.objectweb.asm.Type.getInternalName(Double.class));
		dartArgInternalNameMap.put(Type.BOOL_NAME, org.objectweb.asm.Type.getInternalName(Boolean.class));
		dartArgInternalNameMap.put(Type.STRING_NAME, org.objectweb.asm.Type.getInternalName(String.class));

		// Determinando os descriptors dos tipos argumentos utilizados para criar
		// os argumentos utilizados para criar os tipos do dart... ZUADO...
		dartTypeToJavaPrimitiveMap = new HashMap<>();
		dartTypeToJavaPrimitiveMap.put(Type.INT_NAME, org.objectweb.asm.Type.getDescriptor(int.class));
		dartTypeToJavaPrimitiveMap.put(Type.DOUBLE_NAME, org.objectweb.asm.Type.getDescriptor(double.class));
		dartTypeToJavaPrimitiveMap.put(Type.BOOL_NAME, org.objectweb.asm.Type.getDescriptor(boolean.class));
	}

	public void visit(){
		_cw.visit(V14, ACC_PUBLIC, "Main", null, "java/lang/Object", null);

		for (var childNode: _ast.getChildren()) {

			if(childNode instanceof FunctionDefinitionNode){
				visitFunctionDefinition((FunctionDefinitionNode) childNode);
			}

			// TODO: Implementar isso aqui depois
//			if(childNode instanceof GlobalVarNode){
//				visit(childNode);
//			}
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

	private void hardCodedPrint(FunctionCallNode node,
								MethodVisitor mv, HashMap<String, Integer> varIndex){
		var arg = node.getChildren().get(0);

		// Caso seja uma constante XD
		if(arg instanceof LiteralNode){
			String literalValue = ((LiteralNode) arg).literal.toString();

			mv.visitFieldInsn(GETSTATIC, "java/lang/System",
					"out", "Ljava/io/PrintStream;");

			mv.visitLdcInsn(literalValue);

			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream",
					"println", "(Ljava/lang/String;)V", false);
		}else{
			var variableNode = ((VariableNode)node.getChildren().get(0));

			int localIdNumber = varIndex.get(variableNode.name);
			Type varType = _varSymbolTable.getVar(variableNode.name, variableNode.scopeId).type;

			switch (varType.name){
				case Type.INT_NAME:
					mv.visitFieldInsn(GETSTATIC, "java/lang/System",
							"out", "Ljava/io/PrintStream;");
					mv.visitVarInsn(ILOAD, localIdNumber);
					mv.visitMethodInsn(INVOKESTATIC, "java/lang/String", "valueOf", "(I)Ljava/lang/String;", false);
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream",
							"println", "(Ljava/lang/String;)V", false);
				default:
					System.out.println("...");
			}
		}
	}

	private void visitFunctionCall(FunctionCallNode node,
								   MethodVisitor mv, HashMap<String, Integer> varIndex){
		System.out.println("Function Call");

		// Tenho que repensar isso aqui ehueeheuhehe
		// Por enquanto esse pedaço hardcoded pra caralho tá aqui,
		// mas o adequado seria primeiro separar o trecho que
		// transforma um "literal java" em um "literal dart".
		// Fora as partes q ainda nem fiz...
		// E caralho com esse monte de HashMap tá ficando uma merda confusa...
		// Vou arrumar isso dps
		if(node.name.equals("print")){
			// Arrumar isso aqui pra invocar o print do pacote Runtime

			Node arg = node.getChildren().get(0);

			if(arg instanceof LiteralNode){
				LiteralNode lit = (LiteralNode) arg;

				newLocalVariableIndex++;

				mv.visitTypeInsn(NEW, internalNameMap.get(lit.type.name));
				mv.visitInsn(DUP);


				switch (lit.type.name) {
					case Type.INT_NAME, Type.DOUBLE_NAME, Type.BOOL_NAME ->
							{
								// Criando arg do tipo necessario
								mv.visitTypeInsn(NEW, dartArgInternalNameMap.get(lit.type.name));
								mv.visitInsn(DUP);
								mv.visitLdcInsn(lit.literal);

								mv.visitMethodInsn(INVOKESPECIAL,
										dartArgInternalNameMap.get(lit.type.name),
										"<init>",
										"(" + dartTypeToJavaPrimitiveMap.get(lit.type.name) + ")V",
										false);
							}
					default -> {
						// Isso aqui precisa estar aqui
						mv.visitLdcInsn(lit.literal);
						System.out.println("Não foi necessaŕio criar Arg");
					}
				}

				// Criando a variavel local/temporaria
				mv.visitMethodInsn(INVOKESPECIAL,
						internalNameMap.get(lit.type.name),
						"<init>",
						"("+ dartArgTypeDescriptorMap.get(lit.type.name) +")V",
						false);
			}else{
				// Nesse caso arg é uma instancia de VariableNode
				//VariableNode var =
				return;
			}

			mv.visitMethodInsn(INVOKESTATIC, internalNameMap.get("DartFunctions"),
					"print", "("+ typeDescriptorMap.get("DartType") +")V", false);
		}
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
			String descriptor = "()" + typeDescriptorMap.get(node.type.name);

			if(node.name.equals("main")){
				// TODO: arrumar isso aqui dps
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
			switch (childNode.getClass().getSimpleName()){
				//case "AssignNode" -> visitAssign((AssignNode) childNode, mv, localVarIndex);
				case "FunctionCallNode" -> visitFunctionCall((FunctionCallNode) childNode, mv, localVarIndex);
				case "VariableDefinitionNode" -> visitVariableDefinition((VariableDefinitionNode) childNode, mv, localVarIndex);
				default -> visit(childNode);
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

	private void visitVariableDefinition(VariableDefinitionNode node,
										 MethodVisitor mv, HashMap<String, Integer> varIndex){
		System.out.println("Variable Definition");

		if(node.initializer == null){
			// Instanciação do tipo utilizando o construtor vazio...
			int index = newLocalVariableIndex++;

			varIndex.put(node.name, index);

			mv.visitTypeInsn(NEW, internalNameMap.get(node.type.name));
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL,
					internalNameMap.get(node.type.name),
					"<init>",
					"()V",
					false);
			mv.visitVarInsn(ASTORE, index);
		}else{
			// Instanciar variaveis inicializadas...
		}
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
