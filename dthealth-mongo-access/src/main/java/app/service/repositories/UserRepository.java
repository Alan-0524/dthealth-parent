package app.service.repositories;

import com.mq.entities.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByFirstName(String firstName);

    List<User> findByLastName(String lastName);
}
