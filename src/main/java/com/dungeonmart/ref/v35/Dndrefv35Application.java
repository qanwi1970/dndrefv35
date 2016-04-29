package com.dungeonmart.ref.v35;

import com.dungeonmart.ref.v35.controllers.SeedController;
import com.dungeonmart.ref.v35.entities.Power;
import com.dungeonmart.ref.v35.repositories.PowerRepository;
import com.dungeonmart.ref.v35.repositories.SkillRepository;
import com.dungeonmart.ref.v35.seeds.SeedPower;
import com.dungeonmart.ref.v35.seeds.SeedSkill;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

@Slf4j
@SpringBootApplication
public class Dndrefv35Application {

	// TODO Profiles
	// TODO unit tests
	// TODO Integration tests
	// TODO resolve differences between manual controllers and automated controllers

	@Bean
	CommandLineRunner seedData(SeedController classSeedController) {
		return (evt) -> {
			classSeedController.seedClasses();
			classSeedController.seedClassTables();
			classSeedController.seedDomains();
			classSeedController.seedEquipment();
			classSeedController.seedFeats();
			classSeedController.seedItems();
			classSeedController.seedMonsters();
		};
	}

    @Bean
    CommandLineRunner seedPowers(PowerRepository powerRepository) {
        return (evt) -> {
            SeedPower seedPower = new SeedPower();
            seedPower.loadPowers(powerRepository);
        };
    }

	@Bean
	CommandLineRunner seedSkills(SkillRepository skillRepository) {
		return (evt) -> {
			SeedSkill seedSkill = new SeedSkill();
			seedSkill.loadSkills(skillRepository);
		};
	}

    public static void main(String[] args) {
		SpringApplication.run(Dndrefv35Application.class, args);
	}
}
