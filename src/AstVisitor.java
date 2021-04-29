import AST.*;
import Types.Type;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;

public class AstVisitor {
	private final ClassWriter _cw;

	public AstVisitor(){
		_cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
	}

	private String dartTypeToJvmType(Type type) throws Exception {
		// FIXME:
		return switch (type.name) {
			case Type.INT_NAME -> org.objectweb.asm.Type.getDescriptor(int.class);
			case Type.DOUBLE_NAME -> org.objectweb.asm.Type.getDescriptor(double.class);
			case Type.BOOL_NAME -> org.objectweb.asm.Type.getDescriptor(boolean.class);
			case Type.STRING_NAME -> org.objectweb.asm.Type.getDescriptor(String.class);
			// case Type.DYNAMIC_NAME ->  // Nem sei como fazer isso na JVM
			// Pequena gambiarra temporaria
			case Type.DYNAMIC_NAME -> org.objectweb.asm.Type.getDescriptor(void.class);
			// No dart uma função de retorno void retorna um objeto do tipo Null
			case Type.NULL_NAME ->  org.objectweb.asm.Type.getDescriptor(void.class);
			default -> throw new Exception("Erro de conversão de tipos para JVM");
		};
	}

	public void visit(Node node){
		_cw.visit(V1_5, ACC_PUBLIC, "Main", null, null, null);

		// Atualmente considerando que node só tem um FunctionDefinitionNode.
		visit((FunctionDefinitionNode) node.getChildren().get(0));

		// Como o nome do metodo já indica, sinaliza o final da classe.
		_cw.visitEnd();
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
