package com.mrtb.Services;

import com.mrtb.Enities.User;
import com.mrtb.Enities.UserUpdate;
import com.mrtb.Exceptions.UserAlreadyExistException;
import com.mrtb.Exceptions.UserNotFoundException;
import com.mrtb.Mappers.UserMapper;
import com.mrtb.ObjectValues.UserValue;
import com.mrtb.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserRepository<User> repository;
    private final UserMapper mapper=new UserMapper();

    public UserService(){}

    public UserValue addUser(UserValue user){
        try{
            UserValue new_User = this.repository.save(user);
            return new_User;
        } catch (RuntimeException e){
            throw new UserAlreadyExistException("there is a user with this username,please try again with another username.");
        }
    }

    public UserValue getById(Long id){
        UserValue User = this.repository.findById(id).orElse(null);
        if (User == null){
            throw new UserNotFoundException("Can't find a user by id: "+id);
        }
        return User;
    }

    public List<UserValue> getPages(int page, int size, String username, String email){
        size = size == -1 ? (int) repository.count() : size;
        Pageable selectedPage = PageRequest.of(page,size);
        List<UserValue> usersInPage;

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

    public UserValue delete(Long id){
        UserValue user = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return user;
    }
    public UserValue update(Long id, UserUpdate userUpdate){
        UserValue user = repository.findById(id).orElse(null);
        user.setUsername((userUpdate.getUsername()==null || userUpdate.getUsername().trim().isEmpty())? user.getUsername():userUpdate.getUsername());
        user.setFirstName((userUpdate.getFirstName()==null || userUpdate.getFirstName().trim().isEmpty())? user.getFirstName():userUpdate.getFirstName());
        user.setLastName((userUpdate.getLastName()==null || userUpdate.getLastName().trim().isEmpty())? user.getLastName():userUpdate.getLastName());
        repository.save(user);
        return this.repository.findById(id).orElse(null);
    }

}
