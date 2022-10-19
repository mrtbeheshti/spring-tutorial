package com.mrtb.Repositories;

import com.mrtb.Enities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface  UserRepository<U> extends PagingAndSortingRepository<User,Long> {
    List<User> findByUsername(String username,Pageable p);
    List<User> findByEmail(String email,Pageable p);
    List<User> findByUsernameAndEmail(String username, String email, Pageable p);
}
