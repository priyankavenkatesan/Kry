package com.kry.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot application
 * 
 * @author PVENKAT1
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.kry.*" })
@EntityScan(basePackages = { "com.kry.*" })
@ComponentScan(basePackages = { "com.kry.*" })
public class KryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KryServicesApplication.class, args);
	}

}
