package com.example.disney_challenge.dtos.requests;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.GenreEntity;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@AllArgsConstructor
public class MultimediaRequest {
    private String title;
    private String image;
    private Float rating;
    private LocalDate creation_date;
    private GenreEntity genre;
    private List<Long> characters;

}
