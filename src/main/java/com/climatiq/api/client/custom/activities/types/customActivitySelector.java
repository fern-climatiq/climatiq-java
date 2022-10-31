package com.climatiq.api.client.custom.activities.types;

import com.climatiq.api.client.estimation.types.CalculationMethod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = customActivitySelector.Builder.class
)
public final class customActivitySelector {
  private final String label;

  private final Optional<String> source;

  private final Optional<String> region;

  private final Optional<Boolean> regionFallback;

  private final Optional<String> year;

  private final Optional<String> lcaActivity;

  private final Optional<CalculationMethod> calculationMethod;

  private int _cachedHashCode;

  customActivitySelector(String label, Optional<String> source, Optional<String> region,
      Optional<Boolean> regionFallback, Optional<String> year, Optional<String> lcaActivity,
      Optional<CalculationMethod> calculationMethod) {
    this.label = label;
    this.source = source;
    this.region = region;
    this.regionFallback = regionFallback;
    this.year = year;
    this.lcaActivity = lcaActivity;
    this.calculationMethod = calculationMethod;
  }

  @JsonProperty("label")
  public String getLabel() {
    return label;
  }

  @JsonProperty("source")
  public Optional<String> getSource() {
    return source;
  }

  @JsonProperty("region")
  public Optional<String> getRegion() {
    return region;
  }

  @JsonProperty("region_fallback")
  public Optional<Boolean> getRegionFallback() {
    return regionFallback;
  }

  @JsonProperty("year")
  public Optional<String> getYear() {
    return year;
  }

  @JsonProperty("lca_activity")
  public Optional<String> getLcaActivity() {
    return lcaActivity;
  }

  @JsonProperty("calculation_method")
  public Optional<CalculationMethod> getCalculationMethod() {
    return calculationMethod;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof customActivitySelector && equalTo((customActivitySelector) other);
  }

  private boolean equalTo(customActivitySelector other) {
    return label.equals(other.label) && source.equals(other.source) && region.equals(other.region) && regionFallback.equals(other.regionFallback) && year.equals(other.year) && lcaActivity.equals(other.lcaActivity) && calculationMethod.equals(other.calculationMethod);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.label, this.source, this.region, this.regionFallback, this.year, this.lcaActivity, this.calculationMethod);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "customActivitySelector{" + "label: " + label + ", source: " + source + ", region: " + region + ", regionFallback: " + regionFallback + ", year: " + year + ", lcaActivity: " + lcaActivity + ", calculationMethod: " + calculationMethod + "}";
  }

  public static LabelStage builder() {
    return new Builder();
  }

  public interface LabelStage {
    _FinalStage label(String label);

    Builder from(customActivitySelector other);
  }

  public interface _FinalStage {
    customActivitySelector build();

    _FinalStage source(Optional<String> source);

    _FinalStage source(String source);

    _FinalStage region(Optional<String> region);

    _FinalStage region(String region);

    _FinalStage regionFallback(Optional<Boolean> regionFallback);

    _FinalStage regionFallback(Boolean regionFallback);

    _FinalStage year(Optional<String> year);

    _FinalStage year(String year);

    _FinalStage lcaActivity(Optional<String> lcaActivity);

    _FinalStage lcaActivity(String lcaActivity);

    _FinalStage calculationMethod(Optional<CalculationMethod> calculationMethod);

    _FinalStage calculationMethod(CalculationMethod calculationMethod);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements LabelStage, _FinalStage {
    private String label;

    private Optional<CalculationMethod> calculationMethod = Optional.empty();

    private Optional<String> lcaActivity = Optional.empty();

    private Optional<String> year = Optional.empty();

    private Optional<Boolean> regionFallback = Optional.empty();

    private Optional<String> region = Optional.empty();

    private Optional<String> source = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(customActivitySelector other) {
      label(other.getLabel());
      source(other.getSource());
      region(other.getRegion());
      regionFallback(other.getRegionFallback());
      year(other.getYear());
      lcaActivity(other.getLcaActivity());
      calculationMethod(other.getCalculationMethod());
      return this;
    }

    @Override
    @JsonSetter("label")
    public _FinalStage label(String label) {
      this.label = label;
      return this;
    }

    @Override
    public _FinalStage calculationMethod(CalculationMethod calculationMethod) {
      this.calculationMethod = Optional.of(calculationMethod);
      return this;
    }

    @Override
    @JsonSetter(
        value = "calculation_method",
        nulls = Nulls.SKIP
    )
    public _FinalStage calculationMethod(Optional<CalculationMethod> calculationMethod) {
      this.calculationMethod = calculationMethod;
      return this;
    }

    @Override
    public _FinalStage lcaActivity(String lcaActivity) {
      this.lcaActivity = Optional.of(lcaActivity);
      return this;
    }

    @Override
    @JsonSetter(
        value = "lca_activity",
        nulls = Nulls.SKIP
    )
    public _FinalStage lcaActivity(Optional<String> lcaActivity) {
      this.lcaActivity = lcaActivity;
      return this;
    }

    @Override
    public _FinalStage year(String year) {
      this.year = Optional.of(year);
      return this;
    }

    @Override
    @JsonSetter(
        value = "year",
        nulls = Nulls.SKIP
    )
    public _FinalStage year(Optional<String> year) {
      this.year = year;
      return this;
    }

    @Override
    public _FinalStage regionFallback(Boolean regionFallback) {
      this.regionFallback = Optional.of(regionFallback);
      return this;
    }

    @Override
    @JsonSetter(
        value = "region_fallback",
        nulls = Nulls.SKIP
    )
    public _FinalStage regionFallback(Optional<Boolean> regionFallback) {
      this.regionFallback = regionFallback;
      return this;
    }

    @Override
    public _FinalStage region(String region) {
      this.region = Optional.of(region);
      return this;
    }

    @Override
    @JsonSetter(
        value = "region",
        nulls = Nulls.SKIP
    )
    public _FinalStage region(Optional<String> region) {
      this.region = region;
      return this;
    }

    @Override
    public _FinalStage source(String source) {
      this.source = Optional.of(source);
      return this;
    }

    @Override
    @JsonSetter(
        value = "source",
        nulls = Nulls.SKIP
    )
    public _FinalStage source(Optional<String> source) {
      this.source = source;
      return this;
    }

    @Override
    public customActivitySelector build() {
      return new customActivitySelector(label, source, region, regionFallback, year, lcaActivity, calculationMethod);
    }
  }
}
