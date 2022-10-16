package com.mrtb.Repositories;

import com.mrtb.Enities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository<U> extends CrudRepository<User,Long> {

}
