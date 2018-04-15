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
 * Immutable implementation of {@link Calls.TypeReferenceCall}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTypeReferenceCall.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableTypeReferenceCall.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Calls.TypeReferenceCall"})
@Immutable
@CheckReturnValue
public final class ImmutableTypeReferenceCall implements Calls.TypeReferenceCall {
  private final ATypeName clazz;

  private ImmutableTypeReferenceCall(ATypeName clazz) {
    this.clazz = Objects.requireNonNull(clazz, "clazz");
  }

  private ImmutableTypeReferenceCall(ImmutableTypeReferenceCall original, ATypeName clazz) {
    this.clazz = clazz;
  }

  /**
   * @return The value of the {@code clazz} attribute
   */
  @Override
  public ATypeName clazz() {
    return clazz;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.TypeReferenceCall#clazz() clazz} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for clazz
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTypeReferenceCall withClazz(ATypeName value) {
    if (this.clazz == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "clazz");
    return new ImmutableTypeReferenceCall(this, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTypeReferenceCall} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTypeReferenceCall
        && equalTo((ImmutableTypeReferenceCall) another);
  }

  private boolean equalTo(ImmutableTypeReferenceCall another) {
    return clazz.equals(another.clazz);
  }

  /**
   * Computes a hash code from attributes: {@code clazz}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + clazz.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code TypeReferenceCall} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("TypeReferenceCall")
        .omitNullValues()
        .add("clazz", clazz)
        .toString();
  }

  /**
   * Construct a new immutable {@code TypeReferenceCall} instance.
   * @param clazz The value for the {@code clazz} attribute
   * @return An immutable TypeReferenceCall instance
   */
  public static ImmutableTypeReferenceCall of(ATypeName clazz) {
    return new ImmutableTypeReferenceCall(clazz);
  }

  /**
   * Creates an immutable copy of a {@link Calls.TypeReferenceCall} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable TypeReferenceCall instance
   */
  public static ImmutableTypeReferenceCall copyOf(Calls.TypeReferenceCall instance) {
    if (instance instanceof ImmutableTypeReferenceCall) {
      return (ImmutableTypeReferenceCall) instance;
    }
    return ImmutableTypeReferenceCall.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableTypeReferenceCall ImmutableTypeReferenceCall}.
   * @return A new ImmutableTypeReferenceCall builder
   */
  public static ImmutableTypeReferenceCall.Builder builder() {
    return new ImmutableTypeReferenceCall.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTypeReferenceCall ImmutableTypeReferenceCall}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLAZZ = 0x1L;
    private long initBits = 0x1L;

    private @Nullable ATypeName clazz;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code TypeReferenceCall} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Calls.TypeReferenceCall instance) {
      Objects.requireNonNull(instance, "instance");
      clazz(instance.clazz());
      return this;
    }

    /**
     * Initializes the value for the {@link Calls.TypeReferenceCall#clazz() clazz} attribute.
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
     * Builds a new {@link ImmutableTypeReferenceCall ImmutableTypeReferenceCall}.
     * @return An immutable instance of TypeReferenceCall
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTypeReferenceCall build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableTypeReferenceCall(null, clazz);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLAZZ) != 0) attributes.add("clazz");
      return "Cannot build TypeReferenceCall, some of required attributes are not set " + attributes;
    }
  }
}
