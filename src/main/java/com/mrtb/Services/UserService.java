package com.mrtb.Services;

import com.mrtb.Enities.User;
import com.mrtb.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService {
    @Autowired
    private UserRepository<User> repository;



    public User addUser(User user){
       return this.repository.save(user);
    }

    public Optional<User> getById(Long id){
        Optional<User> user = this.repository.findById(id);
        return user;
    }

    public List<User> getPages(int page,int size){
        
    }

}
