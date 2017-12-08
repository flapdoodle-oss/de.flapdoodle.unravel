package de.flapdoodle.unravel.asm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.objectweb.asm.Type;

public class FieldTypeTest {

	@Test
	public void fieldTypeSample() {
		FieldType fieldType = FieldType.raw("Ljava/lang/String;");
		
		assertThat(Type.getType("Ljava/lang/String;").getClassName()).isEqualTo("java.lang.String");
		assertThat(Type.getType(String[].class).getClassName()).isEqualTo("java.lang.String[]");
		assertThat(Type.getType(String[][].class).getDimensions()).isEqualTo(2);
		assertThat(Type.getType(String[].class).getDimensions()).isEqualTo(1);
		assertThat(Type.getType(String.class).getDimensions()).isEqualTo(1);
		assertThat(Type.getType(String[].class).getElementType().getClassName()).isEqualTo("java.lang.String");
		
		System.out.println(Type.getType(byte.class));
		System.out.println(Type.getType(byte[].class));
		System.out.println(Type.getType(String[].class));
		System.out.println(Type.getType(Iterable.class));
	}
}
