package com.mavila.pos.mapper;

import com.mavila.pos.config.MapStructConfig;
import com.mavila.pos.dto.request.UserRequestDTO;
import com.mavila.pos.dto.response.UserResponseDTO;
import com.mavila.pos.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tools.jackson.databind.cfg.MapperConfig;

@Mapper(config = MapStructConfig.class)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toResponse(User entity);
}
