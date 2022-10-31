package com.climatiq.api.client.flights.types;

import com.climatiq.api.client.estimation.types.EmissionSelector;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = FreightLeg.Builder.class
)
public final class FreightLeg implements IBaseLeg {
  private final String from;

  private final String to;

  private final double weight;

  private final String weightUnit;

  private final EmissionSelector emissionFactor;

  private int _cachedHashCode;

  FreightLeg(String from, String to, double weight, String weightUnit,
      EmissionSelector emissionFactor) {
    this.from = from;
    this.to = to;
    this.weight = weight;
    this.weightUnit = weightUnit;
    this.emissionFactor = emissionFactor;
  }

  @JsonProperty("from")
  @Override
  public String getFrom() {
    return from;
  }

  @JsonProperty("to")
  @Override
  public String getTo() {
    return to;
  }

  @JsonProperty("weight")
  public double getWeight() {
    return weight;
  }

  @JsonProperty("weight_unit")
  public String getWeightUnit() {
    return weightUnit;
  }

  @JsonProperty("emission_factor")
  public EmissionSelector getEmissionFactor() {
    return emissionFactor;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FreightLeg && equalTo((FreightLeg) other);
  }

  private boolean equalTo(FreightLeg other) {
    return from.equals(other.from) && to.equals(other.to) && weight == other.weight && weightUnit.equals(other.weightUnit) && emissionFactor.equals(other.emissionFactor);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.from, this.to, this.weight, this.weightUnit, this.emissionFactor);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FreightLeg{" + "from: " + from + ", to: " + to + ", weight: " + weight + ", weightUnit: " + weightUnit + ", emissionFactor: " + emissionFactor + "}";
  }

  public static FromStage builder() {
    return new Builder();
  }

  public interface FromStage {
    ToStage from(String from);

    Builder from(FreightLeg other);
  }

  public interface ToStage {
    WeightStage to(String to);
  }

  public interface WeightStage {
    WeightUnitStage weight(double weight);
  }

  public interface WeightUnitStage {
    EmissionFactorStage weightUnit(String weightUnit);
  }

  public interface EmissionFactorStage {
    _FinalStage emissionFactor(EmissionSelector emissionFactor);
  }

  public interface _FinalStage {
    FreightLeg build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements FromStage, ToStage, WeightStage, WeightUnitStage, EmissionFactorStage, _FinalStage {
    private String from;

    private String to;

    private double weight;

    private String weightUnit;

    private EmissionSelector emissionFactor;

    private Builder() {
    }

    @Override
    public Builder from(FreightLeg other) {
      from(other.getFrom());
      to(other.getTo());
      weight(other.getWeight());
      weightUnit(other.getWeightUnit());
      emissionFactor(other.getEmissionFactor());
      return this;
    }

    @Override
    @JsonSetter("from")
    public ToStage from(String from) {
      this.from = from;
      return this;
    }

    @Override
    @JsonSetter("to")
    public WeightStage to(String to) {
      this.to = to;
      return this;
    }

    @Override
    @JsonSetter("weight")
    public WeightUnitStage weight(double weight) {
      this.weight = weight;
      return this;
    }

    @Override
    @JsonSetter("weight_unit")
    public EmissionFactorStage weightUnit(String weightUnit) {
      this.weightUnit = weightUnit;
      return this;
    }

    @Override
    @JsonSetter("emission_factor")
    public _FinalStage emissionFactor(EmissionSelector emissionFactor) {
      this.emissionFactor = emissionFactor;
      return this;
    }

    @Override
    public FreightLeg build() {
      return new FreightLeg(from, to, weight, weightUnit, emissionFactor);
    }
  }
}
