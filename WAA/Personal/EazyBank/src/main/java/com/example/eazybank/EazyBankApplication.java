package com.example.eazybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EazyBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazyBankApplication.class, args);
    }

}
