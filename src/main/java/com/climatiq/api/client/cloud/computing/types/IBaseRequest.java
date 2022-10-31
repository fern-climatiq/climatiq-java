package com.climatiq.api.client.cloud.computing.types;

import java.lang.String;
import java.util.Optional;

public interface IBaseRequest {
  String getRegion();

  Optional<String> getDurationUnit();
}
