package app;

import app.service.repositories.UserRepository;
import app.message.MessageReceiver;
import com.mq.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements ApplicationRunner {

    @Autowired
    private UserRepository repository;


    @Autowired
    MessageReceiver messageReceiver;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
//        try {
//            messageReceiver.receive();
//
//        } catch (Exception e) {
//
//        }
//        repository.deleteAll();
//
//        // save a couple of customers
//        repository.save(new User("Alice", "Smith"));
//        repository.save(new User("Bob", "Smith"));
//        repository.findByFirstName("Alice");
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
        for (User user : repository.findByLastName("Smith")) {
            System.out.println(user.toString());
        }
    }
}
