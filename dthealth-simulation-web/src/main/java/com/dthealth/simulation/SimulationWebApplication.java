package com.dthealth.simulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ComponentScan("com.dthealth")
@EnableMongoRepositories("com.dthealth.dao.service")
public class SimulationWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimulationWebApplication.class, args);
    }
}
