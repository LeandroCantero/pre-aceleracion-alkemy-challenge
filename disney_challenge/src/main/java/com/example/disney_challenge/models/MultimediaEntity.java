package com.example.disney_challenge.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "multimedia")
public class MultimediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "multimedia", cascade = CascadeType.MERGE)
    @JsonBackReference

    private Set<CharacterEntity> enrolledCharacters = new HashSet<>();
    private String image;
    private String title;
    private LocalDate creation_date;
    private Float rating;


    public MultimediaEntity(Long id, String image, String title, LocalDate date, Float rating) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.creation_date = date;
        this.rating = rating;
    }

    public MultimediaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate date) {
        this.creation_date = date;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Set<CharacterEntity> getEnrolledCharacters() {
        return enrolledCharacters;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public GenreEntity getGenre() {
        return genre;
    }

}
