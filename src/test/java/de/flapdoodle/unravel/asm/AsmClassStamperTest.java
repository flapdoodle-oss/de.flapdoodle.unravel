package de.flapdoodle.unravel.asm;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.samples.asm.InnerClasses;

public class AsmClassStamperTest {

	@Test
	public void sample() {
		new AsmClassStamper().stampOf(Classes.byteCodeOf(InnerClasses.class));
	}
}
