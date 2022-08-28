package com.mrtb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

import java.sql.Timestamp;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public JSONObject hello(
            @RequestParam(required = false,defaultValue = "World")
                String name){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String message = "Hello  "+name.substring(0, 1).toUpperCase() + name.substring(1)+"!";
        JSONObject obj= new JSONObject();
        obj.put("message",message);
        obj.put("time", timestamp);
        return obj;
    }
}
