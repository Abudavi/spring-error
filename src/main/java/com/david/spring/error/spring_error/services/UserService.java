package com.david.spring.error.spring_error.services;

import java.util.List;
import java.util.Optional;

import com.david.spring.error.spring_error.models.domain.User;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

}
