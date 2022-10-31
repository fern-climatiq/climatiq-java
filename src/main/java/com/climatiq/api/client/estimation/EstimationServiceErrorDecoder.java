package com.climatiq.api.client.estimation;

import com.climatiq.api.client.estimation.exceptions.BatchEstimateException;
import com.climatiq.api.client.estimation.exceptions.EstimateException;
import com.climatiq.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class EstimationServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("estimate")) {
        return decodeException(response, EstimateException.class);
      }
      if (methodKey.contains("batchEstimate")) {
        return decodeException(response, BatchEstimateException.class);
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
