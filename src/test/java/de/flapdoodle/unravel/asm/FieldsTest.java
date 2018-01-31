package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.Fields;
import de.flapdoodle.unravel.types.AccessFlags;

public class FieldsTest {
	
	@Test
	public void fieldTypes() {
		assertThat(Classes.parse(byteCodeOf(Fields.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(Fields.class))
			.signature("<K:Ljava/lang/Object;V:Ljava/lang/Object;>Ljava/lang/Object;")
			.fields(fields -> {
				fields.size().isEqualTo(6);
				fields.element(0)
					.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC, AccessFlags.ACC_FINAL)
					.name("privateStaticFinalString")
					.clazz("java.lang.String")
					.arrayDimension(0)
					.hasNoSignature()
					.value("Foo");
				fields.element(1)
					.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_FINAL)
					.name("privateFinalString")
					.clazz("java.lang.String")
					.arrayDimension(0)
					.hasNoSignature()
					.hasNoValue();
				fields.element(2)
					.accessFlags(AccessFlags.ACC_PROTECTED)
					.name("privateListOfString")
					.clazz("java.util.List")
					.arrayDimension(0)
					.signature("Ljava/util/List<Ljava/lang/String;>;")
					.hasNoValue();
				fields.element(3)
					.accessFlags(AccessFlags.ACC_PUBLIC)
					.name("publicMap")
					.clazz("java.util.Map")
					.arrayDimension(0)
					.signature("Ljava/util/Map<TK;TV;>;")
					.hasNoValue();
				fields.element(4)
					.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_FINAL)
					.name("privateStringFromMethod")
					.clazz("java.lang.String")
					.arrayDimension(0)
					.hasNoSignature()
					.hasNoValue();
				fields.element(5)
					.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_FINAL)
					.name("privateStringFromField")
					.clazz("java.lang.String")
					.arrayDimension(0)
					.hasNoSignature()
					.value("Foo");
			});
		
	}
}