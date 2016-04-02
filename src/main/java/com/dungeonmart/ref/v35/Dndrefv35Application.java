package com.dungeonmart.ref.v35;

import com.dungeonmart.ref.v35.classes.controllers.ClassSeedController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Dndrefv35Application {

    // TODO Authentication
    // TODO SpringSecurityAuditorAware

	@Bean
	CommandLineRunner seedData(ClassSeedController classSeedController) {
		return (evt) -> {
			classSeedController.seedClasses();
			classSeedController.seedClassTables();
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Dndrefv35Application.class, args);
	}
}
