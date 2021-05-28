package com.example.disney_challenge.services;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.util.CharacterDTO;

import java.util.List;

public interface CharacterServiceInterface {
    public List<CharacterEntity> getAllCharacters();
    public CharacterDTO findById(Long id);
    public CharacterEntity create(CharacterEntity characterEntity);
    public void deleteCharacter(Long id);
}
