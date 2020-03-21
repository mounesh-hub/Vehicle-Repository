package com.mounesh.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RootApplication.class, args);
    }

    @GetMapping("/admin")
    public String getData(){
        return "welcome admin";
    }

    @GetMapping("/user")
    public String getData1(){
        return "welcome user";
    }

}
