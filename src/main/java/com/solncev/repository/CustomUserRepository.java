package com.solncev.repository;

import com.solncev.model.User;

import java.util.List;

public interface CustomUserRepository {

    List<User> findAllByNameMatch(String name, double factor);
}
