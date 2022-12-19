package com.mrtb.controller;

import com.mrtb.entities.User;
import com.mrtb.valueObjects.UserObject;
import com.mrtb.valueObjects.UserUpdateObject;
import com.mrtb.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;




    @PostMapping()
    @ResponseBody
    public UserObject addUser(@RequestBody @Valid UserObject userObject){
        UserObject createdUser= UserObject.of(this.service.addUser(User.of(userObject)));
        return  createdUser;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserObject getUser(@PathVariable(value = "id") Long id) {
        UserObject userObject = UserObject.of(this.service.getById(id));
        return userObject;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<UserObject> getUsers(@RequestParam(required = false,defaultValue = "0") int page,
                             @RequestParam(required = false,defaultValue = "10") int size,
                             @RequestParam(required = false) String username,
                             @RequestParam(required = false) String email){

        List<UserObject> userObjects = this.service.getPages(page,size,username,email).
                stream().map(UserObject::of).
                collect(Collectors.toList());
        return userObjects;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Boolean deleteUser(@PathVariable(value = "id") Long id){
        boolean deleted = this.service.delete(id);
        return deleted;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public UserObject updateUser(@PathVariable(value = "id") Long id,
                                                 @RequestBody UserUpdateObject user){
        UserObject updatedUserObject = UserObject.of(this.service.update(id,user));
        return updatedUserObject;
    }
}
