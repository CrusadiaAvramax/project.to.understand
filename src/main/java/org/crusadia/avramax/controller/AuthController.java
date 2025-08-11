package org.crusadia.avramax.controller;

import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.crusadia.avramax.dto.LoginResponse;
import org.crusadia.avramax.dto.LoginUserRequest;
import org.crusadia.avramax.dto.RegisterUserRequest;
import org.crusadia.avramax.service.AuthService;

@Path("/api/auth")
public class AuthController {

    @Inject
    AuthService authService;

    @POST()
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registaUtente(@Valid RegisterUserRequest registerUserRequest) {
        authService.registerUser(registerUserRequest);
        return Response.ok()
                .status(HttpResponseStatus.CREATED.code())
                .build();
    }

    @POST()
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUtente(@Valid LoginUserRequest loginUserRequest) {
        LoginResponse loginResponse = authService.loginUser(loginUserRequest);
        return Response.ok()
                .status(HttpResponseStatus.OK.code())
                .entity(loginResponse)
                .build();

    }
}
