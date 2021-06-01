package com.example.disney_challenge.services;

import com.example.disney_challenge.dtos.MultimediaDTO;
import com.example.disney_challenge.models.MultimediaEntity;

import java.util.List;

public interface IMultimediaService {
    List<MultimediaDTO> getMultimedia();
    MultimediaDTO findById(Long id);
    MultimediaEntity create(MultimediaEntity multimediaEntity);
    void deleteMultimedia(Long id);
    void updateMultimedia(Long id, MultimediaEntity multimedia);
}
