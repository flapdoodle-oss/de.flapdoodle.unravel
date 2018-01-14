package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import java.util.function.Supplier;

import org.junit.Test;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.inherit.AbstractBase;
import de.flapdoodle.unravel.samples.asm.inherit.AbstractExtends;
import de.flapdoodle.unravel.samples.asm.inherit.Base;
import de.flapdoodle.unravel.samples.asm.inherit.ExtendsExtends;
import de.flapdoodle.unravel.samples.asm.inherit.LocalInterface;
import de.flapdoodle.unravel.types.AccessFlags;

public class InheritanceMethodTest extends AbstractClazzParserTest {
	
	@Test
	public void methodsOfAbstractBase() {
		assertThat(parse(byteCodeOf(AbstractBase.class)))
			.isJava8()
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
		assertThat(parse(byteCodeOf(Base.class)))
			.isJava8()
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
	public void methodsOfAbstractExtends() {
		assertThat(parse(byteCodeOf(AbstractExtends.class)))
			.isJava8()
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
		assertThat(parse(byteCodeOf(ExtendsExtends.class)))
			.isJava8()
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
}
