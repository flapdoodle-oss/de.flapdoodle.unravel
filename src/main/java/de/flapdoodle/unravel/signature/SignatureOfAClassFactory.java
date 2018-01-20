package de.flapdoodle.unravel.signature;

import java.util.function.Function;

import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.ATypeName;
import io.vavr.control.Option;

public interface SignatureOfAClassFactory {
	TypeSignature signatureOf(AClass aClass, Function<ATypeName, Option<AClass>> classOfTypeName);
}
