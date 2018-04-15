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
		Double[][] d=new Double[1][2];
		return x;
	}
	
	private static int len(Class<?> clazz) {
		return clazz.getName().length();
	}
}
