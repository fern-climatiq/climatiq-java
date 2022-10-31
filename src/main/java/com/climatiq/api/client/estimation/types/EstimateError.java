package com.climatiq.api.client.estimation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = EstimateError.Builder.class
)
public final class EstimateError {
  private final String error;

  private final String message;

  private int _cachedHashCode;

  EstimateError(String error, String message) {
    this.error = error;
    this.message = message;
  }

  @JsonProperty("error")
  public String getError() {
    return error;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EstimateError && equalTo((EstimateError) other);
  }

  private boolean equalTo(EstimateError other) {
    return error.equals(other.error) && message.equals(other.message);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.error, this.message);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EstimateError{" + "error: " + error + ", message: " + message + "}";
  }

  public static ErrorStage builder() {
    return new Builder();
  }

  public interface ErrorStage {
    MessageStage error(String error);

    Builder from(EstimateError other);
  }

  public interface MessageStage {
    _FinalStage message(String message);
  }

  public interface _FinalStage {
    EstimateError build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements ErrorStage, MessageStage, _FinalStage {
    private String error;

    private String message;

    private Builder() {
    }

    @Override
    public Builder from(EstimateError other) {
      error(other.getError());
      message(other.getMessage());
      return this;
    }

    @Override
    @JsonSetter("error")
    public MessageStage error(String error) {
      this.error = error;
      return this;
    }

    @Override
    @JsonSetter("message")
    public _FinalStage message(String message) {
      this.message = message;
      return this;
    }

    @Override
    public EstimateError build() {
      return new EstimateError(error, message);
    }
  }
}
