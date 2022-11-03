package fr.uge.jee.springmvc.pokematch.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonList {

    @Autowired
    private List<Pokemon> pokemonListField;

    public List<Pokemon> getPokemonListField() {
        return pokemonListField;
    }

    public PokemonList(){
    }

}
