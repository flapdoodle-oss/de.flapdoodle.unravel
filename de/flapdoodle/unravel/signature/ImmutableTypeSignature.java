package de.flapdoodle.unravel.signature;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.JavaVersion;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link TypeSignature}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTypeSignature.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "TypeSignature"})
@Immutable
@CheckReturnValue
public final class ImmutableTypeSignature implements TypeSignature {
  private final ATypeName typeName;
  private final JavaVersion javaVersion;
  private final Set<AccessFlags> accessFlags;
  private final @Nullable ATypeName superClazz;
  private final List<ATypeName> interfaces;
  private final List<TypeSignature> innerClasses;
  private final List<TypeSignature.Field> fields;
  private final List<TypeSignature.Method> methods;
  private final TypeSignature.Uses uses;
  private final Usage usage;

  private ImmutableTypeSignature(
      ATypeName typeName,
      JavaVersion javaVersion,
      Set<AccessFlags> accessFlags,
      @Nullable ATypeName superClazz,
      List<ATypeName> interfaces,
      List<TypeSignature> innerClasses,
      List<TypeSignature.Field> fields,
      List<TypeSignature.Method> methods,
      TypeSignature.Uses uses,
      Usage usage) {
    this.typeName = typeName;
    this.javaVersion = javaVersion;
    this.accessFlags = accessFlags;
    this.superClazz = superClazz;
    this.interfaces = interfaces;
    this.innerClasses = innerClasses;
    this.fields = fields;
    this.methods = methods;
    this.uses = uses;
    this.usage = usage;
  }

  /**
   * @return The value of the {@code typeName} attribute
   */
  @Override
  public ATypeName typeName() {
    return typeName;
  }

  /**
   * @return The value of the {@code javaVersion} attribute
   */
  @Override
  public JavaVersion javaVersion() {
    return javaVersion;
  }

  /**
   * @return The value of the {@code accessFlags} attribute
   */
  @Override
  public Set<AccessFlags> accessFlags() {
    return accessFlags;
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
  public List<TypeSignature> innerClasses() {
    return innerClasses;
  }

  /**
   * @return The value of the {@code fields} attribute
   */
  @Override
  public List<TypeSignature.Field> fields() {
    return fields;
  }

  /**
   * @return The value of the {@code methods} attribute
   */
  @Override
  public List<TypeSignature.Method> methods() {
    return methods;
  }

  /**
   * @return The value of the {@code uses} attribute
   */
  @Override
  public TypeSignature.Uses uses() {
    return uses;
  }

  /**
   * @return The value of the {@code usage} attribute
   */
  @Override
  public Usage usage() {
    return usage;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeSignature#typeName() typeName} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for typeName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTypeSignature withTypeName(ATypeName value) {
    if (this.typeName == value) return this;
    ATypeName newValue = Objects.requireNonNull(value, "typeName");
    return new ImmutableTypeSignature(
        newValue,
        this.javaVersion,
        this.accessFlags,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.fields,
        this.methods,
        this.uses,
        this.usage);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeSignature#javaVersion() javaVersion} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for javaVersion
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTypeSignature withJavaVersion(JavaVersion value) {
    if (this.javaVersion == value) return this;
    JavaVersion newValue = Objects.requireNonNull(value, "javaVersion");
    return new ImmutableTypeSignature(
        this.typeName,
        newValue,
        this.accessFlags,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.fields,
        this.methods,
        this.uses,
        this.usage);
  }

  public ImmutableTypeSignature withAccessFlags(Set<AccessFlags> value) {
    Set<AccessFlags> newValue = accessFlags_from(value);
    if (this.accessFlags == newValue) return this;
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        newValue,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.fields,
        this.methods,
        this.uses,
        this.usage);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link TypeSignature#superClazz() superClazz} attribute.
   * @param value The value for superClazz
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTypeSignature withSuperClazz(ATypeName value) {
    @Nullable ATypeName newValue = Objects.requireNonNull(value, "superClazz");
    if (this.superClazz == newValue) return this;
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        this.accessFlags,
        newValue,
        this.interfaces,
        this.innerClasses,
        this.fields,
        this.methods,
        this.uses,
        this.usage);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link TypeSignature#superClazz() superClazz} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for superClazz
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTypeSignature withSuperClazz(Optional<? extends ATypeName> optional) {
    @Nullable ATypeName value = optional.orElse(null);
    if (this.superClazz == value) return this;
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        this.accessFlags,
        value,
        this.interfaces,
        this.innerClasses,
        this.fields,
        this.methods,
        this.uses,
        this.usage);
  }

  public ImmutableTypeSignature withInterfaces(List<ATypeName> value) {
    List<ATypeName> newValue = interfaces_from(value);
    if (this.interfaces == newValue) return this;
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        this.accessFlags,
        this.superClazz,
        newValue,
        this.innerClasses,
        this.fields,
        this.methods,
        this.uses,
        this.usage);
  }

