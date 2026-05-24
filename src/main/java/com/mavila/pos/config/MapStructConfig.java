package com.mavila.pos.config;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapStructConfig {

}
