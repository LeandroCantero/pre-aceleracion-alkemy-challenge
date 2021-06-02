package com.example.disney_challenge.controllers;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.services.CharacterService;
import com.example.disney_challenge.dtos.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
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
    public ResponseEntity<List<CharacterDTO>> getCharacters(){
        var characters =  characterService.getCharacters();
        if (characters==null) {
            return new ResponseEntity(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(characters, HttpStatus.OK);
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