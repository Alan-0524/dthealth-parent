package com.dthealth.interaction.repository;


import com.dthealth.interaction.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepository extends BaseRepository<User> {
    @Override
    Class getEntityClass() {
        return User.class;
    }
}
