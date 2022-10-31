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
    builder = RegionsResponse.Builder.class
)
public final class RegionsResponse {
  private final List<Region> results;

  private int _cachedHashCode;

  RegionsResponse(List<Region> results) {
    this.results = results;
  }

  @JsonProperty("results")
  public List<Region> getResults() {
    return results;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RegionsResponse && equalTo((RegionsResponse) other);
  }

  private boolean equalTo(RegionsResponse other) {
    return results.equals(other.results);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.results);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RegionsResponse{" + "results: " + results + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Region> results = new ArrayList<>();

    private Builder() {
    }

    public Builder from(RegionsResponse other) {
      results(other.getResults());
      return this;
    }

    @JsonSetter(
        value = "results",
        nulls = Nulls.SKIP
    )
    public Builder results(List<Region> results) {
      this.results.clear();
      this.results.addAll(results);
      return this;
    }

    public Builder results(Region results) {
      this.results.add(results);
      return this;
    }

    public Builder addAllResults(List<Region> results) {
      this.results.addAll(results);
      return this;
    }

    public RegionsResponse build() {
      return new RegionsResponse(results);
    }
  }
}
