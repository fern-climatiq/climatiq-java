package com.climatiq.api.client.estimation.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class CalculationMethod {
  public static final CalculationMethod AR_4 = new CalculationMethod(Value.AR_4, "ar4");

  public static final CalculationMethod AR_5 = new CalculationMethod(Value.AR_5, "ar5");

  private final Value value;

  private final String string;

  CalculationMethod(Value value, String string) {
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
      || (other instanceof CalculationMethod && this.string.equals(((CalculationMethod) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case AR_4:
        return visitor.visitAr4();
      case AR_5:
        return visitor.visitAr5();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static CalculationMethod valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "ar4":
        return AR_4;
      case "ar5":
        return AR_5;
      default:
        return new CalculationMethod(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    AR_4,

    AR_5,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitAr4();

    T visitAr5();

    T visitUnknown(String unknownType);
  }
}
