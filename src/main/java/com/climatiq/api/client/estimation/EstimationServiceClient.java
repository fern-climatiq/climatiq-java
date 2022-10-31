package com.climatiq.api.client.estimation;

import com.climatiq.api.client.estimation.endpoints.BatchEstimate;
import com.climatiq.api.client.estimation.endpoints.Estimate;
import com.climatiq.api.client.estimation.exceptions.BatchEstimateException;
import com.climatiq.api.client.estimation.exceptions.EstimateException;
import com.climatiq.api.client.estimation.types.BatchEstimateResponse;
import com.climatiq.api.client.estimation.types.EstimateResponse;
import com.climatiq.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class EstimationServiceClient {
  private final EstimationService service;

  private final Optional<BearerAuth> auth;

  public EstimationServiceClient(String url) {
    this.service = EstimationService.getClient(url);
    this.auth = Optional.empty();
  }

  public EstimationServiceClient(String url, BearerAuth auth) {
    this.service = EstimationService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public EstimateResponse estimate(Estimate.Request request) throws EstimateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for estimate")));
    return this.service.estimate(authValue, request.getBody());
  }

  public BatchEstimateResponse batchEstimate(BatchEstimate.Request request) throws
      BatchEstimateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for batchEstimate")));
    return this.service.batchEstimate(authValue, request.getBody());
  }
}
