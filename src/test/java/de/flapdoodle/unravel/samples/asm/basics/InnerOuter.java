package de.flapdoodle.unravel.samples.asm.basics;

public class InnerOuter {
	public static class Inner {
		public static class InnerInner {
		}		
	}
	
	static Inner foo=new Inner() {
		{
			Outer blub = new Outer() {
				
			};
			
			class AnonInner {
				
			}
		}
	};
	
	Inner bar=new Inner() {
		
	};
	
	public void foo() {
		new Inner() {
			
		};
	}
}

class Outer{
	
}
