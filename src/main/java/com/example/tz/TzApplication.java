package com.example.tz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class TzApplication {

    public static void main(String[] args) {
        SpringApplication.run(TzApplication.class, args);
        System.out.println("started!");
    }

}
