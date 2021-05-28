package com.example.disney_challenge.controllers;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.services.CharacterService;
import com.example.disney_challenge.util.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    private ResponseEntity <CharacterEntity> save(@RequestBody CharacterEntity characterEntity){
        CharacterEntity characterEntity1 = characterService.create(characterEntity);

        try{
            return ResponseEntity.created(new URI("/characters"+characterEntity1.getId())).body(characterEntity1);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/allCharacters")
    private List <CharacterEntity> listAllCharacters(@RequestBody CharacterEntity characterEntity){
        return characterService.getAllCharacters();
    }

    @DeleteMapping("/characters/delete/{id}")
    private String deleteCharacter(@PathVariable ("id") Long id){
        characterService.deleteCharacter(id);
        return "Delete successfully id =" + id;
    }

    @GetMapping(value = "/characters/{id}")
    private ResponseEntity<CharacterDTO> listById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

}