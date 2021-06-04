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
		character.setName("Goofy");
		character.setWeight(10);
		character.setImage("Goofy.png");
		character.setHistory("Dog from disney...");
		character.setAge(15);

		var genre = new GenreEntity();
		genre.setName("Fantasy");
		genre.setImage("Fantasy.png");


		var multimedia = new MultimediaEntity();
		multimedia.setTitle("Goofy is my friend");
		multimedia.setCreation_date(LocalDate.now());
		multimedia.setImage("Goofy_is_my_friend.png");
		multimedia.setRating(3F);
		multimedia.setGenre(genre);

		multimediaRepository.save(multimedia);
		genre.addMultimedia(multimedia);
		genreRepository.save(genre);
		character.addMultimedia(multimedia);
		characterRepository.save(character);

	}

	@Test
	void update(){
		var character = characterRepository.findById(1L);
		if (character.isPresent()){
			var ch = character.get();
			ch.setName("Pluto");
			characterRepository.save(ch);
		}

	}


}
