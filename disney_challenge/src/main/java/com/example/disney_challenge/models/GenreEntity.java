package com.example.disney_challenge.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String image;
    private String name;


    @OneToMany(mappedBy = "genre", cascade = CascadeType.MERGE)
    @JsonBackReference
    private Set<MultimediaEntity> multimedia;

    public GenreEntity(Long id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public GenreEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MultimediaEntity> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Set<MultimediaEntity> multimedia) {
        this.multimedia = multimedia;
    }

    public void addMultimedia(MultimediaEntity multimediaEntity) {
        if (multimediaEntity != null) {
            if (multimedia == null) {
                multimedia = new HashSet<MultimediaEntity>();
            }
            multimediaEntity.setGenre(this);
            multimedia.add(multimediaEntity);
        }
    }
}
