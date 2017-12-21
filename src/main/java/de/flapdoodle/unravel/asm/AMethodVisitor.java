package de.flapdoodle.unravel.asm;

import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import de.flapdoodle.unravel.types.AMethod;
import de.flapdoodle.unravel.types.ImmutableAMethod;
import de.flapdoodle.unravel.types.ImmutableAMethod.Builder;


public class AMethodVisitor extends MethodVisitor {

	private final Builder builder;
	private final Consumer<AMethod> methodConsumer;

	public AMethodVisitor(ImmutableAMethod.Builder builder, Consumer<AMethod> methodConsumer) {
		super(Opcodes.ASM6);
		this.builder = builder;
		this.methodConsumer = methodConsumer;
	}
	
	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
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
	public void visitEnd() {
		super.visitEnd();
		methodConsumer.accept(builder.build());
	}

}
