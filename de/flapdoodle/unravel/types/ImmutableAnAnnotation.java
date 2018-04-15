package de.flapdoodle.unravel.types;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.collection.HashMultimap;
import io.vavr.collection.Multimap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link AnAnnotation}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAnAnnotation.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AnAnnotation"})
@Immutable
@CheckReturnValue
public final class ImmutableAnAnnotation extends AnAnnotation {
  private final ATypeName clazz;
  private final boolean visible;
  private final Multimap<String, Object> valueAttributes;
  private final Multimap<String, AnAnnotation> annotationAttributes;
  private final Multimap<String, ATypeName> clazzAttributes;
  private final Multimap<String, AnEnumValue> enumAttributes;

  private ImmutableAnAnnotation(
      ATypeName clazz,
      boolean visible,
      Multimap<String, Object> valueAttributes,
      Multimap<String, AnAnnotation> annotationAttributes,
      Multimap<String, ATypeName> clazzAttributes,
      Multimap<String, AnEnumValue> enumAttributes) {
    this.clazz = clazz;
    this.visible = visible;
    this.valueAttributes = valueAttributes;
    this.annotationAttributes = annotationAttributes;
    this.clazzAttributes = clazzAttributes;
    this.enumAttributes = enumAttributes;
  }

  /**
   * @return The value of the {@code clazz} attribute
   */
  @Override
  public ATypeName clazz() {
    return clazz;
  }

  /**
   * @return The value of the {@code visible} attribute
   */
  @Override
  public boolean visible() {
    return visible;
  }

  /**
   * @return The value of the {@code valueAttributes} attribute
   */
  @Override
  public Multimap<String, Object> valueAttributes() {
    return valueAttributes;
  }

  /**
   * @return The value of the {@code annotationAttributes} attribute
   */
  @Override
  public Multimap<String, AnAnnotation> annotationAttributes() {
    return annotationAttributes;
  }

  /**
   * @return The value of the {@code clazzAttributes} attribute
   */
  @Override
  public Multimap<String, ATypeName> clazzAttributes() {
    return clazzAttributes;
  }

