package org.crusadia.avramax.service;

import org.crusadia.avramax.dto.LoginResponse;
import org.crusadia.avramax.dto.LoginUserRequest;
import org.crusadia.avramax.dto.RegisterUserRequest;

public interface AuthService {

    void registerUser(RegisterUserRequest registerUserRequest);

    LoginResponse loginUser(LoginUserRequest loginUserRequest);
}
