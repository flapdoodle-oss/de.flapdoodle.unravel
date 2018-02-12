package de.flapdoodle.unravel.signature;

import de.flapdoodle.unravel.types.AMethodSignature;
import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.InvocationType;
import io.vavr.collection.Map;

public interface UsageListener {
	void type(ATypeName type);
	void field(ATypeName clazz, String name, AType fieldType, boolean staticCall);
	void method(ATypeName clazz, String name, AMethodSignature signature, InvocationType invocationType);
	void annotation(ATypeName clazz, Map<String, AType> parameters);
}
