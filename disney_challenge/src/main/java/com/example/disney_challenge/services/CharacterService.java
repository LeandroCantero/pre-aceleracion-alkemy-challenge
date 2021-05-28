package com.example.disney_challenge.services;

import com.example.disney_challenge.models.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.disney_challenge.repositories.CharacterRepository;

import java.util.List;
import java.util.Optional;

@Service
@Repository
public class CharacterService{

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterEntity create(CharacterEntity characterEntity){
        return characterRepository.save(characterEntity);
    }

    public List<CharacterEntity> getAllCharacters(){
        return characterRepository.findAll();
    }

    public void delete(CharacterEntity characterEntity){
        characterRepository.delete(characterEntity);
    }

    public Optional<CharacterEntity> findById(Long id){
        return characterRepository.findById(id);
    }
}
