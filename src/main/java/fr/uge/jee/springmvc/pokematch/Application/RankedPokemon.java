package fr.uge.jee.springmvc.pokematch.Application;

public class RankedPokemon {

    private final Pokemon pokemon;

    private final int occ;

    public RankedPokemon(Pokemon pokemon, int occ){
        this.pokemon = pokemon;
        this.occ = occ;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public int getOcc(){
        return occ;
    }

}
