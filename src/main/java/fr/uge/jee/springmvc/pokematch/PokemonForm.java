package fr.uge.jee.springmvc.pokematch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonForm {

    @JsonProperty("id")
    private long uid;

    @JsonProperty("sprites")
    private Sprites sprites;

    @JsonProperty("id")
    public long getUid() {
        return uid;
    }

    @JsonProperty("sprites")
    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public PokemonForm() {}
}
