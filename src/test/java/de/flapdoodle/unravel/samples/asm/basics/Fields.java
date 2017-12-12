package de.flapdoodle.unravel.samples.asm.basics;

import java.util.List;

public class Fields {
	private static final String privateStaticFinalString = "Foo";

	private final String privateFinalString;
	
	private List<String> privateListOfString;
	
	public Fields() {
		privateFinalString="Bar";
	}
}
