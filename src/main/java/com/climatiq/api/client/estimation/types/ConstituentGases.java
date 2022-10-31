package com.climatiq.api.client.estimation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ConstituentGases.Builder.class
)
public final class ConstituentGases {
  private final Optional<Double> co2ETotal;

  private final Optional<Double> co2EOther;

  private final Optional<Double> co2;

  private final Optional<Double> ch4;

  private final Optional<Double> n2O;

  private int _cachedHashCode;

  ConstituentGases(Optional<Double> co2ETotal, Optional<Double> co2EOther, Optional<Double> co2,
      Optional<Double> ch4, Optional<Double> n2O) {
    this.co2ETotal = co2ETotal;
    this.co2EOther = co2EOther;
    this.co2 = co2;
    this.ch4 = ch4;
    this.n2O = n2O;
  }

  @JsonProperty("co2e_total")
  public Optional<Double> getCo2ETotal() {
    return co2ETotal;
  }

  @JsonProperty("co2e_other")
  public Optional<Double> getCo2EOther() {
    return co2EOther;
  }

  @JsonProperty("co2")
  public Optional<Double> getCo2() {
    return co2;
  }

  @JsonProperty("ch4")
  public Optional<Double> getCh4() {
    return ch4;
  }

  @JsonProperty("n2o")
  public Optional<Double> getN2O() {
    return n2O;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ConstituentGases && equalTo((ConstituentGases) other);
  }

  private boolean equalTo(ConstituentGases other) {
    return co2ETotal.equals(other.co2ETotal) && co2EOther.equals(other.co2EOther) && co2.equals(other.co2) && ch4.equals(other.ch4) && n2O.equals(other.n2O);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.co2ETotal, this.co2EOther, this.co2, this.ch4, this.n2O);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ConstituentGases{" + "co2ETotal: " + co2ETotal + ", co2EOther: " + co2EOther + ", co2: " + co2 + ", ch4: " + ch4 + ", n2O: " + n2O + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Double> co2ETotal = Optional.empty();

    private Optional<Double> co2EOther = Optional.empty();

    private Optional<Double> co2 = Optional.empty();

    private Optional<Double> ch4 = Optional.empty();

    private Optional<Double> n2O = Optional.empty();

    private Builder() {
    }

    public Builder from(ConstituentGases other) {
      co2ETotal(other.getCo2ETotal());
      co2EOther(other.getCo2EOther());
      co2(other.getCo2());
      ch4(other.getCh4());
      n2O(other.getN2O());
      return this;
    }

    @JsonSetter(
        value = "co2e_total",
        nulls = Nulls.SKIP
    )
    public Builder co2ETotal(Optional<Double> co2ETotal) {
      this.co2ETotal = co2ETotal;
      return this;
    }

    public Builder co2ETotal(Double co2ETotal) {
      this.co2ETotal = Optional.of(co2ETotal);
      return this;
    }

    @JsonSetter(
        value = "co2e_other",
        nulls = Nulls.SKIP
    )
    public Builder co2EOther(Optional<Double> co2EOther) {
      this.co2EOther = co2EOther;
      return this;
    }

    public Builder co2EOther(Double co2EOther) {
      this.co2EOther = Optional.of(co2EOther);
      return this;
    }

    @JsonSetter(
        value = "co2",
        nulls = Nulls.SKIP
    )
    public Builder co2(Optional<Double> co2) {
      this.co2 = co2;
      return this;
    }

    public Builder co2(Double co2) {
      this.co2 = Optional.of(co2);
      return this;
    }

    @JsonSetter(
        value = "ch4",
        nulls = Nulls.SKIP
    )
    public Builder ch4(Optional<Double> ch4) {
      this.ch4 = ch4;
      return this;
    }

    public Builder ch4(Double ch4) {
      this.ch4 = Optional.of(ch4);
      return this;
    }

    @JsonSetter(
        value = "n2o",
        nulls = Nulls.SKIP
    )
    public Builder n2O(Optional<Double> n2O) {
      this.n2O = n2O;
      return this;
    }

    public Builder n2O(Double n2O) {
      this.n2O = Optional.of(n2O);
      return this;
    }

    public ConstituentGases build() {
      return new ConstituentGases(co2ETotal, co2EOther, co2, ch4, n2O);
    }
  }
}
