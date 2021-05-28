package com.example.disney_challenge.controllers;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.net.URI;
import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/characters")
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

    @GetMapping("/all")
    private ResponseEntity <List<CharacterEntity>> listAllCharacters(@RequestBody CharacterEntity characterEntity){
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteCharacter(@RequestBody CharacterEntity characterEntity){
        characterService.delete(characterEntity);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    private ResponseEntity <Optional<CharacterEntity>> listById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

}