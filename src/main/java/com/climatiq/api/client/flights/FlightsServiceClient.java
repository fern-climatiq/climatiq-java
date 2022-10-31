package com.climatiq.api.client.flights;

import com.climatiq.api.client.flights.endpoints.FreightFlights;
import com.climatiq.api.client.flights.endpoints.TravelFlights;
import com.climatiq.api.client.flights.exceptions.FreightFlightsException;
import com.climatiq.api.client.flights.exceptions.TravelFlightsException;
import com.climatiq.api.client.flights.types.TripEmissions;
import com.climatiq.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class FlightsServiceClient {
  private final FlightsService service;

  private final Optional<BearerAuth> auth;

  public FlightsServiceClient(String url) {
    this.service = FlightsService.getClient(url);
    this.auth = Optional.empty();
  }

  public FlightsServiceClient(String url, BearerAuth auth) {
    this.service = FlightsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public TripEmissions travelFlights(TravelFlights.Request request) throws TravelFlightsException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for travelFlights")));
    return this.service.travelFlights(authValue, request.getBody());
  }

  public TripEmissions freightFlights(FreightFlights.Request request) throws
      FreightFlightsException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for freightFlights")));
    return this.service.freightFlights(authValue, request.getBody());
  }
}
