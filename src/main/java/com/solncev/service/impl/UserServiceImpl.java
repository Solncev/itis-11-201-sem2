package com.solncev.service.impl;

import com.solncev.dto.UserDto;
import com.solncev.repository.UserRepository;
import com.solncev.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAllByName(String name) {
        return userRepository.findAllByName(name)
                .stream().map(u-> new UserDto(u.getName()))
                .collect(Collectors.toList());
    }
}
