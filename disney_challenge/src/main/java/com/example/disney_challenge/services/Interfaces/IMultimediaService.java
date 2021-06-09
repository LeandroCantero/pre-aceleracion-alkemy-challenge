package com.example.disney_challenge.services.Interfaces;

import com.example.disney_challenge.dtos.MultimediaDTO;
import com.example.disney_challenge.dtos.requests.MultimediaRequest;
import com.example.disney_challenge.models.MultimediaEntity;

import java.util.List;

public interface IMultimediaService {
    List<MultimediaDTO> getMultimedia();

    MultimediaDTO findById(Long id);

    MultimediaEntity createMultimedia(MultimediaRequest multimediaRequest);

    void deleteMultimedia(Long id);

    MultimediaEntity updateMultimedia(Long id, MultimediaEntity multimedia);
}
