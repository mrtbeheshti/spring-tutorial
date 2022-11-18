package com.mrtb.Repositories;

import com.mrtb.ObjectValues.UserValue;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface  UserRepository<U> extends PagingAndSortingRepository<UserValue,Long> {
    List<UserValue> findByUsername(String username, Pageable p);
    List<UserValue> findByEmail(String email, Pageable p);
    List<UserValue> findByUsernameAndEmail(String username, String email, Pageable p);
}