  /**
   * @return The value of the {@code enumAttributes} attribute
   */
  @Override
  public Multimap<String, AnEnumValue> enumAttributes() {
    return enumAttributes;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AnAnnotation#clazz() clazz} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for clazz
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAnAnnotation withClazz(ATypeName value) {
    if (this.clazz == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "clazz");
    return new ImmutableAnAnnotation(
        newValue,
        this.visible,
        this.valueAttributes,
        this.annotationAttributes,
        this.clazzAttributes,
        this.enumAttributes);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AnAnnotation#visible() visible} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for visible
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAnAnnotation withVisible(boolean value) {
    if (this.visible == value) return this;
    return new ImmutableAnAnnotation(
        this.clazz,
        value,
        this.valueAttributes,
        this.annotationAttributes,
        this.clazzAttributes,
        this.enumAttributes);
  }

  public ImmutableAnAnnotation withValueAttributes(Multimap<String, Object> value) {
    Multimap<String, Object> newValue = valueAttributes_from(value);
    if (this.valueAttributes == newValue) return this;
    return new ImmutableAnAnnotation(
        this.clazz,
        this.visible,
        newValue,
        this.annotationAttributes,
        this.clazzAttributes,
        this.enumAttributes);
  }

  public ImmutableAnAnnotation withAnnotationAttributes(Multimap<String, AnAnnotation> value) {
    Multimap<String, AnAnnotation> newValue = annotationAttributes_from(value);
    if (this.annotationAttributes == newValue) return this;
    return new ImmutableAnAnnotation(
        this.clazz,
        this.visible,
        this.valueAttributes,
        newValue,
        this.clazzAttributes,
        this.enumAttributes);
  }

  public ImmutableAnAnnotation withClazzAttributes(Multimap<String, ATypeName> value) {
    Multimap<String, ATypeName> newValue = clazzAttributes_from(value);
    if (this.clazzAttributes == newValue) return this;
    return new ImmutableAnAnnotation(
        this.clazz,
        this.visible,
        this.valueAttributes,
        this.annotationAttributes,
        newValue,
        this.enumAttributes);
  }

  public ImmutableAnAnnotation withEnumAttributes(Multimap<String, AnEnumValue> value) {
    Multimap<String, AnEnumValue> newValue = enumAttributes_from(value);
    if (this.enumAttributes == newValue) return this;
    return new ImmutableAnAnnotation(
        this.clazz,
        this.visible,
        this.valueAttributes,
        this.annotationAttributes,
        this.clazzAttributes,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAnAnnotation} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAnAnnotation
        && equalTo((ImmutableAnAnnotation) another);
  }

  private boolean equalTo(ImmutableAnAnnotation another) {
    return clazz.equals(another.clazz)
        && visible == another.visible
        && this.valueAttributes().equals(another.valueAttributes())
        && this.annotationAttributes().equals(another.annotationAttributes())
        && this.clazzAttributes().equals(another.clazzAttributes())
        && this.enumAttributes().equals(another.enumAttributes());
  }

  /**
   * Computes a hash code from attributes: {@code clazz}, {@code visible}, {@code valueAttributes}, {@code annotationAttributes}, {@code clazzAttributes}, {@code enumAttributes}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + clazz.hashCode();
    h += (h << 5) + Booleans.hashCode(visible);
    h += (h << 5) + (valueAttributes().hashCode());
    h += (h << 5) + (annotationAttributes().hashCode());
    h += (h << 5) + (clazzAttributes().hashCode());
    h += (h << 5) + (enumAttributes().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code AnAnnotation} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AnAnnotation")
        .omitNullValues()
        .add("clazz", clazz)
        .add("visible", visible)
        .add("valueAttributes", valueAttributes().toString())
        .add("annotationAttributes", annotationAttributes().toString())
        .add("clazzAttributes", clazzAttributes().toString())
        .add("enumAttributes", enumAttributes().toString())
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link AnAnnotation} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AnAnnotation instance
   */
  public static ImmutableAnAnnotation copyOf(AnAnnotation instance) {
    if (instance instanceof ImmutableAnAnnotation) {
      return (ImmutableAnAnnotation) instance;
    }
    return ImmutableAnAnnotation.builder()
        .from(instance)
        .build();
  }

  private static Multimap<String, Object> valueAttributes_from(Multimap<String, Object> value) {
    return value;
  }

  private static Multimap<String, AnAnnotation> annotationAttributes_from(Multimap<String, AnAnnotation> value) {
    return value;
  }

  private static Multimap<String, ATypeName> clazzAttributes_from(Multimap<String, ATypeName> value) {
    return value;
  }

  private static Multimap<String, AnEnumValue> enumAttributes_from(Multimap<String, AnEnumValue> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableAnAnnotation ImmutableAnAnnotation}.
   * @param clazz {@code clazz} parameter
   * @param visible {@code visible} parameter
   * @return A new ImmutableAnAnnotation builder
   */
  public static ImmutableAnAnnotation.Builder builder(ATypeName clazz, boolean visible) {
    return new ImmutableAnAnnotation.Builder(clazz, visible);
  }

  static ImmutableAnAnnotation.Builder builder() {
    return new ImmutableAnAnnotation.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAnAnnotation ImmutableAnAnnotation}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLAZZ = 0x1L;
    private static final long INIT_BIT_VISIBLE = 0x2L;
    private long initBits = 0x3L;

    private Multimap<String, Object> valueAttributes_map = HashMultimap.withSet().empty();
    private Multimap<String, AnAnnotation> annotationAttributes_map = HashMultimap.withSet().empty();
    private Multimap<String, ATypeName> clazzAttributes_map = HashMultimap.withSet().empty();
    private Multimap<String, AnEnumValue> enumAttributes_map = HashMultimap.withSet().empty();
    private @Nullable ATypeName clazz;
    private boolean visible;

    private Builder(ATypeName clazz, boolean visible) {
      clazz(clazz);
      visible(visible);
    }

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AnAnnotation} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AnAnnotation instance) {
      Objects.requireNonNull(instance, "instance");
      clazz(instance.clazz());
      visible(instance.visible());
      valueAttributes(instance.valueAttributes());
      annotationAttributes(instance.annotationAttributes());
      clazzAttributes(instance.clazzAttributes());
      enumAttributes(instance.enumAttributes());
      return this;
    }

