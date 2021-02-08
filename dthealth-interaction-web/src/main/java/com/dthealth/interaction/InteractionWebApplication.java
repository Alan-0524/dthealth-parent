package com.dthealth.interaction;

import com.dthealth.interaction.service.MessageExtractionScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ComponentScan("com.dthealth")
@EnableMongoRepositories("com.dthealth.dao.service")
public class InteractionWebApplication implements ApplicationRunner {
    @Autowired
    MessageExtractionScheduler messageExtractionScheduler;

    public static void main(String[] args) {
        SpringApplication.run(InteractionWebApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("feature-master");
        System.out.println("feature-master-01");
        messageExtractionScheduler.runTasks();
    }
}
