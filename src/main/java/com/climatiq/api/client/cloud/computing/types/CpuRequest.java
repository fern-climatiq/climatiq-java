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
    builder = CpuRequest.Builder.class
)
public final class CpuRequest implements IBaseRequest {
  private final String region;

  private final Optional<String> durationUnit;

  private final int cpuCount;

  private final double cpuLoad;

  private final double duration;

  private int _cachedHashCode;

  CpuRequest(String region, Optional<String> durationUnit, int cpuCount, double cpuLoad,
      double duration) {
    this.region = region;
    this.durationUnit = durationUnit;
    this.cpuCount = cpuCount;
    this.cpuLoad = cpuLoad;
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

  @JsonProperty("cpu_count")
  public int getCpuCount() {
    return cpuCount;
  }

  @JsonProperty("cpu_load")
  public double getCpuLoad() {
    return cpuLoad;
  }

  @JsonProperty("duration")
  public double getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CpuRequest && equalTo((CpuRequest) other);
  }

  private boolean equalTo(CpuRequest other) {
    return region.equals(other.region) && durationUnit.equals(other.durationUnit) && cpuCount == other.cpuCount && cpuLoad == other.cpuLoad && duration == other.duration;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.region, this.durationUnit, this.cpuCount, this.cpuLoad, this.duration);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CpuRequest{" + "region: " + region + ", durationUnit: " + durationUnit + ", cpuCount: " + cpuCount + ", cpuLoad: " + cpuLoad + ", duration: " + duration + "}";
  }

  public static RegionStage builder() {
    return new Builder();
  }

  public interface RegionStage {
    CpuCountStage region(String region);

    Builder from(CpuRequest other);
  }

  public interface CpuCountStage {
    CpuLoadStage cpuCount(int cpuCount);
  }

  public interface CpuLoadStage {
    DurationStage cpuLoad(double cpuLoad);
  }

  public interface DurationStage {
    _FinalStage duration(double duration);
  }

  public interface _FinalStage {
    CpuRequest build();

    _FinalStage durationUnit(Optional<String> durationUnit);

    _FinalStage durationUnit(String durationUnit);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements RegionStage, CpuCountStage, CpuLoadStage, DurationStage, _FinalStage {
    private String region;

    private int cpuCount;

    private double cpuLoad;

    private double duration;

    private Optional<String> durationUnit = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(CpuRequest other) {
      region(other.getRegion());
      durationUnit(other.getDurationUnit());
      cpuCount(other.getCpuCount());
      cpuLoad(other.getCpuLoad());
      duration(other.getDuration());
      return this;
    }

    @Override
    @JsonSetter("region")
    public CpuCountStage region(String region) {
      this.region = region;
      return this;
    }

    @Override
    @JsonSetter("cpu_count")
    public CpuLoadStage cpuCount(int cpuCount) {
      this.cpuCount = cpuCount;
      return this;
    }

    @Override
    @JsonSetter("cpu_load")
    public DurationStage cpuLoad(double cpuLoad) {
      this.cpuLoad = cpuLoad;
      return this;
    }

    @Override
    @JsonSetter("duration")
    public _FinalStage duration(double duration) {
      this.duration = duration;
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
    public CpuRequest build() {
      return new CpuRequest(region, durationUnit, cpuCount, cpuLoad, duration);
    }
  }
}
