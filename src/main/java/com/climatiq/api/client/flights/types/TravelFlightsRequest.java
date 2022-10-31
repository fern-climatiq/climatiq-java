package com.climatiq.api.client.flights.types;

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
    builder = TravelFlightsRequest.Builder.class
)
public final class TravelFlightsRequest {
  private final List<TravelLeg> legs;

  private int _cachedHashCode;

  TravelFlightsRequest(List<TravelLeg> legs) {
    this.legs = legs;
  }

  @JsonProperty("legs")
  public List<TravelLeg> getLegs() {
    return legs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof TravelFlightsRequest && equalTo((TravelFlightsRequest) other);
  }

  private boolean equalTo(TravelFlightsRequest other) {
    return legs.equals(other.legs);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.legs);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "TravelFlightsRequest{" + "legs: " + legs + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<TravelLeg> legs = new ArrayList<>();

    private Builder() {
    }

    public Builder from(TravelFlightsRequest other) {
      legs(other.getLegs());
      return this;
    }

    @JsonSetter(
        value = "legs",
        nulls = Nulls.SKIP
    )
    public Builder legs(List<TravelLeg> legs) {
      this.legs.clear();
      this.legs.addAll(legs);
      return this;
    }

    public Builder legs(TravelLeg legs) {
      this.legs.add(legs);
      return this;
    }

    public Builder addAllLegs(List<TravelLeg> legs) {
      this.legs.addAll(legs);
      return this;
    }

    public TravelFlightsRequest build() {
      return new TravelFlightsRequest(legs);
    }
  }
}
