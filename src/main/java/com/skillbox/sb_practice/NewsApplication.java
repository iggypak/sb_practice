package com.skillbox.sb_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.skillbox.sb_practice")
public class NewsApplication {
    public static void main(String [] args) {
        SpringApplication.run(NewsApplication.class, args);
    }
}
