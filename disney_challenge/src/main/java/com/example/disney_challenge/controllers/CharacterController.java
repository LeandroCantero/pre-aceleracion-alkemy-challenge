/*
package com.example.disney_challenge.controllers;

import com.example.disney_challenge.models.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.disney_challenge.repositories.CharacterRepository;
import com.example.disney_challenge.services.CharacterService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping
    public ArrayList<CharacterEntity> getCharacters(){
        return characterService.getCharacters();
    }

    @PostMapping(path = "/add")
    public CharacterEntity saveCharacters(@RequestBody CharacterEntity user){
        return this.characterService.saveCharacters(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<CharacterEntity> getAllCharacters() {
        return characterRepository.findAll();
    }
}
*/