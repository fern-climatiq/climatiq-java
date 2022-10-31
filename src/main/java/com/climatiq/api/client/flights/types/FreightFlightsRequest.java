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
    builder = FreightFlightsRequest.Builder.class
)
public final class FreightFlightsRequest {
  private final List<FreightLeg> legs;

  private int _cachedHashCode;

  FreightFlightsRequest(List<FreightLeg> legs) {
    this.legs = legs;
  }

  @JsonProperty("legs")
  public List<FreightLeg> getLegs() {
    return legs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FreightFlightsRequest && equalTo((FreightFlightsRequest) other);
  }

  private boolean equalTo(FreightFlightsRequest other) {
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
    return "FreightFlightsRequest{" + "legs: " + legs + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<FreightLeg> legs = new ArrayList<>();

    private Builder() {
    }

    public Builder from(FreightFlightsRequest other) {
      legs(other.getLegs());
      return this;
    }

    @JsonSetter(
        value = "legs",
        nulls = Nulls.SKIP
    )
    public Builder legs(List<FreightLeg> legs) {
      this.legs.clear();
      this.legs.addAll(legs);
      return this;
    }

    public Builder legs(FreightLeg legs) {
      this.legs.add(legs);
      return this;
    }

    public Builder addAllLegs(List<FreightLeg> legs) {
      this.legs.addAll(legs);
      return this;
    }

    public FreightFlightsRequest build() {
      return new FreightFlightsRequest(legs);
    }
  }
}
