package com.tapiwanashe.pet.consumer.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/home")
public class HomController {


    @GetMapping
    public ResponseEntity<String> helloHome(){

        return  ResponseEntity.ok("Hello");
    }
}
