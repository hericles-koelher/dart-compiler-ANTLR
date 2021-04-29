import AST.*;
import Types.Type;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class AstVisitor {
	private final ClassVisitor _cw;

	public AstVisitor(){
		_cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
	}

	private String dartTypeToJvmType(Type type){
		String className;

		switch (type.name){
			case Type.TYPE_INT.name:
				className = int.class.getName();
		}
	}

	public void visit(Node node){
		_cw.visit(V1_5, ACC_PUBLIC, "Main", null, null, null);

		// Atualmente considerando que node é um FunctionDefinitionNode.
		visit((FunctionDefinitionNode) node.getChildren().get(0));

		// Como o nome do metodo já indica, sinaliza o final da classe.
		_cw.visitEnd();
	}

	private void visit(FunctionDefinitionNode node){
		//TODO: aprender como definir "descriptor list"
		MethodVisitor mv = _cw.visitMethod(
				ACC_PUBLIC + ACC_STATIC, node.name,null, null, null);

		mv.visitCode();



		mv.visitEnd();
	}
}
