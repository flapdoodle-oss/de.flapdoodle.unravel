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

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import java.util.function.Supplier;

import org.junit.Test;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.inherit.AbstractBase;
import de.flapdoodle.unravel.samples.asm.inherit.AbstractExtends;
import de.flapdoodle.unravel.samples.asm.inherit.Base;
import de.flapdoodle.unravel.samples.asm.inherit.Caller;
import de.flapdoodle.unravel.samples.asm.inherit.ExtendsExtends;
import de.flapdoodle.unravel.samples.asm.inherit.LocalInterface;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.InvocationType;
import de.flapdoodle.unravel.types.JavaVersion;

public class InheritanceMethodTest  {
	
	@Test
	public void methodsOfAbstractBase() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(AbstractBase.class))).isAtLeast(JavaVersion.V1_8)
			.superClass(Object.class)
			.interfaces()
			.methods(methods -> {
				methods.size().isEqualTo(3);
					methods.element(0).name("<init>")
						.accessFlags(AccessFlags.ACC_PUBLIC);
					methods.element(1).name("abstractAbstractBaseMethod")
						.accessFlags(AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_PROTECTED);
					methods.element(2).name("abstractBaseMethod")
						.accessFlags(AccessFlags.ACC_PROTECTED);
				});
	}

	@Test
	public void methodsOfBase() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(Base.class))).isAtLeast(JavaVersion.V1_8)
			.superClass(AbstractBase.class)
			.interfaces()
			.methods(methods -> {
				methods.size().isEqualTo(3);
					methods.element(0).name("<init>")
						.accessFlags(AccessFlags.ACC_PUBLIC);
					methods.element(1).name("abstractAbstractBaseMethod")
						.accessFlags(AccessFlags.ACC_PROTECTED);
					methods.element(2).name("baseMethod")
					.accessFlags(AccessFlags.ACC_PROTECTED);
				});
	}

	@Test
	public void methodsOfLocalInterface() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(LocalInterface.class))).isAtLeast(JavaVersion.V1_8)
			.superClass(Object.class)
			.interfaces()
			.methods(methods -> {
				methods.size().isEqualTo(2);
					methods.element(0).name("interfaceMethod")
						.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT);
					methods.element(1).name("defaultMethod")
						.accessFlags(AccessFlags.ACC_PUBLIC);
				});
	}
	
	@Test
	public void methodsOfAbstractExtends() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(AbstractExtends.class))).isAtLeast(JavaVersion.V1_8)
			.superClass(Base.class)
			.interfaces(Classnames.nameOf(Supplier.class), Classnames.nameOf(LocalInterface.class))
			.methods(methods -> {
				methods.size().isEqualTo(3);
					methods.element(0).name("<init>")
						.accessFlags(AccessFlags.ACC_PUBLIC);
					methods.element(1).name("get")
						.accessFlags(AccessFlags.ACC_PUBLIC)
						.returnType(Classnames.typeOf(String.class));
					methods.element(2).name("get")
						.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SYNTHETIC, AccessFlags.ACC_BRIDGE)
						.returnType(Classnames.typeOf(Object.class));
				});
	}

	@Test
	public void methodsOfExtendsExtends() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(ExtendsExtends.class)))
				.isAtLeast(JavaVersion.V1_8)
			.superClass(AbstractExtends.class)
			.interfaces()
			.methods(methods -> {
				methods.size().isEqualTo(3);
					methods.element(0).name("<init>")
						.accessFlags(AccessFlags.ACC_PUBLIC);
					methods.element(1).name("interfaceMethod")
						.accessFlags(AccessFlags.ACC_PUBLIC)
						.returnType(Classnames.typeOf(int.class));
					methods.element(2).name("abstractBaseMethod")
						.accessFlags(AccessFlags.ACC_PROTECTED)
						.returnType(Classnames.typeOf(boolean.class));
				});
	}
	
	@Test
	public void calls() {
		/*, ExtendsExtends.class, AbstractExtends.class, Base.class, AbstractBase.class, LocalInterface.class*/
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(
						Caller.class/*, ExtendsExtends.class, AbstractExtends.class, Base.class, AbstractBase.class, LocalInterface.class*/)))
				.isAtLeast(JavaVersion.V1_8)
			.superClass(Object.class)
			.interfaces()
			.methods(methods -> {
				methods.size().isEqualTo(3);
				methods.element(0).name("<init>");
				methods.element(1)
					.name("allMethodsOfExtendsExtends")
					.calls(calls -> {
						calls.methodCalls(methodCalls -> {
							methodCalls.size().isEqualTo(7);
							methodCalls.element(0)
								.name("abstractAbstractBaseMethod")
								.clazz(Classnames.nameOf(ExtendsExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(1)
								.name("abstractBaseMethod")
								.clazz(Classnames.nameOf(ExtendsExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(2)
								.name("baseMethod")
								.clazz(Classnames.nameOf(ExtendsExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(3)
								.name("get")
								.clazz(Classnames.nameOf(ExtendsExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(4)
								.name("interfaceMethod")
								.clazz(Classnames.nameOf(ExtendsExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(5)
								.name("defaultMethod")
								.clazz(Classnames.nameOf(ExtendsExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(6)
								.name("toString")
								.clazz(Classnames.nameOf(Object.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
						});
					});
				methods.element(2)
					.name("allMethodsOfAbstractExtends")
					.calls(calls -> {
						calls.methodCalls(methodCalls -> {
							methodCalls.size().isEqualTo(7);
							methodCalls.element(0)
								.name("abstractAbstractBaseMethod")
								.clazz(Classnames.nameOf(AbstractExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(1)
								.name("abstractBaseMethod")
								.clazz(Classnames.nameOf(AbstractExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(2)
								.name("baseMethod")
								.clazz(Classnames.nameOf(AbstractExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(3)
								.name("get")
								.clazz(Classnames.nameOf(AbstractExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(4)
								.name("interfaceMethod")
								.clazz(Classnames.nameOf(AbstractExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(5)
								.name("defaultMethod")
								.clazz(Classnames.nameOf(AbstractExtends.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
							methodCalls.element(6)
								.name("toString")
								.clazz(Classnames.nameOf(Object.class))
								.invocationType(InvocationType.INVOKEVIRTUAL);
						});
					});
			});
		
	}
}
