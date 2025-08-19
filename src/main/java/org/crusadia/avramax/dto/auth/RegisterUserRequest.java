package org.crusadia.avramax.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterUserRequest {

    private Long id;
    @NotBlank(message = "Definire un username")
    private String username;
    @NotNull(message = "Definire almeno un ruolo per l'utente!")
    private String role;
    @NotBlank(message = "L'email è obbligatoria")
    private String email;
    @NotBlank(message = "Inserire una password")
    private String password;

}
