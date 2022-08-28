package com.mrtb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String hello(
            @RequestParam(required = false,defaultValue = "World")
                String name){
        return "Hello  "+name.substring(0, 1).toUpperCase() + name.substring(1)+"!";
    }
}
