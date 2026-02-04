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
import org.objectweb.asm.Attribute;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import de.flapdoodle.unravel.parser.types.AField;
import de.flapdoodle.unravel.parser.types.ImmutableAField;
import de.flapdoodle.unravel.parser.types.ImmutableAField.Builder;

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
		NotImplementedException.with("visitAttribute", "attr", attr);
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
