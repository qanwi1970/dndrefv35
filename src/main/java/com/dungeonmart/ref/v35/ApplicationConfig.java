package com.dungeonmart.ref.v35;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@Configuration
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class ApplicationConfig {
}
