package com.gamesUP.gamesUP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.gamesUP.gamesUP")
@ComponentScan(basePackages = "com.gamesUP.gamesUP")
public class GamesUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesUpApplication.class, args);
	}

}
