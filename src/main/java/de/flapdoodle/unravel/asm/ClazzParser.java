/**
 * Copyright (C) 2017
 *   Michael Mosmann <michael@mosmann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.unravel.asm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.function.Supplier;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.AField;
import de.flapdoodle.unravel.types.AMethod;
import de.flapdoodle.unravel.types.AMethodSignature;
import de.flapdoodle.unravel.types.AnInnerClass;
import de.flapdoodle.unravel.types.AnOuterClass;
import de.flapdoodle.unravel.types.ImmutableAClass.Builder;
import de.flapdoodle.unravel.types.ImmutableAField;
import de.flapdoodle.unravel.types.ImmutableAnOuterClass;
import io.vavr.collection.List;

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
		private Optional<AClass> clazz = Optional.empty();

		public Visitor() {
			super(Opcodes.ASM6);
		}

		@Override
		public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
			builder.typeName(Visitors.typeNameOf(name))
					.genericSignature(Optional.ofNullable(signature))
					.version(version)
					.access(access)
					.superClazz(Visitors.typeNameOf(superName));

			for (String interfaze : interfaces) {
				builder.addInterfaces(Visitors.typeNameOf(interfaze));
			}
		}

		@Override
		public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
			ImmutableAField.Builder fieldBuilder = AField.builder()
					.access(access)
					.name(name)
					.type(Visitors.typeOf(desc))
					.genericSignature(Optional.ofNullable(signature))
					.value(Optional.ofNullable(value));

			return new AFieldVisitor(fieldBuilder, builder::addFields);
		}

		@Override
		public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
			return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
		}

		@Override
		public void visitOuterClass(String owner, String name, String desc) {
			ImmutableAnOuterClass.Builder outerBuilder = AnOuterClass.builder(Visitors.typeNameOf(owner));
			if (name != null) {
				outerBuilder.methodName(name)
						.methodSignature(Visitors.methodSignOf(desc));
			}
			builder.outerClazz(outerBuilder.build());
		}

		@Override
		public void visitInnerClass(String name, String outerName, String innerName, int access) {
			builder.addInnerClasses(AnInnerClass.builder()
					.typeName(Visitors.typeNameOf(name))
					.innerName(Optional.ofNullable(innerName).map(n -> Visitors.typeNameOf(n)))
					.outerName(Optional.ofNullable(outerName).map(n -> Visitors.typeNameOf(n)))
					.access(access)
					.build());
		}

		@Override
		public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
			throw new NotImplementedException("typeRef: " + typeRef + ",typePath: " + typePath + ",desc:" + desc + ",visible:" + visible);
		}

		@Override
		public void visitAttribute(Attribute attr) {
			throw new NotImplementedException("attr: " + attr);
		}

		@Override
		public ModuleVisitor visitModule(String name, int access, String version) {
			throw new NotImplementedException("name: " + name + ",access: " + access + ",version: " + version);
		}

		@Override
		public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
			AMethodSignature methodSign = Visitors.methodSignOf(desc);

			return new AMethodVisitor(AMethod.builder()
					.access(access)
					.name(name)
					.returnType(methodSign.returnType())
					.parameters(methodSign.parameters())
					.genericSignature(Optional.ofNullable(signature))
					.addAllExceptions(exceptions != null
							? List.of(exceptions)
									.map(Visitors::typeNameOf)
							: List.of()),
					builder::addMethods);
		}

		@Override
		public void visitEnd() {
			super.visitEnd();
			clazz = Optional.of(builder.build());
		}

		public AClass clazz() {
			return clazz.get();
		}
	}

	//	private static class Fields extends FieldVisitor {
	//
	//		public Fields() {
	//			super(Opcodes.ASM6);
	//		}
	//		
	//	}

	private static void log(String method, Object... parameter) {
		System.out.print("call " + method);
		for (Object value : parameter) {
			System.out.print(" ");
			System.out.print(value);
		}
		System.out.println();
	}
}
