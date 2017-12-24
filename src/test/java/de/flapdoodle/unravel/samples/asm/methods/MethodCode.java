package de.flapdoodle.unravel.samples.asm.methods;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class MethodCode {

	private String xx;
	private String y;
	private static String z;

	public String simple(List<String> list) {
		@One
		String x = list.get(0);

		this.y= x;
		z="hallo";
		return x;
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface One {	}

}
