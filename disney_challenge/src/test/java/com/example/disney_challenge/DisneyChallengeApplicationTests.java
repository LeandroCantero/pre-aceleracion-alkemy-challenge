package com.example.disney_challenge;

import com.example.disney_challenge.models.CharacterEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.disney_challenge.repositories.CharacterRepository;

@SpringBootTest
class DisneyChallengeApplicationTests {

	@Autowired
	CharacterRepository characterRepository;

	@Test
	void createCharacter() {
		CharacterEntity character1 = new CharacterEntity();
		character1.setName("Cars");
		character1.setAge(7);
		character1.setHistory("sdaf");
		character1.setImage("cars.jpg");
		character1.setWeight(100);
		characterRepository.save(character1);
	}


}
