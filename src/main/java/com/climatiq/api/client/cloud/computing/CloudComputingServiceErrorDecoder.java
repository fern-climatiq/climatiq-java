package com.climatiq.api.client.cloud.computing;

import com.climatiq.api.client.cloud.computing.exceptions.CpuException;
import com.climatiq.api.client.cloud.computing.exceptions.MemoryException;
import com.climatiq.api.client.cloud.computing.exceptions.MetadataException;
import com.climatiq.api.client.cloud.computing.exceptions.StorageException;
import com.climatiq.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class CloudComputingServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("metadata")) {
        return decodeException(response, MetadataException.class);
      }
      if (methodKey.contains("cpu")) {
        return decodeException(response, CpuException.class);
      }
      if (methodKey.contains("storage")) {
        return decodeException(response, StorageException.class);
      }
      if (methodKey.contains("memory")) {
        return decodeException(response, MemoryException.class);
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
