package com.ea.aop.hillaryaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hillary")
public class AppController {
    @GetMapping
    public void print(){
        System.out.println("Testing api endpoint");
    }
}
