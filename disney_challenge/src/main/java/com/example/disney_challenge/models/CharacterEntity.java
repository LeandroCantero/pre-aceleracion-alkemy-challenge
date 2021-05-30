package com.example.disney_challenge.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "movie_characters",
            joinColumns = @JoinColumn(name = "character_id", nullable=false),
            inverseJoinColumns = @JoinColumn(name = "multimedia_id")
    )
    @JsonManagedReference

    private Set<MultimediaEntity> multimedia = new HashSet<>();

    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String history;



    public CharacterEntity(Long id, String image, String name, Integer age, Integer weight, String history) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
    }

    public CharacterEntity() {

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

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getHistory() {
        return history;
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void addMultimedia(MultimediaEntity multimedia) {
        this.multimedia.add(multimedia);
    }

    public Set<MultimediaEntity> getMultimedia() {
        return multimedia;
    }
}
