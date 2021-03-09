package com.siit.nationalgrupa3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class NationalGrupa3Application {

    public static void main(String[] args) {
        SpringApplication.run(NationalGrupa3Application.class, args);
    }

}
