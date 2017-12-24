package de.flapdoodle.unravel.asm;

import java.util.function.Consumer;

import org.assertj.core.internal.asm.Type;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import de.flapdoodle.unravel.types.AMethod;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.Calls;
import de.flapdoodle.unravel.types.Calls.FieldCall;
import de.flapdoodle.unravel.types.ImmutableAMethod;
import de.flapdoodle.unravel.types.ImmutableAMethod.Builder;


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
	public AnnotationVisitor visitAnnotationDefault() {
		return NotImplementedException.with("visitAnnotationDefault");
	}
	
	@Override
	public void visitAttribute(Attribute attr) {
		NotImplementedException.with("visitAttribute", "attr",attr);
	}
	
	@Override
	public void visitFieldInsn(int opcode, String owner, String name, String desc) {
		super.visitFieldInsn(opcode, owner, name, desc);
		callsBuilder.addFieldCalls(FieldCall.of(Visitors.typeNameOf(owner), name, ATypeName.of(Type.getType(desc).getClassName())));
	}
	
	@Override
	public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
		super.visitFrame(type, nLocal, local, nStack, stack);
		NotImplementedException.with("visitFrame", "type",type,"nLocal",nLocal,"local",local,"nStack",stack);
	}
	
	
	// Annotations
	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
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
	public void visitInsn(int opcode) {
		super.visitInsn(opcode);
		// NOOP
		//NotImplementedException.with("visitInsn", "opcode",opcode);
	}
	
	@Override
	public void visitIincInsn(int var, int increment) {
		super.visitIincInsn(var, increment);
		// NOOP
	}
	

}
