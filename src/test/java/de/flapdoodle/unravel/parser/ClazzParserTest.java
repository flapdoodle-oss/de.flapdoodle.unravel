package de.flapdoodle.unravel.parser;

import org.assertj.core.api.AbstractIterableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.JavaSource;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.parser.types.AClass;
import de.flapdoodle.unravel.parser.types.AccessFlags;
import de.flapdoodle.unravel.parser.types.JavaVersion;
import de.flapdoodle.unravel.samples.asm.basics.AnnotationPublic;

import static de.flapdoodle.unravel.Assertions.assertThat;

class ClazzParserTest {

    @Nested
    @DisplayName("basic")
    class Basic {

        @Test
        void annotationPublic() {
            assertThat(ClazzParser.parse(Classes.byteCodeOf(JavaVersion.V1_8, JavaSource.of(AnnotationPublic.class))))
                    .isNotNull()
                    .typeNameIs(Classnames.nameOf(AnnotationPublic.class))
                    .isAtLeast(JavaVersion.V1_8)
                    .superClass(Object.class)
                    .methods(AbstractIterableAssert::isEmpty)
                    .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE);
        }
    }
}