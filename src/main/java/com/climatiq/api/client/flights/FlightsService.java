package com.climatiq.api.client.flights;

import com.climatiq.api.client.flights.exceptions.FreightFlightsException;
import com.climatiq.api.client.flights.exceptions.TravelFlightsException;
import com.climatiq.api.client.flights.types.FreightFlightsRequest;
import com.climatiq.api.client.flights.types.TravelFlightsRequest;
import com.climatiq.api.client.flights.types.TripEmissions;
import com.climatiq.api.core.BearerAuth;
import com.climatiq.api.core.ObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
interface FlightsService {
  @POST
  @Path("/travel/flights")
  TripEmissions travelFlights(@HeaderParam("Authorization") BearerAuth auth,
      TravelFlightsRequest body) throws TravelFlightsException;

  @POST
  @Path("/freight/flights")
  TripEmissions freightFlights(@HeaderParam("Authorization") BearerAuth auth,
      FreightFlightsRequest body) throws FreightFlightsException;

  static FlightsService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new FlightsServiceErrorDecoder()).target(FlightsService.class, url);
  }
}
