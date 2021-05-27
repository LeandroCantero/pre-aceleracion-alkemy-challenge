package com.example.disney_challenge.controllers;

import com.example.disney_challenge.interfaceServices.InterfaceCharacterServices;
import com.example.disney_challenge.models.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.disney_challenge.repositories.CharacterRepository;
import com.example.disney_challenge.services.CharacterService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class CharacterController {

    @Autowired
    InterfaceCharacterServices interfaceCharacterServices;

    @GetMapping("/toList")
    public String toList(Model model){
        List<CharacterEntity> characters = interfaceCharacterServices.toList();
        model.addAttribute("characters", characters);
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("character", new CharacterEntity());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Validated CharacterEntity character, Model model){
        interfaceCharacterServices.save(character);
        return "redirect:/toList";
    }


}