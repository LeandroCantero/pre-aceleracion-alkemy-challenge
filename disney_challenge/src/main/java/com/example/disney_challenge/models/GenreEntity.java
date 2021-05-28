package com.example.disney_challenge.models;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String image;
    private String name;

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
}
