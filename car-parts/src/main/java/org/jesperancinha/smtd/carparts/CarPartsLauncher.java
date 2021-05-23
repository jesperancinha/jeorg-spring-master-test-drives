package org.jesperancinha.smtd.carparts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableWebSecurity
@EnableJpaRepositories
@SpringBootApplication
public class CarPartsLauncher {
    public static void main(String[] args) {
        SpringApplication.run(CarPartsLauncher.class, args);
    }
}
