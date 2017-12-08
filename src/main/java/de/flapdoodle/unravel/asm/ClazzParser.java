package de.flapdoodle.unravel.asm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.function.Supplier;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

import de.flapdoodle.unravel.asm.ImmutableClazz.Builder;

public class ClazzParser {

	public Clazz parse(Supplier<? extends InputStream> classStream) {
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
		
		private final Builder builder = Clazz.builder();
		
		public Visitor() {
			super(Opcodes.ASM6);
		}
		
		@Override
		public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
			builder.clazzName(ClazzName.raw(name))
				.version(version)
				.access(access)
				.superClazz(ClazzName.raw(superName));
			
			for (String interfaze : interfaces) {
				builder.addInterfaces(ClazzName.raw(interfaze));
			}
		}
		
		@Override
		public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
			builder.addFields(Field.builder()
					.access(access)
					.name(name)
					.type(FieldType.raw(desc))
					.signature(Optional.ofNullable(signature))
					.value(Optional.ofNullable(value))
					.build());
			return null;
		}

		public Clazz clazz() {
			return builder.build();
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
