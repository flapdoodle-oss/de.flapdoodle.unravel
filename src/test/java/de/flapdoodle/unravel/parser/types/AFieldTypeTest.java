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
package de.flapdoodle.unravel.parser.types;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.objectweb.asm.Type;

import de.flapdoodle.unravel.parser.types.AFieldType;

public class AFieldTypeTest {

	@Test
	public void simpleStringField() {
		AFieldType fieldType = AFieldType.raw("Ljava/lang/String;");
		assertThat(fieldType.clazz().value()).isEqualTo("java.lang.String");
		assertThat(fieldType.arrayDimension()).isEqualTo(0);
		
	}

	@Test
	public void stringArrayField() {
		AFieldType fieldType = AFieldType.raw("[[Ljava/lang/String;");
		assertThat(fieldType.clazz().value()).isEqualTo("java.lang.String");
		assertThat(fieldType.arrayDimension()).isEqualTo(2);
	}
	
	@Test
	public void typeTests() {
		assertThat(Type.getType("Ljava/lang/String;").getClassName()).isEqualTo("java.lang.String");
		assertThat(Type.getType(String[].class).getClassName()).isEqualTo("java.lang.String[]");
		assertThat(Type.getType(String[].class).getElementType().getClassName()).isEqualTo("java.lang.String");
		assertThat(Type.getType(String[][].class).getDimensions()).isEqualTo(2);
		assertThat(Type.getType(String[][].class).getSort()).isEqualTo(Type.ARRAY);
		assertThat(Type.getType(String[].class).getDimensions()).isEqualTo(1);
		assertThat(Type.getType(String.class).getDimensions()).isEqualTo(1);
		assertThat(Type.getType(String[].class).getElementType().getClassName()).isEqualTo("java.lang.String");
		
//		System.out.println(Type.getType(byte.class));
//		System.out.println(Type.getType(byte[].class));
//		System.out.println(Type.getType(String.class));
//		System.out.println(Type.getType(String[].class));
//		System.out.println(Type.getType(String[][].class));
//		System.out.println(Type.getType(Iterable.class));
	}
}
