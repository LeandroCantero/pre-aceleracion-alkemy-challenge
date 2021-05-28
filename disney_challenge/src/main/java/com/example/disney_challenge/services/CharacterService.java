package com.example.disney_challenge.services;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.util.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.disney_challenge.repositories.CharacterRepository;

import java.util.List;
import java.util.Optional;

@Service
@Repository
public class CharacterService implements CharacterServiceInterface {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public CharacterEntity create(CharacterEntity characterEntity){
        return characterRepository.save(characterEntity);
    }

    @Override
    public List<CharacterEntity> getAllCharacters(){
        return (List<CharacterEntity>)characterRepository.findAll();
    }

    @Override
    public void deleteCharacter(Long id){
        characterRepository.deleteById(id);
    }

    @Override
    public CharacterDTO findById(Long id){
        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
        CharacterDTO characterDTO = new CharacterDTO();
        if (characterEntity != null && characterEntity.isPresent()){
            characterDTO.setName(characterEntity.get().getName());
            characterDTO.setUrl(characterEntity.get().getImage());
        }
        return characterDTO;
    }
}
