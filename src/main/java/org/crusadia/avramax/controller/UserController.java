package org.crusadia.avramax.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.crusadia.avramax.dto.UserDto;
import org.crusadia.avramax.service.UserService;

import java.util.List;

@Path("/api/user")
@RequiredArgsConstructor
public class UserController {
    @Inject
    UserService userService;

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getUsers() {
       return userService.getUsers();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUser(@QueryParam("email") String email) {
        return userService.getUser(email);
    }


}
