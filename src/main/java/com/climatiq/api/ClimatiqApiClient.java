package com.climatiq.api;

import com.climatiq.api.client.classifications.ClassificationsServiceClient;
import com.climatiq.api.client.cloud.computing.CloudComputingServiceClient;
import com.climatiq.api.client.custom.activities.CustomActivitiesServiceClient;
import com.climatiq.api.client.emission.factor.EmissionFactorsServiceClient;
import com.climatiq.api.client.estimation.EstimationServiceClient;
import com.climatiq.api.client.flights.FlightsServiceClient;
import com.climatiq.api.core.BearerAuth;
import java.lang.String;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class ClimatiqApiClient {
  private final Supplier<ClassificationsServiceClient> classificationsServiceClient;

  private final Supplier<CloudComputingServiceClient> cloudComputingServiceClient;

  private final Supplier<CustomActivitiesServiceClient> customActivitiesServiceClient;

  private final Supplier<EmissionFactorsServiceClient> emissionFactorsServiceClient;

  private final Supplier<EstimationServiceClient> estimationServiceClient;

  private final Supplier<FlightsServiceClient> flightsServiceClient;

  public ClimatiqApiClient(String url) {
    this.customActivitiesServiceClient = memoize(() -> new CustomActivitiesServiceClient(url));
    this.emissionFactorsServiceClient = memoize(() -> new EmissionFactorsServiceClient(url));
    this.cloudComputingServiceClient = memoize(() -> new CloudComputingServiceClient(url));
    this.estimationServiceClient = memoize(() -> new EstimationServiceClient(url));
    this.classificationsServiceClient = memoize(() -> new ClassificationsServiceClient(url));
    this.flightsServiceClient = memoize(() -> new FlightsServiceClient(url));
  }

  public ClimatiqApiClient(String url, BearerAuth auth) {
    this.customActivitiesServiceClient = memoize(() -> new CustomActivitiesServiceClient(url, auth));
    this.emissionFactorsServiceClient = memoize(() -> new EmissionFactorsServiceClient(url, auth));
    this.cloudComputingServiceClient = memoize(() -> new CloudComputingServiceClient(url, auth));
    this.estimationServiceClient = memoize(() -> new EstimationServiceClient(url, auth));
    this.classificationsServiceClient = memoize(() -> new ClassificationsServiceClient(url, auth));
    this.flightsServiceClient = memoize(() -> new FlightsServiceClient(url, auth));
  }

  public final ClassificationsServiceClient classifications() {
    return this.classificationsServiceClient.get();
  }

  public final CloudComputingServiceClient cloudComputing() {
    return this.cloudComputingServiceClient.get();
  }

  public final CustomActivitiesServiceClient customActivities() {
    return this.customActivitiesServiceClient.get();
  }

  public final EmissionFactorsServiceClient emissionFactor() {
    return this.emissionFactorsServiceClient.get();
  }

  public final EstimationServiceClient estimation() {
    return this.estimationServiceClient.get();
  }

  public final FlightsServiceClient flights() {
    return this.flightsServiceClient.get();
  }

  private static <T> Supplier<T> memoize(Supplier<T> delegate) {
    AtomicReference<T> value = new AtomicReference<>();
    return () ->  {
      T val = value.get();
      if (val == null) {
        val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
      }
      return val;
    } ;
  }
}
