package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.AccessFlags;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link TypeSignature.Method}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableMethod.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "TypeSignature.Method"})
@Immutable
@CheckReturnValue
public final class ImmutableMethod implements TypeSignature.Method {
  private final String name;
  private final Set<AccessFlags> accessFlags;
  private final AType returnType;
  private final List<AType> parameters;

  private ImmutableMethod(
      String name,
      Set<AccessFlags> accessFlags,
      AType returnType,
      List<AType> parameters) {
    this.name = name;
    this.accessFlags = accessFlags;
    this.returnType = returnType;
    this.parameters = parameters;
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
   * Copy the current immutable object by setting a value for the {@link TypeSignature.Method#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMethod withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableMethod(newValue, this.accessFlags, this.returnType, this.parameters);
  }

  public ImmutableMethod withAccessFlags(Set<AccessFlags> value) {
    Set<AccessFlags> newValue = accessFlags_from(value);
    if (this.accessFlags == newValue) return this;
    return new ImmutableMethod(this.name, newValue, this.returnType, this.parameters);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeSignature.Method#returnType() returnType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for returnType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMethod withReturnType(AType value) {
    if (this.returnType == value) return this;
    AType newValue = Objects.requireNonNull(value, "returnType");
    return new ImmutableMethod(this.name, this.accessFlags, newValue, this.parameters);
  }

  public ImmutableMethod withParameters(List<AType> value) {
    List<AType> newValue = parameters_from(value);
    if (this.parameters == newValue) return this;
    return new ImmutableMethod(this.name, this.accessFlags, this.returnType, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableMethod} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableMethod
        && equalTo((ImmutableMethod) another);
  }

  private boolean equalTo(ImmutableMethod another) {
    return name.equals(another.name)
        && this.accessFlags().equals(another.accessFlags())
        && returnType.equals(another.returnType)
        && this.parameters().equals(another.parameters());
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code accessFlags}, {@code returnType}, {@code parameters}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + (accessFlags().hashCode());
    h += (h << 5) + returnType.hashCode();
    h += (h << 5) + (parameters().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code Method} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Method")
        .omitNullValues()
        .add("name", name)
        .add("accessFlags", accessFlags().toString())
        .add("returnType", returnType)
        .add("parameters", parameters().toString())
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link TypeSignature.Method} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Method instance
   */
  public static ImmutableMethod copyOf(TypeSignature.Method instance) {
    if (instance instanceof ImmutableMethod) {
      return (ImmutableMethod) instance;
    }
    return ImmutableMethod.builder()
        .from(instance)
        .build();
  }

  private static Set<AccessFlags> accessFlags_from(Set<AccessFlags> value) {
    return value;
  }

  private static List<AType> parameters_from(List<AType> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableMethod ImmutableMethod}.
   * @return A new ImmutableMethod builder
   */
  public static ImmutableMethod.Builder builder() {
    return new ImmutableMethod.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableMethod ImmutableMethod}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_RETURN_TYPE = 0x2L;
    private long initBits = 0x3L;

    private Set<AccessFlags> accessFlags_set = HashSet.empty();
    private List<AType> parameters_list = List.empty();
    private @Nullable String name;
    private @Nullable AType returnType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Method} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(TypeSignature.Method instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      accessFlags(instance.accessFlags());
      returnType(instance.returnType());
      parameters(instance.parameters());
      return this;
    }

    /**
     * Initializes the value for the {@link TypeSignature.Method#name() name} attribute.
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
     * Initializes the value for the {@link TypeSignature.Method#returnType() returnType} attribute.
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
     * Builds a new {@link ImmutableMethod ImmutableMethod}.
     * @return An immutable instance of Method
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableMethod build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableMethod(name, this.accessFlags_set, returnType, this.parameters_list);
    }

    private String formatRequiredAttributesMessage() {
      java.util.List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_RETURN_TYPE) != 0) attributes.add("returnType");
      return "Cannot build Method, some of required attributes are not set " + attributes;
    }
  }
}
