package com.climatiq.api.client.emission.factor.endpoints;

import com.climatiq.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetRegions {
  private GetRegions() {
  }

  public static final class Request {
    private final Optional<BearerAuth> authOverride;

    private final Optional<String> sector;

    private final Optional<String> category;

    private final Optional<String> source;

    private final Optional<String> region;

    private final Optional<String> year;

    private final Optional<String> calculationMethod;

    private final Optional<String> lcaActivity;

    private final Optional<String> activityId;

    private int _cachedHashCode;

    Request(Optional<BearerAuth> authOverride, Optional<String> sector, Optional<String> category,
        Optional<String> source, Optional<String> region, Optional<String> year,
        Optional<String> calculationMethod, Optional<String> lcaActivity,
        Optional<String> activityId) {
      this.authOverride = authOverride;
      this.sector = sector;
      this.category = category;
      this.source = source;
      this.region = region;
      this.year = year;
      this.calculationMethod = calculationMethod;
      this.lcaActivity = lcaActivity;
      this.activityId = activityId;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    public Optional<String> getSector() {
      return sector;
    }

    public Optional<String> getCategory() {
      return category;
    }

    public Optional<String> getSource() {
      return source;
    }

    public Optional<String> getRegion() {
      return region;
    }

    public Optional<String> getYear() {
      return year;
    }

    public Optional<String> getCalculationMethod() {
      return calculationMethod;
    }

    public Optional<String> getLcaActivity() {
      return lcaActivity;
    }

    public Optional<String> getActivityId() {
      return activityId;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && sector.equals(other.sector) && category.equals(other.category) && source.equals(other.source) && region.equals(other.region) && year.equals(other.year) && calculationMethod.equals(other.calculationMethod) && lcaActivity.equals(other.lcaActivity) && activityId.equals(other.activityId);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.sector, this.category, this.source, this.region, this.year, this.calculationMethod, this.lcaActivity, this.activityId);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetRegions.Request{" + "authOverride: " + authOverride + ", sector: " + sector + ", category: " + category + ", source: " + source + ", region: " + region + ", year: " + year + ", calculationMethod: " + calculationMethod + ", lcaActivity: " + lcaActivity + ", activityId: " + activityId + "}";
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Builder {
      private Optional<BearerAuth> authOverride = Optional.empty();

      private Optional<String> sector = Optional.empty();

      private Optional<String> category = Optional.empty();

      private Optional<String> source = Optional.empty();

      private Optional<String> region = Optional.empty();

      private Optional<String> year = Optional.empty();

      private Optional<String> calculationMethod = Optional.empty();

      private Optional<String> lcaActivity = Optional.empty();

      private Optional<String> activityId = Optional.empty();

      private Builder() {
      }

      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        sector(other.getSector());
        category(other.getCategory());
        source(other.getSource());
        region(other.getRegion());
        year(other.getYear());
        calculationMethod(other.getCalculationMethod());
        lcaActivity(other.getLcaActivity());
        activityId(other.getActivityId());
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

      public Builder sector(Optional<String> sector) {
        this.sector = sector;
        return this;
      }

      public Builder sector(String sector) {
        this.sector = Optional.of(sector);
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

      public Builder source(Optional<String> source) {
        this.source = source;
        return this;
      }

      public Builder source(String source) {
        this.source = Optional.of(source);
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

      public Builder year(Optional<String> year) {
        this.year = year;
        return this;
      }

      public Builder year(String year) {
        this.year = Optional.of(year);
        return this;
      }

      public Builder calculationMethod(Optional<String> calculationMethod) {
        this.calculationMethod = calculationMethod;
        return this;
      }

      public Builder calculationMethod(String calculationMethod) {
        this.calculationMethod = Optional.of(calculationMethod);
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

      public Builder activityId(Optional<String> activityId) {
        this.activityId = activityId;
        return this;
      }

      public Builder activityId(String activityId) {
        this.activityId = Optional.of(activityId);
        return this;
      }

      public Request build() {
        return new Request(authOverride, sector, category, source, region, year, calculationMethod, lcaActivity, activityId);
      }
    }
  }
}
