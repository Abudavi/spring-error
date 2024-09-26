package com.david.spring.error.spring_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.spring.error.spring_error.models.domain.User;

@Service
public class UserServiceImp implements UserService {

    private List<User> users;

    public UserServiceImp() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Pepe", "Gonzales"));
        users.add(new User(2L, "Andres", "Mena"));
        users.add(new User(3L, "Maria", "Perez"));
        users.add(new User(4L, "Jose", "Gonzales"));
        users.add(new User(5L, "Ale", "Guitierrez"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        User u = null;
        for (User user : users) {
            if (user.getId().equals(id)) {
                u = user;
                break;
            }
        }
        return Optional.ofNullable(u);
    }

}
