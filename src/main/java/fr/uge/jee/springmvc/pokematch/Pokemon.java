package fr.uge.jee.springmvc.pokematch;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Pokemon {
    @JsonIgnore
    private long uid;
    @JsonProperty("name")
    private String name;

    @JsonProperty("sprites")
    private Sprites sprites;


    public Pokemon() {}

    @JsonProperty("sprites")
    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    @JsonIgnore
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", url image =" + sprites.getUrl() +
                '}';
    }

    public int hashName(){
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return uid == pokemon.uid && Objects.equals(name, pokemon.name) && Objects.equals(sprites, pokemon.sprites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, sprites);
    }
}
