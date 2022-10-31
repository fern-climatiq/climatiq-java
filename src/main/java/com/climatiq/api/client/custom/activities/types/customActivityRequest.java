package com.climatiq.api.client.custom.activities.types;

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
import java.util.Optional;

@JsonDeserialize(
    builder = customActivityRequest.Builder.class
)
public final class customActivityRequest {
  private final customActivitySelector customActivity;

  private final Map<String, Optional<Object>> parameters;

  private int _cachedHashCode;

  customActivityRequest(customActivitySelector customActivity,
      Map<String, Optional<Object>> parameters) {
    this.customActivity = customActivity;
    this.parameters = parameters;
  }

  @JsonProperty("custom_activity")
  public customActivitySelector getCustomActivity() {
    return customActivity;
  }

  @JsonProperty("parameters")
  public Map<String, Optional<Object>> getParameters() {
    return parameters;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof customActivityRequest && equalTo((customActivityRequest) other);
  }

  private boolean equalTo(customActivityRequest other) {
    return customActivity.equals(other.customActivity) && parameters.equals(other.parameters);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.customActivity, this.parameters);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "customActivityRequest{" + "customActivity: " + customActivity + ", parameters: " + parameters + "}";
  }

  public static CustomActivityStage builder() {
    return new Builder();
  }

  public interface CustomActivityStage {
    _FinalStage customActivity(customActivitySelector customActivity);

    Builder from(customActivityRequest other);
  }

  public interface _FinalStage {
    customActivityRequest build();

    _FinalStage parameters(Map<String, Optional<Object>> parameters);

    _FinalStage putAllParameters(Map<String, Optional<Object>> parameters);

    _FinalStage parameters(String key, Optional<Object> value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements CustomActivityStage, _FinalStage {
    private customActivitySelector customActivity;

    private Map<String, Optional<Object>> parameters = new LinkedHashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(customActivityRequest other) {
      customActivity(other.getCustomActivity());
      parameters(other.getParameters());
      return this;
    }

    @Override
    @JsonSetter("custom_activity")
    public _FinalStage customActivity(customActivitySelector customActivity) {
      this.customActivity = customActivity;
      return this;
    }

    @Override
    public _FinalStage parameters(String key, Optional<Object> value) {
      this.parameters.put(key, value);
      return this;
    }

    @Override
    public _FinalStage putAllParameters(Map<String, Optional<Object>> parameters) {
      this.parameters.putAll(parameters);
      return this;
    }

    @Override
    @JsonSetter(
        value = "parameters",
        nulls = Nulls.SKIP
    )
    public _FinalStage parameters(Map<String, Optional<Object>> parameters) {
      this.parameters.clear();
      this.parameters.putAll(parameters);
      return this;
    }

    @Override
    public customActivityRequest build() {
      return new customActivityRequest(customActivity, parameters);
    }
  }
}
