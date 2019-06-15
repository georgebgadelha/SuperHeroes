package com.example.superheroes.model;

public class Hero {

    private String name;
    private String description;
    private String imagemUrl;

    public Hero(String name, String description, String imagemUrl) {
        this.name = name;
        this.description = description;
        this.imagemUrl = imagemUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
