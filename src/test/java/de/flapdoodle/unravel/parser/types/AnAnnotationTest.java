package de.flapdoodle.unravel.parser.types;

import org.junit.jupiter.api.Test;

import de.flapdoodle.unravel.assertions.AnAnnotationAssert;

import static org.assertj.core.api.Assertions.assertThat;

class AnAnnotationTest {

    @Test
    void builderResults() {
        ImmutableAnAnnotation result = AnAnnotation.builder(ATypeName.of("foo"), true)
                .putAnnotations("bar", AnAnnotation.builder(ATypeName.of("barOne"), true).build())
                .putAnnotations("bar", AnAnnotation.builder(ATypeName.of("barTwo"), true).build())
                .putAnnotations("baz", AnAnnotation.builder(ATypeName.of("baz"), true).build())
                .build();

        assertThat(result).isNotNull();

        assertThat(result.annotations().asMap())
                .hasSize(2)
                .containsKeys("bar", "baz")
                .anySatisfy((key, value) -> assertThat(value)
                        .hasSize(2)
                        .anyMatch(it -> it.clazz().value().equals("barOne"))
                        .anyMatch(it -> it.clazz().value().equals("barTwo"))
                ).anySatisfy((key, value) -> assertThat(value)
                        .hasSize(1)
                        .anyMatch(it -> it.clazz().value().equals("baz"))
                );

        new AnAnnotationAssert(result)
                .annotation("bar", it -> {
                    it.size().isEqualTo(2);
                    it.element(0).isClass("barOne");
                    it.element(1).isClass("barTwo");
                })
                .annotation("baz", it -> {
                    it.size().isEqualTo(1);
                    it.element(0).isClass("baz");
                });
    }
}