package com.example.disney_challenge;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.GenreEntity;
import com.example.disney_challenge.models.MultimediaEntity;
import com.example.disney_challenge.repositories.GenreRepository;
import com.example.disney_challenge.repositories.MultimediaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.disney_challenge.repositories.CharacterRepository;

import java.time.LocalDate;

@SpringBootTest
class DisneyChallengeApplicationTests {

	@Autowired
	CharacterRepository characterRepository;
	@Autowired
	MultimediaRepository multimediaRepository;
	@Autowired
	GenreRepository genreRepository;


	@Test
	void createCharacterWithMultimedia() {
		var character = new CharacterEntity();
		character.setName("pluto");
		character.setWeight(30);
		character.setImage("Pluto.png");
		character.setHistory("Dog from disney...");
		character.setAge(20);

		var genre = new GenreEntity();
		genre.setName("Drama");
		genre.setImage("Drama.png");


		var multimedia = new MultimediaEntity();
		multimedia.setTitle("Pluto and his friends");
		multimedia.setCreation_date(LocalDate.now());
		multimedia.setImage("PlutoAndHisFriends.png");
		multimedia.setRating(1F);
		multimedia.setGenre(genre);

		multimediaRepository.save(multimedia);
		genre.addMultimedia(multimedia);
		genreRepository.save(genre);
		character.addMultimedia(multimedia);
		characterRepository.save(character);

	}


}
