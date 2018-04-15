package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import de.flapdoodle.unravel.types.AMethodSignature;
import de.flapdoodle.unravel.types.InvocationType;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link Usage.UsedMethod}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUsedMethod.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Usage.UsedMethod"})
@Immutable
@CheckReturnValue
public final class ImmutableUsedMethod implements Usage.UsedMethod {
  private final String name;
  private final AMethodSignature signature;
  private final InvocationType invocationType;

  private ImmutableUsedMethod(
      String name,
      AMethodSignature signature,
      InvocationType invocationType) {
    this.name = name;
    this.signature = signature;
    this.invocationType = invocationType;
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
   * @return The value of the {@code invocationType} attribute
   */
  @Override
  public InvocationType invocationType() {
    return invocationType;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Usage.UsedMethod#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUsedMethod withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableUsedMethod(newValue, this.signature, this.invocationType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Usage.UsedMethod#signature() signature} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for signature
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUsedMethod withSignature(AMethodSignature value) {
    if (this.signature == value) return this;
    AMethodSignature newValue = Objects.requireNonNull(value, "signature");
    return new ImmutableUsedMethod(this.name, newValue, this.invocationType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Usage.UsedMethod#invocationType() invocationType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for invocationType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUsedMethod withInvocationType(InvocationType value) {
    if (this.invocationType == value) return this;
    InvocationType newValue = Objects.requireNonNull(value, "invocationType");
    return new ImmutableUsedMethod(this.name, this.signature, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUsedMethod} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUsedMethod
        && equalTo((ImmutableUsedMethod) another);
  }

  private boolean equalTo(ImmutableUsedMethod another) {
    return name.equals(another.name)
        && signature.equals(another.signature)
        && invocationType.equals(another.invocationType);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code signature}, {@code invocationType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + signature.hashCode();
    h += (h << 5) + invocationType.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UsedMethod} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UsedMethod")
        .omitNullValues()
        .add("name", name)
        .add("signature", signature)
        .add("invocationType", invocationType)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Usage.UsedMethod} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UsedMethod instance
   */
  public static ImmutableUsedMethod copyOf(Usage.UsedMethod instance) {
    if (instance instanceof ImmutableUsedMethod) {
      return (ImmutableUsedMethod) instance;
    }
    return ImmutableUsedMethod.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUsedMethod ImmutableUsedMethod}.
   * @return A new ImmutableUsedMethod builder
   */
  public static ImmutableUsedMethod.Builder builder() {
    return new ImmutableUsedMethod.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUsedMethod ImmutableUsedMethod}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_SIGNATURE = 0x2L;
    private static final long INIT_BIT_INVOCATION_TYPE = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String name;
    private @Nullable AMethodSignature signature;
    private @Nullable InvocationType invocationType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UsedMethod} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Usage.UsedMethod instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      signature(instance.signature());
      invocationType(instance.invocationType());
      return this;
    }

    /**
     * Initializes the value for the {@link Usage.UsedMethod#name() name} attribute.
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
     * Initializes the value for the {@link Usage.UsedMethod#signature() signature} attribute.
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
     * Initializes the value for the {@link Usage.UsedMethod#invocationType() invocationType} attribute.
     * @param invocationType The value for invocationType 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder invocationType(InvocationType invocationType) {
      this.invocationType = Objects.requireNonNull(invocationType, "invocationType");
      initBits &= ~INIT_BIT_INVOCATION_TYPE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUsedMethod ImmutableUsedMethod}.
     * @return An immutable instance of UsedMethod
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUsedMethod build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUsedMethod(name, signature, invocationType);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_SIGNATURE) != 0) attributes.add("signature");
      if ((initBits & INIT_BIT_INVOCATION_TYPE) != 0) attributes.add("invocationType");
      return "Cannot build UsedMethod, some of required attributes are not set " + attributes;
    }
  }
}
