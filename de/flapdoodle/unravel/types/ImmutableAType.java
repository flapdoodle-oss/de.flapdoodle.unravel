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
 * Immutable implementation of {@link AType}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAType.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableAType.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AType"})
@Immutable
@CheckReturnValue
public final class ImmutableAType implements AType {
  private final ATypeName clazz;
  private final int arrayDimension;

  private ImmutableAType(ATypeName clazz, int arrayDimension) {
    this.clazz = Objects.requireNonNull(clazz, "clazz");
    this.arrayDimension = arrayDimension;
  }

  private ImmutableAType(ImmutableAType original, ATypeName clazz, int arrayDimension) {
    this.clazz = clazz;
    this.arrayDimension = arrayDimension;
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
   * Copy the current immutable object by setting a value for the {@link AType#clazz() clazz} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for clazz
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAType withClazz(ATypeName value) {
    if (this.clazz == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "clazz");
    return new ImmutableAType(this, newValue, this.arrayDimension);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AType#arrayDimension() arrayDimension} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for arrayDimension
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAType withArrayDimension(int value) {
    if (this.arrayDimension == value) return this;
    return new ImmutableAType(this, this.clazz, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAType} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAType
        && equalTo((ImmutableAType) another);
  }

  private boolean equalTo(ImmutableAType another) {
    return clazz.equals(another.clazz)
        && arrayDimension == another.arrayDimension;
  }

  /**
   * Computes a hash code from attributes: {@code clazz}, {@code arrayDimension}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + clazz.hashCode();
    h += (h << 5) + arrayDimension;
    return h;
  }

  /**
   * Prints the immutable value {@code AType} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AType")
        .omitNullValues()
        .add("clazz", clazz)
        .add("arrayDimension", arrayDimension)
        .toString();
  }

  /**
   * Construct a new immutable {@code AType} instance.
   * @param clazz The value for the {@code clazz} attribute
   * @param arrayDimension The value for the {@code arrayDimension} attribute
   * @return An immutable AType instance
   */
  public static ImmutableAType of(ATypeName clazz, int arrayDimension) {
    return new ImmutableAType(clazz, arrayDimension);
  }

  /**
   * Creates an immutable copy of a {@link AType} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AType instance
   */
  public static ImmutableAType copyOf(AType instance) {
    if (instance instanceof ImmutableAType) {
      return (ImmutableAType) instance;
    }
    return ImmutableAType.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAType ImmutableAType}.
   * @return A new ImmutableAType builder
   */
  public static ImmutableAType.Builder builder() {
    return new ImmutableAType.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAType ImmutableAType}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLAZZ = 0x1L;
    private static final long INIT_BIT_ARRAY_DIMENSION = 0x2L;
    private long initBits = 0x3L;

    private @Nullable ATypeName clazz;
    private int arrayDimension;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AType} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AType instance) {
      Objects.requireNonNull(instance, "instance");
      clazz(instance.clazz());
      arrayDimension(instance.arrayDimension());
      return this;
    }

    /**
     * Initializes the value for the {@link AType#clazz() clazz} attribute.
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
     * Initializes the value for the {@link AType#arrayDimension() arrayDimension} attribute.
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
     * Builds a new {@link ImmutableAType ImmutableAType}.
     * @return An immutable instance of AType
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAType build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAType(null, clazz, arrayDimension);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLAZZ) != 0) attributes.add("clazz");
      if ((initBits & INIT_BIT_ARRAY_DIMENSION) != 0) attributes.add("arrayDimension");
      return "Cannot build AType, some of required attributes are not set " + attributes;
    }
  }
}
