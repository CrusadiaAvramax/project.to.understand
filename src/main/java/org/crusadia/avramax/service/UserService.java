package org.crusadia.avramax.service;


import org.crusadia.avramax.dto.RegisterUserRequest;

import java.util.List;

public interface UserService {


    List<RegisterUserRequest> getUsers();

    RegisterUserRequest addUser(RegisterUserRequest user);

}
