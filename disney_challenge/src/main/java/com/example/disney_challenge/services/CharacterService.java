package com.example.disney_challenge.services;

import com.example.disney_challenge.interfaceServices.InterfaceCharacterServices;
import com.example.disney_challenge.models.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.disney_challenge.repositories.CharacterRepository;

import java.util.List;
import java.util.Optional;

@Service
@Repository
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
        int res=0;
        CharacterEntity character = characterRepository.save(characterEntity);;
        if (!character.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {

    }
}
