package de.flapdoodle.unravel.samples.asm.inherit;

public class Base extends AbstractBase {

	@Override
	protected boolean abstractAbstractBaseMethod() {
		return false;
	}

	protected boolean baseMethod() {
		return false;
	}
}
