package org.crusadia.avramax.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterUserRequest {

    private Long id;
    @NotNull(message = "Definire almeno un ruolo per l'utente!")
    private String role;
    @NotBlank(message = "L'email è obbligatoria")
    private String email;
    @NotBlank(message = "Inserire una password")
    private String password;

}
