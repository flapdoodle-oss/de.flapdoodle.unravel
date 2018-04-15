package de.flapdoodle.unravel.types;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ATypeName}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableATypeName.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableATypeName.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "ATypeName"})
@Immutable
@CheckReturnValue
public final class ImmutableATypeName implements ATypeName {
  private final String value;

  private ImmutableATypeName(String value) {
    this.value = Objects.requireNonNull(value, "value");
  }

  private ImmutableATypeName(ImmutableATypeName original, String value) {
    this.value = value;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @Override
  public String value() {
    return value;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ATypeName#value() value} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableATypeName withValue(String value) {
    if (this.value.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "value");
    return new ImmutableATypeName(this, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableATypeName} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableATypeName
        && equalTo((ImmutableATypeName) another);
  }

  private boolean equalTo(ImmutableATypeName another) {
    return value.equals(another.value);
  }

  /**
   * Computes a hash code from attributes: {@code value}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + value.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ATypeName} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ATypeName")
        .omitNullValues()
        .add("value", value)
        .toString();
  }

  /**
   * Construct a new immutable {@code ATypeName} instance.
   * @param value The value for the {@code value} attribute
   * @return An immutable ATypeName instance
   */
  public static ImmutableATypeName of(String value) {
    return new ImmutableATypeName(value);
  }

  /**
   * Creates an immutable copy of a {@link ATypeName} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ATypeName instance
   */
  public static ImmutableATypeName copyOf(ATypeName instance) {
    if (instance instanceof ImmutableATypeName) {
      return (ImmutableATypeName) instance;
    }
    return ImmutableATypeName.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableATypeName ImmutableATypeName}.
   * @return A new ImmutableATypeName builder
   */
  public static ImmutableATypeName.Builder builder() {
    return new ImmutableATypeName.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableATypeName ImmutableATypeName}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_VALUE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String value;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ATypeName} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(ATypeName instance) {
      Objects.requireNonNull(instance, "instance");
      value(instance.value());
      return this;
    }

    /**
     * Initializes the value for the {@link ATypeName#value() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder value(String value) {
      this.value = Objects.requireNonNull(value, "value");
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableATypeName ImmutableATypeName}.
     * @return An immutable instance of ATypeName
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableATypeName build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableATypeName(null, value);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build ATypeName, some of required attributes are not set " + attributes;
    }
  }
}
