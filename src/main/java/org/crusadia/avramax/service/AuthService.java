package org.crusadia.avramax.service;

import org.crusadia.avramax.dto.auth.LoginResponse;
import org.crusadia.avramax.dto.auth.LoginUserRequest;
import org.crusadia.avramax.dto.auth.RegisterUserRequest;

public interface AuthService {

    void registerUser(RegisterUserRequest registerUserRequest);

    LoginResponse loginUser(LoginUserRequest loginUserRequest);
}
