package com.dthealth.cache;

import com.dthealth.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;


@SpringBootApplication
@ComponentScan("com.dthealth")
@EnableMongoRepositories("com.dthealth.dao.service")
@Component
public class CacheWebApplication extends SpringBootServletInitializer implements ApplicationRunner {
    @Autowired
    private CacheService cacheService;

    public static void main(String[] args) {
        SpringApplication.run(CacheWebApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        cacheService.extractAndWrite();
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
