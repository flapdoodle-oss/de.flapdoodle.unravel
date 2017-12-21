package de.flapdoodle.unravel.asm;

import java.io.InputStream;
import java.util.function.Supplier;

import de.flapdoodle.unravel.types.AClass;

public class AbstractClazzParserTest {

	static AClass parse(Supplier<InputStream> byteCodeOf) {
		return new ClazzParser().parse(byteCodeOf);
	}

}
