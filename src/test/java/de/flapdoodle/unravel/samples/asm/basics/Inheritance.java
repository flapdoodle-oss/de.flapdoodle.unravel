package de.flapdoodle.unravel.samples.asm.basics;

import java.io.Serializable;

public class Inheritance {

	public static class A {
		
	}

	public static interface I {
		
	}

	public static class B extends A implements I,Serializable {
		
	}
}
