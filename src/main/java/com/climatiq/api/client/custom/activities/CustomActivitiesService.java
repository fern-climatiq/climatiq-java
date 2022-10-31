package com.climatiq.api.client.custom.activities;

import com.climatiq.api.client.custom.activities.exceptions.BatchCustomActivitiesException;
import com.climatiq.api.client.custom.activities.exceptions.EstimateException;
import com.climatiq.api.client.custom.activities.types.batchCustomActivitiesResponse;
import com.climatiq.api.client.custom.activities.types.customActivityRequest;
import com.climatiq.api.client.estimation.types.EstimateResponse;
import com.climatiq.api.core.BearerAuth;
import com.climatiq.api.core.ObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/custom-activities")
interface CustomActivitiesService {
  @POST
  @Path("/estimate")
  EstimateResponse estimate(@HeaderParam("Authorization") BearerAuth auth,
      customActivityRequest body) throws EstimateException;

  @POST
  @Path("/batch")
  batchCustomActivitiesResponse batchCustomActivities(@HeaderParam("Authorization") BearerAuth auth,
      List<customActivityRequest> body) throws BatchCustomActivitiesException;

  static CustomActivitiesService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new CustomActivitiesServiceErrorDecoder()).target(CustomActivitiesService.class, url);
  }
}
