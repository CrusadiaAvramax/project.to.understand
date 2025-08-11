package org.crusadia.avramax.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterUserRequest {

    private Long id;
    @NotBlank(message = "Inserire una password")
    private String password;
    private String nome;
    private String cognome;
    @NotNull(message = "Definire almeno un ruolo per l'utente!")
    private Set<String> roles;
    @NotBlank(message = "L'email è obbligatoria")
    private String email;
    private String bio;
}
