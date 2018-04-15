package de.flapdoodle.unravel.types;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.vavr.collection.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link AClass}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAClass.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AClass"})
@Immutable
@CheckReturnValue
public final class ImmutableAClass extends AClass {
  private final int version;
  private final int access;
  private final ATypeName typeName;
  private final @Nullable String genericSignature;
  private final @Nullable ATypeName superClazz;
  private final List<ATypeName> interfaces;
  private final List<AnInnerClass> innerClasses;
  private final @Nullable AnOuterClass outerClazz;
  private final List<AnAnnotation> annotations;
  private final List<AField> fields;
  private final List<AMethod> methods;

  private ImmutableAClass(
      int version,
      int access,
      ATypeName typeName,
      @Nullable String genericSignature,
      @Nullable ATypeName superClazz,
      List<ATypeName> interfaces,
      List<AnInnerClass> innerClasses,
      @Nullable AnOuterClass outerClazz,
      List<AnAnnotation> annotations,
      List<AField> fields,
      List<AMethod> methods) {
    this.version = version;
    this.access = access;
    this.typeName = typeName;
    this.genericSignature = genericSignature;
    this.superClazz = superClazz;
    this.interfaces = interfaces;
    this.innerClasses = innerClasses;
    this.outerClazz = outerClazz;
    this.annotations = annotations;
    this.fields = fields;
    this.methods = methods;
  }

