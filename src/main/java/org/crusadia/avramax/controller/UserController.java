package org.crusadia.avramax.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.crusadia.avramax.dto.RegisterUserRequest;
import org.crusadia.avramax.service.UserService;

import java.util.List;

@Path("/user")
@RequiredArgsConstructor
public class UserController {
    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RegisterUserRequest> getUsers() {
       return userService.getUsers();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RegisterUserRequest addUser(RegisterUserRequest user) {
        return userService.addUser(user);
    }

}
