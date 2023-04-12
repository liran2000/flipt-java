package com.flipt.api.resources.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Namespace.Builder.class
)
public final class Namespace {
  private final String key;

  private final String name;

  private final String description;

  private final boolean protected_;

  private final String createdAt;

  private final String updatedAt;

  private int _cachedHashCode;

  Namespace(String key, String name, String description, boolean protected_, String createdAt,
      String updatedAt) {
    this.key = key;
    this.name = name;
    this.description = description;
    this.protected_ = protected_;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @JsonProperty("key")
  public String getKey() {
    return key;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("protected")
  public boolean getProtected() {
    return protected_;
  }

  @JsonProperty("createdAt")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updatedAt")
  public String getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Namespace && equalTo((Namespace) other);
  }

  private boolean equalTo(Namespace other) {
    return key.equals(other.key) && name.equals(other.name) && description.equals(other.description) && protected_ == other.protected_ && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.key, this.name, this.description, this.protected_, this.createdAt, this.updatedAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Namespace{" + "key: " + key + ", name: " + name + ", description: " + description + ", protected_: " + protected_ + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + "}";
  }

  public static KeyStage builder() {
    return new Builder();
  }

  public interface KeyStage {
    NameStage key(String key);

    Builder from(Namespace other);
  }

  public interface NameStage {
    DescriptionStage name(String name);
  }

  public interface DescriptionStage {
    ProtectedStage description(String description);
  }

  public interface ProtectedStage {
    CreatedAtStage protected_(boolean protected_);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    _FinalStage updatedAt(String updatedAt);
  }

  public interface _FinalStage {
    Namespace build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements KeyStage, NameStage, DescriptionStage, ProtectedStage, CreatedAtStage, UpdatedAtStage, _FinalStage {
    private String key;

    private String name;

    private String description;

    private boolean protected_;

    private String createdAt;

    private String updatedAt;

    private Builder() {
    }

    @Override
    public Builder from(Namespace other) {
      key(other.getKey());
      name(other.getName());
      description(other.getDescription());
      protected_(other.getProtected());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      return this;
    }

    @Override
    @JsonSetter("key")
    public NameStage key(String key) {
      this.key = key;
      return this;
    }

    @Override
    @JsonSetter("name")
    public DescriptionStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("description")
    public ProtectedStage description(String description) {
      this.description = description;
      return this;
    }

    @Override
    @JsonSetter("protected")
    public CreatedAtStage protected_(boolean protected_) {
      this.protected_ = protected_;
      return this;
    }

    @Override
    @JsonSetter("createdAt")
    public UpdatedAtStage createdAt(String createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    @Override
    @JsonSetter("updatedAt")
    public _FinalStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    public Namespace build() {
      return new Namespace(key, name, description, protected_, createdAt, updatedAt);
    }
  }
}
