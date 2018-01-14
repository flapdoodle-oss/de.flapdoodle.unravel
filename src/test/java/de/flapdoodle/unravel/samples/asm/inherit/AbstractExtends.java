package de.flapdoodle.unravel.samples.asm.inherit;

import java.util.function.Supplier;

public abstract class AbstractExtends extends Base implements Supplier<String>, LocalInterface {

	@Override
	public String get() {
		return "extends";
	}
	
}
