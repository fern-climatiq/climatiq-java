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
    builder = MemoryRequest.Builder.class
)
public final class MemoryRequest {
  private final double data;

  private final Optional<String> dataUnit;

  private final double duration;

  private int _cachedHashCode;

  MemoryRequest(double data, Optional<String> dataUnit, double duration) {
    this.data = data;
    this.dataUnit = dataUnit;
    this.duration = duration;
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
    return other instanceof MemoryRequest && equalTo((MemoryRequest) other);
  }

  private boolean equalTo(MemoryRequest other) {
    return data == other.data && dataUnit.equals(other.dataUnit) && duration == other.duration;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.data, this.dataUnit, this.duration);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MemoryRequest{" + "data: " + data + ", dataUnit: " + dataUnit + ", duration: " + duration + "}";
  }

  public static DataStage builder() {
    return new Builder();
  }

  public interface DataStage {
    DurationStage data(double data);

    Builder from(MemoryRequest other);
  }

  public interface DurationStage {
    _FinalStage duration(double duration);
  }

  public interface _FinalStage {
    MemoryRequest build();

    _FinalStage dataUnit(Optional<String> dataUnit);

    _FinalStage dataUnit(String dataUnit);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements DataStage, DurationStage, _FinalStage {
    private double data;

    private double duration;

    private Optional<String> dataUnit = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(MemoryRequest other) {
      data(other.getData());
      dataUnit(other.getDataUnit());
      duration(other.getDuration());
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
    public MemoryRequest build() {
      return new MemoryRequest(data, dataUnit, duration);
    }
  }
}
