package de.flapdoodle.unravel.samples.asm;

public class InnerClasses {

	public class Level2 {
		
		public class Level3 {
			
			public void foo() {
				System.out.println("foo");
			}
		}
	}
	
//	public static void createInstances() {
//		new InnerClasses().new Level2().new Level3().foo();
//	}
}
