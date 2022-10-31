package com.climatiq.api.client.flights.types;

import com.climatiq.api.client.estimation.types.EstimateResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = TripEmissions.Builder.class
)
public final class TripEmissions {
  private final double co2E;

  private final String cot2EUnit;

  private final List<EstimateResponse> legs;

  private int _cachedHashCode;

  TripEmissions(double co2E, String cot2EUnit, List<EstimateResponse> legs) {
    this.co2E = co2E;
    this.cot2EUnit = cot2EUnit;
    this.legs = legs;
  }

  @JsonProperty("co2e")
  public double getCo2E() {
    return co2E;
  }

  @JsonProperty("cot2e_unit")
  public String getCot2EUnit() {
    return cot2EUnit;
  }

  @JsonProperty("legs")
  public List<EstimateResponse> getLegs() {
    return legs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof TripEmissions && equalTo((TripEmissions) other);
  }

  private boolean equalTo(TripEmissions other) {
    return co2E == other.co2E && cot2EUnit.equals(other.cot2EUnit) && legs.equals(other.legs);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.co2E, this.cot2EUnit, this.legs);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "TripEmissions{" + "co2E: " + co2E + ", cot2EUnit: " + cot2EUnit + ", legs: " + legs + "}";
  }

  public static Co2EStage builder() {
    return new Builder();
  }

  public interface Co2EStage {
    Cot2EUnitStage co2E(double co2E);

    Builder from(TripEmissions other);
  }

  public interface Cot2EUnitStage {
    _FinalStage cot2EUnit(String cot2EUnit);
  }

  public interface _FinalStage {
    TripEmissions build();

    _FinalStage legs(List<EstimateResponse> legs);

    _FinalStage legs(EstimateResponse legs);

    _FinalStage addAllLegs(List<EstimateResponse> legs);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements Co2EStage, Cot2EUnitStage, _FinalStage {
    private double co2E;

    private String cot2EUnit;

    private List<EstimateResponse> legs = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(TripEmissions other) {
      co2E(other.getCo2E());
      cot2EUnit(other.getCot2EUnit());
      legs(other.getLegs());
      return this;
    }

    @Override
    @JsonSetter("co2e")
    public Cot2EUnitStage co2E(double co2E) {
      this.co2E = co2E;
      return this;
    }

    @Override
    @JsonSetter("cot2e_unit")
    public _FinalStage cot2EUnit(String cot2EUnit) {
      this.cot2EUnit = cot2EUnit;
      return this;
    }

    @Override
    public _FinalStage addAllLegs(List<EstimateResponse> legs) {
      this.legs.addAll(legs);
      return this;
    }

    @Override
    public _FinalStage legs(EstimateResponse legs) {
      this.legs.add(legs);
      return this;
    }

    @Override
    @JsonSetter(
        value = "legs",
        nulls = Nulls.SKIP
    )
    public _FinalStage legs(List<EstimateResponse> legs) {
      this.legs.clear();
      this.legs.addAll(legs);
      return this;
    }

    @Override
    public TripEmissions build() {
      return new TripEmissions(co2E, cot2EUnit, legs);
    }
  }
}
