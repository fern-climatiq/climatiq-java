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
    builder = StorageRequest.Builder.class
)
public final class StorageRequest implements IBaseRequest {
  private final String region;

  private final Optional<String> durationUnit;

  private final StorageType storageType;

  private final double data;

  private final Optional<String> dataUnit;

  private final double duration;

  private int _cachedHashCode;

  StorageRequest(String region, Optional<String> durationUnit, StorageType storageType, double data,
      Optional<String> dataUnit, double duration) {
    this.region = region;
    this.durationUnit = durationUnit;
    this.storageType = storageType;
    this.data = data;
    this.dataUnit = dataUnit;
    this.duration = duration;
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

  @JsonProperty("storage_type")
  public StorageType getStorageType() {
    return storageType;
  }

  @JsonProperty("data")
  public double getData() {
    return data;
  }

  @JsonProperty("data_unit")
  public Optional<String> getDataUnit() {
    return dataUnit;
  }

  @JsonProperty("duration")
  public double getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof StorageRequest && equalTo((StorageRequest) other);
  }

  private boolean equalTo(StorageRequest other) {
    return region.equals(other.region) && durationUnit.equals(other.durationUnit) && storageType.equals(other.storageType) && data == other.data && dataUnit.equals(other.dataUnit) && duration == other.duration;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.region, this.durationUnit, this.storageType, this.data, this.dataUnit, this.duration);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "StorageRequest{" + "region: " + region + ", durationUnit: " + durationUnit + ", storageType: " + storageType + ", data: " + data + ", dataUnit: " + dataUnit + ", duration: " + duration + "}";
  }

  public static RegionStage builder() {
    return new Builder();
  }

  public interface RegionStage {
    StorageTypeStage region(String region);

    Builder from(StorageRequest other);
  }

  public interface StorageTypeStage {
    DataStage storageType(StorageType storageType);
  }

  public interface DataStage {
    DurationStage data(double data);
  }

  public interface DurationStage {
    _FinalStage duration(double duration);
  }

  public interface _FinalStage {
    StorageRequest build();

    _FinalStage durationUnit(Optional<String> durationUnit);

    _FinalStage durationUnit(String durationUnit);

    _FinalStage dataUnit(Optional<String> dataUnit);

    _FinalStage dataUnit(String dataUnit);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements RegionStage, StorageTypeStage, DataStage, DurationStage, _FinalStage {
    private String region;

    private StorageType storageType;

    private double data;

    private double duration;

    private Optional<String> dataUnit = Optional.empty();

    private Optional<String> durationUnit = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(StorageRequest other) {
      region(other.getRegion());
      durationUnit(other.getDurationUnit());
      storageType(other.getStorageType());
      data(other.getData());
      dataUnit(other.getDataUnit());
      duration(other.getDuration());
      return this;
    }

    @Override
    @JsonSetter("region")
    public StorageTypeStage region(String region) {
      this.region = region;
      return this;
    }

    @Override
    @JsonSetter("storage_type")
    public DataStage storageType(StorageType storageType) {
      this.storageType = storageType;
      return this;
    }

    @Override
    @JsonSetter("data")
    public DurationStage data(double data) {
      this.data = data;
      return this;
    }

    @Override
    @JsonSetter("duration")
    public _FinalStage duration(double duration) {
      this.duration = duration;
      return this;
    }

    @Override
    public _FinalStage dataUnit(String dataUnit) {
      this.dataUnit = Optional.of(dataUnit);
      return this;
    }

    @Override
    @JsonSetter(
        value = "data_unit",
        nulls = Nulls.SKIP
    )
    public _FinalStage dataUnit(Optional<String> dataUnit) {
      this.dataUnit = dataUnit;
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
    public StorageRequest build() {
      return new StorageRequest(region, durationUnit, storageType, data, dataUnit, duration);
    }
  }
}
