package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link Usage.UsedType}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUsedType.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Usage.UsedType"})
@Immutable
@CheckReturnValue
public final class ImmutableUsedType implements Usage.UsedType {
  private final Set<Usage.UsedAnnotation> annotations;
  private final Set<Usage.UsedField> fields;
  private final Set<Usage.UsedMethod> methods;

  private ImmutableUsedType(
      Set<Usage.UsedAnnotation> annotations,
      Set<Usage.UsedField> fields,
      Set<Usage.UsedMethod> methods) {
    this.annotations = annotations;
    this.fields = fields;
    this.methods = methods;
  }

  /**
   * @return The value of the {@code annotations} attribute
   */
  @Override
  public Set<Usage.UsedAnnotation> annotations() {
    return annotations;
  }

  /**
   * @return The value of the {@code fields} attribute
   */
  @Override
  public Set<Usage.UsedField> fields() {
    return fields;
  }

  /**
   * @return The value of the {@code methods} attribute
   */
  @Override
  public Set<Usage.UsedMethod> methods() {
    return methods;
  }

  public ImmutableUsedType withAnnotations(Set<Usage.UsedAnnotation> value) {
    Set<Usage.UsedAnnotation> newValue = annotations_from(value);
    if (this.annotations == newValue) return this;
    return new ImmutableUsedType(newValue, this.fields, this.methods);
  }

  public ImmutableUsedType withFields(Set<Usage.UsedField> value) {
    Set<Usage.UsedField> newValue = fields_from(value);
    if (this.fields == newValue) return this;
    return new ImmutableUsedType(this.annotations, newValue, this.methods);
  }

  public ImmutableUsedType withMethods(Set<Usage.UsedMethod> value) {
    Set<Usage.UsedMethod> newValue = methods_from(value);
    if (this.methods == newValue) return this;
    return new ImmutableUsedType(this.annotations, this.fields, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUsedType} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUsedType
        && equalTo((ImmutableUsedType) another);
  }

  private boolean equalTo(ImmutableUsedType another) {
    return this.annotations().equals(another.annotations())
        && this.fields().equals(another.fields())
        && this.methods().equals(another.methods());
  }

  /**
   * Computes a hash code from attributes: {@code annotations}, {@code fields}, {@code methods}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + (annotations().hashCode());
    h += (h << 5) + (fields().hashCode());
    h += (h << 5) + (methods().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code UsedType} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UsedType")
        .omitNullValues()
        .add("annotations", annotations().toString())
        .add("fields", fields().toString())
        .add("methods", methods().toString())
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Usage.UsedType} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UsedType instance
   */
  public static ImmutableUsedType copyOf(Usage.UsedType instance) {
    if (instance instanceof ImmutableUsedType) {
      return (ImmutableUsedType) instance;
    }
    return ImmutableUsedType.builder()
        .from(instance)
        .build();
  }

  private static Set<Usage.UsedAnnotation> annotations_from(Set<Usage.UsedAnnotation> value) {
    return value;
  }

  private static Set<Usage.UsedField> fields_from(Set<Usage.UsedField> value) {
    return value;
  }

  private static Set<Usage.UsedMethod> methods_from(Set<Usage.UsedMethod> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableUsedType ImmutableUsedType}.
   * @return A new ImmutableUsedType builder
   */
  public static ImmutableUsedType.Builder builder() {
    return new ImmutableUsedType.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUsedType ImmutableUsedType}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private Set<Usage.UsedAnnotation> annotations_set = HashSet.empty();
    private Set<Usage.UsedField> fields_set = HashSet.empty();
    private Set<Usage.UsedMethod> methods_set = HashSet.empty();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UsedType} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Usage.UsedType instance) {
      Objects.requireNonNull(instance, "instance");
      annotations(instance.annotations());
      fields(instance.fields());
      methods(instance.methods());
      return this;
    }

    public Builder addAnnotations(Usage.UsedAnnotation element) {
      this.annotations_set = this.annotations_set.add(element);
      return this;
    }

    public Builder addAllAnnotations(Iterable<Usage.UsedAnnotation> element) {
      this.annotations_set = this.annotations_set.addAll(element);
      return this;
    }

    public Builder annotations(Set<Usage.UsedAnnotation> elements) {
      this.annotations_set = elements;
      return this;
    }

    public Builder setIterableAnnotations(Iterable<Usage.UsedAnnotation> elements) {
      this.annotations_set = HashSet.ofAll(elements);
      return this;
    }

    public Builder addFields(Usage.UsedField element) {
      this.fields_set = this.fields_set.add(element);
      return this;
    }

    public Builder addAllFields(Iterable<Usage.UsedField> element) {
      this.fields_set = this.fields_set.addAll(element);
      return this;
    }

    public Builder fields(Set<Usage.UsedField> elements) {
      this.fields_set = elements;
      return this;
    }

    public Builder setIterableFields(Iterable<Usage.UsedField> elements) {
      this.fields_set = HashSet.ofAll(elements);
      return this;
    }

    public Builder addMethods(Usage.UsedMethod element) {
      this.methods_set = this.methods_set.add(element);
      return this;
    }

    public Builder addAllMethods(Iterable<Usage.UsedMethod> element) {
      this.methods_set = this.methods_set.addAll(element);
      return this;
    }

    public Builder methods(Set<Usage.UsedMethod> elements) {
      this.methods_set = elements;
      return this;
    }

    public Builder setIterableMethods(Iterable<Usage.UsedMethod> elements) {
      this.methods_set = HashSet.ofAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableUsedType ImmutableUsedType}.
     * @return An immutable instance of UsedType
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUsedType build() {
      return new ImmutableUsedType(this.annotations_set, this.fields_set, this.methods_set);
    }
  }
}
