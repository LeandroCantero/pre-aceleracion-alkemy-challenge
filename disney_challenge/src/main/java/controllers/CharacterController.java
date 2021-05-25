package controllers;

import models.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repositories.CharacterRepository;
import services.CharacterService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class CharacterController {
    @Autowired
    private CharacterService userService;

    @Autowired
    private CharacterRepository userRepository;

    @GetMapping
    public ArrayList<CharacterEntity> getCharacters(){
        return userService.getCharacters();
    }

    @PostMapping(path = "/add")
    public CharacterEntity saveCharacters(@RequestBody CharacterEntity user){
        return this.userService.saveCharacters(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<CharacterEntity> getAllCharacters() {
        return userRepository.findAll();
    }
}
