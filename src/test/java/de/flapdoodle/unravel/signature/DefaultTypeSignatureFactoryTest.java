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
package de.flapdoodle.unravel.signature;

import org.junit.Test;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.InnerOuter;
import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import io.vavr.collection.List;
import io.vavr.collection.Map;

public class DefaultTypeSignatureFactoryTest {

	@Test
	public void resolveInnerClasses() {
		AClass innerOuter = Classes.parse(Classes.byteCodeOf(InnerOuter.class));
		AClass inner_1 = Classes.parse(Classes.byteCodeOf(Classes.anonClass(InnerOuter.class,"1")));
		AClass inner_1_1 = Classes.parse(Classes.byteCodeOf(Classes.anonClass(InnerOuter.class,"1","1")));
		AClass inner_1_anonInner = Classes.parse(Classes.byteCodeOf(Classes.anonClass(InnerOuter.class,"1","1AnonInner")));
		AClass inner = Classes.parse(Classes.byteCodeOf(InnerOuter.Inner.class));
		AClass innerInner = Classes.parse(Classes.byteCodeOf(InnerOuter.Inner.InnerInner.class));
		AClass inner_2 = Classes.parse(Classes.byteCodeOf(Classes.anonClass(InnerOuter.class,"2")));
		AClass inner_3 = Classes.parse(Classes.byteCodeOf(Classes.anonClass(InnerOuter.class,"3")));
		
		Map<ATypeName, AClass> map = List.of(inner_1, inner_1_1, inner_1_anonInner, inner, innerInner, inner_2, inner_3)
			.toMap(AClass::typeName, clazz -> clazz);
		
		SignatureOfAClassFactory factory = new DefaultTypeSignatureFactory();
		
		TypeSignature result = factory.signatureOf(innerOuter, map::get);
		
		Assertions.assertThat(result)
			.isJava8()
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC)
			.typeNameIs(Classnames.typeNameOf(InnerOuter.class))
			.innerClasses(level1 -> {
				level1.size().isEqualTo(4);
				level1.element(0)
					.isJava8()
					.accessFlags(AccessFlags.ACC_SUPER)
					.typeNameIs(Classnames.anonTypeNameOf(InnerOuter.class,"1"))
					.innerClasses(level1_0 -> {
						level1_0.size().isEqualTo(2);
						level1_0.element(0)
							.isJava8()
							.accessFlags(AccessFlags.ACC_SUPER)
							.typeNameIs(Classnames.anonTypeNameOf(InnerOuter.class,"1","1"))
							.innerClasses(level1_0_0 -> {
								level1_0_0.size().isEqualTo(0);
							});
						level1_0.element(1)
							.isJava8()
							.accessFlags(AccessFlags.ACC_SUPER)
							.typeNameIs(Classnames.anonTypeNameOf(InnerOuter.class,"1","1AnonInner"))
							.innerClasses(level1_0_1 -> {
								level1_0_1.size().isEqualTo(0);
							});
				});
				level1.element(1)
					.isJava8()
					.accessFlags(AccessFlags.ACC_SUPER)
					.typeNameIs(Classnames.anonNameOf(InnerOuter.class,"2"))
					.innerClasses(level1_1 -> {
						level1_1.size().isEqualTo(0);
					});
				level1.element(2)
					.isJava8()
					.accessFlags(AccessFlags.ACC_SUPER)
					.typeNameIs(Classnames.anonNameOf(InnerOuter.class,"3"))
					.innerClasses(level1_2 -> {
						level1_2.size().isEqualTo(0);
					});
				level1.element(3)
					.isJava8()
					.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC)
					.typeNameIs(Classnames.nameOf(InnerOuter.Inner.class))
					.innerClasses(level1_3 -> {
						level1_3.size().isEqualTo(1);
						level1_3.element(0)
							.isJava8()
							.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC)
							.typeNameIs(Classnames.nameOf(InnerOuter.Inner.InnerInner.class))
							.innerClasses(level1_3_0 -> {
								level1_3_0.size().isEqualTo(0);
							});
					});
			});
	}
	
	
}
