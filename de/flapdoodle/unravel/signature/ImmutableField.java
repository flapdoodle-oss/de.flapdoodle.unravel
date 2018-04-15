package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.AccessFlags;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link TypeSignature.Field}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableField.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "TypeSignature.Field"})
@Immutable
@CheckReturnValue
public final class ImmutableField implements TypeSignature.Field {
  private final String name;
  private final Set<AccessFlags> accessFlags;
  private final AType type;

  private ImmutableField(
      String name,
      Set<AccessFlags> accessFlags,
      AType type) {
    this.name = name;
    this.accessFlags = accessFlags;
    this.type = type;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code accessFlags} attribute
   */
  @Override
  public Set<AccessFlags> accessFlags() {
    return accessFlags;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @Override
  public AType type() {
    return type;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeSignature.Field#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableField withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableField(newValue, this.accessFlags, this.type);
  }

  public ImmutableField withAccessFlags(Set<AccessFlags> value) {
    Set<AccessFlags> newValue = accessFlags_from(value);
    if (this.accessFlags == newValue) return this;
    return new ImmutableField(this.name, newValue, this.type);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeSignature.Field#type() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableField withType(AType value) {
    if (this.type == value) return this;
    AType newValue = Objects.requireNonNull(value, "type");
    return new ImmutableField(this.name, this.accessFlags, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableField} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableField
        && equalTo((ImmutableField) another);
  }

  private boolean equalTo(ImmutableField another) {
    return name.equals(another.name)
        && this.accessFlags().equals(another.accessFlags())
        && type.equals(another.type);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code accessFlags}, {@code type}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + (accessFlags().hashCode());
    h += (h << 5) + type.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Field} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Field")
        .omitNullValues()
        .add("name", name)
        .add("accessFlags", accessFlags().toString())
        .add("type", type)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link TypeSignature.Field} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Field instance
   */
  public static ImmutableField copyOf(TypeSignature.Field instance) {
    if (instance instanceof ImmutableField) {
      return (ImmutableField) instance;
    }
    return ImmutableField.builder()
        .from(instance)
        .build();
  }

  private static Set<AccessFlags> accessFlags_from(Set<AccessFlags> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableField ImmutableField}.
   * @return A new ImmutableField builder
   */
  public static ImmutableField.Builder builder() {
    return new ImmutableField.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableField ImmutableField}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_TYPE = 0x2L;
    private long initBits = 0x3L;

    private Set<AccessFlags> accessFlags_set = HashSet.empty();
    private @Nullable String name;
    private @Nullable AType type;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Field} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(TypeSignature.Field instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      accessFlags(instance.accessFlags());
      type(instance.type());
      return this;
    }

    /**
     * Initializes the value for the {@link TypeSignature.Field#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    public Builder addAccessFlags(AccessFlags element) {
      this.accessFlags_set = this.accessFlags_set.add(element);
      return this;
    }

    public Builder addAllAccessFlags(Iterable<AccessFlags> element) {
      this.accessFlags_set = this.accessFlags_set.addAll(element);
      return this;
    }

    public Builder accessFlags(Set<AccessFlags> elements) {
      this.accessFlags_set = elements;
      return this;
    }

    public Builder setIterableAccessFlags(Iterable<AccessFlags> elements) {
      this.accessFlags_set = HashSet.ofAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link TypeSignature.Field#type() type} attribute.
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
     * Builds a new {@link ImmutableField ImmutableField}.
     * @return An immutable instance of Field
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableField build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableField(name, this.accessFlags_set, type);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      return "Cannot build Field, some of required attributes are not set " + attributes;
    }
  }
}
