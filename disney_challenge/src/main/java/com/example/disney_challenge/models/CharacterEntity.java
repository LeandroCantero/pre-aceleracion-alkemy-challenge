package com.example.disney_challenge.models;

import javax.persistence.*;

@Entity
@Table(name = "characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
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

    /* Imagen.
○ Nombre.
○ Edad.
○ Peso.
○ Historia.
○ Películas o series asociadas
     */
}
