package de.flapdoodle.unravel.samples.asm.methods;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class MethodSignatures<A,B extends List<?>,C extends Map<A, B>,D extends IOException> implements Consumer<String> {
	// static
	static {
	}
	
	private static void privateStatic() {	}
	protected static void protectedStatic() {	}
	static void packageProtectedStatic() {	}
	public static void publicStatic() {	}
	
	// non static
	{
	}
	
	public MethodSignatures() {	}
	
	public MethodSignatures(String param) {	}
	
	private void privateNonStatic() {	}
	protected void protectedNonStatic() {	}
	void packageProtectedNonStatic() {	}
	public void publicNonStatic() {	}

	public String stringInOut(String param) {
		return param;
	}
	
	public String stringInOutThrowsRuntime(String param) throws RuntimeException {
		return param;
	}
	
	public String stringInOutThrowsChecked(String param) throws ParseException, IOException {
		return param;
	}
	
	public String[] arrayInOut(String[] param, int[] idx, Date date) {
		return param;
	}
	
	public C generics(A a,B b) throws D {
		return null;
	}
	
	@Sample
	public String annotations(@Sample String a, @Sample String b) {
		@Sample
		String c = a+b;
		return c;
	}
	
	@Override
	public void accept(String t) {
		
	}
	
	// abstract
	public abstract String abstractMethod();
	
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Sample {
		
	}
	
}
