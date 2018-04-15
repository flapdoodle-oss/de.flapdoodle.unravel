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
 * Immutable implementation of {@link AnInnerClass}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAnInnerClass.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AnInnerClass"})
@Immutable
@CheckReturnValue
public final class ImmutableAnInnerClass extends AnInnerClass {
  private final int access;
  private final ATypeName typeName;
  private final @Nullable ATypeName innerName;
  private final @Nullable ATypeName outerName;

  private ImmutableAnInnerClass(
      int access,
      ATypeName typeName,
      @Nullable ATypeName innerName,
      @Nullable ATypeName outerName) {
    this.access = access;
    this.typeName = typeName;
    this.innerName = innerName;
    this.outerName = outerName;
  }

  /**
   * @return The value of the {@code access} attribute
   */
  @Override
  protected int access() {
    return access;
  }

  /**
   * @return The value of the {@code typeName} attribute
   */
  @Override
  public ATypeName typeName() {
    return typeName;
  }

  /**
   * @return The value of the {@code innerName} attribute
   */
  @Override
  public Optional<ATypeName> innerName() {
    return Optional.ofNullable(innerName);
  }

  /**
   * @return The value of the {@code outerName} attribute
   */
  @Override
  public Optional<ATypeName> outerName() {
    return Optional.ofNullable(outerName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AnInnerClass#access() access} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for access
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAnInnerClass withAccess(int value) {
    if (this.access == value) return this;
    return new ImmutableAnInnerClass(value, this.typeName, this.innerName, this.outerName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AnInnerClass#typeName() typeName} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for typeName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAnInnerClass withTypeName(ATypeName value) {
    if (this.typeName == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "typeName");
    return new ImmutableAnInnerClass(this.access, newValue, this.innerName, this.outerName);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AnInnerClass#innerName() innerName} attribute.
   * @param value The value for innerName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAnInnerClass withInnerName(ATypeName value) {
    @Nullable ATypeName newValue = Objects.requireNonNull(value, "innerName");
    if (this.innerName == newValue) return this;
    return new ImmutableAnInnerClass(this.access, this.typeName, newValue, this.outerName);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AnInnerClass#innerName() innerName} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for innerName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAnInnerClass withInnerName(Optional<? extends ATypeName> optional) {
    @Nullable ATypeName value = optional.orElse(null);
    if (this.innerName == value) return this;
    return new ImmutableAnInnerClass(this.access, this.typeName, value, this.outerName);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AnInnerClass#outerName() outerName} attribute.
   * @param value The value for outerName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAnInnerClass withOuterName(ATypeName value) {
    @Nullable ATypeName newValue = Objects.requireNonNull(value, "outerName");
    if (this.outerName == newValue) return this;
    return new ImmutableAnInnerClass(this.access, this.typeName, this.innerName, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AnInnerClass#outerName() outerName} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for outerName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAnInnerClass withOuterName(Optional<? extends ATypeName> optional) {
    @Nullable ATypeName value = optional.orElse(null);
    if (this.outerName == value) return this;
    return new ImmutableAnInnerClass(this.access, this.typeName, this.innerName, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAnInnerClass} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAnInnerClass
        && equalTo((ImmutableAnInnerClass) another);
  }

  private boolean equalTo(ImmutableAnInnerClass another) {
    return access == another.access
        && typeName.equals(another.typeName)
        && Objects.equals(innerName, another.innerName)
        && Objects.equals(outerName, another.outerName);
  }

  /**
   * Computes a hash code from attributes: {@code access}, {@code typeName}, {@code innerName}, {@code outerName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + access;
    h += (h << 5) + typeName.hashCode();
    h += (h << 5) + Objects.hashCode(innerName);
    h += (h << 5) + Objects.hashCode(outerName);
    return h;
  }

  /**
   * Prints the immutable value {@code AnInnerClass} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AnInnerClass")
        .omitNullValues()
        .add("access", access)
        .add("typeName", typeName)
        .add("innerName", innerName)
        .add("outerName", outerName)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link AnInnerClass} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AnInnerClass instance
   */
  public static ImmutableAnInnerClass copyOf(AnInnerClass instance) {
    if (instance instanceof ImmutableAnInnerClass) {
      return (ImmutableAnInnerClass) instance;
    }
    return ImmutableAnInnerClass.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAnInnerClass ImmutableAnInnerClass}.
   * @return A new ImmutableAnInnerClass builder
   */
  public static ImmutableAnInnerClass.Builder builder() {
    return new ImmutableAnInnerClass.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAnInnerClass ImmutableAnInnerClass}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ACCESS = 0x1L;
    private static final long INIT_BIT_TYPE_NAME = 0x2L;
    private long initBits = 0x3L;

    private int access;
    private @Nullable ATypeName typeName;
    private @Nullable ATypeName innerName;
    private @Nullable ATypeName outerName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AnInnerClass} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AnInnerClass instance) {
      Objects.requireNonNull(instance, "instance");
      access(instance.access());
      typeName(instance.typeName());
      Optional<ATypeName> innerNameOptional = instance.innerName();
      if (innerNameOptional.isPresent()) {
        innerName(innerNameOptional);
      }
      Optional<ATypeName> outerNameOptional = instance.outerName();
      if (outerNameOptional.isPresent()) {
        outerName(outerNameOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link AnInnerClass#access() access} attribute.
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
     * Initializes the value for the {@link AnInnerClass#typeName() typeName} attribute.
     * @param typeName The value for typeName 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder typeName(ATypeName typeName) {
      this.typeName = Objects.requireNonNull(typeName, "typeName");
      initBits &= ~INIT_BIT_TYPE_NAME;
      return this;
    }

    /**
     * Initializes the optional value {@link AnInnerClass#innerName() innerName} to innerName.
     * @param innerName The value for innerName
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder innerName(ATypeName innerName) {
      this.innerName = Objects.requireNonNull(innerName, "innerName");
      return this;
    }

    /**
     * Initializes the optional value {@link AnInnerClass#innerName() innerName} to innerName.
     * @param innerName The value for innerName
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder innerName(Optional<? extends ATypeName> innerName) {
      this.innerName = innerName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link AnInnerClass#outerName() outerName} to outerName.
     * @param outerName The value for outerName
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder outerName(ATypeName outerName) {
      this.outerName = Objects.requireNonNull(outerName, "outerName");
      return this;
    }

    /**
     * Initializes the optional value {@link AnInnerClass#outerName() outerName} to outerName.
     * @param outerName The value for outerName
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder outerName(Optional<? extends ATypeName> outerName) {
      this.outerName = outerName.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableAnInnerClass ImmutableAnInnerClass}.
     * @return An immutable instance of AnInnerClass
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAnInnerClass build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAnInnerClass(access, typeName, innerName, outerName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ACCESS) != 0) attributes.add("access");
      if ((initBits & INIT_BIT_TYPE_NAME) != 0) attributes.add("typeName");
      return "Cannot build AnInnerClass, some of required attributes are not set " + attributes;
    }
  }
}
