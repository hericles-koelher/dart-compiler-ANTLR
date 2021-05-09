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
	private final HashMap<String, String> internalNameMap;

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

		// Determinando internal name dos tipos existentes...
		internalNameMap = new HashMap<>();
		internalNameMap.put(Type.INT_NAME, org.objectweb.asm.Type.getInternalName(DartInt.class));
		internalNameMap.put(Type.DOUBLE_NAME, org.objectweb.asm.Type.getInternalName(DartDouble.class));
		internalNameMap.put(Type.BOOL_NAME, org.objectweb.asm.Type.getInternalName(DartBool.class));
		internalNameMap.put(Type.STRING_NAME, org.objectweb.asm.Type.getInternalName(DartString.class));
		internalNameMap.put(Type.NULL_NAME, org.objectweb.asm.Type.getInternalName(DartNull.class));
		internalNameMap.put("DartFunctions", org.objectweb.asm.Type.getInternalName(DartFunctions.class));
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

	private void getNull(MethodVisitor mv){
		mv.visitMethodInsn(INVOKESTATIC,
				internalNameMap.get(Type.NULL_NAME),
				"getInstance",
				"()" + typeDescriptorMap.get(Type.NULL_NAME),
				false);
	}

	private void visitLiteral(LiteralNode node, MethodVisitor mv){
		//TODO: devo deixar comentado msm?
		//newLocalVariableIndex++;

		if(node.type.name.equals(Type.NULL_NAME)){
			getNull(mv);
			return;
		}

		// Puta rolê pra criar um DartType ehhehueueuee
		mv.visitTypeInsn(NEW, internalNameMap.get(node.type.name));
		mv.visitInsn(DUP);

		String javaArgInternalName = null, javaPrimitive = null, dartArgTypeDescriptor = null;

		// Esse bagulho é um caso especial...
		switch (node.type.name){
			case Type.INT_NAME ->{
				javaArgInternalName = "java/lang/Integer";
				javaPrimitive = "I";
				dartArgTypeDescriptor = "Ljava/lang/Integer;";
			}
			case Type.DOUBLE_NAME ->{
				javaArgInternalName = "java/lang/Double";
				javaPrimitive = "D";
				dartArgTypeDescriptor = "Ljava/lang/Double;";
			}
			case Type.BOOL_NAME ->{
				javaArgInternalName = "java/lang/Boolean";
				javaPrimitive = "Z";
				dartArgTypeDescriptor = "Ljava/lang/Boolean;";
			}
			case Type.STRING_NAME ->{
				dartArgTypeDescriptor = "Ljava/lang/String;";
			}
		}

		// Caso caia em um dos casos especiais temos q executar isso antes...
		if(javaArgInternalName != null){
			// Criando arg do tipo necessario
			mv.visitTypeInsn(NEW, javaArgInternalName);
			mv.visitInsn(DUP);
			mv.visitLdcInsn(node.literal);

			mv.visitMethodInsn(INVOKESPECIAL,
					javaArgInternalName,
					"<init>",
					"(" + javaPrimitive + ")V",
					false);
		}else{
			mv.visitLdcInsn(node.literal);
		}

		// Criando a variavel local/temporaria
		mv.visitMethodInsn(INVOKESPECIAL,
				internalNameMap.get(node.type.name),
				"<init>",
				"("+ dartArgTypeDescriptor +")V",
				false);
	}

	private void visitFunctionCall(FunctionCallNode node,
								   MethodVisitor mv, HashMap<String, Integer> varIndex){
		System.out.println("Function Call");

		// Poderia ser menos "hardcoded" ehuehuehuehuh
		if(node.name.equals("print")){

			Node arg = node.getChildren().get(0);

			if(arg instanceof LiteralNode){
				// Criando o literal do dart
				visitLiteral((LiteralNode) arg, mv);
			} else if (arg instanceof OperationNode) {
				expressionSolver((OperationNode) arg, mv, varIndex);
			} else{
				// Nesse caso arg é uma instancia de VariableNode
				int index = varIndex.get(((VariableNode) arg).name);

				mv.visitVarInsn(ALOAD, index);
			}

			mv.visitMethodInsn(INVOKESTATIC,
					internalNameMap.get("DartFunctions"),
					"print",
					"("+ typeDescriptorMap.get("DartType") +")V",
					false);
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

		int index = newLocalVariableIndex++;

		varIndex.put(node.name, index);

		if(node.initializer == null){
			// Instanciação do tipo utilizando o construtor vazio...

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
			expressionSolver((AbstractExpressionNode) node.initializer, mv, varIndex);

			mv.visitVarInsn(ASTORE, index);
		}
	}

	private void expressionSolver(AbstractExpressionNode node,
								  MethodVisitor mv,
								  HashMap<String, Integer> varIndex){

		if(node instanceof LiteralNode) {
			visitLiteral((LiteralNode) node, mv);
			return;
		}

		if(node instanceof VariableNode){
			VariableNode v = (VariableNode) node;

			int index = varIndex.get(v.name);

			mv.visitVarInsn(ALOAD, index);
			return;
		}

		if(node instanceof FunctionCallNode){
			visitFunctionCall((FunctionCallNode) node, mv, varIndex);
		}

		// Estamos assumindo que todas as operações
		// são feitas entre variaveis de  tipos iguais :(
		if(node instanceof OperationNode){
			OperationNode opn = (OperationNode) node;

			expressionSolver(opn.left, mv, varIndex);
			expressionSolver(opn.right, mv, varIndex);

			/// Abaixo foi o matheus que fez, cuidado
			String methodName;
			String dartType;
			String dartDescriptorType;

			switch (opn.operation) {
				case Addition -> methodName = "add";
				case Subtraction -> methodName = "sub";
				case Multiplication -> methodName = "mul";
				case Division -> methodName = "div";
				default -> {
					System.out.println("Mehhh deu ruim!");
					return;
				}
			}

			dartType = internalNameMap.get(opn.left.type.name);
			String descriptor = typeDescriptorMap.get(opn.left.type.name);
			String descriptorRight = typeDescriptorMap.get(opn.left.type.name);
			dartDescriptorType = "(" + descriptor + ")" + descriptorRight;

			System.out.println(methodName + " " + dartType + " " + dartDescriptorType);

			mv.visitMethodInsn(INVOKEVIRTUAL,
					dartType,
					methodName,
					dartDescriptorType,
					false);
			/// Acima é coisa do matheus, deve ta tudo errado
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
