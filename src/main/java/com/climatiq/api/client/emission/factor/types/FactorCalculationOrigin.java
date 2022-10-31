package com.climatiq.api.client.emission.factor.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class FactorCalculationOrigin {
  public static final FactorCalculationOrigin SOURCE = new FactorCalculationOrigin(Value.SOURCE, "source");

  public static final FactorCalculationOrigin CLIMATIQ = new FactorCalculationOrigin(Value.CLIMATIQ, "climatiq");

  private final Value value;

  private final String string;

  FactorCalculationOrigin(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof FactorCalculationOrigin && this.string.equals(((FactorCalculationOrigin) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case SOURCE:
        return visitor.visitSource();
      case CLIMATIQ:
        return visitor.visitClimatiq();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static FactorCalculationOrigin valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "source":
        return SOURCE;
      case "climatiq":
        return CLIMATIQ;
      default:
        return new FactorCalculationOrigin(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    CLIMATIQ,

    SOURCE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitClimatiq();

    T visitSource();

    T visitUnknown(String unknownType);
  }
}
