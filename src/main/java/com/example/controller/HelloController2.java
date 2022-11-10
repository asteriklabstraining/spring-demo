package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {

    @GetMapping(value = "/hello2")
    public String getHello() {
        return "Hello World Version 2";
    }

}
