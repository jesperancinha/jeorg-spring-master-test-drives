package org.jesperancinha.smtd.planets;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlanetsLauncher implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(PlanetsLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

    }
}
