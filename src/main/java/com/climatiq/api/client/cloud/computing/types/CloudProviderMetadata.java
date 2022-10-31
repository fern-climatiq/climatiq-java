package com.climatiq.api.client.cloud.computing.types;

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
    builder = CloudProviderMetadata.Builder.class
)
public final class CloudProviderMetadata {
  private final String providerFullName;

  private final String providerId;

  private final List<String> cpuRegions;

  private final List<String> storageRegions;

  private final List<String> memoryRegions;

  private int _cachedHashCode;

  CloudProviderMetadata(String providerFullName, String providerId, List<String> cpuRegions,
      List<String> storageRegions, List<String> memoryRegions) {
    this.providerFullName = providerFullName;
    this.providerId = providerId;
    this.cpuRegions = cpuRegions;
    this.storageRegions = storageRegions;
    this.memoryRegions = memoryRegions;
  }

  @JsonProperty("provider_full_name")
  public String getProviderFullName() {
    return providerFullName;
  }

  @JsonProperty("provider_id")
  public String getProviderId() {
    return providerId;
  }

  @JsonProperty("cpu_regions")
  public List<String> getCpuRegions() {
    return cpuRegions;
  }

  @JsonProperty("storage_regions")
  public List<String> getStorageRegions() {
    return storageRegions;
  }

  @JsonProperty("memory_regions")
  public List<String> getMemoryRegions() {
    return memoryRegions;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CloudProviderMetadata && equalTo((CloudProviderMetadata) other);
  }

  private boolean equalTo(CloudProviderMetadata other) {
    return providerFullName.equals(other.providerFullName) && providerId.equals(other.providerId) && cpuRegions.equals(other.cpuRegions) && storageRegions.equals(other.storageRegions) && memoryRegions.equals(other.memoryRegions);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.providerFullName, this.providerId, this.cpuRegions, this.storageRegions, this.memoryRegions);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CloudProviderMetadata{" + "providerFullName: " + providerFullName + ", providerId: " + providerId + ", cpuRegions: " + cpuRegions + ", storageRegions: " + storageRegions + ", memoryRegions: " + memoryRegions + "}";
  }

  public static ProviderFullNameStage builder() {
    return new Builder();
  }

  public interface ProviderFullNameStage {
    ProviderIdStage providerFullName(String providerFullName);

    Builder from(CloudProviderMetadata other);
  }

  public interface ProviderIdStage {
    _FinalStage providerId(String providerId);
  }

  public interface _FinalStage {
    CloudProviderMetadata build();

    _FinalStage cpuRegions(List<String> cpuRegions);

    _FinalStage cpuRegions(String cpuRegions);

    _FinalStage addAllCpuRegions(List<String> cpuRegions);

    _FinalStage storageRegions(List<String> storageRegions);

    _FinalStage storageRegions(String storageRegions);

    _FinalStage addAllStorageRegions(List<String> storageRegions);

    _FinalStage memoryRegions(List<String> memoryRegions);

    _FinalStage memoryRegions(String memoryRegions);

    _FinalStage addAllMemoryRegions(List<String> memoryRegions);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements ProviderFullNameStage, ProviderIdStage, _FinalStage {
    private String providerFullName;

    private String providerId;

    private List<String> memoryRegions = new ArrayList<>();

    private List<String> storageRegions = new ArrayList<>();

    private List<String> cpuRegions = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(CloudProviderMetadata other) {
      providerFullName(other.getProviderFullName());
      providerId(other.getProviderId());
      cpuRegions(other.getCpuRegions());
      storageRegions(other.getStorageRegions());
      memoryRegions(other.getMemoryRegions());
      return this;
    }

    @Override
    @JsonSetter("provider_full_name")
    public ProviderIdStage providerFullName(String providerFullName) {
      this.providerFullName = providerFullName;
      return this;
    }

    @Override
    @JsonSetter("provider_id")
    public _FinalStage providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    @Override
    public _FinalStage addAllMemoryRegions(List<String> memoryRegions) {
      this.memoryRegions.addAll(memoryRegions);
      return this;
    }

    @Override
    public _FinalStage memoryRegions(String memoryRegions) {
      this.memoryRegions.add(memoryRegions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "memory_regions",
        nulls = Nulls.SKIP
    )
    public _FinalStage memoryRegions(List<String> memoryRegions) {
      this.memoryRegions.clear();
      this.memoryRegions.addAll(memoryRegions);
      return this;
    }

    @Override
    public _FinalStage addAllStorageRegions(List<String> storageRegions) {
      this.storageRegions.addAll(storageRegions);
      return this;
    }

    @Override
    public _FinalStage storageRegions(String storageRegions) {
      this.storageRegions.add(storageRegions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "storage_regions",
        nulls = Nulls.SKIP
    )
    public _FinalStage storageRegions(List<String> storageRegions) {
      this.storageRegions.clear();
      this.storageRegions.addAll(storageRegions);
      return this;
    }

    @Override
    public _FinalStage addAllCpuRegions(List<String> cpuRegions) {
      this.cpuRegions.addAll(cpuRegions);
      return this;
    }

    @Override
    public _FinalStage cpuRegions(String cpuRegions) {
      this.cpuRegions.add(cpuRegions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "cpu_regions",
        nulls = Nulls.SKIP
    )
    public _FinalStage cpuRegions(List<String> cpuRegions) {
      this.cpuRegions.clear();
      this.cpuRegions.addAll(cpuRegions);
      return this;
    }

    @Override
    public CloudProviderMetadata build() {
      return new CloudProviderMetadata(providerFullName, providerId, cpuRegions, storageRegions, memoryRegions);
    }
  }
}
