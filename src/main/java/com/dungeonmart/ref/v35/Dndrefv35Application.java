package com.dungeonmart.ref.v35;

import com.dungeonmart.ref.v35.controllers.SeedController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Dndrefv35Application {

	// TODO Profiles
	// TODO unit tests
	// TODO Integration tests

	@Bean
	CommandLineRunner seedData(SeedController classSeedController) {
		return (evt) -> {
			classSeedController.seedClasses();
			classSeedController.seedClassTables();
			classSeedController.seedDomains();
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Dndrefv35Application.class, args);
	}
}
