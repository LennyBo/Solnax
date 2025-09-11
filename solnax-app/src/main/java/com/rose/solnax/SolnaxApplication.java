package com.rose.solnax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SolnaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolnaxApplication.class, args);
	}

}
