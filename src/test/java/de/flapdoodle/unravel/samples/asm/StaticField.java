package de.flapdoodle.unravel.samples.asm;

import java.io.PrintStream;

public class StaticField {
	private static final String one = "hallo";
	private static final String two = "" + System.currentTimeMillis();
	private static final String three;
	private static final PrintStream out=System.out;
	
	static {
		three=some();
	}

	private static String some() {
		return "some";
	}
}
