package com.climatiq.api.client.cloud.computing;

import com.climatiq.api.client.cloud.computing.endpoints.Cpu;
import com.climatiq.api.client.cloud.computing.endpoints.Memory;
import com.climatiq.api.client.cloud.computing.endpoints.Metadata;
import com.climatiq.api.client.cloud.computing.endpoints.Storage;
import com.climatiq.api.client.cloud.computing.exceptions.CpuException;
import com.climatiq.api.client.cloud.computing.exceptions.MemoryException;
import com.climatiq.api.client.cloud.computing.exceptions.MetadataException;
import com.climatiq.api.client.cloud.computing.exceptions.StorageException;
import com.climatiq.api.client.cloud.computing.types.MetadataResponse;
import com.climatiq.api.client.estimation.types.EstimateResponse;
import com.climatiq.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class CloudComputingServiceClient {
  private final CloudComputingService service;

  private final Optional<BearerAuth> auth;

  public CloudComputingServiceClient(String url) {
    this.service = CloudComputingService.getClient(url);
    this.auth = Optional.empty();
  }

  public CloudComputingServiceClient(String url, BearerAuth auth) {
    this.service = CloudComputingService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public MetadataResponse metadata(Metadata.Request request) throws MetadataException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for metadata")));
    return this.service.metadata(authValue);
  }

  public EstimateResponse cpu(Cpu.Request request) throws CpuException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for cpu")));
    return this.service.cpu(authValue, request.getProvider(), request.getBody());
  }

  public EstimateResponse storage(Storage.Request request) throws StorageException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for storage")));
    return this.service.storage(authValue, request.getProvider(), request.getBody());
  }

  public EstimateResponse memory(Memory.Request request) throws MemoryException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for memory")));
    return this.service.memory(authValue, request.getProvider(), request.getBody());
  }
}
