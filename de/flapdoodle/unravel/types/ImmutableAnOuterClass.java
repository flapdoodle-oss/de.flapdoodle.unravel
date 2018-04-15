package de.flapdoodle.unravel.types;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link AnOuterClass}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAnOuterClass.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AnOuterClass"})
@Immutable
@CheckReturnValue
public final class ImmutableAnOuterClass extends AnOuterClass {
  private final ATypeName typeName;
  private final @Nullable String methodName;
  private final @Nullable AMethodSignature methodSignature;

  private ImmutableAnOuterClass(
      ATypeName typeName,
      @Nullable String methodName,
      @Nullable AMethodSignature methodSignature) {
    this.typeName = typeName;
    this.methodName = methodName;
    this.methodSignature = methodSignature;
  }

  /**
   * @return The value of the {@code typeName} attribute
   */
  @Override
  public ATypeName typeName() {
    return typeName;
  }

  /**
   * @return The value of the {@code methodName} attribute
   */
  @Override
  public Optional<String> methodName() {
    return Optional.ofNullable(methodName);
  }

  /**
   * @return The value of the {@code methodSignature} attribute
   */
  @Override
  public Optional<AMethodSignature> methodSignature() {
    return Optional.ofNullable(methodSignature);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AnOuterClass#typeName() typeName} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for typeName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAnOuterClass withTypeName(ATypeName value) {
    if (this.typeName == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "typeName");
    return new ImmutableAnOuterClass(newValue, this.methodName, this.methodSignature);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AnOuterClass#methodName() methodName} attribute.
   * @param value The value for methodName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAnOuterClass withMethodName(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "methodName");
    if (Objects.equals(this.methodName, newValue)) return this;
    return new ImmutableAnOuterClass(this.typeName, newValue, this.methodSignature);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AnOuterClass#methodName() methodName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for methodName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAnOuterClass withMethodName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.methodName, value)) return this;
    return new ImmutableAnOuterClass(this.typeName, value, this.methodSignature);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AnOuterClass#methodSignature() methodSignature} attribute.
   * @param value The value for methodSignature
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAnOuterClass withMethodSignature(AMethodSignature value) {
    @Nullable AMethodSignature newValue = Objects.requireNonNull(value, "methodSignature");
    if (this.methodSignature == newValue) return this;
    return new ImmutableAnOuterClass(this.typeName, this.methodName, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AnOuterClass#methodSignature() methodSignature} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for methodSignature
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAnOuterClass withMethodSignature(Optional<? extends AMethodSignature> optional) {
    @Nullable AMethodSignature value = optional.orElse(null);
    if (this.methodSignature == value) return this;
    return new ImmutableAnOuterClass(this.typeName, this.methodName, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAnOuterClass} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAnOuterClass
        && equalTo((ImmutableAnOuterClass) another);
  }

  private boolean equalTo(ImmutableAnOuterClass another) {
    return typeName.equals(another.typeName)
        && Objects.equals(methodName, another.methodName)
        && Objects.equals(methodSignature, another.methodSignature);
  }

  /**
   * Computes a hash code from attributes: {@code typeName}, {@code methodName}, {@code methodSignature}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + typeName.hashCode();
    h += (h << 5) + Objects.hashCode(methodName);
    h += (h << 5) + Objects.hashCode(methodSignature);
    return h;
  }

  /**
   * Prints the immutable value {@code AnOuterClass} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AnOuterClass")
        .omitNullValues()
        .add("typeName", typeName)
        .add("methodName", methodName)
        .add("methodSignature", methodSignature)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link AnOuterClass} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AnOuterClass instance
   */
  public static ImmutableAnOuterClass copyOf(AnOuterClass instance) {
    if (instance instanceof ImmutableAnOuterClass) {
      return (ImmutableAnOuterClass) instance;
    }
    return ImmutableAnOuterClass.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAnOuterClass ImmutableAnOuterClass}.
   * @param typeName {@code typeName} parameter
   * @return A new ImmutableAnOuterClass builder
   */
  public static ImmutableAnOuterClass.Builder builder(ATypeName typeName) {
    return new ImmutableAnOuterClass.Builder(typeName);
  }

  static ImmutableAnOuterClass.Builder builder() {
    return new ImmutableAnOuterClass.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAnOuterClass ImmutableAnOuterClass}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TYPE_NAME = 0x1L;
    private long initBits = 0x1L;

    private @Nullable ATypeName typeName;
    private @Nullable String methodName;
    private @Nullable AMethodSignature methodSignature;

    private Builder(ATypeName typeName) {
      typeName(typeName);
    }

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AnOuterClass} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AnOuterClass instance) {
      Objects.requireNonNull(instance, "instance");
      typeName(instance.typeName());
      Optional<String> methodNameOptional = instance.methodName();
      if (methodNameOptional.isPresent()) {
        methodName(methodNameOptional);
      }
      Optional<AMethodSignature> methodSignatureOptional = instance.methodSignature();
      if (methodSignatureOptional.isPresent()) {
        methodSignature(methodSignatureOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link AnOuterClass#typeName() typeName} attribute.
     * @param typeName The value for typeName 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    final Builder typeName(ATypeName typeName) {
      this.typeName = Objects.requireNonNull(typeName, "typeName");
      initBits &= ~INIT_BIT_TYPE_NAME;
      return this;
    }

    /**
     * Initializes the optional value {@link AnOuterClass#methodName() methodName} to methodName.
     * @param methodName The value for methodName
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder methodName(String methodName) {
      this.methodName = Objects.requireNonNull(methodName, "methodName");
      return this;
    }

    /**
     * Initializes the optional value {@link AnOuterClass#methodName() methodName} to methodName.
     * @param methodName The value for methodName
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder methodName(Optional<String> methodName) {
      this.methodName = methodName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link AnOuterClass#methodSignature() methodSignature} to methodSignature.
     * @param methodSignature The value for methodSignature
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder methodSignature(AMethodSignature methodSignature) {
      this.methodSignature = Objects.requireNonNull(methodSignature, "methodSignature");
      return this;
    }

    /**
     * Initializes the optional value {@link AnOuterClass#methodSignature() methodSignature} to methodSignature.
     * @param methodSignature The value for methodSignature
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder methodSignature(Optional<? extends AMethodSignature> methodSignature) {
      this.methodSignature = methodSignature.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableAnOuterClass ImmutableAnOuterClass}.
     * @return An immutable instance of AnOuterClass
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAnOuterClass build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAnOuterClass(typeName, methodName, methodSignature);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TYPE_NAME) != 0) attributes.add("typeName");
      return "Cannot build AnOuterClass, some of required attributes are not set " + attributes;
    }
  }
}
