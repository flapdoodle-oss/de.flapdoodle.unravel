package de.flapdoodle.unravel.samples.asm.methods;

import java.util.List;

public class MethodCode {

	private static final int CONST=123;
	private String xx;
	private String y;
	private static String z;

	public String simple(List<String> list) {
		String x = list.get(0);
		Class<?> clazz = void.class;
		
		this.y= x;
		z="hallo";
		int u1=len(clazz);
		u1=CONST;
		try {
			x.length();
		} catch (IllegalArgumentException|IllegalStateException iax) {
			u1=17;
		}
		return x;
	}
	
	private static int len(Class<?> clazz) {
		return clazz.getName().length();
	}
}
