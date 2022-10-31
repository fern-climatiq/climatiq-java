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
    builder = UsedEmissionFactor.Builder.class
)
public final class UsedEmissionFactor {
  private final String activityId;

  private final String source;

  private final String year;

  private final String region;

  private final String category;

  private final String lcaActivity;

  private int _cachedHashCode;

  UsedEmissionFactor(String activityId, String source, String year, String region, String category,
      String lcaActivity) {
    this.activityId = activityId;
    this.source = source;
    this.year = year;
    this.region = region;
    this.category = category;
    this.lcaActivity = lcaActivity;
  }

  @JsonProperty("activity_id")
  public String getActivityId() {
    return activityId;
  }

  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  @JsonProperty("year")
  public String getYear() {
    return year;
  }

  @JsonProperty("region")
  public String getRegion() {
    return region;
  }

  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  @JsonProperty("lca_activity")
  public String getLcaActivity() {
    return lcaActivity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UsedEmissionFactor && equalTo((UsedEmissionFactor) other);
  }

  private boolean equalTo(UsedEmissionFactor other) {
    return activityId.equals(other.activityId) && source.equals(other.source) && year.equals(other.year) && region.equals(other.region) && category.equals(other.category) && lcaActivity.equals(other.lcaActivity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.activityId, this.source, this.year, this.region, this.category, this.lcaActivity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UsedEmissionFactor{" + "activityId: " + activityId + ", source: " + source + ", year: " + year + ", region: " + region + ", category: " + category + ", lcaActivity: " + lcaActivity + "}";
  }

  public static ActivityIdStage builder() {
    return new Builder();
  }

  public interface ActivityIdStage {
    SourceStage activityId(String activityId);

    Builder from(UsedEmissionFactor other);
  }

  public interface SourceStage {
    YearStage source(String source);
  }

  public interface YearStage {
    RegionStage year(String year);
  }

  public interface RegionStage {
    CategoryStage region(String region);
  }

  public interface CategoryStage {
    LcaActivityStage category(String category);
  }

  public interface LcaActivityStage {
    _FinalStage lcaActivity(String lcaActivity);
  }

  public interface _FinalStage {
    UsedEmissionFactor build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements ActivityIdStage, SourceStage, YearStage, RegionStage, CategoryStage, LcaActivityStage, _FinalStage {
    private String activityId;

    private String source;

    private String year;

    private String region;

    private String category;

    private String lcaActivity;

    private Builder() {
    }

    @Override
    public Builder from(UsedEmissionFactor other) {
      activityId(other.getActivityId());
      source(other.getSource());
      year(other.getYear());
      region(other.getRegion());
      category(other.getCategory());
      lcaActivity(other.getLcaActivity());
      return this;
    }

    @Override
    @JsonSetter("activity_id")
    public SourceStage activityId(String activityId) {
      this.activityId = activityId;
      return this;
    }

    @Override
    @JsonSetter("source")
    public YearStage source(String source) {
      this.source = source;
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
    public CategoryStage region(String region) {
      this.region = region;
      return this;
    }

    @Override
    @JsonSetter("category")
    public LcaActivityStage category(String category) {
      this.category = category;
      return this;
    }

    @Override
    @JsonSetter("lca_activity")
    public _FinalStage lcaActivity(String lcaActivity) {
      this.lcaActivity = lcaActivity;
      return this;
    }

    @Override
    public UsedEmissionFactor build() {
      return new UsedEmissionFactor(activityId, source, year, region, category, lcaActivity);
    }
  }
}
