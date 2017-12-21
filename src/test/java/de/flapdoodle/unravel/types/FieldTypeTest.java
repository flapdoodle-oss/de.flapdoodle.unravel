package de.flapdoodle.unravel.types;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.objectweb.asm.Type;

import de.flapdoodle.unravel.types.FieldType;

public class FieldTypeTest {

	@Test
	public void simpleStringField() {
		FieldType fieldType = FieldType.raw("Ljava/lang/String;");
		assertThat(fieldType.clazz().value()).isEqualTo("java.lang.String");
		assertThat(fieldType.arrayDimension()).isEqualTo(0);
		
	}

	@Test
	public void stringArrayField() {
		FieldType fieldType = FieldType.raw("[[Ljava/lang/String;");
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
