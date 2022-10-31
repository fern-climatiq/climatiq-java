package com.climatiq.api.client.estimation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = EstimateResponse.Builder.class
)
public final class EstimateResponse {
  private final double co2E;

  private final String co2EUnit;

  private final String co2ECalculationMethod;

  private final String co2ECalculationOrigin;

  private final UsedEmissionFactor emissionFactor;

  private final ConstituentGases constituentGases;

  private int _cachedHashCode;

  EstimateResponse(double co2E, String co2EUnit, String co2ECalculationMethod,
      String co2ECalculationOrigin, UsedEmissionFactor emissionFactor,
      ConstituentGases constituentGases) {
    this.co2E = co2E;
    this.co2EUnit = co2EUnit;
    this.co2ECalculationMethod = co2ECalculationMethod;
    this.co2ECalculationOrigin = co2ECalculationOrigin;
    this.emissionFactor = emissionFactor;
    this.constituentGases = constituentGases;
  }

  @JsonProperty("co2e")
  public double getCo2E() {
    return co2E;
  }

  @JsonProperty("co2e_unit")
  public String getCo2EUnit() {
    return co2EUnit;
  }

  @JsonProperty("co2e_calculation_method")
  public String getCo2ECalculationMethod() {
    return co2ECalculationMethod;
  }

  @JsonProperty("co2e_calculation_origin")
  public String getCo2ECalculationOrigin() {
    return co2ECalculationOrigin;
  }

  @JsonProperty("emission_factor")
  public UsedEmissionFactor getEmissionFactor() {
    return emissionFactor;
  }

  @JsonProperty("constituent_gases")
  public ConstituentGases getConstituentGases() {
    return constituentGases;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EstimateResponse && equalTo((EstimateResponse) other);
  }

  private boolean equalTo(EstimateResponse other) {
    return co2E == other.co2E && co2EUnit.equals(other.co2EUnit) && co2ECalculationMethod.equals(other.co2ECalculationMethod) && co2ECalculationOrigin.equals(other.co2ECalculationOrigin) && emissionFactor.equals(other.emissionFactor) && constituentGases.equals(other.constituentGases);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.co2E, this.co2EUnit, this.co2ECalculationMethod, this.co2ECalculationOrigin, this.emissionFactor, this.constituentGases);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EstimateResponse{" + "co2E: " + co2E + ", co2EUnit: " + co2EUnit + ", co2ECalculationMethod: " + co2ECalculationMethod + ", co2ECalculationOrigin: " + co2ECalculationOrigin + ", emissionFactor: " + emissionFactor + ", constituentGases: " + constituentGases + "}";
  }

  public static Co2EStage builder() {
    return new Builder();
  }

  public interface Co2EStage {
    Co2EUnitStage co2E(double co2E);

    Builder from(EstimateResponse other);
  }

  public interface Co2EUnitStage {
    Co2ECalculationMethodStage co2EUnit(String co2EUnit);
  }

  public interface Co2ECalculationMethodStage {
    Co2ECalculationOriginStage co2ECalculationMethod(String co2ECalculationMethod);
  }

  public interface Co2ECalculationOriginStage {
    EmissionFactorStage co2ECalculationOrigin(String co2ECalculationOrigin);
  }

  public interface EmissionFactorStage {
    ConstituentGasesStage emissionFactor(UsedEmissionFactor emissionFactor);
  }

  public interface ConstituentGasesStage {
    _FinalStage constituentGases(ConstituentGases constituentGases);
  }

  public interface _FinalStage {
    EstimateResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements Co2EStage, Co2EUnitStage, Co2ECalculationMethodStage, Co2ECalculationOriginStage, EmissionFactorStage, ConstituentGasesStage, _FinalStage {
    private double co2E;

    private String co2EUnit;

    private String co2ECalculationMethod;

    private String co2ECalculationOrigin;

    private UsedEmissionFactor emissionFactor;

    private ConstituentGases constituentGases;

    private Builder() {
    }

    @Override
    public Builder from(EstimateResponse other) {
      co2E(other.getCo2E());
      co2EUnit(other.getCo2EUnit());
      co2ECalculationMethod(other.getCo2ECalculationMethod());
      co2ECalculationOrigin(other.getCo2ECalculationOrigin());
      emissionFactor(other.getEmissionFactor());
      constituentGases(other.getConstituentGases());
      return this;
    }

    @Override
    @JsonSetter("co2e")
    public Co2EUnitStage co2E(double co2E) {
      this.co2E = co2E;
      return this;
    }

    @Override
    @JsonSetter("co2e_unit")
    public Co2ECalculationMethodStage co2EUnit(String co2EUnit) {
      this.co2EUnit = co2EUnit;
      return this;
    }

    @Override
    @JsonSetter("co2e_calculation_method")
    public Co2ECalculationOriginStage co2ECalculationMethod(String co2ECalculationMethod) {
      this.co2ECalculationMethod = co2ECalculationMethod;
      return this;
    }

    @Override
    @JsonSetter("co2e_calculation_origin")
    public EmissionFactorStage co2ECalculationOrigin(String co2ECalculationOrigin) {
      this.co2ECalculationOrigin = co2ECalculationOrigin;
      return this;
    }

    @Override
    @JsonSetter("emission_factor")
    public ConstituentGasesStage emissionFactor(UsedEmissionFactor emissionFactor) {
      this.emissionFactor = emissionFactor;
      return this;
    }

    @Override
    @JsonSetter("constituent_gases")
    public _FinalStage constituentGases(ConstituentGases constituentGases) {
      this.constituentGases = constituentGases;
      return this;
    }

    @Override
    public EstimateResponse build() {
      return new EstimateResponse(co2E, co2EUnit, co2ECalculationMethod, co2ECalculationOrigin, emissionFactor, constituentGases);
    }
  }
}
