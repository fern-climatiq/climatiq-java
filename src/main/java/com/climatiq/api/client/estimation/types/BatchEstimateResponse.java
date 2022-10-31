package com.climatiq.api.client.estimation.types;

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
    builder = BatchEstimateResponse.Builder.class
)
public final class BatchEstimateResponse {
  private final List<BatchItemEstimate> response;

  private int _cachedHashCode;

  BatchEstimateResponse(List<BatchItemEstimate> response) {
    this.response = response;
  }

  @JsonProperty("response")
  public List<BatchItemEstimate> getResponse() {
    return response;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BatchEstimateResponse && equalTo((BatchEstimateResponse) other);
  }

  private boolean equalTo(BatchEstimateResponse other) {
    return response.equals(other.response);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.response);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BatchEstimateResponse{" + "response: " + response + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<BatchItemEstimate> response = new ArrayList<>();

    private Builder() {
    }

    public Builder from(BatchEstimateResponse other) {
      response(other.getResponse());
      return this;
    }

    @JsonSetter(
        value = "response",
        nulls = Nulls.SKIP
    )
    public Builder response(List<BatchItemEstimate> response) {
      this.response.clear();
      this.response.addAll(response);
      return this;
    }

    public Builder response(BatchItemEstimate response) {
      this.response.add(response);
      return this;
    }

    public Builder addAllResponse(List<BatchItemEstimate> response) {
      this.response.addAll(response);
      return this;
    }

    public BatchEstimateResponse build() {
      return new BatchEstimateResponse(response);
    }
  }
}
