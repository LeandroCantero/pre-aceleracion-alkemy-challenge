package com.example.disney_challenge.services;

import com.example.disney_challenge.dtos.MultimediaDTO;
import com.example.disney_challenge.models.MultimediaEntity;
import com.example.disney_challenge.repositories.MultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Repository
public class MultimediaService implements IMultimediaService{

    @Autowired
    MultimediaRepository multimediaRepository;

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
        if (multimediaEntity != null && multimediaEntity.isPresent()){
            multimediaDTO.setImage(multimediaEntity.get().getImage());
            multimediaDTO.setTitle(multimediaEntity.get().getTitle());
            multimediaDTO.setCreation_date(multimediaEntity.get().getCreation_date());
        }
        return multimediaDTO;
    }

    @Override
    public MultimediaEntity create(MultimediaEntity multimediaEntity) {
        return multimediaRepository.save(multimediaEntity);
    }

    @Override
    public void deleteMultimedia(Long id) {
        multimediaRepository.deleteById(id);
    }

    public List<MultimediaEntity> multimediaDetails(){
        var multimedia = multimediaRepository.findAll();
        if (multimedia == null){
            return null;
        }
        else{
            return multimedia;
        }
    }
}
