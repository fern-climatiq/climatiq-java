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
    builder = UnitTypesResponse.Builder.class
)
public final class UnitTypesResponse {
  private final List<String> results;

  private int _cachedHashCode;

  UnitTypesResponse(List<String> results) {
    this.results = results;
  }

  @JsonProperty("results")
  public List<String> getResults() {
    return results;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UnitTypesResponse && equalTo((UnitTypesResponse) other);
  }

  private boolean equalTo(UnitTypesResponse other) {
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
    return "UnitTypesResponse{" + "results: " + results + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<String> results = new ArrayList<>();

    private Builder() {
    }

    public Builder from(UnitTypesResponse other) {
      results(other.getResults());
      return this;
    }

    @JsonSetter(
        value = "results",
        nulls = Nulls.SKIP
    )
    public Builder results(List<String> results) {
      this.results.clear();
      this.results.addAll(results);
      return this;
    }

    public Builder results(String results) {
      this.results.add(results);
      return this;
    }

    public Builder addAllResults(List<String> results) {
      this.results.addAll(results);
      return this;
    }

    public UnitTypesResponse build() {
      return new UnitTypesResponse(results);
    }
  }
}
