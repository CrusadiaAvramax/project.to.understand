package org.crusadia.avramax.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.crusadia.avramax.dto.UserDto;
import org.crusadia.avramax.dto.auth.RegisterUserRequest;
import org.crusadia.avramax.entity.User;
import org.crusadia.avramax.mapper.UserMapper;
import org.crusadia.avramax.repository.UserRepository;
import org.crusadia.avramax.service.UserService;
import org.crusadia.avramax.util.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;
    @Inject
    UserMapper userMapper;


    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map((user)-> userMapper.toDto(user))
                .toList();
    }

    @Override
    public UserDto getUser(String token) {
        Map<String,Object> map = JwtUtil.extractClaims(token);
        String email = map.get("email").toString();
        return userRepository.findByEmail(email)
                .map((user)-> userMapper.toDto(user))
                .orElseThrow( ()-> new EntityNotFoundException("User with email "+email+" not found"));

    }


}
