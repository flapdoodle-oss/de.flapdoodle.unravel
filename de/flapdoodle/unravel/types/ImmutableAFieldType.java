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
 * Immutable implementation of {@link AFieldType}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAFieldType.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AFieldType"})
@Immutable
@CheckReturnValue
public final class ImmutableAFieldType extends AFieldType {
  private final String raw;
  private final ATypeName clazz;
  private final int arrayDimension;

  private ImmutableAFieldType(String raw, ATypeName clazz, int arrayDimension) {
    this.raw = raw;
    this.clazz = clazz;
    this.arrayDimension = arrayDimension;
  }

  /**
   * @return The value of the {@code raw} attribute
   */
  @Override
  public String raw() {
    return raw;
  }

  /**
   * @return The value of the {@code clazz} attribute
   */
  @Override
  public ATypeName clazz() {
    return clazz;
  }

  /**
   * @return The value of the {@code arrayDimension} attribute
   */
  @Override
  public int arrayDimension() {
    return arrayDimension;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AFieldType#raw() raw} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for raw
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAFieldType withRaw(String value) {
    if (this.raw.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "raw");
    return new ImmutableAFieldType(newValue, this.clazz, this.arrayDimension);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AFieldType#clazz() clazz} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for clazz
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAFieldType withClazz(ATypeName value) {
    if (this.clazz == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "clazz");
    return new ImmutableAFieldType(this.raw, newValue, this.arrayDimension);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AFieldType#arrayDimension() arrayDimension} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for arrayDimension
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAFieldType withArrayDimension(int value) {
    if (this.arrayDimension == value) return this;
    return new ImmutableAFieldType(this.raw, this.clazz, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAFieldType} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAFieldType
        && equalTo((ImmutableAFieldType) another);
  }

  private boolean equalTo(ImmutableAFieldType another) {
    return raw.equals(another.raw)
        && clazz.equals(another.clazz)
        && arrayDimension == another.arrayDimension;
  }

  /**
   * Computes a hash code from attributes: {@code raw}, {@code clazz}, {@code arrayDimension}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + raw.hashCode();
    h += (h << 5) + clazz.hashCode();
    h += (h << 5) + arrayDimension;
    return h;
  }

  /**
   * Prints the immutable value {@code AFieldType} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AFieldType")
        .omitNullValues()
        .add("raw", raw)
        .add("clazz", clazz)
        .add("arrayDimension", arrayDimension)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link AFieldType} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AFieldType instance
   */
  public static ImmutableAFieldType copyOf(AFieldType instance) {
    if (instance instanceof ImmutableAFieldType) {
      return (ImmutableAFieldType) instance;
    }
    return ImmutableAFieldType.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAFieldType ImmutableAFieldType}.
   * @return A new ImmutableAFieldType builder
   */
  public static ImmutableAFieldType.Builder builder() {
    return new ImmutableAFieldType.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAFieldType ImmutableAFieldType}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_RAW = 0x1L;
    private static final long INIT_BIT_CLAZZ = 0x2L;
    private static final long INIT_BIT_ARRAY_DIMENSION = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String raw;
    private @Nullable ATypeName clazz;
    private int arrayDimension;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AFieldType} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AFieldType instance) {
      Objects.requireNonNull(instance, "instance");
      raw(instance.raw());
      clazz(instance.clazz());
      arrayDimension(instance.arrayDimension());
      return this;
    }

    /**
     * Initializes the value for the {@link AFieldType#raw() raw} attribute.
     * @param raw The value for raw 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder raw(String raw) {
      this.raw = Objects.requireNonNull(raw, "raw");
      initBits &= ~INIT_BIT_RAW;
      return this;
    }

    /**
     * Initializes the value for the {@link AFieldType#clazz() clazz} attribute.
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
     * Initializes the value for the {@link AFieldType#arrayDimension() arrayDimension} attribute.
     * @param arrayDimension The value for arrayDimension 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder arrayDimension(int arrayDimension) {
      this.arrayDimension = arrayDimension;
      initBits &= ~INIT_BIT_ARRAY_DIMENSION;
      return this;
    }

    /**
     * Builds a new {@link ImmutableAFieldType ImmutableAFieldType}.
     * @return An immutable instance of AFieldType
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAFieldType build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAFieldType(raw, clazz, arrayDimension);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_RAW) != 0) attributes.add("raw");
      if ((initBits & INIT_BIT_CLAZZ) != 0) attributes.add("clazz");
      if ((initBits & INIT_BIT_ARRAY_DIMENSION) != 0) attributes.add("arrayDimension");
      return "Cannot build AFieldType, some of required attributes are not set " + attributes;
    }
  }
}
