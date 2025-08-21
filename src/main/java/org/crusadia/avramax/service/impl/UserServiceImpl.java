package org.crusadia.avramax.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import org.crusadia.avramax.dto.UserDto;
import org.crusadia.avramax.mapper.UserMapper;
import org.crusadia.avramax.repository.UserRepository;
import org.crusadia.avramax.service.UserService;

import java.util.List;


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
    public UserDto getUser(String email) {
        //Map<String,Object> map = JwtUtil.extractClaims(token);String email = map.get("email").toString();
        return userRepository.findByEmail(email)
                .map((user)-> userMapper.toDto(user))
                .orElseThrow( ()-> new EntityNotFoundException("User with email "+email+" not found"));

    }


}
