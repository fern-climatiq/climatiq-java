package com.climatiq.api.client.flights.types;

import com.climatiq.api.client.estimation.types.EmissionSelector;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = TravelLeg.Builder.class
)
public final class TravelLeg implements IBaseLeg {
  private final String from;

  private final String to;

  private final Optional<Integer> passengers;

  private final Optional<String> _class;

  private final Optional<EmissionSelector> emissionFactor;

  private int _cachedHashCode;

  TravelLeg(String from, String to, Optional<Integer> passengers, Optional<String> _class,
      Optional<EmissionSelector> emissionFactor) {
    this.from = from;
    this.to = to;
    this.passengers = passengers;
    this._class = _class;
    this.emissionFactor = emissionFactor;
  }

  @JsonProperty("from")
  @Override
  public String getFrom() {
    return from;
  }

  @JsonProperty("to")
  @Override
  public String getTo() {
    return to;
  }

  @JsonProperty("passengers")
  public Optional<Integer> getPassengers() {
    return passengers;
  }

  @JsonProperty("class")
  public Optional<String> getClass() {
    return _class;
  }

  @JsonProperty("emission_factor")
  public Optional<EmissionSelector> getEmissionFactor() {
    return emissionFactor;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof TravelLeg && equalTo((TravelLeg) other);
  }

  private boolean equalTo(TravelLeg other) {
    return from.equals(other.from) && to.equals(other.to) && passengers.equals(other.passengers) && _class.equals(other._class) && emissionFactor.equals(other.emissionFactor);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.from, this.to, this.passengers, this._class, this.emissionFactor);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "TravelLeg{" + "from: " + from + ", to: " + to + ", passengers: " + passengers + ", _class: " + _class + ", emissionFactor: " + emissionFactor + "}";
  }

  public static FromStage builder() {
    return new Builder();
  }

  public interface FromStage {
    ToStage from(String from);

    Builder from(TravelLeg other);
  }

  public interface ToStage {
    _FinalStage to(String to);
  }

  public interface _FinalStage {
    TravelLeg build();

    _FinalStage passengers(Optional<Integer> passengers);

    _FinalStage passengers(Integer passengers);

    _FinalStage _class(Optional<String> _class);

    _FinalStage _class(String _class);

    _FinalStage emissionFactor(Optional<EmissionSelector> emissionFactor);

    _FinalStage emissionFactor(EmissionSelector emissionFactor);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements FromStage, ToStage, _FinalStage {
    private String from;

    private String to;

    private Optional<EmissionSelector> emissionFactor = Optional.empty();

    private Optional<String> _class = Optional.empty();

    private Optional<Integer> passengers = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(TravelLeg other) {
      from(other.getFrom());
      to(other.getTo());
      passengers(other.getPassengers());
      _class(other.getClass());
      emissionFactor(other.getEmissionFactor());
      return this;
    }

    @Override
    @JsonSetter("from")
    public ToStage from(String from) {
      this.from = from;
      return this;
    }

    @Override
    @JsonSetter("to")
    public _FinalStage to(String to) {
      this.to = to;
      return this;
    }

    @Override
    public _FinalStage emissionFactor(EmissionSelector emissionFactor) {
      this.emissionFactor = Optional.of(emissionFactor);
      return this;
    }

    @Override
    @JsonSetter(
        value = "emission_factor",
        nulls = Nulls.SKIP
    )
    public _FinalStage emissionFactor(Optional<EmissionSelector> emissionFactor) {
      this.emissionFactor = emissionFactor;
      return this;
    }

    @Override
    public _FinalStage _class(String _class) {
      this._class = Optional.of(_class);
      return this;
    }

    @Override
    @JsonSetter(
        value = "class",
        nulls = Nulls.SKIP
    )
    public _FinalStage _class(Optional<String> _class) {
      this._class = _class;
      return this;
    }

    @Override
    public _FinalStage passengers(Integer passengers) {
      this.passengers = Optional.of(passengers);
      return this;
    }

    @Override
    @JsonSetter(
        value = "passengers",
        nulls = Nulls.SKIP
    )
    public _FinalStage passengers(Optional<Integer> passengers) {
      this.passengers = passengers;
      return this;
    }

    @Override
    public TravelLeg build() {
      return new TravelLeg(from, to, passengers, _class, emissionFactor);
    }
  }
}
