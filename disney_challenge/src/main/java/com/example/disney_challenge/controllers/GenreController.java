package com.example.disney_challenge.controllers;

import com.example.disney_challenge.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class GenreController {

    @Autowired
    private GenreService characterService;


}
