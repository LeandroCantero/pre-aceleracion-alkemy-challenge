package com.example.disney_challenge.controllers;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.MultimediaEntity;
import com.example.disney_challenge.services.CharacterService;
import com.example.disney_challenge.dtos.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping("/characters/save")
    public ResponseEntity <CharacterEntity> save(@RequestBody CharacterEntity characterEntity){
        CharacterEntity characterEntity1 = characterService.create(characterEntity);

        try{
            return ResponseEntity.created(new URI("/characters"+characterEntity1.getId())).body(characterEntity1);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/characters/details")
    public ResponseEntity<List<CharacterEntity>> charactersDetails(){
        var characters = characterService.characterDetails();
        return new ResponseEntity(characters, HttpStatus.OK);
    }

    @GetMapping("/characters")
    public ResponseEntity<List<Object>> getCharacters(@RequestParam (required = false) String name,
                                                       @RequestParam (required = false) Integer age,
                                                       @RequestParam (required = false) Integer weight,
                                                       @RequestParam (required = false)MultimediaEntity multimedia){
        List characterList = null;
        if(name != null || age != null || weight != null || multimedia != null){
            characterList =  characterService.findByFilters(name, age, weight, multimedia);
        }
        else{
            var charactersDto =  characterService.getCharacters();
            if (charactersDto==null) {
                return new ResponseEntity(new ArrayList<>(),HttpStatus.NOT_FOUND);
            }
            characterList = charactersDto;
        }
        return ResponseEntity.ok(characterList);
    }

    @DeleteMapping("/characters/delete/{id}")
    public String deleteCharacter(@PathVariable ("id") Long id){
        characterService.deleteCharacter(id);
        return "Delete successfully id =" + id;
    }

    @GetMapping(value = "/characters/{id}")
    public ResponseEntity<CharacterDTO> listById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    @PutMapping(value = "/characters/{id}")
    public ResponseEntity<CharacterEntity> updateCharacter(@PathVariable ("id") Long id, @RequestBody CharacterEntity character){
        return ResponseEntity.ok(characterService.updateCharacter(id, character));
    }

}