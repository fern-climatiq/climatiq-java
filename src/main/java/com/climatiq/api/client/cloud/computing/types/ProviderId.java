package com.climatiq.api.client.cloud.computing.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public final class ProviderId {
  private final String value;

  private ProviderId(String value) {
    this.value = value;
  }

  @JsonValue
  public String get() {
    return this.value;
  }

  @Override
  public boolean equals(Object other) {
    return this == other || (other instanceof ProviderId && this.value.equals(((ProviderId) other).value));
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return value;
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static ProviderId of(String value) {
    return new ProviderId(value);
  }

  public static ProviderId valueOf(String value) {
    return of(value);
  }
}
