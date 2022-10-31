package com.climatiq.api.client.cloud.computing.endpoints;

import com.climatiq.api.client.cloud.computing.types.CpuRequest;
import com.climatiq.api.client.cloud.computing.types.ProviderId;
import com.climatiq.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Cpu {
  private Cpu() {
  }

  public static final class Request {
    private final Optional<BearerAuth> authOverride;

    private final ProviderId provider;

    private final CpuRequest body;

    private int _cachedHashCode;

    Request(Optional<BearerAuth> authOverride, ProviderId provider, CpuRequest body) {
      this.authOverride = authOverride;
      this.provider = provider;
      this.body = body;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    public ProviderId getProvider() {
      return provider;
    }

    public CpuRequest getBody() {
      return body;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && provider.equals(other.provider) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.provider, this.body);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Cpu.Request{" + "authOverride: " + authOverride + ", provider: " + provider + ", body: " + body + "}";
    }

    public static ProviderStage builder() {
      return new Builder();
    }

    public interface ProviderStage {
      BodyStage provider(ProviderId provider);

      Builder from(Request other);
    }

    public interface BodyStage {
      _FinalStage body(CpuRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    static final class Builder implements ProviderStage, BodyStage, _FinalStage {
      private ProviderId provider;

      private CpuRequest body;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        provider(other.getProvider());
        body(other.getBody());
        return this;
      }

      @Override
      public BodyStage provider(ProviderId provider) {
        this.provider = provider;
        return this;
      }

      @Override
      public _FinalStage body(CpuRequest body) {
        this.body = body;
        return this;
      }

      @Override
      public _FinalStage authOverride(BearerAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<BearerAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(authOverride, provider, body);
      }
    }
  }
}
