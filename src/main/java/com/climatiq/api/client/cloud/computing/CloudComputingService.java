package com.climatiq.api.client.cloud.computing;

import com.climatiq.api.client.cloud.computing.exceptions.CpuException;
import com.climatiq.api.client.cloud.computing.exceptions.MemoryException;
import com.climatiq.api.client.cloud.computing.exceptions.MetadataException;
import com.climatiq.api.client.cloud.computing.exceptions.StorageException;
import com.climatiq.api.client.cloud.computing.types.CpuRequest;
import com.climatiq.api.client.cloud.computing.types.MemoryRequest;
import com.climatiq.api.client.cloud.computing.types.MetadataResponse;
import com.climatiq.api.client.cloud.computing.types.ProviderId;
import com.climatiq.api.client.cloud.computing.types.StorageRequest;
import com.climatiq.api.client.estimation.types.EstimateResponse;
import com.climatiq.api.core.BearerAuth;
import com.climatiq.api.core.ObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
interface CloudComputingService {
  @GET
  @Path("/compute")
  MetadataResponse metadata(@HeaderParam("Authorization") BearerAuth auth) throws MetadataException;

  @POST
  @Path("/compute/{provider}/cpu")
  EstimateResponse cpu(@HeaderParam("Authorization") BearerAuth auth,
      @PathParam("provider") ProviderId provider, CpuRequest body) throws CpuException;

  @POST
  @Path("/compute/{provider}/storage")
  EstimateResponse storage(@HeaderParam("Authorization") BearerAuth auth,
      @PathParam("provider") ProviderId provider, StorageRequest body) throws StorageException;

  @POST
  @Path("/compute/{provider}/memory")
  EstimateResponse memory(@HeaderParam("Authorization") BearerAuth auth,
      @PathParam("provider") ProviderId provider, MemoryRequest body) throws MemoryException;

  static CloudComputingService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new CloudComputingServiceErrorDecoder()).target(CloudComputingService.class, url);
  }
}
