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

import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;

import de.flapdoodle.checks.Preconditions;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.parser.Visitors;
import de.flapdoodle.unravel.parser.types.AMethod;
import de.flapdoodle.unravel.parser.types.AMethodSignature;
import de.flapdoodle.unravel.parser.types.AType;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.Calls;
import de.flapdoodle.unravel.parser.types.Calls.FieldCall;
import de.flapdoodle.unravel.parser.types.Calls.LambdaCall;
import de.flapdoodle.unravel.parser.types.Calls.MethodCall;
import de.flapdoodle.unravel.parser.types.Calls.TypeReferenceCall;
import de.flapdoodle.unravel.parser.types.ImmutableAMethod;
import de.flapdoodle.unravel.parser.types.ImmutableAMethod.Builder;
import de.flapdoodle.unravel.parser.types.ImmutableCalls;
import de.flapdoodle.unravel.parser.types.ImmutableLambdaCall;
import de.flapdoodle.unravel.parser.types.InvocationType;
import io.vavr.collection.List;

public class AMethodVisitor extends MethodVisitor {

	private final Builder builder;
	private final Consumer<AMethod> methodConsumer;
	private final ImmutableCalls.Builder callsBuilder;

	public AMethodVisitor(ImmutableAMethod.Builder builder, Consumer<AMethod> methodConsumer) {
		super(Opcodes.ASM6);
		this.builder = builder;
		this.methodConsumer = methodConsumer;
		this.callsBuilder = Calls.builder();
	}

	@Override
	public void visitAttribute(Attribute attr) {
		NotImplementedException.with("visitAttribute", "attr", attr);
	}

	@Override
	public void visitFieldInsn(int opcode, String owner, String name, String desc) {
		super.visitFieldInsn(opcode, owner, name, desc);
		callsBuilder.addFieldCalls(FieldCall.of(Visitors.typeNameOf(owner), name, Visitors.typeOf(desc), isStaticFieldAccess(opcode)));
	}

	private boolean isStaticFieldAccess(int opcode) {
		boolean staticAccess = Opcodes.PUTSTATIC == opcode || Opcodes.GETSTATIC == opcode;
		boolean nonStatic = Opcodes.PUTFIELD == opcode || Opcodes.GETFIELD == opcode;
		Preconditions.checkArgument(staticAccess || nonStatic, "opcodes does not match", opcode);
		return staticAccess;
	}

