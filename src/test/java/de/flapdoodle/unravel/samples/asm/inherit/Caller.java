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
package de.flapdoodle.unravel.samples.asm.inherit;

import java.util.function.Supplier;

public class Caller {

	ExtendsExtends extendsExtends=new ExtendsExtends();
	AbstractExtends abstractExtends=extendsExtends;
	Base base=abstractExtends;
	AbstractBase abstractBase=base;
	
	Supplier<String> supplier=abstractExtends;
	LocalInterface localInterface=abstractExtends;
	
	public void allMethodsOfExtendsExtends() {
		extendsExtends.abstractAbstractBaseMethod();
		extendsExtends.abstractBaseMethod();
		extendsExtends.baseMethod();
		extendsExtends.get();
		extendsExtends.interfaceMethod();
		extendsExtends.defaultMethod();
		extendsExtends.toString();
	}

	public void allMethodsOfAbstractExtends() {
		abstractExtends.abstractAbstractBaseMethod();
		abstractExtends.abstractBaseMethod();
		abstractExtends.baseMethod();
		abstractExtends.get();
		abstractExtends.interfaceMethod();
		abstractExtends.defaultMethod();
		abstractExtends.toString();
	}
}
