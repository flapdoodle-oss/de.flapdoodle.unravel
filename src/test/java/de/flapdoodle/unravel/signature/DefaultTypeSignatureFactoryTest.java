package de.flapdoodle.unravel.signature;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.IterableAssert;
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
		
		DefaultTypeSignatureFactory factory = new DefaultTypeSignatureFactory();
		
		TypeSignature result = factory.signatureOf(innerOuter, map::get);
		
		Assertions.assertThat(result)
			.isJava8()
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC)
			.typeNameIs(Classnames.typeNameOf(InnerOuter.class))
			.innerClasses(level1 -> {
				level1.size().isEqualTo(4);
				level1.element(0)
					.isJava8()
					.accessFlags()
					.typeNameIs(Classnames.anonTypeNameOf(InnerOuter.class,"1"))
					.innerClasses(level1_0 -> {
						level1_0.size().isEqualTo(3);
						level1_0.element(0)
							.isJava8()
							.accessFlags()
							.typeNameIs(Classnames.anonTypeNameOf(InnerOuter.class,"1","1"))
							.innerClasses(level1_0_0 -> {
								level1_0_0.size().isEqualTo(0);
							});
						level1_0.element(1)
							.isJava8()
							.accessFlags()
							.typeNameIs(Classnames.anonTypeNameOf(InnerOuter.class,"1","1AnonInner"))
							.innerClasses(level1_0_1 -> {
								level1_0_1.size().isEqualTo(0);
							});
						level1_0.element(2)
							.isJava8()
							.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC)
							.typeNameIs(Classnames.typeNameOf(InnerOuter.Inner.class))
							.innerClasses(level1_0_1 -> {
								level1_0_1.size().isEqualTo(1);
								level1_0_1.element(0)
									.isJava8()
									.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC)
									.typeNameIs(Classnames.typeNameOf(InnerOuter.Inner.InnerInner.class))
									.innerClasses(level1_0_1_0 -> level1_0_1_0.isEmpty());
								});
				});
				level1.element(1)
					.isJava8()
					.accessFlags()
					.typeNameIs(Classnames.anonNameOf(InnerOuter.class,"2"))
					.innerClasses(level1_1 -> {
						level1_1.size().isEqualTo(1);
						level1_1.element(0)
							.isJava8()
							.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC)
							.typeNameIs(Classnames.typeNameOf(InnerOuter.Inner.class))
							.innerClasses(level1_1_0 -> {
								level1_1_0.size().isEqualTo(1);
								level1_1_0.element(0)
									.isJava8()
									.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC)
									.typeNameIs(Classnames.typeNameOf(InnerOuter.Inner.InnerInner.class))
									.innerClasses(level1_1_0_0 -> level1_1_0_0.isEmpty());
							});
					});
			});

		IterableAssert<TypeSignature> innerClassesAssert = Assertions.assertThat(result.innerClasses());
		innerClassesAssert.size().isEqualTo(4);
		innerClassesAssert.element(0).extracting(TypeSignature::innerClasses).hasSize(1);
		
		assertEquals(4, result.innerClasses().size());
		TypeSignature shouldBeInner_1 = result.innerClasses().get(0);
		assertEquals(inner_1.typeName(), shouldBeInner_1.typeName());
		assertEquals(3, shouldBeInner_1.innerClasses().size());
		
		assertEquals(inner_2.typeName(), result.innerClasses().get(1).typeName());
		assertEquals(inner_3.typeName(), result.innerClasses().get(2).typeName());
		
		TypeSignature shouldBeInner = result.innerClasses().get(3);
		assertEquals(inner.typeName(), shouldBeInner.typeName());
		assertEquals(1, shouldBeInner.innerClasses().size());
		
		TypeSignature shouldBeInnerInner = shouldBeInner.innerClasses().get(0);
		assertEquals(innerInner.typeName(), shouldBeInnerInner.typeName());
		assertEquals(0, shouldBeInnerInner.innerClasses().size());
	}
	
	
}
