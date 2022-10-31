package com.climatiq.api.client.cloud.computing.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class CloudProvider {
  public static final CloudProvider AWS = new CloudProvider(Value.AWS, "aws");

  public static final CloudProvider AZURE = new CloudProvider(Value.AZURE, "azure");

  public static final CloudProvider GCP = new CloudProvider(Value.GCP, "gcp");

  private final Value value;

  private final String string;

  CloudProvider(Value value, String string) {
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
      || (other instanceof CloudProvider && this.string.equals(((CloudProvider) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case AWS:
        return visitor.visitAws();
      case AZURE:
        return visitor.visitAzure();
      case GCP:
        return visitor.visitGcp();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static CloudProvider valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "aws":
        return AWS;
      case "azure":
        return AZURE;
      case "gcp":
        return GCP;
      default:
        return new CloudProvider(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    AWS,

    GCP,

    AZURE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitAws();

    T visitGcp();

    T visitAzure();

    T visitUnknown(String unknownType);
  }
}
