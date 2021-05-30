package com.example.disney_challenge.repositories;

import com.example.disney_challenge.models.MultimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultimediaRepository extends JpaRepository<MultimediaEntity,Long> {
}
