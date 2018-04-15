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
 * Immutable implementation of {@link AMethod}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAMethod.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AMethod"})
@Immutable
@CheckReturnValue
public final class ImmutableAMethod extends AMethod {
  private final int access;
  private final String name;
  private final AType returnType;
  private final List<AType> parameters;
  private final @Nullable String genericSignature;
  private final List<ATypeName> exceptions;
  private final List<AnAnnotation> annotations;
  private final Calls calls;

  private ImmutableAMethod(
      int access,
      String name,
      AType returnType,
      List<AType> parameters,
      @Nullable String genericSignature,
      List<ATypeName> exceptions,
      List<AnAnnotation> annotations,
      Calls calls) {
    this.access = access;
    this.name = name;
    this.returnType = returnType;
    this.parameters = parameters;
    this.genericSignature = genericSignature;
    this.exceptions = exceptions;
    this.annotations = annotations;
    this.calls = calls;
  }

  /**
   * @return The value of the {@code access} attribute
   */
  @Override
  protected int access() {
    return access;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code returnType} attribute
   */
  @Override
  public AType returnType() {
    return returnType;
  }

  /**
   * @return The value of the {@code parameters} attribute
   */
  @Override
  public List<AType> parameters() {
    return parameters;
  }

  /**
   * @return The value of the {@code genericSignature} attribute
   */
  @Override
  public Optional<String> genericSignature() {
    return Optional.ofNullable(genericSignature);
  }

  /**
   * @return The value of the {@code exceptions} attribute
   */
  @Override
  public List<ATypeName> exceptions() {
    return exceptions;
  }

  /**
   * @return The value of the {@code annotations} attribute
   */
  @Override
  public List<AnAnnotation> annotations() {
    return annotations;
  }

  /**
   * @return The value of the {@code calls} attribute
   */
  @Override
  public Calls calls() {
    return calls;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AMethod#access() access} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for access
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAMethod withAccess(int value) {
    if (this.access == value) return this;
    return new ImmutableAMethod(
        value,
        this.name,
        this.returnType,
        this.parameters,
        this.genericSignature,
        this.exceptions,
        this.annotations,
        this.calls);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AMethod#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAMethod withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableAMethod(
        this.access,
        newValue,
        this.returnType,
        this.parameters,
        this.genericSignature,
        this.exceptions,
        this.annotations,
        this.calls);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AMethod#returnType() returnType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for returnType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAMethod withReturnType(AType value) {
    if (this.returnType == value) return this;
    AType newValue = Objects.requireNonNull(value, "returnType");
    return new ImmutableAMethod(
        this.access,
        this.name,
        newValue,
        this.parameters,
        this.genericSignature,
        this.exceptions,
        this.annotations,
        this.calls);
  }

