package de.flapdoodle.unravel.types;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
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
 * Immutable implementation of {@link Calls.FieldCall}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableFieldCall.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableFieldCall.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Calls.FieldCall"})
@Immutable
@CheckReturnValue
public final class ImmutableFieldCall implements Calls.FieldCall {
  private final ATypeName clazz;
  private final String name;
  private final AType type;
  private final boolean staticCall;

  private ImmutableFieldCall(
      ATypeName clazz,
      String name,
      AType type,
      boolean staticCall) {
    this.clazz = Objects.requireNonNull(clazz, "clazz");
    this.name = Objects.requireNonNull(name, "name");
    this.type = Objects.requireNonNull(type, "type");
    this.staticCall = staticCall;
  }

  private ImmutableFieldCall(
      ImmutableFieldCall original,
      ATypeName clazz,
      String name,
      AType type,
      boolean staticCall) {
    this.clazz = clazz;
    this.name = name;
    this.type = type;
    this.staticCall = staticCall;
  }

  /**
   * @return The value of the {@code clazz} attribute
   */
  @Override
  public ATypeName clazz() {
    return clazz;
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
   * Copy the current immutable object by setting a value for the {@link Calls.FieldCall#clazz() clazz} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for clazz
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldCall withClazz(ATypeName value) {
    if (this.clazz == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "clazz");
    return new ImmutableFieldCall(this, newValue, this.name, this.type, this.staticCall);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.FieldCall#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldCall withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableFieldCall(this, this.clazz, newValue, this.type, this.staticCall);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.FieldCall#type() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldCall withType(AType value) {
    if (this.type == value) return this;
    AType newValue = Objects.requireNonNull(value, "type");
    return new ImmutableFieldCall(this, this.clazz, this.name, newValue, this.staticCall);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.FieldCall#staticCall() staticCall} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for staticCall
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldCall withStaticCall(boolean value) {
    if (this.staticCall == value) return this;
    return new ImmutableFieldCall(this, this.clazz, this.name, this.type, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableFieldCall} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableFieldCall
        && equalTo((ImmutableFieldCall) another);
  }

  private boolean equalTo(ImmutableFieldCall another) {
    return clazz.equals(another.clazz)
        && name.equals(another.name)
        && type.equals(another.type)
        && staticCall == another.staticCall;
  }

  /**
   * Computes a hash code from attributes: {@code clazz}, {@code name}, {@code type}, {@code staticCall}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + clazz.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + type.hashCode();
    h += (h << 5) + Booleans.hashCode(staticCall);
    return h;
  }

  /**
   * Prints the immutable value {@code FieldCall} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("FieldCall")
        .omitNullValues()
        .add("clazz", clazz)
        .add("name", name)
        .add("type", type)
        .add("staticCall", staticCall)
        .toString();
  }

  /**
   * Construct a new immutable {@code FieldCall} instance.
   * @param clazz The value for the {@code clazz} attribute
   * @param name The value for the {@code name} attribute
   * @param type The value for the {@code type} attribute
   * @param staticCall The value for the {@code staticCall} attribute
   * @return An immutable FieldCall instance
   */
  public static ImmutableFieldCall of(ATypeName clazz, String name, AType type, boolean staticCall) {
    return new ImmutableFieldCall(clazz, name, type, staticCall);
  }

  /**
   * Creates an immutable copy of a {@link Calls.FieldCall} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable FieldCall instance
   */
  public static ImmutableFieldCall copyOf(Calls.FieldCall instance) {
    if (instance instanceof ImmutableFieldCall) {
      return (ImmutableFieldCall) instance;
    }
    return ImmutableFieldCall.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableFieldCall ImmutableFieldCall}.
   * @return A new ImmutableFieldCall builder
   */
  public static ImmutableFieldCall.Builder builder() {
    return new ImmutableFieldCall.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableFieldCall ImmutableFieldCall}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLAZZ = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_TYPE = 0x4L;
    private static final long INIT_BIT_STATIC_CALL = 0x8L;
    private long initBits = 0xfL;

    private @Nullable ATypeName clazz;
    private @Nullable String name;
    private @Nullable AType type;
    private boolean staticCall;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FieldCall} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Calls.FieldCall instance) {
      Objects.requireNonNull(instance, "instance");
      clazz(instance.clazz());
      name(instance.name());
      type(instance.type());
      staticCall(instance.staticCall());
      return this;
    }

    /**
     * Initializes the value for the {@link Calls.FieldCall#clazz() clazz} attribute.
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
     * Initializes the value for the {@link Calls.FieldCall#name() name} attribute.
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
     * Initializes the value for the {@link Calls.FieldCall#type() type} attribute.
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
     * Initializes the value for the {@link Calls.FieldCall#staticCall() staticCall} attribute.
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
     * Builds a new {@link ImmutableFieldCall ImmutableFieldCall}.
     * @return An immutable instance of FieldCall
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableFieldCall build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableFieldCall(null, clazz, name, type, staticCall);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLAZZ) != 0) attributes.add("clazz");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_STATIC_CALL) != 0) attributes.add("staticCall");
      return "Cannot build FieldCall, some of required attributes are not set " + attributes;
    }
  }
}
