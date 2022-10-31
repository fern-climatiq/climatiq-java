package com.climatiq.api.client.classifications.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonDeserialize(
    builder = ClassificationRequest.Builder.class
)
public final class ClassificationRequest {
  private final ClassificationSelector classification;

  private final Map<String, String> parameters;

  private int _cachedHashCode;

  ClassificationRequest(ClassificationSelector classification, Map<String, String> parameters) {
    this.classification = classification;
    this.parameters = parameters;
  }

  @JsonProperty("classification")
  public ClassificationSelector getClassification() {
    return classification;
  }

  @JsonProperty("parameters")
  public Map<String, String> getParameters() {
    return parameters;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ClassificationRequest && equalTo((ClassificationRequest) other);
  }

  private boolean equalTo(ClassificationRequest other) {
    return classification.equals(other.classification) && parameters.equals(other.parameters);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.classification, this.parameters);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ClassificationRequest{" + "classification: " + classification + ", parameters: " + parameters + "}";
  }

  public static ClassificationStage builder() {
    return new Builder();
  }

  public interface ClassificationStage {
    _FinalStage classification(ClassificationSelector classification);

    Builder from(ClassificationRequest other);
  }

  public interface _FinalStage {
    ClassificationRequest build();

    _FinalStage parameters(Map<String, String> parameters);

    _FinalStage putAllParameters(Map<String, String> parameters);

    _FinalStage parameters(String key, String value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements ClassificationStage, _FinalStage {
    private ClassificationSelector classification;

    private Map<String, String> parameters = new LinkedHashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(ClassificationRequest other) {
      classification(other.getClassification());
      parameters(other.getParameters());
      return this;
    }

    @Override
    @JsonSetter("classification")
    public _FinalStage classification(ClassificationSelector classification) {
      this.classification = classification;
      return this;
    }

    @Override
    public _FinalStage parameters(String key, String value) {
      this.parameters.put(key, value);
      return this;
    }

    @Override
    public _FinalStage putAllParameters(Map<String, String> parameters) {
      this.parameters.putAll(parameters);
      return this;
    }

    @Override
    @JsonSetter(
        value = "parameters",
        nulls = Nulls.SKIP
    )
    public _FinalStage parameters(Map<String, String> parameters) {
      this.parameters.clear();
      this.parameters.putAll(parameters);
      return this;
    }

    @Override
    public ClassificationRequest build() {
      return new ClassificationRequest(classification, parameters);
    }
  }
}
