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
 * Immutable implementation of {@link AnEnumValue}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAnEnumValue.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableAnEnumValue.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AnEnumValue"})
@Immutable
@CheckReturnValue
public final class ImmutableAnEnumValue extends AnEnumValue {
  private final ATypeName clazz;
  private final String value;

  private ImmutableAnEnumValue(ATypeName clazz, String value) {
    this.clazz = Objects.requireNonNull(clazz, "clazz");
    this.value = Objects.requireNonNull(value, "value");
  }

  private ImmutableAnEnumValue(ImmutableAnEnumValue original, ATypeName clazz, String value) {
    this.clazz = clazz;
    this.value = value;
  }

  /**
   * @return The value of the {@code clazz} attribute
   */
  @Override
  public ATypeName clazz() {
    return clazz;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @Override
  public String value() {
    return value;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AnEnumValue#clazz() clazz} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for clazz
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAnEnumValue withClazz(ATypeName value) {
    if (this.clazz == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "clazz");
    return new ImmutableAnEnumValue(this, newValue, this.value);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AnEnumValue#value() value} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAnEnumValue withValue(String value) {
    if (this.value.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "value");
    return new ImmutableAnEnumValue(this, this.clazz, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAnEnumValue} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAnEnumValue
        && equalTo((ImmutableAnEnumValue) another);
  }

  private boolean equalTo(ImmutableAnEnumValue another) {
    return clazz.equals(another.clazz)
        && value.equals(another.value);
  }

  /**
   * Computes a hash code from attributes: {@code clazz}, {@code value}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + clazz.hashCode();
    h += (h << 5) + value.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code AnEnumValue} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AnEnumValue")
        .omitNullValues()
        .add("clazz", clazz)
        .add("value", value)
        .toString();
  }

  /**
   * Construct a new immutable {@code AnEnumValue} instance.
   * @param clazz The value for the {@code clazz} attribute
   * @param value The value for the {@code value} attribute
   * @return An immutable AnEnumValue instance
   */
  public static ImmutableAnEnumValue of(ATypeName clazz, String value) {
    return new ImmutableAnEnumValue(clazz, value);
  }

  /**
   * Creates an immutable copy of a {@link AnEnumValue} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AnEnumValue instance
   */
  public static ImmutableAnEnumValue copyOf(AnEnumValue instance) {
    if (instance instanceof ImmutableAnEnumValue) {
      return (ImmutableAnEnumValue) instance;
    }
    return ImmutableAnEnumValue.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAnEnumValue ImmutableAnEnumValue}.
   * @return A new ImmutableAnEnumValue builder
   */
  public static ImmutableAnEnumValue.Builder builder() {
    return new ImmutableAnEnumValue.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAnEnumValue ImmutableAnEnumValue}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLAZZ = 0x1L;
    private static final long INIT_BIT_VALUE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable ATypeName clazz;
    private @Nullable String value;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AnEnumValue} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AnEnumValue instance) {
      Objects.requireNonNull(instance, "instance");
      clazz(instance.clazz());
      value(instance.value());
      return this;
    }

    /**
     * Initializes the value for the {@link AnEnumValue#clazz() clazz} attribute.
     * @param clazz The value for clazz 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder clazz(ATypeName clazz) {
      this.clazz = Objects.requireNonNull(clazz, "clazz");
      initBits &= ~INIT_BIT_CLAZZ;
      return this;
    }

    /**
     * Initializes the value for the {@link AnEnumValue#value() value} attribute.
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
     * Builds a new {@link ImmutableAnEnumValue ImmutableAnEnumValue}.
     * @return An immutable instance of AnEnumValue
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAnEnumValue build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAnEnumValue(null, clazz, value);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLAZZ) != 0) attributes.add("clazz");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build AnEnumValue, some of required attributes are not set " + attributes;
    }
  }
}
