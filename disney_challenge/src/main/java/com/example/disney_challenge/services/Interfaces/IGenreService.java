package com.example.disney_challenge.services.Interfaces;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.GenreEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IGenreService {
    GenreEntity getGenreById(Long genresId);
}
