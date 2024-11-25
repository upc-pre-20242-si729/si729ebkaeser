package com.kaeser.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Si729ebkaeserApplication {

    public static void main(String[] args) {
        SpringApplication.run(Si729ebkaeserApplication.class, args);
    }

}
