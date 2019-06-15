package com.example.superheroes.dao;

import com.example.superheroes.model.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeroDAO {

    private final static ArrayList<Hero> heroes = new ArrayList<>();

    public List<Hero> todos() {
        return (List<Hero>) heroes.clone();
    }

    public void insere(Hero... heroes) {
        HeroDAO.heroes.addAll(Arrays.asList(heroes));
    }

    public void altera(int posicao, Hero hero) {
        heroes.set(posicao, hero);
    }

    public void remove(int posicao) {
        heroes.remove(posicao);
    }

    public void troca(int posicaoInicio, int posicaoFim) {
        Collections.swap(heroes, posicaoInicio, posicaoFim);
    }

    public void removeTodos() {
        heroes.clear();
    }
}
