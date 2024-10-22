package org.jesperancinha.cracservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
class CracServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CracServiceApplication.class, args).start();
	}
}
