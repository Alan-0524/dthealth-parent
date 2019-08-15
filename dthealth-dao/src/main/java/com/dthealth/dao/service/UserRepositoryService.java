package com.dthealth.dao.service;
import com.dthealth.dao.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserRepositoryService extends MongoRepository<User, String> {
    User findByUserAccount(String userAccount);

    List<User> findByLastName(String lastName);

    List<User> findByMiddleName(String middleName);

    List<User> findByFirstName(String firstName);
}
