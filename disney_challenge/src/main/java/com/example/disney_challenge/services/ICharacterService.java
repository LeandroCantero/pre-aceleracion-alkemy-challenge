package com.example.disney_challenge.services;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.dtos.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getCharacters();
    CharacterDTO findById(Long id);
    CharacterEntity create(CharacterEntity characterEntity);
    void deleteCharacter(Long id);
    CharacterEntity updateCharacter(Long id, CharacterEntity characterEntity);
}
