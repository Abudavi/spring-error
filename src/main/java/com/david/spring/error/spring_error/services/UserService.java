package com.david.spring.error.spring_error.services;

import java.util.List;

import com.david.spring.error.spring_error.models.domain.User;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

}
