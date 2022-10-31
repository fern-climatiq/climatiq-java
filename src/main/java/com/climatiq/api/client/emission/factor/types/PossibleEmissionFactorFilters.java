package com.climatiq.api.client.emission.factor.types;

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
    builder = PossibleEmissionFactorFilters.Builder.class
)
public final class PossibleEmissionFactorFilters {
  private final List<String> year;

  private final List<String> source;

  private final List<Region> region;

  private final List<String> category;

  private final List<String> sector;

  private final List<String> unitType;

  private int _cachedHashCode;

  PossibleEmissionFactorFilters(List<String> year, List<String> source, List<Region> region,
      List<String> category, List<String> sector, List<String> unitType) {
    this.year = year;
    this.source = source;
    this.region = region;
    this.category = category;
    this.sector = sector;
    this.unitType = unitType;
  }

  @JsonProperty("year")
  public List<String> getYear() {
    return year;
  }

  @JsonProperty("source")
  public List<String> getSource() {
    return source;
  }

  @JsonProperty("region")
  public List<Region> getRegion() {
    return region;
  }

  @JsonProperty("category")
  public List<String> getCategory() {
    return category;
  }

  @JsonProperty("sector")
  public List<String> getSector() {
    return sector;
  }

  @JsonProperty("unit_type")
  public List<String> getUnitType() {
    return unitType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PossibleEmissionFactorFilters && equalTo((PossibleEmissionFactorFilters) other);
  }

  private boolean equalTo(PossibleEmissionFactorFilters other) {
    return year.equals(other.year) && source.equals(other.source) && region.equals(other.region) && category.equals(other.category) && sector.equals(other.sector) && unitType.equals(other.unitType);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.year, this.source, this.region, this.category, this.sector, this.unitType);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PossibleEmissionFactorFilters{" + "year: " + year + ", source: " + source + ", region: " + region + ", category: " + category + ", sector: " + sector + ", unitType: " + unitType + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<String> year = new ArrayList<>();

    private List<String> source = new ArrayList<>();

    private List<Region> region = new ArrayList<>();

    private List<String> category = new ArrayList<>();

    private List<String> sector = new ArrayList<>();

    private List<String> unitType = new ArrayList<>();

    private Builder() {
    }

    public Builder from(PossibleEmissionFactorFilters other) {
      year(other.getYear());
      source(other.getSource());
      region(other.getRegion());
      category(other.getCategory());
      sector(other.getSector());
      unitType(other.getUnitType());
      return this;
    }

    @JsonSetter(
        value = "year",
        nulls = Nulls.SKIP
    )
    public Builder year(List<String> year) {
      this.year.clear();
      this.year.addAll(year);
      return this;
    }

    public Builder year(String year) {
      this.year.add(year);
      return this;
    }

    public Builder addAllYear(List<String> year) {
      this.year.addAll(year);
      return this;
    }

    @JsonSetter(
        value = "source",
        nulls = Nulls.SKIP
    )
    public Builder source(List<String> source) {
      this.source.clear();
      this.source.addAll(source);
      return this;
    }

    public Builder source(String source) {
      this.source.add(source);
      return this;
    }

    public Builder addAllSource(List<String> source) {
      this.source.addAll(source);
      return this;
    }

    @JsonSetter(
        value = "region",
        nulls = Nulls.SKIP
    )
    public Builder region(List<Region> region) {
      this.region.clear();
      this.region.addAll(region);
      return this;
    }

    public Builder region(Region region) {
      this.region.add(region);
      return this;
    }

    public Builder addAllRegion(List<Region> region) {
      this.region.addAll(region);
      return this;
    }

    @JsonSetter(
        value = "category",
        nulls = Nulls.SKIP
    )
    public Builder category(List<String> category) {
      this.category.clear();
      this.category.addAll(category);
      return this;
    }

    public Builder category(String category) {
      this.category.add(category);
      return this;
    }

    public Builder addAllCategory(List<String> category) {
      this.category.addAll(category);
      return this;
    }

    @JsonSetter(
        value = "sector",
        nulls = Nulls.SKIP
    )
    public Builder sector(List<String> sector) {
      this.sector.clear();
      this.sector.addAll(sector);
      return this;
    }

    public Builder sector(String sector) {
      this.sector.add(sector);
      return this;
    }

    public Builder addAllSector(List<String> sector) {
      this.sector.addAll(sector);
      return this;
    }

    @JsonSetter(
        value = "unit_type",
        nulls = Nulls.SKIP
    )
    public Builder unitType(List<String> unitType) {
      this.unitType.clear();
      this.unitType.addAll(unitType);
      return this;
    }

    public Builder unitType(String unitType) {
      this.unitType.add(unitType);
      return this;
    }

    public Builder addAllUnitType(List<String> unitType) {
      this.unitType.addAll(unitType);
      return this;
    }

    public PossibleEmissionFactorFilters build() {
      return new PossibleEmissionFactorFilters(year, source, region, category, sector, unitType);
    }
  }
}
