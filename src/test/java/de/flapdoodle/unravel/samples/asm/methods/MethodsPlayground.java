package de.flapdoodle.unravel.samples.asm.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MethodsPlayground {
	public static String hello() {
		return UUID.randomUUID().toString();
	}
	
	public List<String> keys(Map<String, Integer> map) {
		return new ArrayList<>(map.keySet());
	}
}
