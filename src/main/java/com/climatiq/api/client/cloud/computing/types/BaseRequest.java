package com.climatiq.api.client.cloud.computing.types;

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
    builder = BaseRequest.Builder.class
)
public final class BaseRequest implements IBaseRequest {
  private final String region;

  private final Optional<String> durationUnit;

  private int _cachedHashCode;

  BaseRequest(String region, Optional<String> durationUnit) {
    this.region = region;
    this.durationUnit = durationUnit;
  }

  @JsonProperty("region")
  @Override
  public String getRegion() {
    return region;
  }

  @JsonProperty("duration_unit")
  @Override
  public Optional<String> getDurationUnit() {
    return durationUnit;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BaseRequest && equalTo((BaseRequest) other);
  }

  private boolean equalTo(BaseRequest other) {
    return region.equals(other.region) && durationUnit.equals(other.durationUnit);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.region, this.durationUnit);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BaseRequest{" + "region: " + region + ", durationUnit: " + durationUnit + "}";
  }

  public static RegionStage builder() {
    return new Builder();
  }

  public interface RegionStage {
    _FinalStage region(String region);

    Builder from(BaseRequest other);
  }

  public interface _FinalStage {
    BaseRequest build();

    _FinalStage durationUnit(Optional<String> durationUnit);

    _FinalStage durationUnit(String durationUnit);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements RegionStage, _FinalStage {
    private String region;

    private Optional<String> durationUnit = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(BaseRequest other) {
      region(other.getRegion());
      durationUnit(other.getDurationUnit());
      return this;
    }

    @Override
    @JsonSetter("region")
    public _FinalStage region(String region) {
      this.region = region;
      return this;
    }

    @Override
    public _FinalStage durationUnit(String durationUnit) {
      this.durationUnit = Optional.of(durationUnit);
      return this;
    }

    @Override
    @JsonSetter(
        value = "duration_unit",
        nulls = Nulls.SKIP
    )
    public _FinalStage durationUnit(Optional<String> durationUnit) {
      this.durationUnit = durationUnit;
      return this;
    }

    @Override
    public BaseRequest build() {
      return new BaseRequest(region, durationUnit);
    }
  }
}
