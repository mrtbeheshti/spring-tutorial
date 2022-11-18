package com.mrtb.Controller;

import com.mrtb.Enities.User;
import com.mrtb.Enities.UserUpdate;
import com.mrtb.Mappers.UserMapper;
import com.mrtb.Responses.Response;
import com.mrtb.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    private final UserMapper mapper=new UserMapper();



    @PostMapping()
    public Response addUser(@RequestBody @Valid User user){
        User createdUser=mapper.userValueToUser(this.service.addUser(mapper.userToUserValue(user)));
        return  new Response(200,"created!",createdUser);
    }

    @GetMapping("/{id}")
    public Response getUser(@PathVariable(value = "id") Long id) {
        User user = mapper.userValueToUser(this.service.getById(id));
        return new Response(200,"founded",user);
    }

    @GetMapping("/all")
    public Response getUsers(@RequestParam(required = false,defaultValue = "0") int page,
//                               length of user table
                               @RequestParam(required = false,defaultValue = "-1" ) int size,
                               @RequestParam(required = false) String username,
                               @RequestParam(required = false) String email){

        List<User> users = mapper.userValuesToUsers(this.service.getPages(page,size,username,email)) ;
        return new Response(200,"founded",users);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable(value = "id") Long id){
        User user = mapper.userValueToUser(this.service.delete(id));
        return new Response(200,"deleted",user);
    }

    @PutMapping("/{id}")
    public Response updateUser(@PathVariable(value = "id") Long id,
                           @RequestBody UserUpdate user){
        User updatedUser = mapper.userValueToUser(this.service.update(id,user));
        return new Response(200,"updated",updatedUser);
    }
}
