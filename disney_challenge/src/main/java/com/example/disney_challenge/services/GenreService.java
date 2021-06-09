package com.example.disney_challenge.services;

import com.example.disney_challenge.models.GenreEntity;
import com.example.disney_challenge.repositories.GenreRepository;
import com.example.disney_challenge.services.Interfaces.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Repository
public class GenreService implements IGenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Set<GenreEntity> getGenresById(List<Long> genresId) {
        return  genresId
                .stream()
                .map(id -> genreRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
