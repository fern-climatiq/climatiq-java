package com.climatiq.api.client.emission.factor.types;

import com.climatiq.api.client.estimation.types.CalculationMethod;
import com.climatiq.api.client.estimation.types.ConstituentGases;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = EmissionFactor.Builder.class
)
public final class EmissionFactor {
  private final String uuid;

  private final String activityId;

  private final String id;

  private final String accessType;

  private final String name;

  private final String category;

  private final String sector;

  private final String source;

  private final String sourceLink;

  private final Optional<Double> uncertainty;

  private final String year;

  private final String region;

  private final String regionName;

  private final String description;

  private final List<String> unitType;

  private final String unit;

  private final String lcaActivity;

  private final List<String> supportedCalculationMethods;

  private final double factor;

  private final CalculationMethod factorCalculationMethod;

  private final FactorCalculationOrigin factorCalculationOrigin;

  private final ConstituentGases constituentGases;

  private int _cachedHashCode;

  EmissionFactor(String uuid, String activityId, String id, String accessType, String name,
      String category, String sector, String source, String sourceLink,
      Optional<Double> uncertainty, String year, String region, String regionName,
      String description, List<String> unitType, String unit, String lcaActivity,
      List<String> supportedCalculationMethods, double factor,
      CalculationMethod factorCalculationMethod, FactorCalculationOrigin factorCalculationOrigin,
      ConstituentGases constituentGases) {
    this.uuid = uuid;
    this.activityId = activityId;
    this.id = id;
    this.accessType = accessType;
    this.name = name;
    this.category = category;
    this.sector = sector;
    this.source = source;
    this.sourceLink = sourceLink;
    this.uncertainty = uncertainty;
    this.year = year;
    this.region = region;
    this.regionName = regionName;
    this.description = description;
    this.unitType = unitType;
    this.unit = unit;
    this.lcaActivity = lcaActivity;
    this.supportedCalculationMethods = supportedCalculationMethods;
    this.factor = factor;
    this.factorCalculationMethod = factorCalculationMethod;
    this.factorCalculationOrigin = factorCalculationOrigin;
    this.constituentGases = constituentGases;
  }

  @JsonProperty("uuid")
  public String getUuid() {
    return uuid;
  }

