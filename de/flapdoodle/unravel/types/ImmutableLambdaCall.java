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
 * Immutable implementation of {@link Calls.LambdaCall}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableLambdaCall.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Calls.LambdaCall"})
@Immutable
@CheckReturnValue
public final class ImmutableLambdaCall implements Calls.LambdaCall {
  private final ATypeName clazz;
  private final String name;
  private final AMethodSignature signature;
  private final AMethodSignature methodAsLambdaSignature;
  private final ATypeName factoryClazz;
  private final AMethodSignature factorySignature;
  private final Calls.MethodCall delegate;

  private ImmutableLambdaCall(
      ATypeName clazz,
      String name,
      AMethodSignature signature,
      AMethodSignature methodAsLambdaSignature,
      ATypeName factoryClazz,
      AMethodSignature factorySignature,
      Calls.MethodCall delegate) {
    this.clazz = clazz;
    this.name = name;
    this.signature = signature;
    this.methodAsLambdaSignature = methodAsLambdaSignature;
    this.factoryClazz = factoryClazz;
    this.factorySignature = factorySignature;
    this.delegate = delegate;
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
   * @return The value of the {@code signature} attribute
   */
  @Override
  public AMethodSignature signature() {
    return signature;
  }

  /**
   * @return The value of the {@code methodAsLambdaSignature} attribute
   */
  @Override
  public AMethodSignature methodAsLambdaSignature() {
    return methodAsLambdaSignature;
  }

  /**
   * @return The value of the {@code factoryClazz} attribute
   */
  @Override
  public ATypeName factoryClazz() {
    return factoryClazz;
  }

  /**
   * @return The value of the {@code factorySignature} attribute
   */
  @Override
  public AMethodSignature factorySignature() {
    return factorySignature;
  }

  /**
   * @return The value of the {@code delegate} attribute
   */
  @Override
  public Calls.MethodCall delegate() {
    return delegate;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.LambdaCall#clazz() clazz} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for clazz
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLambdaCall withClazz(ATypeName value) {
    if (this.clazz == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "clazz");
    return new ImmutableLambdaCall(
        newValue,
        this.name,
        this.signature,
        this.methodAsLambdaSignature,
        this.factoryClazz,
        this.factorySignature,
        this.delegate);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.LambdaCall#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLambdaCall withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableLambdaCall(
        this.clazz,
        newValue,
        this.signature,
        this.methodAsLambdaSignature,
        this.factoryClazz,
        this.factorySignature,
        this.delegate);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.LambdaCall#signature() signature} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for signature
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLambdaCall withSignature(AMethodSignature value) {
    if (this.signature == value) return this;
    AMethodSignature newValue = Objects.requireNonNull(value, "signature");
    return new ImmutableLambdaCall(
        this.clazz,
        this.name,
        newValue,
        this.methodAsLambdaSignature,
        this.factoryClazz,
        this.factorySignature,
        this.delegate);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.LambdaCall#methodAsLambdaSignature() methodAsLambdaSignature} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for methodAsLambdaSignature
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLambdaCall withMethodAsLambdaSignature(AMethodSignature value) {
    if (this.methodAsLambdaSignature == value) return this;
    AMethodSignature newValue = Objects.requireNonNull(value, "methodAsLambdaSignature");
    return new ImmutableLambdaCall(
        this.clazz,
        this.name,
        this.signature,
        newValue,
        this.factoryClazz,
        this.factorySignature,
        this.delegate);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.LambdaCall#factoryClazz() factoryClazz} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for factoryClazz
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLambdaCall withFactoryClazz(ATypeName value) {
    if (this.factoryClazz == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "factoryClazz");
    return new ImmutableLambdaCall(
        this.clazz,
        this.name,
        this.signature,
        this.methodAsLambdaSignature,
        newValue,
        this.factorySignature,
        this.delegate);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.LambdaCall#factorySignature() factorySignature} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for factorySignature
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLambdaCall withFactorySignature(AMethodSignature value) {
    if (this.factorySignature == value) return this;
    AMethodSignature newValue = Objects.requireNonNull(value, "factorySignature");
    return new ImmutableLambdaCall(
        this.clazz,
        this.name,
        this.signature,
        this.methodAsLambdaSignature,
        this.factoryClazz,
        newValue,
        this.delegate);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Calls.LambdaCall#delegate() delegate} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for delegate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLambdaCall withDelegate(Calls.MethodCall value) {
    if (this.delegate == value) return this;
    Calls.MethodCall newValue = Objects.requireNonNull(value, "delegate");
    return new ImmutableLambdaCall(
        this.clazz,
        this.name,
        this.signature,
        this.methodAsLambdaSignature,
        this.factoryClazz,
        this.factorySignature,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableLambdaCall} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableLambdaCall
        && equalTo((ImmutableLambdaCall) another);
  }

  private boolean equalTo(ImmutableLambdaCall another) {
    return clazz.equals(another.clazz)
        && name.equals(another.name)
        && signature.equals(another.signature)
        && methodAsLambdaSignature.equals(another.methodAsLambdaSignature)
        && factoryClazz.equals(another.factoryClazz)
        && factorySignature.equals(another.factorySignature)
        && delegate.equals(another.delegate);
  }

  /**
   * Computes a hash code from attributes: {@code clazz}, {@code name}, {@code signature}, {@code methodAsLambdaSignature}, {@code factoryClazz}, {@code factorySignature}, {@code delegate}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + clazz.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + signature.hashCode();
    h += (h << 5) + methodAsLambdaSignature.hashCode();
    h += (h << 5) + factoryClazz.hashCode();
    h += (h << 5) + factorySignature.hashCode();
    h += (h << 5) + delegate.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code LambdaCall} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("LambdaCall")
        .omitNullValues()
        .add("clazz", clazz)
        .add("name", name)
        .add("signature", signature)
        .add("methodAsLambdaSignature", methodAsLambdaSignature)
        .add("factoryClazz", factoryClazz)
        .add("factorySignature", factorySignature)
        .add("delegate", delegate)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Calls.LambdaCall} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable LambdaCall instance
   */
  public static ImmutableLambdaCall copyOf(Calls.LambdaCall instance) {
    if (instance instanceof ImmutableLambdaCall) {
      return (ImmutableLambdaCall) instance;
    }
    return ImmutableLambdaCall.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableLambdaCall ImmutableLambdaCall}.
   * @return A new ImmutableLambdaCall builder
   */
  public static ImmutableLambdaCall.Builder builder() {
    return new ImmutableLambdaCall.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableLambdaCall ImmutableLambdaCall}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLAZZ = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_SIGNATURE = 0x4L;
    private static final long INIT_BIT_METHOD_AS_LAMBDA_SIGNATURE = 0x8L;
    private static final long INIT_BIT_FACTORY_CLAZZ = 0x10L;
    private static final long INIT_BIT_FACTORY_SIGNATURE = 0x20L;
    private static final long INIT_BIT_DELEGATE = 0x40L;
    private long initBits = 0x7fL;

    private @Nullable ATypeName clazz;
    private @Nullable String name;
    private @Nullable AMethodSignature signature;
    private @Nullable AMethodSignature methodAsLambdaSignature;
    private @Nullable ATypeName factoryClazz;
    private @Nullable AMethodSignature factorySignature;
    private @Nullable Calls.MethodCall delegate;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code LambdaCall} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Calls.LambdaCall instance) {
      Objects.requireNonNull(instance, "instance");
      clazz(instance.clazz());
      name(instance.name());
      signature(instance.signature());
      methodAsLambdaSignature(instance.methodAsLambdaSignature());
      factoryClazz(instance.factoryClazz());
      factorySignature(instance.factorySignature());
      delegate(instance.delegate());
      return this;
    }

    /**
     * Initializes the value for the {@link Calls.LambdaCall#clazz() clazz} attribute.
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
     * Initializes the value for the {@link Calls.LambdaCall#name() name} attribute.
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
     * Initializes the value for the {@link Calls.LambdaCall#signature() signature} attribute.
     * @param signature The value for signature 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder signature(AMethodSignature signature) {
      this.signature = Objects.requireNonNull(signature, "signature");
      initBits &= ~INIT_BIT_SIGNATURE;
      return this;
    }

    /**
     * Initializes the value for the {@link Calls.LambdaCall#methodAsLambdaSignature() methodAsLambdaSignature} attribute.
     * @param methodAsLambdaSignature The value for methodAsLambdaSignature 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder methodAsLambdaSignature(AMethodSignature methodAsLambdaSignature) {
      this.methodAsLambdaSignature = Objects.requireNonNull(methodAsLambdaSignature, "methodAsLambdaSignature");
      initBits &= ~INIT_BIT_METHOD_AS_LAMBDA_SIGNATURE;
      return this;
    }

    /**
     * Initializes the value for the {@link Calls.LambdaCall#factoryClazz() factoryClazz} attribute.
     * @param factoryClazz The value for factoryClazz 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder factoryClazz(ATypeName factoryClazz) {
      this.factoryClazz = Objects.requireNonNull(factoryClazz, "factoryClazz");
      initBits &= ~INIT_BIT_FACTORY_CLAZZ;
      return this;
    }

    /**
     * Initializes the value for the {@link Calls.LambdaCall#factorySignature() factorySignature} attribute.
     * @param factorySignature The value for factorySignature 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder factorySignature(AMethodSignature factorySignature) {
      this.factorySignature = Objects.requireNonNull(factorySignature, "factorySignature");
      initBits &= ~INIT_BIT_FACTORY_SIGNATURE;
      return this;
    }

    /**
     * Initializes the value for the {@link Calls.LambdaCall#delegate() delegate} attribute.
     * @param delegate The value for delegate 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder delegate(Calls.MethodCall delegate) {
      this.delegate = Objects.requireNonNull(delegate, "delegate");
      initBits &= ~INIT_BIT_DELEGATE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableLambdaCall ImmutableLambdaCall}.
     * @return An immutable instance of LambdaCall
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableLambdaCall build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableLambdaCall(clazz, name, signature, methodAsLambdaSignature, factoryClazz, factorySignature, delegate);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLAZZ) != 0) attributes.add("clazz");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_SIGNATURE) != 0) attributes.add("signature");
      if ((initBits & INIT_BIT_METHOD_AS_LAMBDA_SIGNATURE) != 0) attributes.add("methodAsLambdaSignature");
      if ((initBits & INIT_BIT_FACTORY_CLAZZ) != 0) attributes.add("factoryClazz");
      if ((initBits & INIT_BIT_FACTORY_SIGNATURE) != 0) attributes.add("factorySignature");
      if ((initBits & INIT_BIT_DELEGATE) != 0) attributes.add("delegate");
      return "Cannot build LambdaCall, some of required attributes are not set " + attributes;
    }
  }
}
