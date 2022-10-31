package com.climatiq.api.client.emission.factor.endpoints;

import com.climatiq.api.client.estimation.types.CalculationMethod;
import com.climatiq.api.core.BearerAuth;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Search {
  private Search() {
  }

  public static final class Request {
    private final Optional<BearerAuth> authOverride;

    private final Optional<String> query;

    private final Optional<String> uuid;

    private final Optional<String> activityId;

    private final Optional<String> id;

    private final Optional<String> category;

    private final Optional<String> sector;

    private final Optional<String> source;

    private final Optional<String> year;

    private final Optional<String> region;

    private final Optional<String> lcaActivity;

    private final Optional<String> unitType;

    private final Optional<CalculationMethod> calculationMethod;

    private final Optional<Integer> page;

    private final Optional<Integer> resultsPerPage;

    private int _cachedHashCode;

    Request(Optional<BearerAuth> authOverride, Optional<String> query, Optional<String> uuid,
        Optional<String> activityId, Optional<String> id, Optional<String> category,
        Optional<String> sector, Optional<String> source, Optional<String> year,
        Optional<String> region, Optional<String> lcaActivity, Optional<String> unitType,
        Optional<CalculationMethod> calculationMethod, Optional<Integer> page,
        Optional<Integer> resultsPerPage) {
      this.authOverride = authOverride;
      this.query = query;
      this.uuid = uuid;
      this.activityId = activityId;
      this.id = id;
      this.category = category;
      this.sector = sector;
      this.source = source;
      this.year = year;
      this.region = region;
      this.lcaActivity = lcaActivity;
      this.unitType = unitType;
      this.calculationMethod = calculationMethod;
      this.page = page;
      this.resultsPerPage = resultsPerPage;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    public Optional<String> getQuery() {
      return query;
    }

    public Optional<String> getUuid() {
      return uuid;
    }

    public Optional<String> getActivityId() {
      return activityId;
    }

    public Optional<String> getId() {
      return id;
    }

    public Optional<String> getCategory() {
      return category;
    }

    public Optional<String> getSector() {
      return sector;
    }

    public Optional<String> getSource() {
      return source;
    }

    public Optional<String> getYear() {
      return year;
    }

    public Optional<String> getRegion() {
      return region;
    }

    public Optional<String> getLcaActivity() {
      return lcaActivity;
    }

    public Optional<String> getUnitType() {
      return unitType;
    }

    public Optional<CalculationMethod> getCalculationMethod() {
      return calculationMethod;
    }

    public Optional<Integer> getPage() {
      return page;
    }

    public Optional<Integer> getResultsPerPage() {
      return resultsPerPage;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && query.equals(other.query) && uuid.equals(other.uuid) && activityId.equals(other.activityId) && id.equals(other.id) && category.equals(other.category) && sector.equals(other.sector) && source.equals(other.source) && year.equals(other.year) && region.equals(other.region) && lcaActivity.equals(other.lcaActivity) && unitType.equals(other.unitType) && calculationMethod.equals(other.calculationMethod) && page.equals(other.page) && resultsPerPage.equals(other.resultsPerPage);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.query, this.uuid, this.activityId, this.id, this.category, this.sector, this.source, this.year, this.region, this.lcaActivity, this.unitType, this.calculationMethod, this.page, this.resultsPerPage);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Search.Request{" + "authOverride: " + authOverride + ", query: " + query + ", uuid: " + uuid + ", activityId: " + activityId + ", id: " + id + ", category: " + category + ", sector: " + sector + ", source: " + source + ", year: " + year + ", region: " + region + ", lcaActivity: " + lcaActivity + ", unitType: " + unitType + ", calculationMethod: " + calculationMethod + ", page: " + page + ", resultsPerPage: " + resultsPerPage + "}";
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Builder {
      private Optional<BearerAuth> authOverride = Optional.empty();

      private Optional<String> query = Optional.empty();

      private Optional<String> uuid = Optional.empty();

      private Optional<String> activityId = Optional.empty();

      private Optional<String> id = Optional.empty();

      private Optional<String> category = Optional.empty();

      private Optional<String> sector = Optional.empty();

      private Optional<String> source = Optional.empty();

      private Optional<String> year = Optional.empty();

      private Optional<String> region = Optional.empty();

      private Optional<String> lcaActivity = Optional.empty();

      private Optional<String> unitType = Optional.empty();

      private Optional<CalculationMethod> calculationMethod = Optional.empty();

      private Optional<Integer> page = Optional.empty();

      private Optional<Integer> resultsPerPage = Optional.empty();

      private Builder() {
      }

      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        query(other.getQuery());
        uuid(other.getUuid());
        activityId(other.getActivityId());
        id(other.getId());
        category(other.getCategory());
        sector(other.getSector());
        source(other.getSource());
        year(other.getYear());
        region(other.getRegion());
        lcaActivity(other.getLcaActivity());
        unitType(other.getUnitType());
        calculationMethod(other.getCalculationMethod());
        page(other.getPage());
        resultsPerPage(other.getResultsPerPage());
        return this;
      }

      public Builder authOverride(Optional<BearerAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      public Builder authOverride(BearerAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      public Builder query(Optional<String> query) {
        this.query = query;
        return this;
      }

      public Builder query(String query) {
        this.query = Optional.of(query);
        return this;
      }

      public Builder uuid(Optional<String> uuid) {
        this.uuid = uuid;
        return this;
      }

      public Builder uuid(String uuid) {
        this.uuid = Optional.of(uuid);
        return this;
      }

      public Builder activityId(Optional<String> activityId) {
        this.activityId = activityId;
        return this;
      }

      public Builder activityId(String activityId) {
        this.activityId = Optional.of(activityId);
        return this;
      }

      public Builder id(Optional<String> id) {
        this.id = id;
        return this;
      }

      public Builder id(String id) {
        this.id = Optional.of(id);
        return this;
      }

      public Builder category(Optional<String> category) {
        this.category = category;
        return this;
      }

      public Builder category(String category) {
        this.category = Optional.of(category);
        return this;
      }

      public Builder sector(Optional<String> sector) {
        this.sector = sector;
        return this;
      }

      public Builder sector(String sector) {
        this.sector = Optional.of(sector);
        return this;
      }

      public Builder source(Optional<String> source) {
        this.source = source;
        return this;
      }

      public Builder source(String source) {
        this.source = Optional.of(source);
        return this;
      }

      public Builder year(Optional<String> year) {
        this.year = year;
        return this;
      }

      public Builder year(String year) {
        this.year = Optional.of(year);
        return this;
      }

      public Builder region(Optional<String> region) {
        this.region = region;
        return this;
      }

      public Builder region(String region) {
        this.region = Optional.of(region);
        return this;
      }

      public Builder lcaActivity(Optional<String> lcaActivity) {
        this.lcaActivity = lcaActivity;
        return this;
      }

      public Builder lcaActivity(String lcaActivity) {
        this.lcaActivity = Optional.of(lcaActivity);
        return this;
      }

      public Builder unitType(Optional<String> unitType) {
        this.unitType = unitType;
        return this;
      }

      public Builder unitType(String unitType) {
        this.unitType = Optional.of(unitType);
        return this;
      }

      public Builder calculationMethod(Optional<CalculationMethod> calculationMethod) {
        this.calculationMethod = calculationMethod;
        return this;
      }

      public Builder calculationMethod(CalculationMethod calculationMethod) {
        this.calculationMethod = Optional.of(calculationMethod);
        return this;
      }

      public Builder page(Optional<Integer> page) {
        this.page = page;
        return this;
      }

      public Builder page(Integer page) {
        this.page = Optional.of(page);
        return this;
      }

      public Builder resultsPerPage(Optional<Integer> resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
        return this;
      }

      public Builder resultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = Optional.of(resultsPerPage);
        return this;
      }

      public Request build() {
        return new Request(authOverride, query, uuid, activityId, id, category, sector, source, year, region, lcaActivity, unitType, calculationMethod, page, resultsPerPage);
      }
    }
  }
}
