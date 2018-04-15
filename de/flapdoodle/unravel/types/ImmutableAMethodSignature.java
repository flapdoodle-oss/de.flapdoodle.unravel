package de.flapdoodle.unravel.types;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.vavr.collection.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link AMethodSignature}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAMethodSignature.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableAMethodSignature.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AMethodSignature"})
@Immutable
@CheckReturnValue
public final class ImmutableAMethodSignature implements AMethodSignature {
  private final AType returnType;
  private final List<AType> parameters;

  private ImmutableAMethodSignature(
      AType returnType,
      List<AType> parameters) {
    this.returnType = Objects.requireNonNull(returnType, "returnType");
    this.parameters = parameters_from(parameters);
  }

  private ImmutableAMethodSignature(
      ImmutableAMethodSignature original,
      AType returnType,
      List<AType> parameters) {
    this.returnType = returnType;
    this.parameters = parameters;
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
   * Copy the current immutable object by setting a value for the {@link AMethodSignature#returnType() returnType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for returnType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAMethodSignature withReturnType(AType value) {
    if (this.returnType == value) return this;
    AType newValue = Objects.requireNonNull(value, "returnType");
    return new ImmutableAMethodSignature(this, newValue, this.parameters);
  }

  public ImmutableAMethodSignature withParameters(List<AType> value) {
    List<AType> newValue = parameters_from(value);
    if (this.parameters == newValue) return this;
    return new ImmutableAMethodSignature(this, this.returnType, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAMethodSignature} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAMethodSignature
        && equalTo((ImmutableAMethodSignature) another);
  }

  private boolean equalTo(ImmutableAMethodSignature another) {
    return returnType.equals(another.returnType)
        && this.parameters().equals(another.parameters());
  }

  /**
   * Computes a hash code from attributes: {@code returnType}, {@code parameters}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + returnType.hashCode();
    h += (h << 5) + (parameters().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code AMethodSignature} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AMethodSignature")
        .omitNullValues()
        .add("returnType", returnType)
        .add("parameters", parameters().toString())
        .toString();
  }

  /**
   * Construct a new immutable {@code AMethodSignature} instance.
   * @param returnType The value for the {@code returnType} attribute
   * @param parameters The value for the {@code parameters} attribute
   * @return An immutable AMethodSignature instance
   */
  public static ImmutableAMethodSignature of(AType returnType, List<AType> parameters) {
    return new ImmutableAMethodSignature(returnType, parameters);
  }

  /**
   * Creates an immutable copy of a {@link AMethodSignature} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AMethodSignature instance
   */
  public static ImmutableAMethodSignature copyOf(AMethodSignature instance) {
    if (instance instanceof ImmutableAMethodSignature) {
      return (ImmutableAMethodSignature) instance;
    }
    return ImmutableAMethodSignature.builder()
        .from(instance)
        .build();
  }

  private static List<AType> parameters_from(List<AType> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableAMethodSignature ImmutableAMethodSignature}.
   * @return A new ImmutableAMethodSignature builder
   */
  public static ImmutableAMethodSignature.Builder builder() {
    return new ImmutableAMethodSignature.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAMethodSignature ImmutableAMethodSignature}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_RETURN_TYPE = 0x1L;
    private long initBits = 0x1L;

    private List<AType> parameters_list = List.empty();
    private @Nullable AType returnType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AMethodSignature} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AMethodSignature instance) {
      Objects.requireNonNull(instance, "instance");
      returnType(instance.returnType());
      parameters(instance.parameters());
      return this;
    }

    /**
     * Initializes the value for the {@link AMethodSignature#returnType() returnType} attribute.
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
     * Builds a new {@link ImmutableAMethodSignature ImmutableAMethodSignature}.
     * @return An immutable instance of AMethodSignature
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAMethodSignature build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAMethodSignature(null, returnType, this.parameters_list);
    }

    private String formatRequiredAttributesMessage() {
      java.util.List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_RETURN_TYPE) != 0) attributes.add("returnType");
      return "Cannot build AMethodSignature, some of required attributes are not set " + attributes;
    }
  }
}
