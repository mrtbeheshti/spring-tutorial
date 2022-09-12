package com.mrtb.controller;

import com.mrtb.Enities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final MessageSource messageSource;

    @GetMapping("/user")
    public User getUser(
            @RequestParam(required = false, defaultValue = "World") String name,
            Locale locale
    ) {
        return new User(messageSource.getMessage("welcome.message", new Object[]{name}, locale));
    }
}
