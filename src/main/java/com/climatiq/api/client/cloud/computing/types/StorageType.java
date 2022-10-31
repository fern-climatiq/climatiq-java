package com.climatiq.api.client.cloud.computing.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class StorageType {
  public static final StorageType HDD = new StorageType(Value.HDD, "hdd");

  public static final StorageType SSD = new StorageType(Value.SSD, "ssd");

  private final Value value;

  private final String string;

  StorageType(Value value, String string) {
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
      || (other instanceof StorageType && this.string.equals(((StorageType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case HDD:
        return visitor.visitHdd();
      case SSD:
        return visitor.visitSsd();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static StorageType valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "hdd":
        return HDD;
      case "ssd":
        return SSD;
      default:
        return new StorageType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    SSD,

    HDD,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitSsd();

    T visitHdd();

    T visitUnknown(String unknownType);
  }
}
