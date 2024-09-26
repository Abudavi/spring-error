package com.david.spring.error.spring_error.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.spring.error.spring_error.Exceptions.UserNotFoundException;
import com.david.spring.error.spring_error.models.domain.User;
import com.david.spring.error.spring_error.services.UserService;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String index() {

        // int vaulue = 100 / 0;
        int vaulue = Integer.parseInt("10X");
        System.out.println(vaulue);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> show(@PathVariable(name = "id") Long id) {
        // User user = service.findById(id).orElseThrow(() -> new
        // UserNotFoundException("Error el usuario no existe"));
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // System.out.println(user.getName());
        // return user;
        // lo comentado es otra forma de hacerlo
        return ResponseEntity.ok(optionalUser.get());
    }

}
