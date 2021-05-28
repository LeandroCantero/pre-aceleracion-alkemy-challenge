package com.example.disney_challenge.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "multimedia")
public class MultimediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String image;
    private String title;
    private Date date;
    private Float rating;

    /*
    @ManyToMany(mappedBy = "multimedia", fetch = FetchType.LAZY)
    private Set<CharacterEntity> character = new HashSet<>();
    */


    public MultimediaEntity(Long id, String image, String title, Date date, Float rating, Set<CharacterEntity> character) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.date = date;
        this.rating = rating;
        //this.character = character;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

   /*
    public Set<CharacterEntity> getCharacter() {
        return character;
    }

    public void setCharacter(Set<CharacterEntity> character) {
        this.character = character;
    }

    */
}
