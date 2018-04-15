package de.flapdoodle.unravel.types;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.vavr.collection.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link AField}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAField.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AField"})
@Immutable
@CheckReturnValue
public final class ImmutableAField extends AField {
  private final String name;
  private final AType type;
  private final @Nullable String genericSignature;
  private final @Nullable Object value;
  private final List<AnAnnotation> annotations;
  private final int access;

  private ImmutableAField(
      String name,
      AType type,
      @Nullable String genericSignature,
      @Nullable Object value,
      List<AnAnnotation> annotations,
      int access) {
    this.name = name;
    this.type = type;
    this.genericSignature = genericSignature;
    this.value = value;
    this.annotations = annotations;
    this.access = access;
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
   * @return The value of the {@code genericSignature} attribute
   */
  @Override
  public Optional<String> genericSignature() {
    return Optional.ofNullable(genericSignature);
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @Override
  public Optional<Object> value() {
    return Optional.ofNullable(value);
  }

  /**
   * @return The value of the {@code annotations} attribute
   */
  @Override
  public List<AnAnnotation> annotations() {
    return annotations;
  }

  /**
   * @return The value of the {@code access} attribute
   */
  @Override
  protected int access() {
    return access;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AField#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAField withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableAField(newValue, this.type, this.genericSignature, this.value, this.annotations, this.access);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AField#type() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAField withType(AType value) {
    if (this.type == value) return this;
    AType newValue = Objects.requireNonNull(value, "type");
    return new ImmutableAField(this.name, newValue, this.genericSignature, this.value, this.annotations, this.access);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AField#genericSignature() genericSignature} attribute.
   * @param value The value for genericSignature
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAField withGenericSignature(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "genericSignature");
    if (Objects.equals(this.genericSignature, newValue)) return this;
    return new ImmutableAField(this.name, this.type, newValue, this.value, this.annotations, this.access);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AField#genericSignature() genericSignature} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for genericSignature
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAField withGenericSignature(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.genericSignature, value)) return this;
    return new ImmutableAField(this.name, this.type, value, this.value, this.annotations, this.access);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AField#value() value} attribute.
   * @param value The value for value
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAField withValue(Object value) {
    @Nullable Object newValue = Objects.requireNonNull(value, "value");
    if (this.value == newValue) return this;
    return new ImmutableAField(this.name, this.type, this.genericSignature, newValue, this.annotations, this.access);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AField#value() value} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for value
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAField withValue(Optional<? extends Object> optional) {
    @Nullable Object value = optional.orElse(null);
    if (this.value == value) return this;
    return new ImmutableAField(this.name, this.type, this.genericSignature, value, this.annotations, this.access);
  }

  public ImmutableAField withAnnotations(List<AnAnnotation> value) {
    List<AnAnnotation> newValue = annotations_from(value);
    if (this.annotations == newValue) return this;
    return new ImmutableAField(this.name, this.type, this.genericSignature, this.value, newValue, this.access);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AField#access() access} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for access
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAField withAccess(int value) {
    if (this.access == value) return this;
    return new ImmutableAField(this.name, this.type, this.genericSignature, this.value, this.annotations, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAField} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAField
        && equalTo((ImmutableAField) another);
  }

  private boolean equalTo(ImmutableAField another) {
    return name.equals(another.name)
        && type.equals(another.type)
        && Objects.equals(genericSignature, another.genericSignature)
        && Objects.equals(value, another.value)
        && this.annotations().equals(another.annotations())
        && access == another.access;
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code type}, {@code genericSignature}, {@code value}, {@code annotations}, {@code access}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + type.hashCode();
    h += (h << 5) + Objects.hashCode(genericSignature);
    h += (h << 5) + Objects.hashCode(value);
    h += (h << 5) + (annotations().hashCode());
    h += (h << 5) + access;
    return h;
  }

  /**
   * Prints the immutable value {@code AField} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AField")
        .omitNullValues()
        .add("name", name)
        .add("type", type)
        .add("genericSignature", genericSignature)
        .add("value", value)
        .add("annotations", annotations().toString())
        .add("access", access)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link AField} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AField instance
   */
  public static ImmutableAField copyOf(AField instance) {
    if (instance instanceof ImmutableAField) {
      return (ImmutableAField) instance;
    }
    return ImmutableAField.builder()
        .from(instance)
        .build();
  }

  private static List<AnAnnotation> annotations_from(List<AnAnnotation> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableAField ImmutableAField}.
   * @return A new ImmutableAField builder
   */
  public static ImmutableAField.Builder builder() {
    return new ImmutableAField.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAField ImmutableAField}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_TYPE = 0x2L;
    private static final long INIT_BIT_ACCESS = 0x4L;
    private long initBits = 0x7L;

    private List<AnAnnotation> annotations_list = List.empty();
    private @Nullable String name;
    private @Nullable AType type;
    private @Nullable String genericSignature;
    private @Nullable Object value;
    private int access;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AField} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AField instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      type(instance.type());
      Optional<String> genericSignatureOptional = instance.genericSignature();
      if (genericSignatureOptional.isPresent()) {
        genericSignature(genericSignatureOptional);
      }
      Optional<Object> valueOptional = instance.value();
      if (valueOptional.isPresent()) {
        value(valueOptional);
      }
      annotations(instance.annotations());
      access(instance.access());
      return this;
    }

    /**
     * Initializes the value for the {@link AField#name() name} attribute.
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
     * Initializes the value for the {@link AField#type() type} attribute.
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
     * Initializes the optional value {@link AField#genericSignature() genericSignature} to genericSignature.
     * @param genericSignature The value for genericSignature
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder genericSignature(String genericSignature) {
      this.genericSignature = Objects.requireNonNull(genericSignature, "genericSignature");
      return this;
    }

    /**
     * Initializes the optional value {@link AField#genericSignature() genericSignature} to genericSignature.
     * @param genericSignature The value for genericSignature
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder genericSignature(Optional<String> genericSignature) {
      this.genericSignature = genericSignature.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link AField#value() value} to value.
     * @param value The value for value
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder value(Object value) {
      this.value = Objects.requireNonNull(value, "value");
      return this;
    }

    /**
     * Initializes the optional value {@link AField#value() value} to value.
     * @param value The value for value
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder value(Optional<? extends Object> value) {
      this.value = value.orElse(null);
      return this;
    }

    public Builder addAnnotations(AnAnnotation element) {
      this.annotations_list = this.annotations_list.append(element);
      return this;
    }

    public Builder addAllAnnotations(Iterable<AnAnnotation> element) {
      this.annotations_list = this.annotations_list.appendAll(element);
      return this;
    }

    public Builder annotations(List<AnAnnotation> elements) {
      this.annotations_list = elements;
      return this;
    }

    public Builder setIterableAnnotations(Iterable<AnAnnotation> elements) {
      this.annotations_list = List.ofAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link AField#access() access} attribute.
     * @param access The value for access 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder access(int access) {
      this.access = access;
      initBits &= ~INIT_BIT_ACCESS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableAField ImmutableAField}.
     * @return An immutable instance of AField
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAField build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAField(name, type, genericSignature, value, this.annotations_list, access);
    }

    private String formatRequiredAttributesMessage() {
      java.util.List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_ACCESS) != 0) attributes.add("access");
      return "Cannot build AField, some of required attributes are not set " + attributes;
    }
  }
}
