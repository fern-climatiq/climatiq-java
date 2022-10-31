package com.climatiq.api.client.emission.factor;

import com.climatiq.api.client.emission.factor.exceptions.GetCategoriesException;
import com.climatiq.api.client.emission.factor.exceptions.GetLcaActivitiesException;
import com.climatiq.api.client.emission.factor.exceptions.GetRegionsException;
import com.climatiq.api.client.emission.factor.exceptions.GetSectorsException;
import com.climatiq.api.client.emission.factor.exceptions.GetSourcesException;
import com.climatiq.api.client.emission.factor.exceptions.GetUnitTypesException;
import com.climatiq.api.client.emission.factor.exceptions.GetYearsException;
import com.climatiq.api.client.emission.factor.exceptions.SearchException;
import com.climatiq.api.client.emission.factor.types.CategoriesResponse;
import com.climatiq.api.client.emission.factor.types.LcaActivitiesResponse;
import com.climatiq.api.client.emission.factor.types.RegionsResponse;
import com.climatiq.api.client.emission.factor.types.SearchEmissionFactorsResponse;
import com.climatiq.api.client.emission.factor.types.SectorsResponse;
import com.climatiq.api.client.emission.factor.types.SourcesResponse;
import com.climatiq.api.client.emission.factor.types.UnitTypesResponse;
import com.climatiq.api.client.emission.factor.types.YearsResponse;
import com.climatiq.api.client.estimation.types.CalculationMethod;
import com.climatiq.api.core.BearerAuth;
import com.climatiq.api.core.ObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.Integer;
import java.lang.String;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
interface EmissionFactorsService {
  @GET
  @Path("/search")
  SearchEmissionFactorsResponse search(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("query") Optional<String> query, @QueryParam("uuid") Optional<String> uuid,
      @QueryParam("activity_id") Optional<String> activityId, @QueryParam("id") Optional<String> id,
      @QueryParam("category") Optional<String> category,
      @QueryParam("sector") Optional<String> sector, @QueryParam("source") Optional<String> source,
      @QueryParam("year") Optional<String> year, @QueryParam("region") Optional<String> region,
      @QueryParam("lca_activity") Optional<String> lcaActivity,
      @QueryParam("unit_type") Optional<String> unitType,
      @QueryParam("calculation_method") Optional<CalculationMethod> calculationMethod,
      @QueryParam("page") Optional<Integer> page,
      @QueryParam("results_per_page") Optional<Integer> resultsPerPage) throws SearchException;

  @GET
  @Path("/emission-factors/years")
  YearsResponse getYears(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("category") Optional<String> category,
      @QueryParam("source") Optional<String> source, @QueryParam("region") Optional<String> region,
      @QueryParam("year") Optional<String> year,
      @QueryParam("calculation_method") Optional<String> calculationMethod,
      @QueryParam("lca_activity") Optional<String> lcaActivity,
      @QueryParam("activity_id") Optional<String> activityId) throws GetYearsException;

  @GET
  @Path("/emission-factors/sources")
  SourcesResponse getSources(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("sector") Optional<String> sector,
      @QueryParam("category") Optional<String> category,
      @QueryParam("source") Optional<String> source, @QueryParam("region") Optional<String> region,
      @QueryParam("year") Optional<String> year,
      @QueryParam("calculation_method") Optional<String> calculationMethod,
      @QueryParam("lca_activity") Optional<String> lcaActivity,
      @QueryParam("iactivity_idd") Optional<String> iactivityIdd) throws GetSourcesException;

  @GET
  @Path("/emission-factors/regions")
  RegionsResponse getRegions(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("sector") Optional<String> sector,
      @QueryParam("category") Optional<String> category,
      @QueryParam("source") Optional<String> source, @QueryParam("region") Optional<String> region,
      @QueryParam("year") Optional<String> year,
      @QueryParam("calculation_method") Optional<String> calculationMethod,
      @QueryParam("lca_activity") Optional<String> lcaActivity,
      @QueryParam("activity_id") Optional<String> activityId) throws GetRegionsException;

  @GET
  @Path("/emission-factors/categories")
  CategoriesResponse getCategories(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("sector") Optional<String> sector,
      @QueryParam("category") Optional<String> category,
      @QueryParam("source") Optional<String> source, @QueryParam("region") Optional<String> region,
      @QueryParam("year") Optional<String> year,
      @QueryParam("calculation_method") Optional<String> calculationMethod,
      @QueryParam("lca_activity") Optional<String> lcaActivity,
      @QueryParam("activity_id") Optional<String> activityId) throws GetCategoriesException;

  @GET
  @Path("/emission-factors/sectors")
  SectorsResponse getSectors(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("sector") Optional<String> sector,
      @QueryParam("category") Optional<String> category,
      @QueryParam("source") Optional<String> source, @QueryParam("region") Optional<String> region,
      @QueryParam("year") Optional<String> year,
      @QueryParam("calculation_method") Optional<String> calculationMethod,
      @QueryParam("lca_activity") Optional<String> lcaActivity,
      @QueryParam("activity_id") Optional<String> activityId) throws GetSectorsException;

  @GET
  @Path("/emission-factors/lca-activities")
  LcaActivitiesResponse getLcaActivities(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("sector") Optional<String> sector,
      @QueryParam("category") Optional<String> category,
      @QueryParam("source") Optional<String> source, @QueryParam("region") Optional<String> region,
      @QueryParam("year") Optional<String> year,
      @QueryParam("calculation_method") Optional<String> calculationMethod,
      @QueryParam("lca_activity") Optional<String> lcaActivity,
      @QueryParam("activity_id") Optional<String> activityId) throws GetLcaActivitiesException;

  @GET
  @Path("/emission-factors/")
  UnitTypesResponse getUnitTypes(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("sector") Optional<String> sector,
      @QueryParam("category") Optional<String> category,
      @QueryParam("source") Optional<String> source, @QueryParam("region") Optional<String> region,
      @QueryParam("year") Optional<String> year,
      @QueryParam("calculation_method") Optional<String> calculationMethod,
      @QueryParam("lca_activity") Optional<String> lcaActivity,
      @QueryParam("activity_id") Optional<String> activityId) throws GetUnitTypesException;

  static EmissionFactorsService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new EmissionFactorsServiceErrorDecoder()).target(EmissionFactorsService.class, url);
  }
}
