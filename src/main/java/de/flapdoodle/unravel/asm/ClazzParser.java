package de.flapdoodle.unravel.asm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import de.flapdoodle.checks.Preconditions;
import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.AField;
import de.flapdoodle.unravel.types.AFieldType;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AnAnnotation;
import de.flapdoodle.unravel.types.AnInnerClass;
import de.flapdoodle.unravel.types.ImmutableAClass.Builder;
import de.flapdoodle.unravel.types.ImmutableAnAnnotation;

public class ClazzParser {

	public AClass parse(Supplier<? extends InputStream> classStream) {
		try (InputStream is = classStream.get()) {
			ClassReader reader = new ClassReader(is);
			Visitor classVisitor = new Visitor();
			reader.accept(classVisitor, ClassReader.SKIP_DEBUG);
			return classVisitor.clazz();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static class Visitor extends ClassVisitor {
		
		private final Builder builder = AClass.builder();
		
		public Visitor() {
			super(Opcodes.ASM6);
		}
		
		@Override
		public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
			builder.typeName(typeNameOf(name))
				.genericSignature(Optional.ofNullable(signature))
				.version(version)
				.access(access)
				.superClazz(typeNameOf(superName));
			
			for (String interfaze : interfaces) {
				builder.addInterfaces(typeNameOf(interfaze));
			}
		}

		private static ATypeName typeNameOf(String name) {
			return ATypeName.of(name.replace('/', '.'));
		}
		
		@Override
		public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
			builder.addFields(AField.builder()
					.access(access)
					.name(name)
					.type(AFieldType.raw(desc))
					.genericSignature(Optional.ofNullable(signature))
					.value(Optional.ofNullable(value))
					.build());
			return null;
		}
		
		@Override
		public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
			return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
		}
		
		@Override
		public void visitOuterClass(String owner, String name, String desc) {
			throw new NotImplementedException("owner: "+owner+",name: "+name+",desc:"+desc);
		}
		
		@Override
		public void visitInnerClass(String name, String outerName, String innerName, int access) {
			builder.addInnerClasses(AnInnerClass.builder()
					.typeName(typeNameOf(name))
					.innerName(Optional.ofNullable(innerName).map(n -> typeNameOf(n)))
					.outerName(Optional.ofNullable(outerName).map(n -> typeNameOf(n)))
					.access(access)
					.build());
		}

		public AClass clazz() {
			return builder.build();
		}
	}
	
	private static class Annotations extends AnnotationVisitor {

		private final ImmutableAnAnnotation.Builder builder;
		private final Builder clazzBuilder;

		public Annotations(Builder clazzBuilder, String desc, boolean visible) {
			super(Opcodes.ASM6);
			this.clazzBuilder = clazzBuilder;
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
		public void visitEnum(String name, String desc, String value) {
			throw new NotImplementedException("name: "+name+",desc:"+desc+",value:"+value);
		}
		
		@Override
		public AnnotationVisitor visitArray(String name) {
			return new ArrayAnnotations(builder, name);
		}
		
		@Override
		public void visitEnd() {
			super.visitEnd();
			clazzBuilder.addAnnotations(builder.build());
		}
	}
	
	private static class ArrayAnnotations extends AnnotationVisitor {
		
		private final String name;
		private final ArrayList<Object> values=new ArrayList<>();
		private final ImmutableAnAnnotation.Builder builder;
		
		public ArrayAnnotations(ImmutableAnAnnotation.Builder builder, String name) {
			super(Opcodes.ASM6);
			this.builder = builder;
			this.name = name;
		}
		
		@Override
		public void visit(String name, Object value) {
			Preconditions.checkArgument(name==null, "name is set to %s",name);
			values.add(value);
		}

		@Override
		public AnnotationVisitor visitAnnotation(String name, String desc) {
			values.add(Type.getType(desc));
			//throw new NotImplementedException("name: "+name+",desc:"+desc);
			return this;
		}
		
		@Override
		public void visitEnum(String name, String desc, String value) {
			throw new NotImplementedException("name: "+name+",desc:"+desc+",value:"+value);
		}
		
		@Override
		public AnnotationVisitor visitArray(String name) {
			throw new NotImplementedException("name: "+name);
		}
		
		@Override
		public void visitEnd() {
			super.visitEnd();
			builder.addUsedAttributes(name);
			values.forEach(v -> builder.putAttributeMap(name, v));
		}
		
	}
	
//	private static class Fields extends FieldVisitor {
//
//		public Fields() {
//			super(Opcodes.ASM6);
//		}
//		
//	}


	private static void log(String method, Object ... parameter) {
		System.out.print("call "+method);
		for (Object value : parameter) {
			System.out.print(" ");
			System.out.print(value);
		}
		System.out.println();
	}
}
