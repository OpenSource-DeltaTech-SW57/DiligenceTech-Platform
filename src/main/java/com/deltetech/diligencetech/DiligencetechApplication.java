package com.deltetech.diligencetech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DiligencetechApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiligencetechApplication.class, args);
    }

}
