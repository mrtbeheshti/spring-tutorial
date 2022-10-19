package com.mrtb.Services;

import com.mrtb.Enities.User;
import com.mrtb.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public User getById(Long id){
        User user = this.repository.findById(id).orElse(null);
        return user;
    }

    public List<User> getPages(int page,int size, String username,String email){
        Pageable selectedPage = PageRequest.of(page,size);
        List<User> usersInPage;
        if(username == null && email==null){
            usersInPage = repository.findAll(selectedPage).getContent();
        }
        else if (username == null){
            usersInPage =repository.findByEmail(email,selectedPage);
        }
        else if (email == null){
            usersInPage = repository.findByUsername(username,selectedPage);
        }
        else{
            usersInPage = repository.findByUsernameAndEmail(username,email,selectedPage);
        }
        return usersInPage;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    public void update(Long id,String username,String fname,String lname){
        User user= repository.findById(id).orElse(null);
        user.setUsername(username!=null?username:user.getUsername());
        user.setFirstName(fname!=null? fname:user.getFirstName());
        user.setLastName(lname!=null? lname:user.getLastName());
        repository.save(user);
    }

}
