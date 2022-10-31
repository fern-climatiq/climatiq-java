package com.climatiq.api.client.emission.factor.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = SearchEmissionFactorsResponse.Builder.class
)
public final class SearchEmissionFactorsResponse {
  private final List<EmissionFactor> results;

  private final int currentPage;

  private final int lastPage;

  private final int totalResults;

  private final PossibleEmissionFactorFilters possibleFilters;

  private int _cachedHashCode;

  SearchEmissionFactorsResponse(List<EmissionFactor> results, int currentPage, int lastPage,
      int totalResults, PossibleEmissionFactorFilters possibleFilters) {
    this.results = results;
    this.currentPage = currentPage;
    this.lastPage = lastPage;
    this.totalResults = totalResults;
    this.possibleFilters = possibleFilters;
  }

  @JsonProperty("results")
  public List<EmissionFactor> getResults() {
    return results;
  }

  @JsonProperty("current_page")
  public int getCurrentPage() {
    return currentPage;
  }

  @JsonProperty("last_page")
  public int getLastPage() {
    return lastPage;
  }

  @JsonProperty("total_results")
  public int getTotalResults() {
    return totalResults;
  }

  @JsonProperty("possible_filters")
  public PossibleEmissionFactorFilters getPossibleFilters() {
    return possibleFilters;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SearchEmissionFactorsResponse && equalTo((SearchEmissionFactorsResponse) other);
  }

  private boolean equalTo(SearchEmissionFactorsResponse other) {
    return results.equals(other.results) && currentPage == other.currentPage && lastPage == other.lastPage && totalResults == other.totalResults && possibleFilters.equals(other.possibleFilters);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.results, this.currentPage, this.lastPage, this.totalResults, this.possibleFilters);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SearchEmissionFactorsResponse{" + "results: " + results + ", currentPage: " + currentPage + ", lastPage: " + lastPage + ", totalResults: " + totalResults + ", possibleFilters: " + possibleFilters + "}";
  }

  public static CurrentPageStage builder() {
    return new Builder();
  }

  public interface CurrentPageStage {
    LastPageStage currentPage(int currentPage);

    Builder from(SearchEmissionFactorsResponse other);
  }

  public interface LastPageStage {
    TotalResultsStage lastPage(int lastPage);
  }

  public interface TotalResultsStage {
    PossibleFiltersStage totalResults(int totalResults);
  }

  public interface PossibleFiltersStage {
    _FinalStage possibleFilters(PossibleEmissionFactorFilters possibleFilters);
  }

  public interface _FinalStage {
    SearchEmissionFactorsResponse build();

    _FinalStage results(List<EmissionFactor> results);

    _FinalStage results(EmissionFactor results);

    _FinalStage addAllResults(List<EmissionFactor> results);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements CurrentPageStage, LastPageStage, TotalResultsStage, PossibleFiltersStage, _FinalStage {
    private int currentPage;

    private int lastPage;

    private int totalResults;

    private PossibleEmissionFactorFilters possibleFilters;

    private List<EmissionFactor> results = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(SearchEmissionFactorsResponse other) {
      results(other.getResults());
      currentPage(other.getCurrentPage());
      lastPage(other.getLastPage());
      totalResults(other.getTotalResults());
      possibleFilters(other.getPossibleFilters());
      return this;
    }

    @Override
    @JsonSetter("current_page")
    public LastPageStage currentPage(int currentPage) {
      this.currentPage = currentPage;
      return this;
    }

    @Override
    @JsonSetter("last_page")
    public TotalResultsStage lastPage(int lastPage) {
      this.lastPage = lastPage;
      return this;
    }

    @Override
    @JsonSetter("total_results")
    public PossibleFiltersStage totalResults(int totalResults) {
      this.totalResults = totalResults;
      return this;
    }

    @Override
    @JsonSetter("possible_filters")
    public _FinalStage possibleFilters(PossibleEmissionFactorFilters possibleFilters) {
      this.possibleFilters = possibleFilters;
      return this;
    }

    @Override
    public _FinalStage addAllResults(List<EmissionFactor> results) {
      this.results.addAll(results);
      return this;
    }

    @Override
    public _FinalStage results(EmissionFactor results) {
      this.results.add(results);
      return this;
    }

    @Override
    @JsonSetter(
        value = "results",
        nulls = Nulls.SKIP
    )
    public _FinalStage results(List<EmissionFactor> results) {
      this.results.clear();
      this.results.addAll(results);
      return this;
    }

    @Override
    public SearchEmissionFactorsResponse build() {
      return new SearchEmissionFactorsResponse(results, currentPage, lastPage, totalResults, possibleFilters);
    }
  }
}
