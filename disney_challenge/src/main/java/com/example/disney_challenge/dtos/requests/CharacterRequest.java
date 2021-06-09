package com.example.disney_challenge.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CharacterRequest {
    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String history;

}
