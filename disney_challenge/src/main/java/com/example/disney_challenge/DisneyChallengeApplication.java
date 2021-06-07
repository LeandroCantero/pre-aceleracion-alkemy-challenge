package com.example.disney_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DisneyChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisneyChallengeApplication.class, args);
	}
}
