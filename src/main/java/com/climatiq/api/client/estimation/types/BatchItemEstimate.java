package com.climatiq.api.client.estimation.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class BatchItemEstimate {
  private final Value value;

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  private BatchItemEstimate(Value value) {
    this.value = value;
  }

  public <T> T visit(Visitor<T> visitor) {
    return value.visit(visitor);
  }

  public static BatchItemEstimate response(EstimateResponse response) {
    return new BatchItemEstimate(new ResponseValue(response));
  }

  public static BatchItemEstimate error(EstimateError error) {
    return new BatchItemEstimate(new ErrorValue(error));
  }

  public boolean isResponse() {
    return value instanceof ResponseValue;
  }

  public boolean isError() {
    return value instanceof ErrorValue;
  }

  public boolean _isUnknown() {
    return value instanceof _UnknownValue;
  }

  public Optional<EstimateResponse> getResponse() {
    if (isResponse()) {
      return Optional.of(((ResponseValue) value).response);
    }
    return Optional.empty();
  }

  public Optional<EstimateError> getError() {
    if (isError()) {
      return Optional.of(((ErrorValue) value).error);
    }
    return Optional.empty();
  }

  public Optional<Object> _getUnknown() {
    if (_isUnknown()) {
      return Optional.of(((_UnknownValue) value).value);
    }
    return Optional.empty();
  }

  @JsonValue
  private Value getValue() {
    return this.value;
  }

  public interface Visitor<T> {
    T visitResponse(EstimateResponse response);

    T visitError(EstimateError error);

    T _visitUnknown(Object unknown);
  }

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      property = "type",
      visible = true,
      defaultImpl = _UnknownValue.class
  )
  @JsonSubTypes({
      @JsonSubTypes.Type(ResponseValue.class),
      @JsonSubTypes.Type(ErrorValue.class)
  })
  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  private interface Value {
    <T> T visit(Visitor<T> visitor);
  }

  @JsonTypeName("response")
  private static final class ResponseValue implements Value {
    @JsonUnwrapped
    private EstimateResponse response;

    private ResponseValue(EstimateResponse response) {
      this.response = response;
    }

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private ResponseValue() {
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitResponse(response);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof ResponseValue && equalTo((ResponseValue) other);
    }

    private boolean equalTo(ResponseValue other) {
      return response.equals(other.response);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.response);
    }

    @Override
    public String toString() {
      return "BatchItemEstimate{" + "response: " + response + "}";
    }
  }

  @JsonTypeName("error")
  private static final class ErrorValue implements Value {
    @JsonUnwrapped
    private EstimateError error;

    private ErrorValue(EstimateError error) {
      this.error = error;
    }

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private ErrorValue() {
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitError(error);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof ErrorValue && equalTo((ErrorValue) other);
    }

    private boolean equalTo(ErrorValue other) {
      return error.equals(other.error);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.error);
    }

    @Override
    public String toString() {
      return "BatchItemEstimate{" + "error: " + error + "}";
    }
  }

  private static final class _UnknownValue implements Value {
    private String type;

    @JsonValue
    private Object value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private _UnknownValue(@JsonProperty("value") Object value) {
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor._visitUnknown(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
    }

    private boolean equalTo(_UnknownValue other) {
      return type.equals(other.type) && value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.type, this.value);
    }

    @Override
    public String toString() {
      return "BatchItemEstimate{" + "type: " + type + ", value: " + value + "}";
    }
  }
}
