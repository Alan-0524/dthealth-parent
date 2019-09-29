package com.dthealth.interaction;

import com.dthealth.dao.service.RedisService;
import com.dthealth.interaction.entity.User;
import com.dthealth.interaction.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimulationTest {
    @Autowired
    RedisService redisService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUserAccount("ddddd@gmail.com");
        user.setFirstName("Stephen");
        user.setMiddleName("");
        user.setLastName("Curry");
        user.setStatus("0");
        user.setRoleCode("ROLE_USER");
//        userRepository.save(user);
    }
}
