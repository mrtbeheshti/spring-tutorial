package com.mrtb.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Locale;


@Controller
public class HelloWorldController {

    @Autowired
    MessageSource messageSource;

    @RequestMapping("/")
    public JSONObject getUser(
            @RequestHeader (
                    name= "Accept-Language",required = false
            )final Locale locale,
            @RequestParam(
                    required = false,defaultValue = "World"
            )final String name
            ) {
        JSONObject response = new JSONObject();
        String message = messageSource.getMessage("message.hello", null, locale)+" "+name;
//        String message = "Hello " + name;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        response.put("message",message);
        response.put("time", timestamp);
        return response;
    }
}