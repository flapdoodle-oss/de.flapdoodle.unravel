package de.flapdoodle.unravel.samples.asm.inherit;

public interface LocalInterface {
	int interfaceMethod();
	
	default String defaultMethod() {
		return "defaultMethod";
	}
}
