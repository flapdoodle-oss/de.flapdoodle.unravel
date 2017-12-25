package de.flapdoodle.unravel.asm;

import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import de.flapdoodle.unravel.types.AField;
import de.flapdoodle.unravel.types.ImmutableAField;
import de.flapdoodle.unravel.types.ImmutableAField.Builder;

public class AFieldVisitor extends FieldVisitor {

	private final Builder fieldBuilder;
	private final Consumer<AField> fieldConsumer;

	public AFieldVisitor(ImmutableAField.Builder fieldBuilder, Consumer<AField> fieldConsumer) {
		super(Opcodes.ASM6);
		this.fieldBuilder = fieldBuilder;
		this.fieldConsumer = fieldConsumer;
	}
	
	@Override
	public void visitAttribute(Attribute attr) {
		super.visitAttribute(attr);
		NotImplementedException.with("visitAttribute", "attr",attr);
	}
	
	@Override
	public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		return new AnAnnotationVisitor(desc, visible, fieldBuilder::addAnnotations);
	}
	
	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return new AnAnnotationVisitor(desc, visible, fieldBuilder::addAnnotations);
	}
	
	@Override
	public void visitEnd() {
		super.visitEnd();
		fieldConsumer.accept(fieldBuilder.build());
	}

}
