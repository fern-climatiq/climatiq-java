package com.climatiq.api.client.custom.activities.types;

import com.climatiq.api.client.estimation.types.EstimateResponse;
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
    builder = batchCustomActivitiesResponse.Builder.class
)
public final class batchCustomActivitiesResponse {
  private final List<EstimateResponse> results;

  private int _cachedHashCode;

  batchCustomActivitiesResponse(List<EstimateResponse> results) {
    this.results = results;
  }

  @JsonProperty("results")
  public List<EstimateResponse> getResults() {
    return results;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof batchCustomActivitiesResponse && equalTo((batchCustomActivitiesResponse) other);
  }

  private boolean equalTo(batchCustomActivitiesResponse other) {
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
    return "batchCustomActivitiesResponse{" + "results: " + results + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<EstimateResponse> results = new ArrayList<>();

    private Builder() {
    }

    public Builder from(batchCustomActivitiesResponse other) {
      results(other.getResults());
      return this;
    }

    @JsonSetter(
        value = "results",
        nulls = Nulls.SKIP
    )
    public Builder results(List<EstimateResponse> results) {
      this.results.clear();
      this.results.addAll(results);
      return this;
    }

    public Builder results(EstimateResponse results) {
      this.results.add(results);
      return this;
    }

    public Builder addAllResults(List<EstimateResponse> results) {
      this.results.addAll(results);
      return this;
    }

    public batchCustomActivitiesResponse build() {
      return new batchCustomActivitiesResponse(results);
    }
  }
}
