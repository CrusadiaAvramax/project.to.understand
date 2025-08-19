package org.crusadia.avramax.service;


import org.crusadia.avramax.dto.UserDto;

import java.util.List;

public interface UserService {


    List<UserDto> getUsers();


    UserDto getUser(String token);
}
