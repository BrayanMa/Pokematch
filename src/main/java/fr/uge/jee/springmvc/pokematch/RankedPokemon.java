package fr.uge.jee.springmvc.pokematch;

import javax.sound.sampled.Port;

public class RankedPokemon {
    private final Pokemon pokemon;
    private int occ;

    public RankedPokemon(Pokemon pokemon, int occ){
        this.pokemon = pokemon;
        this.occ = occ;
    }

    public void changeOcc(int value){
        occ = value;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public int getOcc(){
        return occ;
    }
}
