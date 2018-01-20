package de.flapdoodle.unravel.signature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.samples.asm.basics.InnerOuter;
import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.ATypeName;
import io.vavr.collection.HashMap;
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
		
		Map<ATypeName, AClass> map=HashMap.<ATypeName, AClass>empty()
				.put(inner_1.typeName(),inner_1)
				.put(inner_1_1.typeName(),inner_1_1)
				.put(inner_1_anonInner.typeName(),inner_1_anonInner)
				.put(inner.typeName(),inner)
				.put(innerInner.typeName(),innerInner)
				.put(inner_2.typeName(),inner_2)
				.put(inner_3.typeName(),inner_3)
				;
		
		DefaultTypeSignatureFactory factory = new DefaultTypeSignatureFactory();
		
		TypeSignature result = factory.signatureOf(innerOuter, map::get);
		
		assertEquals(4,result.innerClasses().size());
	}
}
