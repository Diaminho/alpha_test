package com.example.alpha_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MyRepositoryRestMvcConfiguration.class})
public class AlphaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaTestApplication.class, args);
    }

}