  /**
   * @return The value of the {@code version} attribute
   */
  @Override
  protected int version() {
    return version;
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
   * @return The value of the {@code genericSignature} attribute
   */
  @Override
  public Optional<String> genericSignature() {
    return Optional.ofNullable(genericSignature);
  }

  /**
   * @return The value of the {@code superClazz} attribute
   */
  @Override
  public Optional<ATypeName> superClazz() {
    return Optional.ofNullable(superClazz);
  }

  /**
   * @return The value of the {@code interfaces} attribute
   */
  @Override
  public List<ATypeName> interfaces() {
    return interfaces;
  }

  /**
   * @return The value of the {@code innerClasses} attribute
   */
  @Override
  public List<AnInnerClass> innerClasses() {
    return innerClasses;
  }

  /**
   * @return The value of the {@code outerClazz} attribute
   */
  @Override
  public Optional<AnOuterClass> outerClazz() {
    return Optional.ofNullable(outerClazz);
  }

  /**
   * @return The value of the {@code annotations} attribute
   */
  @Override
  public List<AnAnnotation> annotations() {
    return annotations;
  }

  /**
   * @return The value of the {@code fields} attribute
   */
  @Override
  public List<AField> fields() {
    return fields;
  }

  /**
   * @return The value of the {@code methods} attribute
   */
  @Override
  public List<AMethod> methods() {
    return methods;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AClass#version() version} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for version
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAClass withVersion(int value) {
    if (this.version == value) return this;
    return new ImmutableAClass(
        value,
        this.access,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AClass#access() access} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for access
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAClass withAccess(int value) {
    if (this.access == value) return this;
    return new ImmutableAClass(
        this.version,
        value,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AClass#typeName() typeName} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for typeName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAClass withTypeName(ATypeName value) {
    if (this.typeName == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "typeName");
    return new ImmutableAClass(
        this.version,
        this.access,
        newValue,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AClass#genericSignature() genericSignature} attribute.
   * @param value The value for genericSignature
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAClass withGenericSignature(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "genericSignature");
    if (Objects.equals(this.genericSignature, newValue)) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        newValue,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AClass#genericSignature() genericSignature} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for genericSignature
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAClass withGenericSignature(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.genericSignature, value)) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        value,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AClass#superClazz() superClazz} attribute.
   * @param value The value for superClazz
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAClass withSuperClazz(ATypeName value) {
    @Nullable ATypeName newValue = Objects.requireNonNull(value, "superClazz");
    if (this.superClazz == newValue) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        newValue,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AClass#superClazz() superClazz} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for superClazz
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAClass withSuperClazz(Optional<? extends ATypeName> optional) {
    @Nullable ATypeName value = optional.orElse(null);
    if (this.superClazz == value) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        value,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  public ImmutableAClass withInterfaces(List<ATypeName> value) {
    List<ATypeName> newValue = interfaces_from(value);
    if (this.interfaces == newValue) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        newValue,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  public ImmutableAClass withInnerClasses(List<AnInnerClass> value) {
    List<AnInnerClass> newValue = innerClasses_from(value);
    if (this.innerClasses == newValue) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        newValue,
        this.outerClazz,
        this.annotations,
        this.fields,
        this.methods);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AClass#outerClazz() outerClazz} attribute.
   * @param value The value for outerClazz
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAClass withOuterClazz(AnOuterClass value) {
    @Nullable AnOuterClass newValue = Objects.requireNonNull(value, "outerClazz");
    if (this.outerClazz == newValue) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        newValue,
        this.annotations,
        this.fields,
        this.methods);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AClass#outerClazz() outerClazz} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for outerClazz
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAClass withOuterClazz(Optional<? extends AnOuterClass> optional) {
    @Nullable AnOuterClass value = optional.orElse(null);
    if (this.outerClazz == value) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        value,
        this.annotations,
        this.fields,
        this.methods);
  }

  public ImmutableAClass withAnnotations(List<AnAnnotation> value) {
    List<AnAnnotation> newValue = annotations_from(value);
    if (this.annotations == newValue) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        newValue,
        this.fields,
        this.methods);
  }

  public ImmutableAClass withFields(List<AField> value) {
    List<AField> newValue = fields_from(value);
    if (this.fields == newValue) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        newValue,
        this.methods);
  }

  public ImmutableAClass withMethods(List<AMethod> value) {
    List<AMethod> newValue = methods_from(value);
    if (this.methods == newValue) return this;
    return new ImmutableAClass(
        this.version,
        this.access,
        this.typeName,
        this.genericSignature,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.outerClazz,
        this.annotations,
        this.fields,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAClass} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAClass
        && equalTo((ImmutableAClass) another);
  }

  private boolean equalTo(ImmutableAClass another) {
    return version == another.version
        && access == another.access
        && typeName.equals(another.typeName)
        && Objects.equals(genericSignature, another.genericSignature)
        && Objects.equals(superClazz, another.superClazz)
        && this.interfaces().equals(another.interfaces())
        && this.innerClasses().equals(another.innerClasses())
        && Objects.equals(outerClazz, another.outerClazz)
        && this.annotations().equals(another.annotations())
        && this.fields().equals(another.fields())
        && this.methods().equals(another.methods());
  }

  /**
   * Computes a hash code from attributes: {@code version}, {@code access}, {@code typeName}, {@code genericSignature}, {@code superClazz}, {@code interfaces}, {@code innerClasses}, {@code outerClazz}, {@code annotations}, {@code fields}, {@code methods}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + version;
    h += (h << 5) + access;
    h += (h << 5) + typeName.hashCode();
    h += (h << 5) + Objects.hashCode(genericSignature);
    h += (h << 5) + Objects.hashCode(superClazz);
    h += (h << 5) + (interfaces().hashCode());
    h += (h << 5) + (innerClasses().hashCode());
    h += (h << 5) + Objects.hashCode(outerClazz);
    h += (h << 5) + (annotations().hashCode());
    h += (h << 5) + (fields().hashCode());
    h += (h << 5) + (methods().hashCode());
    return h;
  }

  /**
   * Prints the immutable value {@code AClass} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AClass")
        .omitNullValues()
        .add("version", version)
        .add("access", access)
        .add("typeName", typeName)
        .add("genericSignature", genericSignature)
        .add("superClazz", superClazz)
        .add("interfaces", interfaces().toString())
        .add("innerClasses", innerClasses().toString())
        .add("outerClazz", outerClazz)
        .add("annotations", annotations().toString())
        .add("fields", fields().toString())
        .add("methods", methods().toString())
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link AClass} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AClass instance
   */
  public static ImmutableAClass copyOf(AClass instance) {
    if (instance instanceof ImmutableAClass) {
      return (ImmutableAClass) instance;
    }
    return ImmutableAClass.builder()
        .version(instance.version())
        .access(instance.access())
        .typeName(instance.typeName())
        .genericSignature(instance.genericSignature())
        .superClazz(instance.superClazz())
        .interfaces(instance.interfaces())
        .innerClasses(instance.innerClasses())
        .outerClazz(instance.outerClazz())
        .annotations(instance.annotations())
        .fields(instance.fields())
        .methods(instance.methods())
        .build();
  }

  private static List<ATypeName> interfaces_from(List<ATypeName> value) {
    return value;
  }

  private static List<AnInnerClass> innerClasses_from(List<AnInnerClass> value) {
    return value;
  }

  private static List<AnAnnotation> annotations_from(List<AnAnnotation> value) {
    return value;
  }

  private static List<AField> fields_from(List<AField> value) {
    return value;
  }

  private static List<AMethod> methods_from(List<AMethod> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableAClass ImmutableAClass}.
   * @return A new ImmutableAClass builder
   */
  public static ImmutableAClass.Builder builder() {
    return new ImmutableAClass.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAClass ImmutableAClass}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_VERSION = 0x1L;
    private static final long INIT_BIT_ACCESS = 0x2L;
    private static final long INIT_BIT_TYPE_NAME = 0x4L;
    private static final long OPT_BIT_GENERIC_SIGNATURE = 0x1L;
    private static final long OPT_BIT_SUPER_CLAZZ = 0x2L;
    private static final long OPT_BIT_INTERFACES = 0x4L;
    private static final long OPT_BIT_INNER_CLASSES = 0x8L;
    private static final long OPT_BIT_OUTER_CLAZZ = 0x10L;
    private static final long OPT_BIT_ANNOTATIONS = 0x20L;
    private static final long OPT_BIT_FIELDS = 0x40L;
    private static final long OPT_BIT_METHODS = 0x80L;
    private long initBits = 0x7L;
    private long optBits;

    private List<ATypeName> interfaces_list = List.empty();
    private List<AnInnerClass> innerClasses_list = List.empty();
    private List<AnAnnotation> annotations_list = List.empty();
    private List<AField> fields_list = List.empty();
    private List<AMethod> methods_list = List.empty();
    private int version;
    private int access;
    private @Nullable ATypeName typeName;
    private @Nullable String genericSignature;
    private @Nullable ATypeName superClazz;
    private @Nullable AnOuterClass outerClazz;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link AClass#version() version} attribute.
     * @param version The value for version 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder version(int version) {
      checkNotIsSet(versionIsSet(), "version");
      this.version = version;
      initBits &= ~INIT_BIT_VERSION;
      return this;
    }

    /**
     * Initializes the value for the {@link AClass#access() access} attribute.
     * @param access The value for access 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder access(int access) {
      checkNotIsSet(accessIsSet(), "access");
      this.access = access;
      initBits &= ~INIT_BIT_ACCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link AClass#typeName() typeName} attribute.
     * @param typeName The value for typeName 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder typeName(ATypeName typeName) {
      checkNotIsSet(typeNameIsSet(), "typeName");
      this.typeName = Objects.requireNonNull(typeName, "typeName");
      initBits &= ~INIT_BIT_TYPE_NAME;
      return this;
    }

    /**
     * Initializes the optional value {@link AClass#genericSignature() genericSignature} to genericSignature.
     * @param genericSignature The value for genericSignature
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder genericSignature(String genericSignature) {
      checkNotIsSet(genericSignatureIsSet(), "genericSignature");
      this.genericSignature = Objects.requireNonNull(genericSignature, "genericSignature");
      optBits |= OPT_BIT_GENERIC_SIGNATURE;
      return this;
    }

    /**
     * Initializes the optional value {@link AClass#genericSignature() genericSignature} to genericSignature.
     * @param genericSignature The value for genericSignature
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder genericSignature(Optional<String> genericSignature) {
      checkNotIsSet(genericSignatureIsSet(), "genericSignature");
      this.genericSignature = genericSignature.orElse(null);
      optBits |= OPT_BIT_GENERIC_SIGNATURE;
      return this;
    }

    /**
     * Initializes the optional value {@link AClass#superClazz() superClazz} to superClazz.
     * @param superClazz The value for superClazz
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder superClazz(ATypeName superClazz) {
      checkNotIsSet(superClazzIsSet(), "superClazz");
      this.superClazz = Objects.requireNonNull(superClazz, "superClazz");
      optBits |= OPT_BIT_SUPER_CLAZZ;
      return this;
    }

    /**
     * Initializes the optional value {@link AClass#superClazz() superClazz} to superClazz.
     * @param superClazz The value for superClazz
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder superClazz(Optional<? extends ATypeName> superClazz) {
      checkNotIsSet(superClazzIsSet(), "superClazz");
      this.superClazz = superClazz.orElse(null);
      optBits |= OPT_BIT_SUPER_CLAZZ;
      return this;
    }

    public Builder addInterfaces(ATypeName element) {
      this.interfaces_list = this.interfaces_list.append(element);
      return this;
    }

    public Builder addAllInterfaces(Iterable<ATypeName> element) {
      this.interfaces_list = this.interfaces_list.appendAll(element);
      return this;
    }

    public Builder interfaces(List<ATypeName> elements) {
      this.interfaces_list = elements;
      return this;
    }

    public Builder setIterableInterfaces(Iterable<ATypeName> elements) {
      this.interfaces_list = List.ofAll(elements);
      return this;
    }

    public Builder addInnerClasses(AnInnerClass element) {
      this.innerClasses_list = this.innerClasses_list.append(element);
      return this;
    }

    public Builder addAllInnerClasses(Iterable<AnInnerClass> element) {
      this.innerClasses_list = this.innerClasses_list.appendAll(element);
      return this;
    }

    public Builder innerClasses(List<AnInnerClass> elements) {
      this.innerClasses_list = elements;
      return this;
    }

    public Builder setIterableInnerClasses(Iterable<AnInnerClass> elements) {
      this.innerClasses_list = List.ofAll(elements);
      return this;
    }

    /**
     * Initializes the optional value {@link AClass#outerClazz() outerClazz} to outerClazz.
     * @param outerClazz The value for outerClazz
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder outerClazz(AnOuterClass outerClazz) {
      checkNotIsSet(outerClazzIsSet(), "outerClazz");
      this.outerClazz = Objects.requireNonNull(outerClazz, "outerClazz");
      optBits |= OPT_BIT_OUTER_CLAZZ;
      return this;
    }

    /**
     * Initializes the optional value {@link AClass#outerClazz() outerClazz} to outerClazz.
     * @param outerClazz The value for outerClazz
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder outerClazz(Optional<? extends AnOuterClass> outerClazz) {
      checkNotIsSet(outerClazzIsSet(), "outerClazz");
      this.outerClazz = outerClazz.orElse(null);
      optBits |= OPT_BIT_OUTER_CLAZZ;
      return this;
    }

    public Builder addAnnotations(AnAnnotation element) {
      this.annotations_list = this.annotations_list.append(element);
      return this;
    }

    public Builder addAllAnnotations(Iterable<AnAnnotation> element) {
      this.annotations_list = this.annotations_list.appendAll(element);
      return this;
    }

    public Builder annotations(List<AnAnnotation> elements) {
      this.annotations_list = elements;
      return this;
    }

    public Builder setIterableAnnotations(Iterable<AnAnnotation> elements) {
      this.annotations_list = List.ofAll(elements);
      return this;
    }

    public Builder addFields(AField element) {
      this.fields_list = this.fields_list.append(element);
      return this;
    }

    public Builder addAllFields(Iterable<AField> element) {
      this.fields_list = this.fields_list.appendAll(element);
      return this;
    }

    public Builder fields(List<AField> elements) {
      this.fields_list = elements;
      return this;
    }

    public Builder setIterableFields(Iterable<AField> elements) {
      this.fields_list = List.ofAll(elements);
      return this;
    }

    public Builder addMethods(AMethod element) {
      this.methods_list = this.methods_list.append(element);
      return this;
    }

    public Builder addAllMethods(Iterable<AMethod> element) {
      this.methods_list = this.methods_list.appendAll(element);
      return this;
    }

    public Builder methods(List<AMethod> elements) {
      this.methods_list = elements;
      return this;
    }

    public Builder setIterableMethods(Iterable<AMethod> elements) {
      this.methods_list = List.ofAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableAClass ImmutableAClass}.
     * @return An immutable instance of AClass
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAClass build() {
      checkRequiredAttributes();
      return new ImmutableAClass(
          version,
          access,
          typeName,
          genericSignature,
          superClazz,
          this.interfaces_list,
          this.innerClasses_list,
          outerClazz,
          this.annotations_list,
          this.fields_list,
          this.methods_list);
    }

    private boolean genericSignatureIsSet() {
      return (optBits & OPT_BIT_GENERIC_SIGNATURE) != 0;
    }

    private boolean superClazzIsSet() {
      return (optBits & OPT_BIT_SUPER_CLAZZ) != 0;
    }

    private boolean interfacesIsSet() {
      return (optBits & OPT_BIT_INTERFACES) != 0;
    }

    private boolean innerClassesIsSet() {
      return (optBits & OPT_BIT_INNER_CLASSES) != 0;
    }

    private boolean outerClazzIsSet() {
      return (optBits & OPT_BIT_OUTER_CLAZZ) != 0;
    }

    private boolean annotationsIsSet() {
      return (optBits & OPT_BIT_ANNOTATIONS) != 0;
    }

    private boolean fieldsIsSet() {
      return (optBits & OPT_BIT_FIELDS) != 0;
    }

    private boolean methodsIsSet() {
      return (optBits & OPT_BIT_METHODS) != 0;
    }

    private boolean versionIsSet() {
      return (initBits & INIT_BIT_VERSION) == 0;
    }

    private boolean accessIsSet() {
      return (initBits & INIT_BIT_ACCESS) == 0;
    }

    private boolean typeNameIsSet() {
      return (initBits & INIT_BIT_TYPE_NAME) == 0;
    }

    private void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of AClass is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() throws IllegalStateException {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      java.util.List<String> attributes = Lists.newArrayList();
      if (!versionIsSet()) attributes.add("version");
      if (!accessIsSet()) attributes.add("access");
      if (!typeNameIsSet()) attributes.add("typeName");
      return "Cannot build AClass, some of required attributes are not set " + attributes;
    }
  }
}
