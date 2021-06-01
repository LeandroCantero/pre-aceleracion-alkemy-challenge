package com.example.disney_challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MultimediaDTO {
    private String image;
    private String title;
    private LocalDate creation_date;
}
