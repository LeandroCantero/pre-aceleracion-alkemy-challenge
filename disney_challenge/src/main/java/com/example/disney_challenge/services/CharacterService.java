package com.example.disney_challenge.services;

import com.example.disney_challenge.dtos.CharacterDTO;
import com.example.disney_challenge.dtos.requests.CharacterRequest;
import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.MultimediaEntity;
import com.example.disney_challenge.repositories.CharacterRepository;
import com.example.disney_challenge.services.Interfaces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Repository
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public CharacterEntity createCharacter(CharacterRequest characterRequest) {
        var character = new CharacterEntity();
        character.setName(characterRequest.getName());
        character.setAge(characterRequest.getAge());
        character.setImage(characterRequest.getImage());
        character.setWeight(characterRequest.getWeight());
        character.setHistory(characterRequest.getHistory());
        return characterRepository.save(character);
    }

    @Override
    public List<CharacterDTO> getCharacters() {

        var charactes = characterRepository.findAll();
        if (charactes == null) return null;

        var mappedCharacters = charactes
                .stream()
                .map(c -> new CharacterDTO(c.getName(), c.getImage()))
                .collect(Collectors.toList());
        return mappedCharacters;

    }

    @Override
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public CharacterDTO findById(Long id) {
        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
        CharacterDTO characterDTO = new CharacterDTO();
        if (characterEntity != null && characterEntity.isPresent()) {
            characterDTO.setName(characterEntity.get().getName());
            characterDTO.setUrl(characterEntity.get().getImage());
        }
        return characterDTO;
    }


    @Override
    public CharacterEntity updateCharacter(Long id, CharacterEntity characterEntity) {
        var character = characterRepository.findById(id);
        var ch = character.get();
        if (character.isPresent()) {
            String name = characterEntity.getName() == null ? ch.getName() : characterEntity.getName();
            Integer age = characterEntity.getAge() == null ? ch.getAge() : characterEntity.getAge();
            String history = characterEntity.getHistory() == null ? ch.getHistory() : characterEntity.getHistory();
            Integer weight = characterEntity.getWeight() == null ? ch.getWeight() : characterEntity.getWeight();
            String image = characterEntity.getImage() == null ? ch.getImage() : characterEntity.getImage();
            ch.setName(name);
            ch.setAge(age);
            ch.setHistory(history);
            ch.setWeight(weight);
            ch.setImage(image);
        }
        return characterRepository.save(ch);
    }

    public List<CharacterEntity> characterDetails() {
        var characters = characterRepository.findAll();
        if (characters == null) {
            return null;
        } else {
            return characters;
        }
    }

    public List<CharacterEntity> findByFilters(String name, Integer age, Integer weight, MultimediaEntity multimedia) {
        if (name != null) {
            return characterRepository.findByName(name);
        }
        if (age != null) {
            return characterRepository.findByAge(age);
        }
        if (weight != null) {
            return characterRepository.findByWeight(weight);
        }
        if (multimedia != null) {
            return characterRepository.findByMultimedia(multimedia);
        }
        return characterRepository.findAll();
    }

    @Override
    public Set<CharacterEntity> getCharactersById(List<Long> charactersId) {
        return  charactersId
                .stream()
                .map(id -> characterRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

    }


    /*public List<CharacterEntity> findByFilters2(String name, Integer age, Integer weight, MultimediaEntity multimedia){
        if (name != null || age != null || weight != null || multimedia != null){
            return characterRepository.findByNameOrAgeOrWeightOrMultimedia(name, age, weight, multimedia);
        }
        return characterRepository.findAll();
    }
    */

}
