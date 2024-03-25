package com.solncev.controller;

import com.solncev.dto.UserDto;
import com.solncev.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> findByName(@RequestParam String name){
        return userService.findAllByName(name);
    }
}
