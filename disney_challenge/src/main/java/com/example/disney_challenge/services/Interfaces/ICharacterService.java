package com.example.disney_challenge.services.Interfaces;

import com.example.disney_challenge.dtos.CharacterDTO;
import com.example.disney_challenge.dtos.requests.CharacterRequest;
import com.example.disney_challenge.models.CharacterEntity;

import java.util.List;
import java.util.Set;

public interface ICharacterService {
    List<CharacterDTO> getCharacters();

    CharacterDTO findById(Long id);

    CharacterEntity createCharacter(CharacterRequest characterRequest);

    void deleteCharacter(Long id);

    CharacterEntity updateCharacter(Long id, CharacterEntity characterEntity);

    Set<CharacterEntity> getCharactersById(List<Long> charactersId);
}
