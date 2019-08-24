package com.dthealth.simulation;

import com.dthealth.simulation.service.CurrentStateService;
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
public class SimulationWebApplication implements ApplicationRunner {
    @Autowired
    CurrentStateService currentStateService;

    public static void main(String[] args) {
        SpringApplication.run(SimulationWebApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        currentStateService.loadingMessage();
    }
}
