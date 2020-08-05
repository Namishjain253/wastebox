package com.skillassure.wastebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan
//@EntityScan(basePackages = {"com.skillassure.wastebox.model"})
public class WasteBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasteBoxApplication.class, args);
	}	
}