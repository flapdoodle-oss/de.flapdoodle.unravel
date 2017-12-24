package de.flapdoodle.unravel.asm;

import de.flapdoodle.unravel.types.ATypeName;

public abstract class Visitors {

	static ATypeName typeNameOf(String name) {
		return ATypeName.of(name.replace('/', '.'));
	}
	
}
