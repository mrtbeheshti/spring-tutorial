package com.mrtb.repositories;

import com.mrtb.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface  UserRepository extends PagingAndSortingRepository<User,Long> {

    @Query(value =  "SELECT * " +
                    "FROM   user " +
                    "WHERE  username =  IF(:username IS NULL OR :username = '',username,:username) " +
                    "       AND email = IF(:email IS NULL OR :email = '',email,:email)",
            nativeQuery = true)
    List<User> findAllByUsernameAndEmail(@Param("username") String username,
                                         @Param("email") String email, Pageable pageable);
}
