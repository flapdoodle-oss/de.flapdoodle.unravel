package de.flapdoodle.unravel.types;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.vavr.collection.LinkedHashSet;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link Calls}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCalls.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Calls"})
@Immutable
@CheckReturnValue
public final class ImmutableCalls extends Calls {
  private final LinkedHashSet<Calls.FieldCall> fieldCalls;
  private final LinkedHashSet<Calls.MethodCall> methodCalls;
  private final LinkedHashSet<Calls.LambdaCall> lambdaCalls;
  private final LinkedHashSet<Calls.TypeReferenceCall> typeReferenceCalls;

  private ImmutableCalls(
      LinkedHashSet<Calls.FieldCall> fieldCalls,
      LinkedHashSet<Calls.MethodCall> methodCalls,
      LinkedHashSet<Calls.LambdaCall> lambdaCalls,
      LinkedHashSet<Calls.TypeReferenceCall> typeReferenceCalls) {
    this.fieldCalls = fieldCalls;
    this.methodCalls = methodCalls;
    this.lambdaCalls = lambdaCalls;
    this.typeReferenceCalls = typeReferenceCalls;
  }

  /**
   * @return The value of the {@code fieldCalls} attribute
   */
  @Override
  public LinkedHashSet<Calls.FieldCall> fieldCalls() {
    return fieldCalls;
  }

  /**
   * @return The value of the {@code methodCalls} attribute
   */
  @Override
  public LinkedHashSet<Calls.MethodCall> methodCalls() {
    return methodCalls;
  }

  /**
   * @return The value of the {@code lambdaCalls} attribute
   */
  @Override
  public LinkedHashSet<Calls.LambdaCall> lambdaCalls() {
    return lambdaCalls;
  }

  /**
   * @return The value of the {@code typeReferenceCalls} attribute
   */
  @Override
  public LinkedHashSet<Calls.TypeReferenceCall> typeReferenceCalls() {
    return typeReferenceCalls;
  }

  public ImmutableCalls withFieldCalls(LinkedHashSet<Calls.FieldCall> value) {
    LinkedHashSet<Calls.FieldCall> newValue = fieldCalls_from(value);
    if (this.fieldCalls == newValue) return this;
    return new ImmutableCalls(newValue, this.methodCalls, this.lambdaCalls, this.typeReferenceCalls);
  }

  public ImmutableCalls withMethodCalls(LinkedHashSet<Calls.MethodCall> value) {
    LinkedHashSet<Calls.MethodCall> newValue = methodCalls_from(value);
    if (this.methodCalls == newValue) return this;
    return new ImmutableCalls(this.fieldCalls, newValue, this.lambdaCalls, this.typeReferenceCalls);
  }

  public ImmutableCalls withLambdaCalls(LinkedHashSet<Calls.LambdaCall> value) {
    LinkedHashSet<Calls.LambdaCall> newValue = lambdaCalls_from(value);
    if (this.lambdaCalls == newValue) return this;
    return new ImmutableCalls(this.fieldCalls, this.methodCalls, newValue, this.typeReferenceCalls);
  }

  public ImmutableCalls withTypeReferenceCalls(LinkedHashSet<Calls.TypeReferenceCall> value) {
    LinkedHashSet<Calls.TypeReferenceCall> newValue = typeReferenceCalls_from(value);
    if (this.typeReferenceCalls == newValue) return this;
    return new ImmutableCalls(this.fieldCalls, this.methodCalls, this.lambdaCalls, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCalls} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCalls
        && equalTo((ImmutableCalls) another);
  }

  private boolean equalTo(ImmutableCalls another) {
    return this.fieldCalls().equals(another.fieldCalls())
        && this.methodCalls().equals(another.methodCalls())
        && this.lambdaCalls().equals(another.lambdaCalls())
        && this.typeReferenceCalls().equals(another.typeReferenceCalls());
  }

  /**
   * Computes a hash code from attributes: {@code fieldCalls}, {@code methodCalls}, {@code lambdaCalls}, {@code typeReferenceCalls}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + (fieldCalls().hashCode());
    h += (h << 5) + (methodCalls().hashCode());
    h += (h << 5) + (lambdaCalls().hashCode());
    h += (h << 5) + (typeReferenceCalls().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code Calls} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Calls")
        .omitNullValues()
        .add("fieldCalls", fieldCalls().toString())
        .add("methodCalls", methodCalls().toString())
        .add("lambdaCalls", lambdaCalls().toString())
        .add("typeReferenceCalls", typeReferenceCalls().toString())
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Calls} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Calls instance
   */
  public static ImmutableCalls copyOf(Calls instance) {
    if (instance instanceof ImmutableCalls) {
      return (ImmutableCalls) instance;
    }
    return ImmutableCalls.builder()
        .from(instance)
        .build();
  }

