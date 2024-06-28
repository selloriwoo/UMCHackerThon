package com.UMC.HackerTon.PJRHT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PjrhtApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjrhtApplication.class, args);
	}

}
