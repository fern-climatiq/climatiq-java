package com.climatiq.api.client.flights;

import com.climatiq.api.client.flights.exceptions.FreightFlightsException;
import com.climatiq.api.client.flights.exceptions.TravelFlightsException;
import com.climatiq.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class FlightsServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("travelFlights")) {
        return decodeException(response, TravelFlightsException.class);
      }
      if (methodKey.contains("freightFlights")) {
        return decodeException(response, FreightFlightsException.class);
      }
    }
    catch (IOException e) {
    }
    return new RuntimeException("Failed to read response body. Received status " + response.status() + " for method " + methodKey);
  }

  private static <T extends Exception> Exception decodeException(Response response, Class<T> clazz)
      throws IOException {
    return ObjectMappers.JSON_MAPPER.reader().withAttribute("statusCode", response.status()).readValue(response.body().asInputStream(), clazz);
  }
}
