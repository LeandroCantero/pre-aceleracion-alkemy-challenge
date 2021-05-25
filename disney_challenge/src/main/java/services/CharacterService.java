package services;

import models.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CharacterRepository;

import java.util.ArrayList;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository userRepository;

    public ArrayList<CharacterEntity> getCharacters() {
        return (ArrayList<CharacterEntity>) userRepository.findAll();
    }

    public CharacterEntity saveCharacters(CharacterEntity usuario) {
        return userRepository.save(usuario);
    }
}
