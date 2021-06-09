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
    private String image;
    private String title;
    private LocalDate creation_date;
    private Float rating;
    private List<Long> genreEntityList;
    private List<Long> characterEntityList;

}
