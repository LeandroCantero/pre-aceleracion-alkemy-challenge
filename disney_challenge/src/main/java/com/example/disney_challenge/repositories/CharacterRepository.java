package com.example.disney_challenge.repositories;

import com.example.disney_challenge.models.CharacterEntity;
import com.example.disney_challenge.models.MultimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    List<CharacterEntity> findByName(String name);
    List<CharacterEntity> findByAge(Integer age);
    List<CharacterEntity> findByWeight(Integer weight);
    List<CharacterEntity> findByMultimedia(MultimediaEntity multimedia);

}
