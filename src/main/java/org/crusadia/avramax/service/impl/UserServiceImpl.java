package org.crusadia.avramax.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.crusadia.avramax.dto.UserDto;
import org.crusadia.avramax.entity.User;
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
    @Transactional
    public UserDto addUser(UserDto user) {
        User userEntity = userMapper.toEntity(user);
        userRepository.persist(userEntity);
        return userMapper.toDto(userEntity);
    }
}