  private static LinkedHashSet<Calls.FieldCall> fieldCalls_from(LinkedHashSet<Calls.FieldCall> value) {
    return value;
  }

  private static LinkedHashSet<Calls.MethodCall> methodCalls_from(LinkedHashSet<Calls.MethodCall> value) {
    return value;
  }

  private static LinkedHashSet<Calls.LambdaCall> lambdaCalls_from(LinkedHashSet<Calls.LambdaCall> value) {
    return value;
  }

  private static LinkedHashSet<Calls.TypeReferenceCall> typeReferenceCalls_from(LinkedHashSet<Calls.TypeReferenceCall> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableCalls ImmutableCalls}.
   * @return A new ImmutableCalls builder
   */
  public static ImmutableCalls.Builder builder() {
    return new ImmutableCalls.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCalls ImmutableCalls}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private LinkedHashSet<Calls.FieldCall> fieldCalls_set = LinkedHashSet.empty();
    private LinkedHashSet<Calls.MethodCall> methodCalls_set = LinkedHashSet.empty();
    private LinkedHashSet<Calls.LambdaCall> lambdaCalls_set = LinkedHashSet.empty();
    private LinkedHashSet<Calls.TypeReferenceCall> typeReferenceCalls_set = LinkedHashSet.empty();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Calls} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Calls instance) {
      Objects.requireNonNull(instance, "instance");
      fieldCalls(instance.fieldCalls());
      methodCalls(instance.methodCalls());
      lambdaCalls(instance.lambdaCalls());
      typeReferenceCalls(instance.typeReferenceCalls());
      return this;
    }

    public Builder addFieldCalls(Calls.FieldCall element) {
      this.fieldCalls_set = this.fieldCalls_set.add(element);
      return this;
    }

    public Builder addAllFieldCalls(Iterable<Calls.FieldCall> element) {
      this.fieldCalls_set = this.fieldCalls_set.addAll(element);
      return this;
    }

    public Builder fieldCalls(LinkedHashSet<Calls.FieldCall> elements) {
      this.fieldCalls_set = elements;
      return this;
    }

    public Builder setIterableFieldCalls(Iterable<Calls.FieldCall> elements) {
      this.fieldCalls_set = LinkedHashSet.ofAll(elements);
      return this;
    }

    public Builder addMethodCalls(Calls.MethodCall element) {
      this.methodCalls_set = this.methodCalls_set.add(element);
      return this;
    }

    public Builder addAllMethodCalls(Iterable<Calls.MethodCall> element) {
      this.methodCalls_set = this.methodCalls_set.addAll(element);
      return this;
    }

    public Builder methodCalls(LinkedHashSet<Calls.MethodCall> elements) {
      this.methodCalls_set = elements;
      return this;
    }

    public Builder setIterableMethodCalls(Iterable<Calls.MethodCall> elements) {
      this.methodCalls_set = LinkedHashSet.ofAll(elements);
      return this;
    }

    public Builder addLambdaCalls(Calls.LambdaCall element) {
      this.lambdaCalls_set = this.lambdaCalls_set.add(element);
      return this;
    }

    public Builder addAllLambdaCalls(Iterable<Calls.LambdaCall> element) {
      this.lambdaCalls_set = this.lambdaCalls_set.addAll(element);
      return this;
    }

    public Builder lambdaCalls(LinkedHashSet<Calls.LambdaCall> elements) {
      this.lambdaCalls_set = elements;
      return this;
    }

    public Builder setIterableLambdaCalls(Iterable<Calls.LambdaCall> elements) {
      this.lambdaCalls_set = LinkedHashSet.ofAll(elements);
      return this;
    }

    public Builder addTypeReferenceCalls(Calls.TypeReferenceCall element) {
      this.typeReferenceCalls_set = this.typeReferenceCalls_set.add(element);
      return this;
    }

    public Builder addAllTypeReferenceCalls(Iterable<Calls.TypeReferenceCall> element) {
      this.typeReferenceCalls_set = this.typeReferenceCalls_set.addAll(element);
      return this;
    }

    public Builder typeReferenceCalls(LinkedHashSet<Calls.TypeReferenceCall> elements) {
      this.typeReferenceCalls_set = elements;
      return this;
    }

    public Builder setIterableTypeReferenceCalls(Iterable<Calls.TypeReferenceCall> elements) {
      this.typeReferenceCalls_set = LinkedHashSet.ofAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCalls ImmutableCalls}.
     * @return An immutable instance of Calls
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCalls build() {
      return new ImmutableCalls(this.fieldCalls_set, this.methodCalls_set, this.lambdaCalls_set, this.typeReferenceCalls_set);
    }
  }
}
