package com.mrtb.controller;

import com.mrtb.Enities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Slf4j
@Controller
public class HelloWorldController {
    @RequestMapping("/")
    public User getUser(
            @RequestHeader (
                    name= "Accept-Language",required = false
            )final Locale locale,
            @RequestParam(
                    required = false,defaultValue = "World"
            )final String name
            ) {
        User user = new User(name);
        return user;
    }
}