package com.example.disney_challenge.repositories;

import com.example.disney_challenge.models.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository <GenreEntity,Long> {
}
