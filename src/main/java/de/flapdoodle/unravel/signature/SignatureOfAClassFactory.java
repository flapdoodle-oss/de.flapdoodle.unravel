package de.flapdoodle.unravel.signature;

import de.flapdoodle.unravel.types.AClass;

public interface SignatureOfAClassFactory {
	TypeSignature signatureOf(AClass aClass);
}
