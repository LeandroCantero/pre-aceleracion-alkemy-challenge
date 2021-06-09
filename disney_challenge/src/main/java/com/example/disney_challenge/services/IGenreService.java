package com.example.disney_challenge.services;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.GenreEntity;

import java.util.List;
import java.util.Set;

public interface IGenreService {
    Set<GenreEntity> getGenresById(List<Long> genresId);
}