  public ImmutableAMethod withParameters(List<AType> value) {
    List<AType> newValue = parameters_from(value);
    if (this.parameters == newValue) return this;
    return new ImmutableAMethod(
        this.access,
        this.name,
        this.returnType,
        newValue,
        this.genericSignature,
        this.exceptions,
        this.annotations,
        this.calls);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AMethod#genericSignature() genericSignature} attribute.
   * @param value The value for genericSignature
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAMethod withGenericSignature(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "genericSignature");
    if (Objects.equals(this.genericSignature, newValue)) return this;
    return new ImmutableAMethod(
        this.access,
        this.name,
        this.returnType,
        this.parameters,
        newValue,
        this.exceptions,
        this.annotations,
        this.calls);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AMethod#genericSignature() genericSignature} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for genericSignature
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAMethod withGenericSignature(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.genericSignature, value)) return this;
    return new ImmutableAMethod(
        this.access,
        this.name,
        this.returnType,
        this.parameters,
        value,
        this.exceptions,
        this.annotations,
        this.calls);
  }

  public ImmutableAMethod withExceptions(List<ATypeName> value) {
    List<ATypeName> newValue = exceptions_from(value);
    if (this.exceptions == newValue) return this;
    return new ImmutableAMethod(
        this.access,
        this.name,
        this.returnType,
        this.parameters,
        this.genericSignature,
        newValue,
        this.annotations,
        this.calls);
  }

  public ImmutableAMethod withAnnotations(List<AnAnnotation> value) {
    List<AnAnnotation> newValue = annotations_from(value);
    if (this.annotations == newValue) return this;
    return new ImmutableAMethod(
        this.access,
        this.name,
        this.returnType,
        this.parameters,
        this.genericSignature,
        this.exceptions,
        newValue,
        this.calls);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AMethod#calls() calls} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for calls
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAMethod withCalls(Calls value) {
    if (this.calls == value) return this;
    Calls newValue = Objects.requireNonNull(value, "calls");
    return new ImmutableAMethod(
        this.access,
        this.name,
        this.returnType,
        this.parameters,
        this.genericSignature,
        this.exceptions,
        this.annotations,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAMethod} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAMethod
        && equalTo((ImmutableAMethod) another);
  }

  private boolean equalTo(ImmutableAMethod another) {
    return access == another.access
        && name.equals(another.name)
        && returnType.equals(another.returnType)
        && this.parameters().equals(another.parameters())
        && Objects.equals(genericSignature, another.genericSignature)
        && this.exceptions().equals(another.exceptions())
        && this.annotations().equals(another.annotations())
        && calls.equals(another.calls);
  }

  /**
   * Computes a hash code from attributes: {@code access}, {@code name}, {@code returnType}, {@code parameters}, {@code genericSignature}, {@code exceptions}, {@code annotations}, {@code calls}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + access;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + returnType.hashCode();
    h += (h << 5) + (parameters().hashCode());
    h += (h << 5) + Objects.hashCode(genericSignature);
    h += (h << 5) + (exceptions().hashCode());
    h += (h << 5) + (annotations().hashCode());
    h += (h << 5) + calls.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code AMethod} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AMethod")
        .omitNullValues()
        .add("access", access)
        .add("name", name)
        .add("returnType", returnType)
        .add("parameters", parameters().toString())
        .add("genericSignature", genericSignature)
        .add("exceptions", exceptions().toString())
        .add("annotations", annotations().toString())
        .add("calls", calls)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link AMethod} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AMethod instance
   */
  public static ImmutableAMethod copyOf(AMethod instance) {
    if (instance instanceof ImmutableAMethod) {
      return (ImmutableAMethod) instance;
    }
    return ImmutableAMethod.builder()
        .from(instance)
        .build();
  }

  private static List<AType> parameters_from(List<AType> value) {
    return value;
  }

  private static List<ATypeName> exceptions_from(List<ATypeName> value) {
    return value;
  }

  private static List<AnAnnotation> annotations_from(List<AnAnnotation> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableAMethod ImmutableAMethod}.
   * @return A new ImmutableAMethod builder
   */
  public static ImmutableAMethod.Builder builder() {
    return new ImmutableAMethod.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAMethod ImmutableAMethod}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ACCESS = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_RETURN_TYPE = 0x4L;
    private static final long INIT_BIT_CALLS = 0x8L;
    private long initBits = 0xfL;

    private List<AType> parameters_list = List.empty();
    private List<ATypeName> exceptions_list = List.empty();
    private List<AnAnnotation> annotations_list = List.empty();
    private int access;
    private @Nullable String name;
    private @Nullable AType returnType;
    private @Nullable String genericSignature;
    private @Nullable Calls calls;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AMethod} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AMethod instance) {
      Objects.requireNonNull(instance, "instance");
      access(instance.access());
      name(instance.name());
      returnType(instance.returnType());
      parameters(instance.parameters());
      Optional<String> genericSignatureOptional = instance.genericSignature();
      if (genericSignatureOptional.isPresent()) {
        genericSignature(genericSignatureOptional);
      }
      exceptions(instance.exceptions());
      annotations(instance.annotations());
      calls(instance.calls());
      return this;
    }

    /**
     * Initializes the value for the {@link AMethod#access() access} attribute.
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
     * Initializes the value for the {@link AMethod#name() name} attribute.
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
     * Initializes the value for the {@link AMethod#returnType() returnType} attribute.
     * @param returnType The value for returnType 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder returnType(AType returnType) {
      this.returnType = Objects.requireNonNull(returnType, "returnType");
      initBits &= ~INIT_BIT_RETURN_TYPE;
      return this;
    }

    public Builder addParameters(AType element) {
      this.parameters_list = this.parameters_list.append(element);
      return this;
    }

    public Builder addAllParameters(Iterable<AType> element) {
      this.parameters_list = this.parameters_list.appendAll(element);
      return this;
    }

    public Builder parameters(List<AType> elements) {
      this.parameters_list = elements;
      return this;
    }

    public Builder setIterableParameters(Iterable<AType> elements) {
      this.parameters_list = List.ofAll(elements);
      return this;
    }

    /**
     * Initializes the optional value {@link AMethod#genericSignature() genericSignature} to genericSignature.
     * @param genericSignature The value for genericSignature
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder genericSignature(String genericSignature) {
      this.genericSignature = Objects.requireNonNull(genericSignature, "genericSignature");
      return this;
    }

    /**
     * Initializes the optional value {@link AMethod#genericSignature() genericSignature} to genericSignature.
     * @param genericSignature The value for genericSignature
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder genericSignature(Optional<String> genericSignature) {
      this.genericSignature = genericSignature.orElse(null);
      return this;
    }

    public Builder addExceptions(ATypeName element) {
      this.exceptions_list = this.exceptions_list.append(element);
      return this;
    }

    public Builder addAllExceptions(Iterable<ATypeName> element) {
      this.exceptions_list = this.exceptions_list.appendAll(element);
      return this;
    }

    public Builder exceptions(List<ATypeName> elements) {
      this.exceptions_list = elements;
      return this;
    }

    public Builder setIterableExceptions(Iterable<ATypeName> elements) {
      this.exceptions_list = List.ofAll(elements);
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
     * Initializes the value for the {@link AMethod#calls() calls} attribute.
     * @param calls The value for calls 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder calls(Calls calls) {
      this.calls = Objects.requireNonNull(calls, "calls");
      initBits &= ~INIT_BIT_CALLS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableAMethod ImmutableAMethod}.
     * @return An immutable instance of AMethod
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAMethod build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAMethod(
          access,
          name,
          returnType,
          this.parameters_list,
          genericSignature,
          this.exceptions_list,
          this.annotations_list,
          calls);
    }

    private String formatRequiredAttributesMessage() {
      java.util.List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ACCESS) != 0) attributes.add("access");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_RETURN_TYPE) != 0) attributes.add("returnType");
      if ((initBits & INIT_BIT_CALLS) != 0) attributes.add("calls");
      return "Cannot build AMethod, some of required attributes are not set " + attributes;
    }
  }
}