  @JsonProperty("activity_id")
  public String getActivityId() {
    return activityId;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("access_type")
  public String getAccessType() {
    return accessType;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  @JsonProperty("sector")
  public String getSector() {
    return sector;
  }

  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  @JsonProperty("source_link")
  public String getSourceLink() {
    return sourceLink;
  }

  @JsonProperty("uncertainty")
  public Optional<Double> getUncertainty() {
    return uncertainty;
  }

  @JsonProperty("year")
  public String getYear() {
    return year;
  }

  @JsonProperty("region")
  public String getRegion() {
    return region;
  }

  @JsonProperty("region_name")
  public String getRegionName() {
    return regionName;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("unit_type")
  public List<String> getUnitType() {
    return unitType;
  }

  @JsonProperty("unit")
  public String getUnit() {
    return unit;
  }

  @JsonProperty("lca_activity")
  public String getLcaActivity() {
    return lcaActivity;
  }

  @JsonProperty("supported_calculation_methods")
  public List<String> getSupportedCalculationMethods() {
    return supportedCalculationMethods;
  }

  @JsonProperty("factor")
  public double getFactor() {
    return factor;
  }

  @JsonProperty("factor_calculation_method")
  public CalculationMethod getFactorCalculationMethod() {
    return factorCalculationMethod;
  }

  @JsonProperty("factor_calculation_origin")
  public FactorCalculationOrigin getFactorCalculationOrigin() {
    return factorCalculationOrigin;
  }

  @JsonProperty("constituent_gases")
  public ConstituentGases getConstituentGases() {
    return constituentGases;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EmissionFactor && equalTo((EmissionFactor) other);
  }

  private boolean equalTo(EmissionFactor other) {
    return uuid.equals(other.uuid) && activityId.equals(other.activityId) && id.equals(other.id) && accessType.equals(other.accessType) && name.equals(other.name) && category.equals(other.category) && sector.equals(other.sector) && source.equals(other.source) && sourceLink.equals(other.sourceLink) && uncertainty.equals(other.uncertainty) && year.equals(other.year) && region.equals(other.region) && regionName.equals(other.regionName) && description.equals(other.description) && unitType.equals(other.unitType) && unit.equals(other.unit) && lcaActivity.equals(other.lcaActivity) && supportedCalculationMethods.equals(other.supportedCalculationMethods) && factor == other.factor && factorCalculationMethod.equals(other.factorCalculationMethod) && factorCalculationOrigin.equals(other.factorCalculationOrigin) && constituentGases.equals(other.constituentGases);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.uuid, this.activityId, this.id, this.accessType, this.name, this.category, this.sector, this.source, this.sourceLink, this.uncertainty, this.year, this.region, this.regionName, this.description, this.unitType, this.unit, this.lcaActivity, this.supportedCalculationMethods, this.factor, this.factorCalculationMethod, this.factorCalculationOrigin, this.constituentGases);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EmissionFactor{" + "uuid: " + uuid + ", activityId: " + activityId + ", id: " + id + ", accessType: " + accessType + ", name: " + name + ", category: " + category + ", sector: " + sector + ", source: " + source + ", sourceLink: " + sourceLink + ", uncertainty: " + uncertainty + ", year: " + year + ", region: " + region + ", regionName: " + regionName + ", description: " + description + ", unitType: " + unitType + ", unit: " + unit + ", lcaActivity: " + lcaActivity + ", supportedCalculationMethods: " + supportedCalculationMethods + ", factor: " + factor + ", factorCalculationMethod: " + factorCalculationMethod + ", factorCalculationOrigin: " + factorCalculationOrigin + ", constituentGases: " + constituentGases + "}";
  }

  public static UuidStage builder() {
    return new Builder();
  }

  public interface UuidStage {
    ActivityIdStage uuid(String uuid);

    Builder from(EmissionFactor other);
  }

  public interface ActivityIdStage {
    IdStage activityId(String activityId);
  }

  public interface IdStage {
    AccessTypeStage id(String id);
  }

  public interface AccessTypeStage {
    NameStage accessType(String accessType);
  }

  public interface NameStage {
    CategoryStage name(String name);
  }

  public interface CategoryStage {
    SectorStage category(String category);
  }

  public interface SectorStage {
    SourceStage sector(String sector);
  }

  public interface SourceStage {
    SourceLinkStage source(String source);
  }

  public interface SourceLinkStage {
    YearStage sourceLink(String sourceLink);
  }

  public interface YearStage {
    RegionStage year(String year);
  }

  public interface RegionStage {
    RegionNameStage region(String region);
  }

  public interface RegionNameStage {
    DescriptionStage regionName(String regionName);
  }

  public interface DescriptionStage {
    UnitStage description(String description);
  }

  public interface UnitStage {
    LcaActivityStage unit(String unit);
  }

  public interface LcaActivityStage {
    FactorStage lcaActivity(String lcaActivity);
  }

  public interface FactorStage {
    FactorCalculationMethodStage factor(double factor);
  }

  public interface FactorCalculationMethodStage {
    FactorCalculationOriginStage factorCalculationMethod(CalculationMethod factorCalculationMethod);
  }

  public interface FactorCalculationOriginStage {
    ConstituentGasesStage factorCalculationOrigin(FactorCalculationOrigin factorCalculationOrigin);
  }

  public interface ConstituentGasesStage {
    _FinalStage constituentGases(ConstituentGases constituentGases);
  }

  public interface _FinalStage {
    EmissionFactor build();

    _FinalStage uncertainty(Optional<Double> uncertainty);

    _FinalStage uncertainty(Double uncertainty);

    _FinalStage unitType(List<String> unitType);

    _FinalStage unitType(String unitType);

    _FinalStage addAllUnitType(List<String> unitType);

    _FinalStage supportedCalculationMethods(List<String> supportedCalculationMethods);

    _FinalStage supportedCalculationMethods(String supportedCalculationMethods);

    _FinalStage addAllSupportedCalculationMethods(List<String> supportedCalculationMethods);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements UuidStage, ActivityIdStage, IdStage, AccessTypeStage, NameStage, CategoryStage, SectorStage, SourceStage, SourceLinkStage, YearStage, RegionStage, RegionNameStage, DescriptionStage, UnitStage, LcaActivityStage, FactorStage, FactorCalculationMethodStage, FactorCalculationOriginStage, ConstituentGasesStage, _FinalStage {
    private String uuid;

    private String activityId;

    private String id;

    private String accessType;

    private String name;

    private String category;

    private String sector;

    private String source;

    private String sourceLink;

    private String year;

    private String region;

    private String regionName;

    private String description;

    private String unit;

    private String lcaActivity;

    private double factor;

    private CalculationMethod factorCalculationMethod;

    private FactorCalculationOrigin factorCalculationOrigin;

    private ConstituentGases constituentGases;

    private List<String> supportedCalculationMethods = new ArrayList<>();

    private List<String> unitType = new ArrayList<>();

    private Optional<Double> uncertainty = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(EmissionFactor other) {
      uuid(other.getUuid());
      activityId(other.getActivityId());
      id(other.getId());
      accessType(other.getAccessType());
      name(other.getName());
      category(other.getCategory());
      sector(other.getSector());
      source(other.getSource());
      sourceLink(other.getSourceLink());
      uncertainty(other.getUncertainty());
      year(other.getYear());
      region(other.getRegion());
      regionName(other.getRegionName());
      description(other.getDescription());
      unitType(other.getUnitType());
      unit(other.getUnit());
      lcaActivity(other.getLcaActivity());
      supportedCalculationMethods(other.getSupportedCalculationMethods());
      factor(other.getFactor());
      factorCalculationMethod(other.getFactorCalculationMethod());
      factorCalculationOrigin(other.getFactorCalculationOrigin());
      constituentGases(other.getConstituentGases());
      return this;
    }

    @Override
    @JsonSetter("uuid")
    public ActivityIdStage uuid(String uuid) {
      this.uuid = uuid;
      return this;
    }

    @Override
    @JsonSetter("activity_id")
    public IdStage activityId(String activityId) {
      this.activityId = activityId;
      return this;
    }

    @Override
    @JsonSetter("id")
    public AccessTypeStage id(String id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("access_type")
    public NameStage accessType(String accessType) {
      this.accessType = accessType;
      return this;
    }

    @Override
    @JsonSetter("name")
    public CategoryStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("category")
    public SectorStage category(String category) {
      this.category = category;
      return this;
    }

    @Override
    @JsonSetter("sector")
    public SourceStage sector(String sector) {
      this.sector = sector;
      return this;
    }

    @Override
    @JsonSetter("source")
    public SourceLinkStage source(String source) {
      this.source = source;
      return this;
    }

    @Override
    @JsonSetter("source_link")
    public YearStage sourceLink(String sourceLink) {
      this.sourceLink = sourceLink;
      return this;
    }

    @Override
    @JsonSetter("year")
    public RegionStage year(String year) {
      this.year = year;
      return this;
    }

    @Override
    @JsonSetter("region")
    public RegionNameStage region(String region) {
      this.region = region;
      return this;
    }

    @Override
    @JsonSetter("region_name")
    public DescriptionStage regionName(String regionName) {
      this.regionName = regionName;
      return this;
    }

    @Override
    @JsonSetter("description")
    public UnitStage description(String description) {
      this.description = description;
      return this;
    }

    @Override
    @JsonSetter("unit")
    public LcaActivityStage unit(String unit) {
      this.unit = unit;
      return this;
    }

    @Override
    @JsonSetter("lca_activity")
    public FactorStage lcaActivity(String lcaActivity) {
      this.lcaActivity = lcaActivity;
      return this;
    }

    @Override
    @JsonSetter("factor")
    public FactorCalculationMethodStage factor(double factor) {
      this.factor = factor;
      return this;
    }

    @Override
    @JsonSetter("factor_calculation_method")
    public FactorCalculationOriginStage factorCalculationMethod(
        CalculationMethod factorCalculationMethod) {
      this.factorCalculationMethod = factorCalculationMethod;
      return this;
    }

    @Override
    @JsonSetter("factor_calculation_origin")
    public ConstituentGasesStage factorCalculationOrigin(
        FactorCalculationOrigin factorCalculationOrigin) {
      this.factorCalculationOrigin = factorCalculationOrigin;
      return this;
    }

    @Override
    @JsonSetter("constituent_gases")
    public _FinalStage constituentGases(ConstituentGases constituentGases) {
      this.constituentGases = constituentGases;
      return this;
    }

    @Override
    public _FinalStage addAllSupportedCalculationMethods(List<String> supportedCalculationMethods) {
      this.supportedCalculationMethods.addAll(supportedCalculationMethods);
      return this;
    }

    @Override
    public _FinalStage supportedCalculationMethods(String supportedCalculationMethods) {
      this.supportedCalculationMethods.add(supportedCalculationMethods);
      return this;
    }

    @Override
    @JsonSetter(
        value = "supported_calculation_methods",
        nulls = Nulls.SKIP
    )
    public _FinalStage supportedCalculationMethods(List<String> supportedCalculationMethods) {
      this.supportedCalculationMethods.clear();
      this.supportedCalculationMethods.addAll(supportedCalculationMethods);
      return this;
    }

    @Override
    public _FinalStage addAllUnitType(List<String> unitType) {
      this.unitType.addAll(unitType);
      return this;
    }

    @Override
    public _FinalStage unitType(String unitType) {
      this.unitType.add(unitType);
      return this;
    }

    @Override
    @JsonSetter(
        value = "unit_type",
        nulls = Nulls.SKIP
    )
    public _FinalStage unitType(List<String> unitType) {
      this.unitType.clear();
      this.unitType.addAll(unitType);
      return this;
    }

    @Override
    public _FinalStage uncertainty(Double uncertainty) {
      this.uncertainty = Optional.of(uncertainty);
      return this;
    }

    @Override
    @JsonSetter(
        value = "uncertainty",
        nulls = Nulls.SKIP
    )
    public _FinalStage uncertainty(Optional<Double> uncertainty) {
      this.uncertainty = uncertainty;
      return this;
    }

    @Override
    public EmissionFactor build() {
      return new EmissionFactor(uuid, activityId, id, accessType, name, category, sector, source, sourceLink, uncertainty, year, region, regionName, description, unitType, unit, lcaActivity, supportedCalculationMethods, factor, factorCalculationMethod, factorCalculationOrigin, constituentGases);
    }
  }
}