  public ImmutableTypeSignature withInnerClasses(List<TypeSignature> value) {
    List<TypeSignature> newValue = innerClasses_from(value);
    if (this.innerClasses == newValue) return this;
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        this.accessFlags,
        this.superClazz,
        this.interfaces,
        newValue,
        this.fields,
        this.methods,
        this.uses,
        this.usage);
  }

  public ImmutableTypeSignature withFields(List<TypeSignature.Field> value) {
    List<TypeSignature.Field> newValue = fields_from(value);
    if (this.fields == newValue) return this;
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        this.accessFlags,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        newValue,
        this.methods,
        this.uses,
        this.usage);
  }

  public ImmutableTypeSignature withMethods(List<TypeSignature.Method> value) {
    List<TypeSignature.Method> newValue = methods_from(value);
    if (this.methods == newValue) return this;
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        this.accessFlags,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.fields,
        newValue,
        this.uses,
        this.usage);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeSignature#uses() uses} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uses
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTypeSignature withUses(TypeSignature.Uses value) {
    if (this.uses == value) return this;
    TypeSignature.Uses newValue = Objects.requireNonNull(value, "uses");
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        this.accessFlags,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.fields,
        this.methods,
        newValue,
        this.usage);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeSignature#usage() usage} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for usage
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTypeSignature withUsage(Usage value) {
    if (this.usage == value) return this;
    Usage newValue = Objects.requireNonNull(value, "usage");
    return new ImmutableTypeSignature(
        this.typeName,
        this.javaVersion,
        this.accessFlags,
        this.superClazz,
        this.interfaces,
        this.innerClasses,
        this.fields,
        this.methods,
        this.uses,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTypeSignature} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTypeSignature
        && equalTo((ImmutableTypeSignature) another);
  }

  private boolean equalTo(ImmutableTypeSignature another) {
    return typeName.equals(another.typeName)
        && javaVersion.equals(another.javaVersion)
        && this.accessFlags().equals(another.accessFlags())
        && Objects.equals(superClazz, another.superClazz)
        && this.interfaces().equals(another.interfaces())
        && this.innerClasses().equals(another.innerClasses())
        && this.fields().equals(another.fields())
        && this.methods().equals(another.methods())
        && uses.equals(another.uses)
        && usage.equals(another.usage);
  }

  /**
   * Computes a hash code from attributes: {@code typeName}, {@code javaVersion}, {@code accessFlags}, {@code superClazz}, {@code interfaces}, {@code innerClasses}, {@code fields}, {@code methods}, {@code uses}, {@code usage}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + typeName.hashCode();
    h += (h << 5) + javaVersion.hashCode();
    h += (h << 5) + (accessFlags().hashCode());
    h += (h << 5) + Objects.hashCode(superClazz);
    h += (h << 5) + (interfaces().hashCode());
    h += (h << 5) + (innerClasses().hashCode());
    h += (h << 5) + (fields().hashCode());
    h += (h << 5) + (methods().hashCode());
    h += (h << 5) + uses.hashCode();
    h += (h << 5) + usage.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code TypeSignature} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("TypeSignature")
        .omitNullValues()
        .add("typeName", typeName)
        .add("javaVersion", javaVersion)
        .add("accessFlags", accessFlags().toString())
        .add("superClazz", superClazz)
        .add("interfaces", interfaces().toString())
        .add("innerClasses", innerClasses().toString())
        .add("fields", fields().toString())
        .add("methods", methods().toString())
        .add("uses", uses)
        .add("usage", usage)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link TypeSignature} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable TypeSignature instance
   */
  public static ImmutableTypeSignature copyOf(TypeSignature instance) {
    if (instance instanceof ImmutableTypeSignature) {
      return (ImmutableTypeSignature) instance;
    }
    return ImmutableTypeSignature.builder()
        .from(instance)
        .build();
  }

  private static Set<AccessFlags> accessFlags_from(Set<AccessFlags> value) {
    return value;
  }

  private static List<ATypeName> interfaces_from(List<ATypeName> value) {
    return value;
  }

  private static List<TypeSignature> innerClasses_from(List<TypeSignature> value) {
    return value;
  }

  private static List<TypeSignature.Field> fields_from(List<TypeSignature.Field> value) {
    return value;
  }

  private static List<TypeSignature.Method> methods_from(List<TypeSignature.Method> value) {
    return value;
  }

  /**
   * Creates a builder for {@link ImmutableTypeSignature ImmutableTypeSignature}.
   * @param typeName {@code typeName} parameter
   * @return A new ImmutableTypeSignature builder
   */
  public static ImmutableTypeSignature.Builder builder(ATypeName typeName) {
    return new ImmutableTypeSignature.Builder(typeName);
  }

  static ImmutableTypeSignature.Builder builder() {
    return new ImmutableTypeSignature.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTypeSignature ImmutableTypeSignature}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TYPE_NAME = 0x1L;
    private static final long INIT_BIT_JAVA_VERSION = 0x2L;
    private static final long INIT_BIT_USES = 0x4L;
    private static final long INIT_BIT_USAGE = 0x8L;
    private long initBits = 0xfL;

    private Set<AccessFlags> accessFlags_set = HashSet.empty();
    private List<ATypeName> interfaces_list = List.empty();
    private List<TypeSignature> innerClasses_list = List.empty();
    private List<TypeSignature.Field> fields_list = List.empty();
    private List<TypeSignature.Method> methods_list = List.empty();
    private @Nullable ATypeName typeName;
    private @Nullable JavaVersion javaVersion;
    private @Nullable ATypeName superClazz;
    private @Nullable TypeSignature.Uses uses;
    private @Nullable Usage usage;

    private Builder(ATypeName typeName) {
      typeName(typeName);
    }

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code TypeSignature} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(TypeSignature instance) {
      Objects.requireNonNull(instance, "instance");
      typeName(instance.typeName());
      javaVersion(instance.javaVersion());
      accessFlags(instance.accessFlags());
      Optional<ATypeName> superClazzOptional = instance.superClazz();
      if (superClazzOptional.isPresent()) {
        superClazz(superClazzOptional);
      }
      interfaces(instance.interfaces());
      innerClasses(instance.innerClasses());
      fields(instance.fields());
      methods(instance.methods());
      uses(instance.uses());
      usage(instance.usage());
      return this;
    }

    /**
     * Initializes the value for the {@link TypeSignature#typeName() typeName} attribute.
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
     * Initializes the value for the {@link TypeSignature#javaVersion() javaVersion} attribute.
     * @param javaVersion The value for javaVersion 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder javaVersion(JavaVersion javaVersion) {
      this.javaVersion = Objects.requireNonNull(javaVersion, "javaVersion");
      initBits &= ~INIT_BIT_JAVA_VERSION;
      return this;
    }

    public Builder addAccessFlags(AccessFlags element) {
      this.accessFlags_set = this.accessFlags_set.add(element);
      return this;
    }

    public Builder addAllAccessFlags(Iterable<AccessFlags> element) {
      this.accessFlags_set = this.accessFlags_set.addAll(element);
      return this;
    }

    public Builder accessFlags(Set<AccessFlags> elements) {
      this.accessFlags_set = elements;
      return this;
    }

    public Builder setIterableAccessFlags(Iterable<AccessFlags> elements) {
      this.accessFlags_set = HashSet.ofAll(elements);
      return this;
    }

    /**
     * Initializes the optional value {@link TypeSignature#superClazz() superClazz} to superClazz.
     * @param superClazz The value for superClazz
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder superClazz(ATypeName superClazz) {
      this.superClazz = Objects.requireNonNull(superClazz, "superClazz");
      return this;
    }

    /**
     * Initializes the optional value {@link TypeSignature#superClazz() superClazz} to superClazz.
     * @param superClazz The value for superClazz
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder superClazz(Optional<? extends ATypeName> superClazz) {
      this.superClazz = superClazz.orElse(null);
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

    public Builder addInnerClasses(TypeSignature element) {
      this.innerClasses_list = this.innerClasses_list.append(element);
      return this;
    }

    public Builder addAllInnerClasses(Iterable<TypeSignature> element) {
      this.innerClasses_list = this.innerClasses_list.appendAll(element);
      return this;
    }

    public Builder innerClasses(List<TypeSignature> elements) {
      this.innerClasses_list = elements;
      return this;
    }

    public Builder setIterableInnerClasses(Iterable<TypeSignature> elements) {
      this.innerClasses_list = List.ofAll(elements);
      return this;
    }

    public Builder addFields(TypeSignature.Field element) {
      this.fields_list = this.fields_list.append(element);
      return this;
    }

    public Builder addAllFields(Iterable<TypeSignature.Field> element) {
      this.fields_list = this.fields_list.appendAll(element);
      return this;
    }

    public Builder fields(List<TypeSignature.Field> elements) {
      this.fields_list = elements;
      return this;
    }

    public Builder setIterableFields(Iterable<TypeSignature.Field> elements) {
      this.fields_list = List.ofAll(elements);
      return this;
    }

    public Builder addMethods(TypeSignature.Method element) {
      this.methods_list = this.methods_list.append(element);
      return this;
    }

    public Builder addAllMethods(Iterable<TypeSignature.Method> element) {
      this.methods_list = this.methods_list.appendAll(element);
      return this;
    }

    public Builder methods(List<TypeSignature.Method> elements) {
      this.methods_list = elements;
      return this;
    }

    public Builder setIterableMethods(Iterable<TypeSignature.Method> elements) {
      this.methods_list = List.ofAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link TypeSignature#uses() uses} attribute.
     * @param uses The value for uses 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder uses(TypeSignature.Uses uses) {
      this.uses = Objects.requireNonNull(uses, "uses");
      initBits &= ~INIT_BIT_USES;
      return this;
    }

    /**
     * Initializes the value for the {@link TypeSignature#usage() usage} attribute.
     * @param usage The value for usage 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder usage(Usage usage) {
      this.usage = Objects.requireNonNull(usage, "usage");
      initBits &= ~INIT_BIT_USAGE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableTypeSignature ImmutableTypeSignature}.
     * @return An immutable instance of TypeSignature
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTypeSignature build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableTypeSignature(
          typeName,
          javaVersion,
          this.accessFlags_set,
          superClazz,
          this.interfaces_list,
          this.innerClasses_list,
          this.fields_list,
          this.methods_list,
          uses,
          usage);
    }

    private String formatRequiredAttributesMessage() {
      java.util.List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TYPE_NAME) != 0) attributes.add("typeName");
      if ((initBits & INIT_BIT_JAVA_VERSION) != 0) attributes.add("javaVersion");
      if ((initBits & INIT_BIT_USES) != 0) attributes.add("uses");
      if ((initBits & INIT_BIT_USAGE) != 0) attributes.add("usage");
      return "Cannot build TypeSignature, some of required attributes are not set " + attributes;
    }
  }
}
