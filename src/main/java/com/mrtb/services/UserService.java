package com.mrtb.services;

import com.mrtb.valueObjects.UserUpdateObject;
import com.mrtb.exceptions.UserAlreadyExistException;
import com.mrtb.exceptions.UserNotFoundException;
import com.mrtb.entities.User;
import com.mrtb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@RequiredArgsConstructor
@Service("userService")
public class UserService {
    private final MessageSource messageSource;
    private final UserRepository repository;


    public User addUser(User user){
        try{
            return this.repository.save(user);
        } catch (RuntimeException e){
            throw new UserAlreadyExistException("");
        }
    }

    public User getById(Long id){
        User User = this.repository.findById(id).orElse(null);
        if (User == null){
            throw new UserNotFoundException("{error.getById.notFound}"+id);
        }
        return User;
    }

    public List<User> getPages(int page, int size, String username, String email){
        Pageable selectedPage = PageRequest.of(page,size);
        return this.repository.findAllByUsernameAndEmail(username,email,selectedPage);
    }

    public boolean delete(Long id){
        this.repository.deleteById(id);
        return this.repository.findById(id).isEmpty();
    }
    public User update(Long id, UserUpdateObject userUpdate){
        User user = repository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setUsername((userUpdate.getUsername()==null || userUpdate.getUsername().trim().isEmpty())? user.getUsername():userUpdate.getUsername());
        user.setFirstName((userUpdate.getFirstName()==null || userUpdate.getFirstName().trim().isEmpty())? user.getFirstName():userUpdate.getFirstName());
        user.setLastName((userUpdate.getLastName()==null || userUpdate.getLastName().trim().isEmpty())? user.getLastName():userUpdate.getLastName());
        return repository.save(user);
    }
}
