package de.flapdoodle.unravel.samples.asm.basics;

public class InnerOuter {
	public static class Inner {
		
	}
	
	public void foo() {
		new Inner() {
			
		};
	}
}

class Outer{
	
}
