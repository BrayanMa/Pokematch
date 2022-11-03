package fr.uge.jee.springmvc.pokematch.Application;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonForm {

    @JsonProperty("id")
    private long id;
    @JsonProperty("sprites")
    private String sprites;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSprites() {
        return sprites;
    }

    public void setSprites(String sprites) {
        this.sprites = sprites;
    }

}
