package de.flapdoodle.unravel.asm;

import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import de.flapdoodle.checks.Preconditions;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AnAnnotation;
import de.flapdoodle.unravel.types.ImmutableAnAnnotation.Builder;

public class AnAnnotationVisitor extends AnnotationVisitor {

	private final Builder builder;
	private final Consumer<AnAnnotation> annotationConsumer;

	public AnAnnotationVisitor(String desc, boolean visible, Consumer<AnAnnotation> annotationConsumer) {
		super(Opcodes.ASM6);
		this.annotationConsumer = annotationConsumer;
		this.builder = AnAnnotation.builder(ATypeName.of(Type.getType(desc).getClassName()), visible);
	}

	@Override
	public void visit(String name, Object value) {
		builder.addUsedAttributes(name);
		builder.putAttributeMap(name, value);
	}
	
	@Override
	public AnnotationVisitor visitAnnotation(String name, String desc) {
		throw new NotImplementedException("name: "+name+",desc:"+desc);
	}
	
	@Override
	public AnnotationVisitor visitArray(String name) {
		builder.addUsedAttributes(name);
		return new Array(name, builder);
	}
	
	@Override
	public void visitEnum(String name, String desc, String value) {
		throw new NotImplementedException("name: "+name+",desc:"+desc+",value:"+value);
	}

	@Override
	public void visitEnd() {
		super.visitEnd();
		annotationConsumer.accept(builder.build());
	}
	
	private static class Array extends AnnotationVisitor {
		
		private final Builder builder;
		private final String name;

		public Array(String name, Builder builder) {
			super(Opcodes.ASM6);
			this.name = name;
			this.builder = builder;
		}
		
		@Override
		public void visit(String name, Object value) {
			Preconditions.checkArgument(name == null, "name is set: %s",name);
			builder.putAttributeMap(this.name, value);
		}
		
		@Override
		public AnnotationVisitor visitAnnotation(String name, String desc) {
			Preconditions.checkArgument(name == null, "name is set: %s",name);
			return new AnAnnotationVisitor(desc, true, an -> builder.putAnnotationAttributes(this.name, an));
		}
		
		@Override
		public AnnotationVisitor visitArray(String name) {
			throw new NotImplementedException("name: "+name);
		}
		
		@Override
		public void visitEnum(String name, String desc, String value) {
			throw new NotImplementedException("name: "+name+",desc:"+desc+",value:"+value);
		}
		
		@Override
		public void visitEnd() {
			super.visitEnd();
		}
	}
}
