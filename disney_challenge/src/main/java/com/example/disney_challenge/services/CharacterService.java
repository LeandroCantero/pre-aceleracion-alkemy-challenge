package com.example.disney_challenge.services;

import com.example.disney_challenge.interfaceServices.InterfaceCharacterServices;
import com.example.disney_challenge.models.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.disney_challenge.repositories.CharacterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService implements InterfaceCharacterServices {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<CharacterEntity> toList() {
        return (List<CharacterEntity>)characterRepository.findAll();
    }

    @Override
    public Optional<CharacterEntity> toListId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(CharacterEntity characterEntity) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
