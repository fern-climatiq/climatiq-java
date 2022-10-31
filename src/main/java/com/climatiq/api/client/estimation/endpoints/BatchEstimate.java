package com.climatiq.api.client.estimation.endpoints;

import com.climatiq.api.client.estimation.types.EstimateRequest;
import com.climatiq.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class BatchEstimate {
  private BatchEstimate() {
  }

  public static final class Request {
    private final Optional<BearerAuth> authOverride;

    private final List<EstimateRequest> body;

    private int _cachedHashCode;

    Request(Optional<BearerAuth> authOverride, List<EstimateRequest> body) {
      this.authOverride = authOverride;
      this.body = body;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    public List<EstimateRequest> getBody() {
      return body;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.body);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "BatchEstimate.Request{" + "authOverride: " + authOverride + ", body: " + body + "}";
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Builder {
      private Optional<BearerAuth> authOverride = Optional.empty();

      private List<EstimateRequest> body = new ArrayList<>();

      private Builder() {
      }

      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        body(other.getBody());
        return this;
      }

      public Builder authOverride(Optional<BearerAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      public Builder authOverride(BearerAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      public Builder body(List<EstimateRequest> body) {
        this.body.clear();
        this.body.addAll(body);
        return this;
      }

      public Builder body(EstimateRequest body) {
        this.body.add(body);
        return this;
      }

      public Builder addAllBody(List<EstimateRequest> body) {
        this.body.addAll(body);
        return this;
      }

      public Request build() {
        return new Request(authOverride, body);
      }
    }
  }
}
