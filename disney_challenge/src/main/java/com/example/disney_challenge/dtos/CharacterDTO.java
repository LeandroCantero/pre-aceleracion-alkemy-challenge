package com.example.disney_challenge.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
    private String name;
    private String url;


}