	@Override
	public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
		super.visitLocalVariable(name, desc, signature, start, end, index);
		NotImplementedException.with("visitLocalVariable", "name", name, "desc", desc, "signature", signature, "start", start, "end", end, "index", index);
	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
		super.visitMethodInsn(opcode, owner, name, desc, itf);
		AMethodSignature methodSignature = Visitors.methodSignOf(desc);
		callsBuilder.addMethodCalls(MethodCall.builder()
				.clazz(Visitors.typeNameOf(owner))
				.name(name)
				.signature(methodSignature)
				.invocationType(InvocationType.ofOpcode(opcode))
				//.staticMethod(opcode==Opcodes.INVOKESTATIC)
				.build());
	}

	@Override
	public void visitLdcInsn(Object cst) {
		super.visitLdcInsn(cst);
		if (cst instanceof Type) {
			callsBuilder.addTypeReferenceCalls(TypeReferenceCall.of(ATypeName.of(((Type) cst).getClassName())));
		} else {
			if (!Classnames.isBuildInType(cst.getClass())) {
				NotImplementedException.with("visitLdcInsn", "cst", cst, "class", cst.getClass());
			}
		}
	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc) {
		super.visitMethodInsn(opcode, owner, name, desc);
		NotImplementedException.with("visitMethodInsn", "opcode", opcode, "owner", owner, "name", name, "desc", desc);
	}

	@Override
	public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
		super.visitTryCatchBlock(start, end, handler, type);
		callsBuilder.addTypeReferenceCalls(TypeReferenceCall.of(Visitors.typeNameOf(type)));
	}

	@Override
	public void visitTypeInsn(int opcode, String type) {
		super.visitTypeInsn(opcode, type);
		callsBuilder.addTypeReferenceCalls(TypeReferenceCall.of(Visitors.typeNameOf(type)));
	}

	@Override
	public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
		super.visitFrame(type, nLocal, local, nStack, stack);
		List<ATypeName> localTypeNames = typeNamesOfFrame(local);
		callsBuilder.addAllTypeReferenceCalls(localTypeNames.map(TypeReferenceCall::of));
		List<ATypeName> stackTypeNames = typeNamesOfFrame(stack);
		callsBuilder.addAllTypeReferenceCalls(stackTypeNames.map(TypeReferenceCall::of));
	}

	@Override
	public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
		super.visitTableSwitchInsn(min, max, dflt, labels);
		NotImplementedException.with("visitTableSwitchInsn", "min", min, "max", max, "dflt", dflt, "labels", List.of(labels));
	}

	@Override
	public void visitMultiANewArrayInsn(String desc, int dims) {
		super.visitMultiANewArrayInsn(desc, dims);
		callsBuilder.addTypeReferenceCalls(TypeReferenceCall.of(Visitors.typeOf(desc).clazz()));
	}

	@Override
	public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
		super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);

		switch (bsm.getOwner()) {
			case "java/lang/invoke/LambdaMetafactory":
				invokeDynamicLambda(name, desc, bsm, bsmArgs);
				break;
			default:
				NotImplementedException.with("visitInvokeDynamicInsn", "name", name, "desc", desc, "bsm.name", bsm.getName(), "bsm.desc", bsm.getDesc(), "bsm.owner",
						bsm.getOwner(), "bsm.tag", bsm.getTag(), "bsmArgs", List.of(bsmArgs).map(s -> s + "(" + s.getClass() + ")"));
		}
	}

	private void invokeDynamicLambda(String name, String handlerMethodSignature, Handle bsm, Object[] bsmArgs) {

		boolean descMatches = bsm.getDesc().equals(
				"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;");
		Preconditions.checkArgument(descMatches, "invalid handle: %", bsm.getDesc());
		Preconditions.checkArgument(bsmArgs.length == 3, "unknown bsmArgs: %s", List.of(bsmArgs));

		AMethodSignature lambdaMethodSignature = Visitors.methodSignOf((Type) bsmArgs[0]);
		Handle methodHandle = (Handle) bsmArgs[1];
		AMethodSignature methodAsLambdaSignature = Visitors.methodSignOf((Type) bsmArgs[2]);

		AType functionalType = Visitors.methodSignOf(handlerMethodSignature).returnType();

		Preconditions.checkArgument(!functionalType.isArray(), "type is array: %s", functionalType);

		ImmutableLambdaCall lambdaCall = LambdaCall.builder()
				.clazz(functionalType.clazz())
				.name(name)
				.signature(lambdaMethodSignature)
				.methodAsLambdaSignature(methodAsLambdaSignature)
				.factoryClazz(Visitors.typeNameOf(bsm.getOwner()))
				.factorySignature(Visitors.methodSignOf(bsm.getDesc()))
				.delegate(MethodCall.builder()
						.clazz(Visitors.typeNameOf(methodHandle.getOwner()))
						.name(methodHandle.getName())
						.signature(Visitors.methodSignOf(methodHandle.getDesc()))
						.invocationType(InvocationType.INVOKEDYNAMIC)
						.build())
				.build();

		//		Preconditions.checkArgument(lambdaMethodSignature.toString().equals("(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"), "unknown bsmArgType: %s",lambdaMethodSignature);
		//		
		//		NotImplementedException.with("lambda", "method.desc",methodSignature,"method.name",methodHandle.getName(),"method.owner",methodHandle.getOwner(),"method.tag",HandleTag.fromCode(methodHandle.getTag()),"sign",methodAsLambdaSignature);
		//		
		//
		//		lambdaCallBuilder.name(name)
		//			.clazz(functionalType.clazz());
		//		
		////		try {
		//			NotImplementedException.with("lambda", "name",name,"type",functionalType,"bsm.interface",bsm.isInterface(),"bsm.tag",bsm.getTag(),"bsmArgs",
		//				List.of(bsmArgs).map(s -> "("+s.getClass()+":"+s+")").foldLeft("", (a,b) -> a+" | "+b));
		////		} catch (RuntimeException rx) {
		////			rx.printStackTrace();
		////		}
		//		
		callsBuilder.addLambdaCalls(lambdaCall);
	}

	@Override
	public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
		super.visitLookupSwitchInsn(dflt, keys, labels);
		NotImplementedException.with("visitLookupSwitchInsn", "dflt", dflt, "keys", List.of(keys), "labels", List.of(labels));
	}

	private List<ATypeName> typeNamesOfFrame(Object[] local) {
		return List.of(local)
				.filter(o -> o != null)
				.flatMap(o -> {
					if (o instanceof String) {
						return List.of((String) o);
					}
					if (o instanceof Integer) {
						return List.of();
					}
					throw new RuntimeException("could not map " + o + " to String");
				})
				.map(Visitors::typeNameOf);
	}

	// Annotations
	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}

	@Override
	public AnnotationVisitor visitAnnotationDefault() {
		return NotImplementedException.with("visitAnnotationDefault");
	}

	@Override
	public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		NotImplementedException.with("visitTryCatchAnnotation", "typeRef", typeRef, "typePath", typePath, "desc", desc, "visible", visible);
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}

	@Override
	public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		NotImplementedException.with("visitInsnAnnotation", "typeRef", typeRef, "typePath", typePath, "desc", desc, "visible", visible);
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}

	@Override
	public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
		NotImplementedException.with("visitLocalVariableAnnotation", "typeRef", typeRef, "typePath", typePath, "start", start, "end", end, "index", index, "desc",
				desc, "visible", visible);
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}

	@Override
	public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
		return new AnAnnotationVisitor(desc, visible, builder::addAnnotations);
	}

	@Override
	public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		NotImplementedException.with("visitTypeAnnotation", "typeRef", typeRef, "typePath", typePath, "desc", desc, "visible", visible);
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
	public void visitVarInsn(int opcode, int var) {
		super.visitVarInsn(opcode, var);
		// NOOP
	}

	@Override
	public void visitParameter(String name, int access) {
		super.visitParameter(name, access);
		// NOOP
	}

	@Override
	public void visitMaxs(int maxStack, int maxLocals) {
		super.visitMaxs(maxStack, maxLocals);
		// NOOP
	}

	@Override
	public void visitLineNumber(int line, Label start) {
		super.visitLineNumber(line, start);
		// NOOP
	}

	@Override
	public void visitLabel(Label label) {
		super.visitLabel(label);
		// NOOP
	}

	@Override
	public void visitJumpInsn(int opcode, Label label) {
		super.visitJumpInsn(opcode, label);
		// NOOP
	}

	@Override
	public void visitIntInsn(int opcode, int operand) {
		super.visitIntInsn(opcode, operand);
		// NOOP
	}

	@Override
	public void visitInsn(int opcode) {
		super.visitInsn(opcode);
		// NOOP
	}

	@Override
	public void visitIincInsn(int var, int increment) {
		super.visitIincInsn(var, increment);
		// NOOP
	}

}
