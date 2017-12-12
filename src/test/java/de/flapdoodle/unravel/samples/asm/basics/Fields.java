package de.flapdoodle.unravel.samples.asm.basics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Fields<K,V> {
	private static final String privateStaticFinalString = "Foo";

	private final String privateFinalString;
	
	protected List<String> privateListOfString;
	
	public Map<K,V> publicMap=new LinkedHashMap<>();
	
	public Fields() {
		privateFinalString="Bar";
	}
}
