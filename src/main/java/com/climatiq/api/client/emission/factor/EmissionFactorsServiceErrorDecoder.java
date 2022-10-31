package com.climatiq.api.client.emission.factor;

import com.climatiq.api.client.emission.factor.exceptions.GetCategoriesException;
import com.climatiq.api.client.emission.factor.exceptions.GetLcaActivitiesException;
import com.climatiq.api.client.emission.factor.exceptions.GetRegionsException;
import com.climatiq.api.client.emission.factor.exceptions.GetSectorsException;
import com.climatiq.api.client.emission.factor.exceptions.GetSourcesException;
import com.climatiq.api.client.emission.factor.exceptions.GetUnitTypesException;
import com.climatiq.api.client.emission.factor.exceptions.GetYearsException;
import com.climatiq.api.client.emission.factor.exceptions.SearchException;
import com.climatiq.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class EmissionFactorsServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("search")) {
        return decodeException(response, SearchException.class);
      }
      if (methodKey.contains("getYears")) {
        return decodeException(response, GetYearsException.class);
      }
      if (methodKey.contains("getSources")) {
        return decodeException(response, GetSourcesException.class);
      }
      if (methodKey.contains("getRegions")) {
        return decodeException(response, GetRegionsException.class);
      }
      if (methodKey.contains("getCategories")) {
        return decodeException(response, GetCategoriesException.class);
      }
      if (methodKey.contains("getSectors")) {
        return decodeException(response, GetSectorsException.class);
      }
      if (methodKey.contains("getLcaActivities")) {
        return decodeException(response, GetLcaActivitiesException.class);
      }
      if (methodKey.contains("getUnitTypes")) {
        return decodeException(response, GetUnitTypesException.class);
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
