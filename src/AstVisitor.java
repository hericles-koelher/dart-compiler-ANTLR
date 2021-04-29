import AST.*;
import Types.Type;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class AstVisitor {
	private final ClassVisitor _cw;

	public AstVisitor(){
		_cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
	}

	private String dartTypeToJvmType(Type type) throws Exception {
		// FIXME:
		return switch (type.name) {
			case Type.INT_NAME -> "I";
			case Type.DOUBLE_NAME ->"D";
			case Type.BOOL_NAME -> "Z";
			case Type.STRING_NAME -> "L" + String.class.getName();
			// case Type.DYNAMIC_NAME ->  // Nem sei como fazer isso na JVM
			// Pequena gambiarra temporaria
			case Type.DYNAMIC_NAME -> "V";
			// No dart uma função de retorno void retorna um objeto do tipo Null
			case Type.NULL_NAME ->  "V";
			default -> throw new Exception("Erro de conversão de tipos para JVM");
		};
	}

	public void visit(Node node){
		_cw.visit(V1_5, ACC_PUBLIC, "Main", null, null, null);

		// Atualmente considerando que node é um FunctionDefinitionNode.
		visit((FunctionDefinitionNode) node.getChildren().get(0));

		// Como o nome do metodo já indica, sinaliza o final da classe.
		_cw.visitEnd();
	}

//	public byte[] write(){
//		return _cw.toByteArray();
//	}

	// Responsavel por gerar o codigo de cada função
	private void visit(FunctionDefinitionNode node){
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

		// Chamando só por obrigação, pq o tamanho necessário para
		// stack, variaveis e mais já é calculado, pois a classe Main
		// foi definida utilizando a flag COMPUTE_FRAMES.
		mv.visitMaxs(0,0);
		mv.visitEnd();
	}
}
