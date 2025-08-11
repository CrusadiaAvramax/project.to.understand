package org.crusadia.avramax.util;

import io.smallrye.jwt.build.Jwt;
import org.crusadia.avramax.entity.User;

public class JwtUtil {
    public static String generateToken(User user) {
        return Jwt
                .issuer("https://portfolio-be/issuer")
                .upn(user.getEmail())
                .claim("userId", user.id)
                .claim("role", user.getRoles())
                .subject(user.id.toString())
                .groups(String.join(", ", user.getRoles())) // utile per @RolesAllowed
                .expiresIn(86400L) // 24h in secondi
                .sign();
    }
}