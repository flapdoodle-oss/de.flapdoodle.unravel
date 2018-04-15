package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import de.flapdoodle.unravel.types.AType;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link Usage.UsedField}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUsedField.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Usage.UsedField"})
@Immutable
@CheckReturnValue
public final class ImmutableUsedField implements Usage.UsedField {
  private final String name;
  private final AType type;
  private final boolean staticCall;

  private ImmutableUsedField(String name, AType type, boolean staticCall) {
    this.name = name;
    this.type = type;
    this.staticCall = staticCall;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @Override
  public AType type() {
    return type;
  }

  /**
   * @return The value of the {@code staticCall} attribute
   */
  @Override
  public boolean staticCall() {
    return staticCall;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Usage.UsedField#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUsedField withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableUsedField(newValue, this.type, this.staticCall);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Usage.UsedField#type() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUsedField withType(AType value) {
    if (this.type == value) return this;
    AType newValue = Objects.requireNonNull(value, "type");
    return new ImmutableUsedField(this.name, newValue, this.staticCall);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Usage.UsedField#staticCall() staticCall} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for staticCall
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUsedField withStaticCall(boolean value) {
    if (this.staticCall == value) return this;
    return new ImmutableUsedField(this.name, this.type, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUsedField} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUsedField
        && equalTo((ImmutableUsedField) another);
  }

  private boolean equalTo(ImmutableUsedField another) {
    return name.equals(another.name)
        && type.equals(another.type)
        && staticCall == another.staticCall;
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code type}, {@code staticCall}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + type.hashCode();
    h += (h << 5) + Booleans.hashCode(staticCall);
    return h;
  }

  /**
   * Prints the immutable value {@code UsedField} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UsedField")
        .omitNullValues()
        .add("name", name)
        .add("type", type)
        .add("staticCall", staticCall)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Usage.UsedField} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UsedField instance
   */
  public static ImmutableUsedField copyOf(Usage.UsedField instance) {
    if (instance instanceof ImmutableUsedField) {
      return (ImmutableUsedField) instance;
    }
    return ImmutableUsedField.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUsedField ImmutableUsedField}.
   * @return A new ImmutableUsedField builder
   */
  public static ImmutableUsedField.Builder builder() {
    return new ImmutableUsedField.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUsedField ImmutableUsedField}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_TYPE = 0x2L;
    private static final long INIT_BIT_STATIC_CALL = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String name;
    private @Nullable AType type;
    private boolean staticCall;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UsedField} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Usage.UsedField instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      type(instance.type());
      staticCall(instance.staticCall());
      return this;
    }

    /**
     * Initializes the value for the {@link Usage.UsedField#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link Usage.UsedField#type() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder type(AType type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link Usage.UsedField#staticCall() staticCall} attribute.
     * @param staticCall The value for staticCall 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder staticCall(boolean staticCall) {
      this.staticCall = staticCall;
      initBits &= ~INIT_BIT_STATIC_CALL;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUsedField ImmutableUsedField}.
     * @return An immutable instance of UsedField
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUsedField build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUsedField(name, type, staticCall);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_STATIC_CALL) != 0) attributes.add("staticCall");
      return "Cannot build UsedField, some of required attributes are not set " + attributes;
    }
  }
}