    /**
     * Initializes the value for the {@link AnAnnotation#clazz() clazz} attribute.
     * @param clazz The value for clazz 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    final Builder clazz(ATypeName clazz) {
      this.clazz = Objects.requireNonNull(clazz, "clazz");
      initBits &= ~INIT_BIT_CLAZZ;
      return this;
    }

    /**
     * Initializes the value for the {@link AnAnnotation#visible() visible} attribute.
     * @param visible The value for visible 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    final Builder visible(boolean visible) {
      this.visible = visible;
      initBits &= ~INIT_BIT_VISIBLE;
      return this;
    }

    public Builder putValueAttributes(String key, Object value) {
      this.valueAttributes_map = this.valueAttributes_map.put(key, value);
      return this;
    }

    public Builder putEntryValueAttributes(Tuple2<String, Object> entry) {
      this.valueAttributes_map = this.valueAttributes_map.put(entry);
      return this;
    }

    public Builder valueAttributes(Multimap<String, Object> elements) {
      this.valueAttributes_map = elements;
      return this;
    }

    public Builder setJavaMultimapValueAttributes(Map<String, Object> in_map) {
      this.valueAttributes_map = HashMultimap.withSet().ofEntries(HashMap.ofAll(in_map));
      return this;
    }

    public Builder setEntriesValueAttributes(Iterable<Tuple2<String, Object>> entries) {
      this.valueAttributes_map = HashMultimap.withSet().ofEntries(entries);
      return this;
    }

    public Builder putAnnotationAttributes(String key, AnAnnotation value) {
      this.annotationAttributes_map = this.annotationAttributes_map.put(key, value);
      return this;
    }

    public Builder putEntryAnnotationAttributes(Tuple2<String, AnAnnotation> entry) {
      this.annotationAttributes_map = this.annotationAttributes_map.put(entry);
      return this;
    }

    public Builder annotationAttributes(Multimap<String, AnAnnotation> elements) {
      this.annotationAttributes_map = elements;
      return this;
    }

    public Builder setJavaMultimapAnnotationAttributes(Map<String, AnAnnotation> in_map) {
      this.annotationAttributes_map = HashMultimap.withSet().ofEntries(HashMap.ofAll(in_map));
      return this;
    }

    public Builder setEntriesAnnotationAttributes(Iterable<Tuple2<String, AnAnnotation>> entries) {
      this.annotationAttributes_map = HashMultimap.withSet().ofEntries(entries);
      return this;
    }

    public Builder putClazzAttributes(String key, ATypeName value) {
      this.clazzAttributes_map = this.clazzAttributes_map.put(key, value);
      return this;
    }

    public Builder putEntryClazzAttributes(Tuple2<String, ATypeName> entry) {
      this.clazzAttributes_map = this.clazzAttributes_map.put(entry);
      return this;
    }

    public Builder clazzAttributes(Multimap<String, ATypeName> elements) {
      this.clazzAttributes_map = elements;
      return this;
    }

    public Builder setJavaMultimapClazzAttributes(Map<String, ATypeName> in_map) {
      this.clazzAttributes_map = HashMultimap.withSet().ofEntries(HashMap.ofAll(in_map));
      return this;
    }

    public Builder setEntriesClazzAttributes(Iterable<Tuple2<String, ATypeName>> entries) {
      this.clazzAttributes_map = HashMultimap.withSet().ofEntries(entries);
      return this;
    }

    public Builder putEnumAttributes(String key, AnEnumValue value) {
      this.enumAttributes_map = this.enumAttributes_map.put(key, value);
      return this;
    }

    public Builder putEntryEnumAttributes(Tuple2<String, AnEnumValue> entry) {
      this.enumAttributes_map = this.enumAttributes_map.put(entry);
      return this;
    }

    public Builder enumAttributes(Multimap<String, AnEnumValue> elements) {
      this.enumAttributes_map = elements;
      return this;
    }

    public Builder setJavaMultimapEnumAttributes(Map<String, AnEnumValue> in_map) {
      this.enumAttributes_map = HashMultimap.withSet().ofEntries(HashMap.ofAll(in_map));
      return this;
    }

    public Builder setEntriesEnumAttributes(Iterable<Tuple2<String, AnEnumValue>> entries) {
      this.enumAttributes_map = HashMultimap.withSet().ofEntries(entries);
      return this;
    }

    /**
     * Builds a new {@link ImmutableAnAnnotation ImmutableAnAnnotation}.
     * @return An immutable instance of AnAnnotation
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAnAnnotation build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAnAnnotation(
          clazz,
          visible,
          this.valueAttributes_map,
          this.annotationAttributes_map,
          this.clazzAttributes_map,
          this.enumAttributes_map);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLAZZ) != 0) attributes.add("clazz");
      if ((initBits & INIT_BIT_VISIBLE) != 0) attributes.add("visible");
      return "Cannot build AnAnnotation, some of required attributes are not set " + attributes;
    }
  }
}
