package de.flapdoodle.unravel.samples.asm.methods;

import java.util.List;

public class MethodLambdas {

	public String lambdas(List<String> list) {
		return list.stream()
				.filter(s -> s.length()>0)
				.filter(String::isEmpty)
				.filter(MethodLambdas::isEmpty)
				.findAny()
				.orElse(null);
	}
	
	private static boolean isEmpty(String s) {
		return s.isEmpty();
	}
}
