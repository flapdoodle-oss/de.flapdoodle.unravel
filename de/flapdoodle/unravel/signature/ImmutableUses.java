package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import de.flapdoodle.unravel.types.ATypeName;
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
 * Immutable implementation of {@link TypeSignature.Uses}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUses.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "TypeSignature.Uses"})
@Immutable
@CheckReturnValue
public final class ImmutableUses implements TypeSignature.Uses {
  private final Set<ATypeName> types;

  private ImmutableUses(Set<ATypeName> types) {
    this.types = types;
  }

  /**
   * @return The value of the {@code types} attribute
   */
  @Override
  public Set<ATypeName> types() {
    return types;
  }

  public ImmutableUses withTypes(Set<ATypeName> value) {
    Set<ATypeName> newValue = types_from(value);
    if (this.types == newValue) return this;
    return new ImmutableUses(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUses} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUses
        && equalTo((ImmutableUses) another);
  }

  private boolean equalTo(ImmutableUses another) {
    return this.types().equals(another.types());
  }

  /**
   * Computes a hash code from attributes: {@code types}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + (types().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code Uses} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Uses")
        .omitNullValues()
        .add("types", types().toString())
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link TypeSignature.Uses} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Uses instance
   */
  public static ImmutableUses copyOf(TypeSignature.Uses instance) {
    if (instance instanceof ImmutableUses) {
      return (ImmutableUses) instance;
    }
    return ImmutableUses.builder()
        .from(instance)
        .build();
  }

  private static Set<ATypeName> types_from(Set<ATypeName> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableUses ImmutableUses}.
   * @return A new ImmutableUses builder
   */
  public static ImmutableUses.Builder builder() {
    return new ImmutableUses.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUses ImmutableUses}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private Set<ATypeName> types_set = HashSet.empty();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Uses} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(TypeSignature.Uses instance) {
      Objects.requireNonNull(instance, "instance");
      types(instance.types());
      return this;
    }

    public Builder addTypes(ATypeName element) {
      this.types_set = this.types_set.add(element);
      return this;
    }

    public Builder addAllTypes(Iterable<ATypeName> element) {
      this.types_set = this.types_set.addAll(element);
      return this;
    }

    public Builder types(Set<ATypeName> elements) {
      this.types_set = elements;
      return this;
    }

    public Builder setIterableTypes(Iterable<ATypeName> elements) {
      this.types_set = HashSet.ofAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableUses ImmutableUses}.
     * @return An immutable instance of Uses
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUses build() {
      return new ImmutableUses(this.types_set);
    }
  }
}
