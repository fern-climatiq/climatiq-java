package com.climatiq.api.client.emission.factor;

import com.climatiq.api.client.emission.factor.endpoints.GetCategories;
import com.climatiq.api.client.emission.factor.endpoints.GetLcaActivities;
import com.climatiq.api.client.emission.factor.endpoints.GetRegions;
import com.climatiq.api.client.emission.factor.endpoints.GetSectors;
import com.climatiq.api.client.emission.factor.endpoints.GetSources;
import com.climatiq.api.client.emission.factor.endpoints.GetUnitTypes;
import com.climatiq.api.client.emission.factor.endpoints.GetYears;
import com.climatiq.api.client.emission.factor.endpoints.Search;
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
import com.climatiq.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class EmissionFactorsServiceClient {
  private final EmissionFactorsService service;

  private final Optional<BearerAuth> auth;

  public EmissionFactorsServiceClient(String url) {
    this.service = EmissionFactorsService.getClient(url);
    this.auth = Optional.empty();
  }

  public EmissionFactorsServiceClient(String url, BearerAuth auth) {
    this.service = EmissionFactorsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public SearchEmissionFactorsResponse search(Search.Request request) throws SearchException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for search")));
    return this.service.search(authValue, request.getQuery(), request.getUuid(), request.getActivityId(), request.getId(), request.getCategory(), request.getSector(), request.getSource(), request.getYear(), request.getRegion(), request.getLcaActivity(), request.getUnitType(), request.getCalculationMethod(), request.getPage(), request.getResultsPerPage());
  }

  public YearsResponse getYears(GetYears.Request request) throws GetYearsException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getYears")));
    return this.service.getYears(authValue, request.getCategory(), request.getSource(), request.getRegion(), request.getYear(), request.getCalculationMethod(), request.getLcaActivity(), request.getActivityId());
  }

  public SourcesResponse getSources(GetSources.Request request) throws GetSourcesException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getSources")));
    return this.service.getSources(authValue, request.getSector(), request.getCategory(), request.getSource(), request.getRegion(), request.getYear(), request.getCalculationMethod(), request.getLcaActivity(), request.getIactivityIdd());
  }

  public RegionsResponse getRegions(GetRegions.Request request) throws GetRegionsException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getRegions")));
    return this.service.getRegions(authValue, request.getSector(), request.getCategory(), request.getSource(), request.getRegion(), request.getYear(), request.getCalculationMethod(), request.getLcaActivity(), request.getActivityId());
  }

  public CategoriesResponse getCategories(GetCategories.Request request) throws
      GetCategoriesException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getCategories")));
    return this.service.getCategories(authValue, request.getSector(), request.getCategory(), request.getSource(), request.getRegion(), request.getYear(), request.getCalculationMethod(), request.getLcaActivity(), request.getActivityId());
  }

  public SectorsResponse getSectors(GetSectors.Request request) throws GetSectorsException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getSectors")));
    return this.service.getSectors(authValue, request.getSector(), request.getCategory(), request.getSource(), request.getRegion(), request.getYear(), request.getCalculationMethod(), request.getLcaActivity(), request.getActivityId());
  }

  public LcaActivitiesResponse getLcaActivities(GetLcaActivities.Request request) throws
      GetLcaActivitiesException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getLcaActivities")));
    return this.service.getLcaActivities(authValue, request.getSector(), request.getCategory(), request.getSource(), request.getRegion(), request.getYear(), request.getCalculationMethod(), request.getLcaActivity(), request.getActivityId());
  }

  public UnitTypesResponse getUnitTypes(GetUnitTypes.Request request) throws GetUnitTypesException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getUnitTypes")));
    return this.service.getUnitTypes(authValue, request.getSector(), request.getCategory(), request.getSource(), request.getRegion(), request.getYear(), request.getCalculationMethod(), request.getLcaActivity(), request.getActivityId());
  }
}
