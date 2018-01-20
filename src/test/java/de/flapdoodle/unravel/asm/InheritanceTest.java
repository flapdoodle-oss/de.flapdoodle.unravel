package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import java.io.Serializable;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.Inheritance;

public class InheritanceTest {
	@Test
	public void innerOuter() {
		assertThat(Classes.parse(byteCodeOf(Inheritance.B.class)))
			.isJava8()
			.superClass(Inheritance.A.class)
			.interfaces(Classnames.nameOf(Inheritance.I.class),Classnames.nameOf(Serializable.class));
	}
}
