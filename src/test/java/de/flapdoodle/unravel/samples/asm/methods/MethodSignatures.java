/**
 * Copyright (C) 2017
 *   Michael Mosmann <michael@mosmann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
