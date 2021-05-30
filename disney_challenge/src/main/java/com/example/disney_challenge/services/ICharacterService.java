package com.example.disney_challenge.services;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.dtos.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    public List<CharacterDTO> getCharacters();
    public CharacterDTO findById(Long id);
    public CharacterEntity create(CharacterEntity characterEntity);
    public void deleteCharacter(Long id);
}
