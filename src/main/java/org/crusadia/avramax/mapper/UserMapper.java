package org.crusadia.avramax.mapper;

import org.crusadia.avramax.dto.UserDto;
import org.crusadia.avramax.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
