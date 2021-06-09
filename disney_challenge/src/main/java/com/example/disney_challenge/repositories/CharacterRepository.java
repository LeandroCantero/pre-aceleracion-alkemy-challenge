package com.example.disney_challenge.repositories;

import com.example.disney_challenge.dtos.requests.CharacterRequest;
import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.MultimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    List<CharacterEntity> findByName(String name);

    List<CharacterEntity> findByAge(Integer age);

    List<CharacterEntity> findByWeight(Integer weight);

    List<CharacterEntity> findByMultimedia(MultimediaEntity multimedia);

    //List<CharacterEntity> findByNameOrAgeOrWeightOrMultimedia(String name, Integer age, Integer weight, MultimediaEntity multimedia);

}
