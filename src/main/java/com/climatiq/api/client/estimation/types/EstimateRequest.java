package com.climatiq.api.client.estimation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = EstimateRequest.Builder.class
)
public final class EstimateRequest {
  private final EmissionSelector emissionFactor;

  private final Optional<Object> parameters;

  private int _cachedHashCode;

  EstimateRequest(EmissionSelector emissionFactor, Optional<Object> parameters) {
    this.emissionFactor = emissionFactor;
    this.parameters = parameters;
  }

  @JsonProperty("emission_factor")
  public EmissionSelector getEmissionFactor() {
    return emissionFactor;
  }

  @JsonProperty("parameters")
  public Optional<Object> getParameters() {
    return parameters;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EstimateRequest && equalTo((EstimateRequest) other);
  }

  private boolean equalTo(EstimateRequest other) {
    return emissionFactor.equals(other.emissionFactor) && parameters.equals(other.parameters);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.emissionFactor, this.parameters);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EstimateRequest{" + "emissionFactor: " + emissionFactor + ", parameters: " + parameters + "}";
  }

  public static EmissionFactorStage builder() {
    return new Builder();
  }

  public interface EmissionFactorStage {
    _FinalStage emissionFactor(EmissionSelector emissionFactor);

    Builder from(EstimateRequest other);
  }

  public interface _FinalStage {
    EstimateRequest build();

    _FinalStage parameters(Optional<Object> parameters);

    _FinalStage parameters(Object parameters);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements EmissionFactorStage, _FinalStage {
    private EmissionSelector emissionFactor;

    private Optional<Object> parameters = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(EstimateRequest other) {
      emissionFactor(other.getEmissionFactor());
      parameters(other.getParameters());
      return this;
    }

    @Override
    @JsonSetter("emission_factor")
    public _FinalStage emissionFactor(EmissionSelector emissionFactor) {
      this.emissionFactor = emissionFactor;
      return this;
    }

    @Override
    public _FinalStage parameters(Object parameters) {
      this.parameters = Optional.of(parameters);
      return this;
    }

    @Override
    @JsonSetter(
        value = "parameters",
        nulls = Nulls.SKIP
    )
    public _FinalStage parameters(Optional<Object> parameters) {
      this.parameters = parameters;
      return this;
    }

    @Override
    public EstimateRequest build() {
      return new EstimateRequest(emissionFactor, parameters);
    }
  }
}
