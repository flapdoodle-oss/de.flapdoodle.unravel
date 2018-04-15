package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import de.flapdoodle.unravel.types.ATypeName;
import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link Usage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUsage.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Usage"})
@Immutable
@CheckReturnValue
public final class ImmutableUsage implements Usage {
  private final Map<ATypeName, Usage.UsedType> types;

  private ImmutableUsage(
      Map<ATypeName, Usage.UsedType> types) {
    this.types = types;
  }

  /**
   * @return The value of the {@code types} attribute
   */
  @Override
  public Map<ATypeName, Usage.UsedType> types() {
    return types;
  }

  public ImmutableUsage withTypes(Map<ATypeName, Usage.UsedType> value) {
    Map<ATypeName, Usage.UsedType> newValue = types_from(value);
    if (this.types == newValue) return this;
    return new ImmutableUsage(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUsage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUsage
        && equalTo((ImmutableUsage) another);
  }

  private boolean equalTo(ImmutableUsage another) {
    return this.types().equals(another.types());
  }

  /**
   * Computes a hash code from attributes: {@code types}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + (types().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code Usage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Usage")
        .omitNullValues()
        .add("types", types().toString())
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Usage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Usage instance
   */
  public static ImmutableUsage copyOf(Usage instance) {
    if (instance instanceof ImmutableUsage) {
      return (ImmutableUsage) instance;
    }
    return ImmutableUsage.builder()
        .from(instance)
        .build();
  }

  private static Map<ATypeName, Usage.UsedType> types_from(Map<ATypeName, Usage.UsedType> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableUsage ImmutableUsage}.
   * @return A new ImmutableUsage builder
   */
  public static ImmutableUsage.Builder builder() {
    return new ImmutableUsage.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUsage ImmutableUsage}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private Map<ATypeName, Usage.UsedType> types_map = HashMap.empty();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Usage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Usage instance) {
      Objects.requireNonNull(instance, "instance");
      types(instance.types());
      return this;
    }

    public Builder putTypes(ATypeName key, Usage.UsedType value) {
      this.types_map = this.types_map.put(key, value);
      return this;
    }

    public Builder putEntryTypes(Tuple2<ATypeName, Usage.UsedType> entry) {
      this.types_map = this.types_map.put(entry);
      return this;
    }

    public Builder types(Map<ATypeName, Usage.UsedType> elements) {
      this.types_map = elements;
      return this;
    }

    public Builder setJavaMapTypes(java.util.Map<ATypeName, Usage.UsedType> in_map) {
      this.types_map = HashMap.ofAll(in_map);
      return this;
    }

    public Builder setEntriesTypes(Iterable<Tuple2<ATypeName, Usage.UsedType>> entries) {
      this.types_map = HashMap.ofEntries(entries);
      return this;
    }

    /**
     * Builds a new {@link ImmutableUsage ImmutableUsage}.
     * @return An immutable instance of Usage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUsage build() {
      return new ImmutableUsage(this.types_map);
    }
  }
}
