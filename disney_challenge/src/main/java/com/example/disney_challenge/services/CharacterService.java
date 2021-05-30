package com.example.disney_challenge.services;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.dtos.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.disney_challenge.repositories.CharacterRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Repository
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public CharacterEntity create(CharacterEntity characterEntity){
        return characterRepository.save(characterEntity);
    }

    @Override
    public List<CharacterDTO> getCharacters(){

        var charactes = characterRepository.findAll();
        if (charactes == null) return null;

        var mappedCharacters =  charactes
                .stream()
                .map(c -> new CharacterDTO(c.getName(),c.getImage()))
                .collect(Collectors.toList());
        return mappedCharacters;

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

    public List<CharacterEntity> getAllCharacters(){
        var characters = characterRepository.findAll();
        if (characters == null){
            return null;
        }
        else{
            return characters;
        }
    }
}
