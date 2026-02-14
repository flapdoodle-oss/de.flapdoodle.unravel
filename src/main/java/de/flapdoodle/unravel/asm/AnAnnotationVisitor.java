/*
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

import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import de.flapdoodle.checks.Preconditions;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.AnAnnotation;
import de.flapdoodle.unravel.parser.types.AnEnumValue;
import de.flapdoodle.unravel.parser.types.ImmutableAnAnnotation.Builder;

public class AnAnnotationVisitor extends AnnotationVisitor {

	private final Builder builder;
	private final Consumer<AnAnnotation> annotationConsumer;

	public AnAnnotationVisitor(String desc, boolean visible, Consumer<AnAnnotation> annotationConsumer) {
		super(Opcodes.ASM9);
		this.annotationConsumer = annotationConsumer;
		this.builder = AnAnnotation.builder(ATypeName.of(Type.getType(desc).getClassName()), visible);
	}

	@Override
	public void visit(String name, Object value) {
		if (value instanceof Type) {
			builder.putClasses(name, ATypeName.of(((Type) value).getClassName()));
		} else {
			builder.putConstants(name, value);
		}
	}

	@Override
	public AnnotationVisitor visitAnnotation(String name, String desc) {
		return new AnAnnotationVisitor(desc, true, an -> builder.putAnnotations(name, an));
	}

	@Override
	public AnnotationVisitor visitArray(String name) {
		return new Array(name, builder);
	}

	@Override
	public void visitEnum(String name, String desc, String value) {
		builder.putEnums(name, AnEnumValue.of(ATypeName.of(Type.getType(desc).getClassName()), value));
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
			super(Opcodes.ASM9);
			this.name = name;
			this.builder = builder;
		}

		@Override
		public void visit(String name, Object value) {
			Preconditions.checkArgument(name == null, "name is set: %s", name);
			if (value instanceof Type) {
				builder.putClasses(this.name, ATypeName.of(((Type) value).getClassName()));
			} else {
				builder.putConstants(this.name, value);
			}
		}

		@Override
		public AnnotationVisitor visitAnnotation(String name, String desc) {
			Preconditions.checkArgument(name == null, "name is set: %s", name);
			return new AnAnnotationVisitor(desc, true, an -> builder.putAnnotations(this.name, an));
		}

		@Override
		public AnnotationVisitor visitArray(String name) {
			throw new NotImplementedException("visitArray name: " + name);
		}

		@Override
		public void visitEnum(String name, String desc, String value) {
			Preconditions.checkArgument(name == null, "name is set: %s", name);
			builder.putEnums(this.name, AnEnumValue.of(ATypeName.of(Type.getType(desc).getClassName()), value));
		}

		@Override
		public void visitEnd() {
			super.visitEnd();
		}
	}
}
