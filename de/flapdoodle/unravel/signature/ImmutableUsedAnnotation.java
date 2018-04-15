package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import de.flapdoodle.unravel.types.AType;
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
 * Immutable implementation of {@link Usage.UsedAnnotation}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUsedAnnotation.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Usage.UsedAnnotation"})
@Immutable
@CheckReturnValue
public final class ImmutableUsedAnnotation implements Usage.UsedAnnotation {
  private final Map<String, AType> parameters;

  private ImmutableUsedAnnotation(Map<String, AType> parameters) {
    this.parameters = parameters;
  }

  /**
   * @return The value of the {@code parameters} attribute
   */
  @Override
  public Map<String, AType> parameters() {
    return parameters;
  }

  public ImmutableUsedAnnotation withParameters(Map<String, AType> value) {
    Map<String, AType> newValue = parameters_from(value);
    if (this.parameters == newValue) return this;
    return new ImmutableUsedAnnotation(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUsedAnnotation} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUsedAnnotation
        && equalTo((ImmutableUsedAnnotation) another);
  }

  private boolean equalTo(ImmutableUsedAnnotation another) {
    return this.parameters().equals(another.parameters());
  }

  /**
   * Computes a hash code from attributes: {@code parameters}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + (parameters().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code UsedAnnotation} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UsedAnnotation")
        .omitNullValues()
        .add("parameters", parameters().toString())
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Usage.UsedAnnotation} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UsedAnnotation instance
   */
  public static ImmutableUsedAnnotation copyOf(Usage.UsedAnnotation instance) {
    if (instance instanceof ImmutableUsedAnnotation) {
      return (ImmutableUsedAnnotation) instance;
    }
    return ImmutableUsedAnnotation.builder()
        .from(instance)
        .build();
  }

  private static Map<String, AType> parameters_from(Map<String, AType> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableUsedAnnotation ImmutableUsedAnnotation}.
   * @return A new ImmutableUsedAnnotation builder
   */
  public static ImmutableUsedAnnotation.Builder builder() {
    return new ImmutableUsedAnnotation.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUsedAnnotation ImmutableUsedAnnotation}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private Map<String, AType> parameters_map = HashMap.empty();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UsedAnnotation} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Usage.UsedAnnotation instance) {
      Objects.requireNonNull(instance, "instance");
      parameters(instance.parameters());
      return this;
    }

    public Builder putParameters(String key, AType value) {
      this.parameters_map = this.parameters_map.put(key, value);
      return this;
    }

    public Builder putEntryParameters(Tuple2<String, AType> entry) {
      this.parameters_map = this.parameters_map.put(entry);
      return this;
    }

    public Builder parameters(Map<String, AType> elements) {
      this.parameters_map = elements;
      return this;
    }

    public Builder setJavaMapParameters(java.util.Map<String, AType> in_map) {
      this.parameters_map = HashMap.ofAll(in_map);
      return this;
    }

    public Builder setEntriesParameters(Iterable<Tuple2<String, AType>> entries) {
      this.parameters_map = HashMap.ofEntries(entries);
      return this;
    }

    /**
     * Builds a new {@link ImmutableUsedAnnotation ImmutableUsedAnnotation}.
     * @return An immutable instance of UsedAnnotation
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUsedAnnotation build() {
      return new ImmutableUsedAnnotation(this.parameters_map);
    }
  }
}
