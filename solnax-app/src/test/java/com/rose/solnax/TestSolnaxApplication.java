package com.rose.solnax;

import org.springframework.boot.SpringApplication;

public class TestSolnaxApplication {

	public static void main(String[] args) {
		SpringApplication.from(SolnaxApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
