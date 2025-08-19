package org.crusadia.avramax.service;


import org.crusadia.avramax.dto.UserDto;
import org.crusadia.avramax.dto.auth.RegisterUserRequest;

import java.util.List;

public interface UserService {


    List<UserDto> getUsers();


    UserDto getUser(String token);
}
