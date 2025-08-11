package org.crusadia.avramax.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserRequest {

    @NotBlank(message = "L'email è obbligatoria")
    private String email;
    @NotBlank(message = "Inserire una password")
    private String password;
}
