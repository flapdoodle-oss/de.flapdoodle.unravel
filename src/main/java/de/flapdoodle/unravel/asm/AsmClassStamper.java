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
import java.util.function.Supplier;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import com.google.common.collect.Lists;

public class AsmClassStamper {

	public void stampOf(Supplier<? extends InputStream> classStream) {
		//		new ClassReader(is)
		try (InputStream is = classStream.get()) {
			ClassReader reader = new ClassReader(is);
			MethodCollectingClassVisitor visitor = new MethodCollectingClassVisitor();
			reader.accept(visitor, ClassReader.SKIP_DEBUG);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static class MethodCollectingClassVisitor extends ClassVisitor {

		public MethodCollectingClassVisitor() {
			super(Opcodes.ASM9);
		}

		@Override
		public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
			log("visitField", access, name, desc, signature, value);
			return super.visitField(access, name, desc, signature, value);
		}

		@Override
		public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
			log("visitMethod", access, name, desc, signature, exceptions != null ? Lists.newArrayList(exceptions) : null);
			return new CollectingMethodVisitor();
		}

		@Override
		public void visitOuterClass(String owner, String name, String desc) {
			log("visitOuterClass", owner, name, desc);
			super.visitOuterClass(owner, name, desc);
		}

		@Override
		public void visitInnerClass(String name, String outerName, String innerName, int access) {
			log("visitInnerClass", name, outerName, innerName, access);
			super.visitInnerClass(name, outerName, innerName, access);
		}

		@Override
		public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
			log("visitAnnotation", desc, visible);
			return super.visitAnnotation(desc, visible);
		}

		@Override
		public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
			log("visitTypeAnnotation", typeRef, typePath, desc, visible);
			return super.visitTypeAnnotation(typeRef, typePath, desc, visible);
		}
	}

	private static class CollectingMethodVisitor extends MethodVisitor {

		public CollectingMethodVisitor() {
			super(Opcodes.ASM5);
		}

		@Override
		public void visitCode() {
			log("visitCode");
			super.visitCode();
		}

		@Override
		public void visitEnd() {
			log("visitEnd");
			super.visitEnd();
		}

		@Override
		public void visitAttribute(Attribute attr) {
			log("visitAttribute", attr);
			super.visitAttribute(attr);
		}

		@Override
		public void visitFieldInsn(int opcode, String owner, String name, String desc) {
			log("visitFieldInsn", opcode, owner, name, desc);
			super.visitFieldInsn(opcode, owner, name, desc);
		}

		@Override
		public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
			log("visitInvokeDynamicInsn", name, desc, bsm, Lists.newArrayList(bsmArgs));
			super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
		}

		@Override
		public void visitLdcInsn(Object cst) {
			log("visitLdcInsn", cst);
			super.visitLdcInsn(cst);
		}

		@Override
		public void visitLineNumber(int line, Label start) {
			log("visitLineNumber", line, start);
			super.visitLineNumber(line, start);
		}

		@Override
		public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
			log("visitLocalVariable", name, desc, signature, start, end, index);
			super.visitLocalVariable(name, desc, signature, start, end, index);
		}

		@Override
		public void visitMethodInsn(int opcode, String owner, String name, String desc) {
			log("visitMethodInsn", opcode, owner, name, desc);
			super.visitMethodInsn(opcode, owner, name, desc);
		}

		@Override
		public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
			log("visitMethodInsn(itf)", opcode, owner, name, desc, itf);
			super.visitMethodInsn(opcode, owner, name, desc, itf);
		}

		@Override
		public void visitParameter(String name, int access) {
			log("visitParameter", name, access);
			super.visitParameter(name, access);
		}

		@Override
		public void visitTypeInsn(int opcode, String type) {
			log("visitTypeInsn", opcode, type);
			super.visitTypeInsn(opcode, type);
		}

		@Override
		public void visitVarInsn(int opcode, int var) {
			log("visitVarInsn", opcode, var);
			super.visitVarInsn(opcode, var);
		}
	}

	private static void log(String method, Object... parameter) {
		System.out.print("call " + method);
		for (Object value : parameter) {
			System.out.print(" ");
			System.out.print(value);
		}
		System.out.println();
	}
}
