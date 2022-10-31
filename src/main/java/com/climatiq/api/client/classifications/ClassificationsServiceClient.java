package com.climatiq.api.client.classifications;

import com.climatiq.api.client.classifications.endpoints.Estimate;
import com.climatiq.api.client.classifications.exceptions.EstimateException;
import com.climatiq.api.client.estimation.types.EstimateResponse;
import com.climatiq.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class ClassificationsServiceClient {
  private final ClassificationsService service;

  private final Optional<BearerAuth> auth;

  public ClassificationsServiceClient(String url) {
    this.service = ClassificationsService.getClient(url);
    this.auth = Optional.empty();
  }

  public ClassificationsServiceClient(String url, BearerAuth auth) {
    this.service = ClassificationsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public EstimateResponse estimate(Estimate.Request request) throws EstimateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for estimate")));
    return this.service.estimate(authValue, request.getBody());
  }
}
