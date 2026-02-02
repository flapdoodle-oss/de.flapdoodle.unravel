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
package de.flapdoodle.unravel;

import java.io.InputStream;
import java.util.function.Supplier;

import com.google.common.base.Joiner;

import de.flapdoodle.unravel.asm.ClazzParser;
import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.JavaVersion;

public class Classes {

	public static Class<?> anonClass(Class<?> base, String... anonName) {
		try {
			return Class.forName(base.getName() + "$" + Joiner.on("$").join(anonName));
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException("could not load anonClass " + base + "" + anonName, e);
		}
	}

	public static AClass parse(Supplier<InputStream> byteCodeOf) {
		return new ClazzParser().parse(byteCodeOf);
	}

	public static Supplier<InputStream> byteCodeOf(JavaVersion javaVersion, java.lang.Class<?> clazz, java.lang.Class<?>... otherClasses) {
		return Compilers.JavaC.byteCodeOf(javaVersion, JavaSource.of(clazz), JavaSource.of(otherClasses));
	}

	@Deprecated
	public static Supplier<InputStream> byteCodeOf(java.lang.Class<?> clazz, java.lang.Class<?>... otherClasses) {
		return Compilers.JavaC.byteCodeOf(JavaVersion.V1_8, JavaSource.of(clazz), JavaSource.of(otherClasses));
	}

	public static Supplier<InputStream> byteCodeOf(JavaVersion javaVersion, java.lang.Class<?> base, String className) {
		return Compilers.JavaC.byteCodeOf(javaVersion, JavaSource.ofUnaccessableClass(base, className));
	}

	@Deprecated
	public static Supplier<InputStream> byteCodeOf(java.lang.Class<?> base, String className) {
		return Compilers.JavaC.byteCodeOf(JavaVersion.V1_8, JavaSource.ofUnaccessableClass(base, className));
	}

	public static Supplier<InputStream> byteCodeOf(JavaVersion javaVersion, JavaSource javaSource, JavaSource... otherSources) {
		return Compilers.JavaC.byteCodeOf(javaVersion, javaSource, otherSources);
	}

	@Deprecated
	public static Supplier<InputStream> byteCodeOf(JavaSource javaSource, JavaSource... otherSources) {
		return Compilers.JavaC.byteCodeOf(JavaVersion.V1_8, javaSource, otherSources);
	}
}
