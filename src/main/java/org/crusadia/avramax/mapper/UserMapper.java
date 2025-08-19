package org.crusadia.avramax.mapper;

import org.crusadia.avramax.dto.UserDto;
import org.crusadia.avramax.dto.auth.RegisterUserRequest;
import org.crusadia.avramax.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    UserDto toDto(User user);

    @Mapping(target = "password", ignore = true)
    User toEntity(RegisterUserRequest registerUserRequest);
}
