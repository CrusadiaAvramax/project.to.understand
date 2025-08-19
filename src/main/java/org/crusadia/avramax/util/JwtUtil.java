package org.crusadia.avramax.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.jwt.build.Jwt;
import org.crusadia.avramax.entity.User;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class JwtUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String generateToken(User user) {
        return Jwt
                .issuer("https://portfolio-be/issuer")
                .upn(user.getEmail())
                .claim("username", user.getUsername())
                .claim("email",user.getEmail())
                .claim("role", user.getRole())
                .subject(user.getUsername())
                .groups(user.getRole()) // utile per @RolesAllowed
                .expiresIn(86400L) // 24h in secondi
                .sign();
    }

    public static Map<String, Object> extractClaims(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Token JWT non valido");
        }

        String payload = parts[1];
        byte[] decodedBytes = Base64.getUrlDecoder().decode(payload);

        String jsonString = new String(decodedBytes, StandardCharsets.UTF_8);

        try {
            return objectMapper.readValue(jsonString, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Errore parsing claims JWT", e);
        }
    }
}