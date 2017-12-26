package de.flapdoodle.unravel.asm;

import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.types.AMethod;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.Calls;
import de.flapdoodle.unravel.types.Calls.FieldCall;
import de.flapdoodle.unravel.types.Calls.MethodCall;
import de.flapdoodle.unravel.types.Calls.TypeReferenceCall;
import de.flapdoodle.unravel.types.ImmutableAMethod;
import de.flapdoodle.unravel.types.ImmutableAMethod.Builder;
import io.vavr.collection.List;


public class AMethodVisitor extends MethodVisitor {

	private final Builder builder;
	private final Consumer<AMethod> methodConsumer;
	private final de.flapdoodle.unravel.types.ImmutableCalls.Builder callsBuilder;

	public AMethodVisitor(ImmutableAMethod.Builder builder, Consumer<AMethod> methodConsumer) {
		super(Opcodes.ASM6);
		this.builder = builder;
		this.methodConsumer = methodConsumer;
		this.callsBuilder = Calls.builder();
	}
	
	@Override
	public void visitAttribute(Attribute attr) {
		NotImplementedException.with("visitAttribute", "attr",attr);
	}
	
	@Override
	public void visitFieldInsn(int opcode, String owner, String name, String desc) {
		super.visitFieldInsn(opcode, owner, name, desc);
		callsBuilder.addFieldCalls(FieldCall.of(Visitors.typeNameOf(owner), name, Visitors.typeOf(desc)));
	}
	
	@Override
	public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
		super.visitLocalVariable(name, desc, signature, start, end, index);
		NotImplementedException.with("visitLocalVariable", "name",name,"desc",desc,"signature",signature,"start",start,"end",end,"index",index);
	}
	
	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
		super.visitMethodInsn(opcode, owner, name, desc, itf);
		Type type = Type.getType(desc);
		callsBuilder.addMethodCalls(MethodCall.builder()
				.clazz(Visitors.typeNameOf(owner))
				.name(name)
				.returnType(Visitors.typeOf(type.getReturnType()))
				.parameters(List.of(type.getArgumentTypes()).map(Visitors::typeOf))
				.interfaceMethod(itf)
				.build());
	}
	
	@Override
	public void visitLdcInsn(Object cst) {
		super.visitLdcInsn(cst);
		if (cst instanceof Type) {
			callsBuilder.addTypeReferenceCalls(TypeReferenceCall.of(ATypeName.of(((Type) cst).getClassName())));
		} else {
			if (!Classnames.isBuildInType(cst.getClass())) {
				NotImplementedException.with("visitLdcInsn", "cst", cst,"class",cst.getClass());
			}
		}
	}
	
	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc) {
		super.visitMethodInsn(opcode, owner, name, desc);
		NotImplementedException.with("visitMethodInsn","opcode",opcode, "owner", owner,"name",name,"desc",desc);
	}
	
	@Override
	public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
		super.visitTryCatchBlock(start, end, handler, type);
		callsBuilder.addTypeReferenceCalls(TypeReferenceCall.of(Visitors.typeNameOf(type)));
	}
	
	@Override
	public void visitTypeInsn(int opcode, String type) {
		super.visitTypeInsn(opcode, type);
		callsBuilder.addTypeReferenceCalls(TypeReferenceCall.of(Visitors.typeNameOf(type)));
	}
	
	@Override
	public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
		super.visitFrame(type, nLocal, local, nStack, stack);
		List<ATypeName> localTypeNames = typeNamesOfFrame(local);
		callsBuilder.addAllTypeReferenceCalls(localTypeNames.map(TypeReferenceCall::of));
		List<ATypeName> stackTypeNames = typeNamesOfFrame(stack);
		callsBuilder.addAllTypeReferenceCalls(stackTypeNames.map(TypeReferenceCall::of));
	}
	
	@Override
	public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
		super.visitTableSwitchInsn(min, max, dflt, labels);
		NotImplementedException.with("visitTableSwitchInsn", "min",min,"max",max,"dflt",dflt,"labels",List.of(labels));
	}
	
	@Override
	public void visitMultiANewArrayInsn(String desc, int dims) {
		super.visitMultiANewArrayInsn(desc, dims);
		callsBuilder.addTypeReferenceCalls(TypeReferenceCall.of(Visitors.typeOf(desc).clazz()));
	}
	
	@Override
	public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
		super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
		try {
			NotImplementedException.with("visitInvokeDynamicInsn", "name",name,"desc",desc,"bsmArgs",List.of(bsmArgs).map(s -> s+"("+s.getClass()+")"));
		} catch (RuntimeException rx) {
			rx.printStackTrace();
		}
	}
	
	@Override
	public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
		super.visitLookupSwitchInsn(dflt, keys, labels);
		NotImplementedException.with("visitLookupSwitchInsn", "dflt",dflt,"keys",List.of(keys),"labels",List.of(labels));
	}
	
	private List<ATypeName> typeNamesOfFrame(Object[] local) {
		return List.of(local)
			.filter(o -> o!=null)
			.flatMap(o -> {
				if (o instanceof String) {
					return List.of((String) o);
				}
				if (o instanceof Integer) {
					return List.of();
				}
				throw new RuntimeException("could not map "+o+" to String");
			})
			.map(Visitors::typeNameOf);
	}

	// Annotations
	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}
	
	@Override
	public AnnotationVisitor visitAnnotationDefault() {
		return NotImplementedException.with("visitAnnotationDefault");
	}
	
	@Override
	public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		NotImplementedException.with("visitTryCatchAnnotation", "typeRef",typeRef,"typePath",typePath,"desc",desc,"visible",visible);
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}
	
	@Override
	public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		NotImplementedException.with("visitInsnAnnotation", "typeRef",typeRef,"typePath",typePath,"desc",desc,"visible",visible);
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}
	
	@Override
	public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
		NotImplementedException.with("visitLocalVariableAnnotation", "typeRef",typeRef,"typePath",typePath,"start",start,"end",end,"index",index,"desc",desc,"visible",visible);
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}
	
	@Override
	public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}
	
	@Override
	public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		NotImplementedException.with("visitTypeAnnotation", "typeRef",typeRef,"typePath",typePath,"desc",desc,"visible",visible);
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}
	
	
	
	
	@Override
	public void visitCode() {
		super.visitCode();
	}
	
	@Override
	public void visitEnd() {
		super.visitEnd();
		builder.calls(callsBuilder.build());
		methodConsumer.accept(builder.build());
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void visitVarInsn(int opcode, int var) {
		super.visitVarInsn(opcode, var);
		// NOOP
	}
	
	@Override
	public void visitParameter(String name, int access) {
		super.visitParameter(name, access);
		// NOOP
	}
	
	@Override
	public void visitMaxs(int maxStack, int maxLocals) {
		super.visitMaxs(maxStack, maxLocals);
		// NOOP
	}
	
	@Override
	public void visitLineNumber(int line, Label start) {
		super.visitLineNumber(line, start);
		// NOOP
	}
	
	@Override
	public void visitLabel(Label label) {
		super.visitLabel(label);
		// NOOP
	}
	
	@Override
	public void visitJumpInsn(int opcode, Label label) {
		super.visitJumpInsn(opcode, label);
		// NOOP
	}
	
	@Override
	public void visitIntInsn(int opcode, int operand) {
		super.visitIntInsn(opcode, operand);
		// NOOP
	}
	
	@Override
	public void visitInsn(int opcode) {
		super.visitInsn(opcode);
		// NOOP
	}
	
	@Override
	public void visitIincInsn(int var, int increment) {
		super.visitIincInsn(var, increment);
		// NOOP
	}
	

}
