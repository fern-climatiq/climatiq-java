package com.climatiq.api.client.custom.activities;

import com.climatiq.api.client.custom.activities.endpoints.BatchCustomActivities;
import com.climatiq.api.client.custom.activities.endpoints.Estimate;
import com.climatiq.api.client.custom.activities.exceptions.BatchCustomActivitiesException;
import com.climatiq.api.client.custom.activities.exceptions.EstimateException;
import com.climatiq.api.client.custom.activities.types.batchCustomActivitiesResponse;
import com.climatiq.api.client.estimation.types.EstimateResponse;
import com.climatiq.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class CustomActivitiesServiceClient {
  private final CustomActivitiesService service;

  private final Optional<BearerAuth> auth;

  public CustomActivitiesServiceClient(String url) {
    this.service = CustomActivitiesService.getClient(url);
    this.auth = Optional.empty();
  }

  public CustomActivitiesServiceClient(String url, BearerAuth auth) {
    this.service = CustomActivitiesService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public EstimateResponse estimate(Estimate.Request request) throws EstimateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for estimate")));
    return this.service.estimate(authValue, request.getBody());
  }

  public batchCustomActivitiesResponse batchCustomActivities(BatchCustomActivities.Request request)
      throws BatchCustomActivitiesException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for batchCustomActivities")));
    return this.service.batchCustomActivities(authValue, request.getBody());
  }
}
