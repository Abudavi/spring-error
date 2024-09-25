package com.david.spring.error.spring_error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("/app")
    public String index() {

        // int vaulue = 100 / 0;
        int vaulue = Integer.parseInt("10X");
        System.out.println(vaulue);
        return "ok 200";
    }

}
