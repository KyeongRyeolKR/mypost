package com.example.mypost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MypostApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypostApplication.class, args);
    }

}
