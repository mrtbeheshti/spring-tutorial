package com.mrtb.controller;

import com.mrtb.Enities.User;
import com.mrtb.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody(required = true) User user){
        this.userService.addUser(user);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam(required = true) Long id) {
        User user = this.userService.getById(id);
        return user;
    }

    @GetMapping("/user/all")
    public List<User> getUsers(@RequestParam(required = true) int page,
                               @RequestParam(required = true) int size,
                               @RequestParam(required = false) String username,
                               @RequestParam(required = false) String email){
        List<User> users = this.userService.getPages(page,size,username,email);
        return users;
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam Long id){
        this.userService.delete(id);
    }

    @PatchMapping("/user")
}
