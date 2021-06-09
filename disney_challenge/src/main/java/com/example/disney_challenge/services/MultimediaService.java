package com.example.disney_challenge.services;

import com.example.disney_challenge.dtos.MultimediaDTO;
import com.example.disney_challenge.dtos.requests.MultimediaRequest;
import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.MultimediaEntity;
import com.example.disney_challenge.repositories.MultimediaRepository;
import com.example.disney_challenge.services.Interfaces.IMultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Repository
public class MultimediaService implements IMultimediaService {

    @Autowired
    private MultimediaRepository multimediaRepository;

    @Autowired
    private CharacterService characterService;

    @Autowired
    private GenreService genreService;

    @Override
    public List<MultimediaDTO> getMultimedia() {
        var multimedia = multimediaRepository.findAll();
        if (multimedia == null) return null;

        var mappedMultimedia = multimedia
                .stream()
                .map(m -> new MultimediaDTO(m.getImage(), m.getTitle(), m.getCreation_date()))
                .collect(Collectors.toList());
        return mappedMultimedia;
    }

    @Override
    public MultimediaDTO findById(Long id) {
        Optional<MultimediaEntity> multimediaEntity = multimediaRepository.findById(id);
        MultimediaDTO multimediaDTO = new MultimediaDTO();
        if (multimediaEntity != null && multimediaEntity.isPresent()) {
            multimediaDTO.setImage(multimediaEntity.get().getImage());
            multimediaDTO.setTitle(multimediaEntity.get().getTitle());
            multimediaDTO.setCreation_date(multimediaEntity.get().getCreation_date());
        }
        return multimediaDTO;
    }

    @Override
    public MultimediaEntity createMultimedia(MultimediaRequest multimediaRequest) {
        var multimedia = new MultimediaEntity();
        multimedia.setTitle(multimediaRequest.getTitle());
        multimedia.setImage(multimediaRequest.getImage());
        multimedia.setRating(multimediaRequest.getRating());
        multimedia.setCreation_date(multimediaRequest.getCreation_date());

        Set<CharacterEntity> characters =
                characterService.getCharactersById(multimediaRequest.getCharacterEntityList());
        multimedia.setCharacters(characters);

//        Set<GenreEntity> genres =
//                genreService.getGenresById(multimediaRequest.getGenreEntityList());
//        multimedia.setGenre(genres);

        return multimediaRepository.save(multimedia);
    }

    @Override
    public void deleteMultimedia(Long id) {
        multimediaRepository.deleteById(id);
    }

    @Override
    public MultimediaEntity updateMultimedia(Long id, MultimediaEntity multimediaEntity) {
        var multimedia = multimediaRepository.findById(id);
        var multi = multimedia.get();
        if (multimedia.isPresent()) {
            String title = multimediaEntity.getTitle() == null ? multi.getTitle() : multimediaEntity.getTitle();
            String image = multimediaEntity.getImage() == null ? multi.getImage() : multimediaEntity.getImage();
            LocalDate date = multimediaEntity.getCreation_date() == null ? multi.getCreation_date() : multimediaEntity.getCreation_date();
            Float rating = multimediaEntity.getRating() == null ? multi.getRating() : multimediaEntity.getRating();
            multi.setTitle(title);
            multi.setImage(image);
            multi.setCreation_date(date);
            multi.setRating(rating);
        }
        return multimediaRepository.save(multi);
    }

    public List<MultimediaEntity> multimediaDetails() {
        var multimedia = multimediaRepository.findAll();
        if (multimedia == null) {
            return null;
        } else {
            return multimedia;
        }
    }

    public List<MultimediaEntity> findByFilters(String title, String genre) {
        if (title != null) {
            return multimediaRepository.findByTitle(title);
        }
        if (genre != null) {
            return multimediaRepository.findByGenre_Name(genre);
        }
        return multimediaRepository.findAll();
    }
}
