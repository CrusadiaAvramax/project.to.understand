package org.crusadia.avramax.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.crusadia.avramax.dto.LoginResponse;
import org.crusadia.avramax.dto.LoginUserRequest;
import org.crusadia.avramax.dto.RegisterUserRequest;
import org.crusadia.avramax.entity.User;
import org.crusadia.avramax.exception.AuthenticationException;
import org.crusadia.avramax.mapper.UserMapper;
import org.crusadia.avramax.repository.UserRepository;
import org.crusadia.avramax.service.AuthService;
import org.crusadia.avramax.util.JwtUtil;
import org.crusadia.avramax.util.PasswordUtil;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    @Inject
    UserRepository userRepository;
    @Inject
    UserMapper userMapper;

    @Override
    @Transactional
    public void registerUser(RegisterUserRequest registerUserRequest) {
        User user = userMapper.toEntity(registerUserRequest);
        String password = PasswordUtil.hashPassword(registerUserRequest.getPassword());
        user.setPassword(password);
        userRepository.persist(user);
    }

    @Override
    public LoginResponse loginUser(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByEmail(loginUserRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Non esiste un utente con questa email"));
        boolean verified = PasswordUtil.verifyPassword(loginUserRequest.getPassword(), user.getPassword());
        if (verified) {
            String token = JwtUtil.generateToken(user);
            return new LoginResponse(token, user.getUsername(),user.getEmail());
        }
        throw new AuthenticationException("La password non è corretta");
    }
}
