/*
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
package de.flapdoodle.unravel.parser.types;

import static de.flapdoodle.unravel.parser.types.Scope.Clazz;
import static de.flapdoodle.unravel.parser.types.Scope.Field;
import static de.flapdoodle.unravel.parser.types.Scope.Inner;
import static de.flapdoodle.unravel.parser.types.Scope.Method;
import static de.flapdoodle.unravel.parser.types.Scope.Module;
import static de.flapdoodle.unravel.parser.types.Scope.ModuleRequires;
import static de.flapdoodle.unravel.parser.types.Scope.Parameter;

import de.flapdoodle.checks.Preconditions;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;

public enum AccessFlags {
	ACC_PUBLIC(0x0001, Clazz, Field, Method), // class, field, method
	ACC_PRIVATE(0x0002, Clazz, Field, Method), // class, field, method
	ACC_PROTECTED(0x0004, Clazz, Field, Method), // class, field, method
	ACC_STATIC(0x0008, Clazz, Field, Method), // field, method - added: clazz
	ACC_FINAL(0x0010, Clazz, Field, Method, Parameter), // class, field, method, parameter
	ACC_SUPER(0x0020, Clazz), // class
	ACC_SYNCHRONIZED(0x0020, Method), // method
	ACC_OPEN(0x0020, Module), // module
	ACC_TRANSITIVE(0x0020, ModuleRequires), // module requires
	ACC_VOLATILE(0x0040, Field), // field
	ACC_BRIDGE(0x0040, Method), // method
	ACC_STATIC_PHASE(0x0040, ModuleRequires), // module requires
	ACC_VARARGS(0x0080, Method), // method
	ACC_TRANSIENT(0x0080, Field), // field
	ACC_NATIVE(0x0100, Method), // method
	ACC_INTERFACE(0x0200, Clazz), // class
	ACC_ABSTRACT(0x0400, Clazz, Method), // class, method
	ACC_STRICT(0x0800, Method), // method
	ACC_SYNTHETIC(0x1000, Clazz, Field, Method, Parameter, Module), // class, field, method, parameter, module *
	ACC_ANNOTATION(0x2000, Clazz), // class
	ACC_ENUM(0x4000, Clazz, Field, Inner), // class(?) field inner
	ACC_MANDATED(0x8000, Parameter, Module), // parameter, module, module *
	ACC_MODULE(0x8000, Clazz); // class

	final int mask;

	private static final Set<AccessFlags> ALL = HashSet.of(AccessFlags.values());

	private final Set<Scope> scopes;

	private AccessFlags(int mask, Scope... scopes) {
		this.mask = mask;
		this.scopes = HashSet.of(scopes);
	}

	public static int bitsetOf(Set<AccessFlags> src) {
		int ret = 0;
		for (AccessFlags f : src) {
			ret = ret | f.mask;
		}
		return ret;
	}

	public static Set<AccessFlags> flags(Scope scope, int value) {
		Set<AccessFlags> ret = ALL.filter(af -> af.scopes.contains(scope))
				.filter(af -> (af.mask & value) != 0);

		int bitset = bitsetOf(ret);
		Preconditions.checkArgument((value ^ bitset) == 0, "missing bits in scope %s - %s != %s", scope, value, bitset);
		return ret;
	}
}
