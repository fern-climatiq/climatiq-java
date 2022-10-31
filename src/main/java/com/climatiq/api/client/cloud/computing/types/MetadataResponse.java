package com.climatiq.api.client.cloud.computing.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonDeserialize(
    builder = MetadataResponse.Builder.class
)
public final class MetadataResponse {
  private final Map<CloudProvider, CloudProviderMetadata> cloudProviders;

  private int _cachedHashCode;

  MetadataResponse(Map<CloudProvider, CloudProviderMetadata> cloudProviders) {
    this.cloudProviders = cloudProviders;
  }

  @JsonProperty("cloud_providers")
  public Map<CloudProvider, CloudProviderMetadata> getCloudProviders() {
    return cloudProviders;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MetadataResponse && equalTo((MetadataResponse) other);
  }

  private boolean equalTo(MetadataResponse other) {
    return cloudProviders.equals(other.cloudProviders);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.cloudProviders);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MetadataResponse{" + "cloudProviders: " + cloudProviders + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Map<CloudProvider, CloudProviderMetadata> cloudProviders = new LinkedHashMap<>();

    private Builder() {
    }

    public Builder from(MetadataResponse other) {
      cloudProviders(other.getCloudProviders());
      return this;
    }

    @JsonSetter(
        value = "cloud_providers",
        nulls = Nulls.SKIP
    )
    public Builder cloudProviders(Map<CloudProvider, CloudProviderMetadata> cloudProviders) {
      this.cloudProviders.clear();
      this.cloudProviders.putAll(cloudProviders);
      return this;
    }

    public Builder putAllCloudProviders(Map<CloudProvider, CloudProviderMetadata> cloudProviders) {
      this.cloudProviders.putAll(cloudProviders);
      return this;
    }

    public Builder cloudProviders(CloudProvider key, CloudProviderMetadata value) {
      this.cloudProviders.put(key, value);
      return this;
    }

    public MetadataResponse build() {
      return new MetadataResponse(cloudProviders);
    }
  }
}
