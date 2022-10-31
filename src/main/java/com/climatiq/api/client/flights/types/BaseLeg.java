package com.climatiq.api.client.flights.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = BaseLeg.Builder.class
)
public final class BaseLeg implements IBaseLeg {
  private final String from;

  private final String to;

  private int _cachedHashCode;

  BaseLeg(String from, String to) {
    this.from = from;
    this.to = to;
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

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BaseLeg && equalTo((BaseLeg) other);
  }

  private boolean equalTo(BaseLeg other) {
    return from.equals(other.from) && to.equals(other.to);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.from, this.to);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BaseLeg{" + "from: " + from + ", to: " + to + "}";
  }

  public static FromStage builder() {
    return new Builder();
  }

  public interface FromStage {
    ToStage from(String from);

    Builder from(BaseLeg other);
  }

  public interface ToStage {
    _FinalStage to(String to);
  }

  public interface _FinalStage {
    BaseLeg build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements FromStage, ToStage, _FinalStage {
    private String from;

    private String to;

    private Builder() {
    }

    @Override
    public Builder from(BaseLeg other) {
      from(other.getFrom());
      to(other.getTo());
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
    public BaseLeg build() {
      return new BaseLeg(from, to);
    }
  }
}
