package de.flapdoodle.unravel.samples.asm.inherit;

public interface InterfaceExtendsAnnotation extends SomeAnnotation {
	@Override
	default String value() {
		return "default value";
	}
}
