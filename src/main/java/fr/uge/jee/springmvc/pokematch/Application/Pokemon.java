package fr.uge.jee.springmvc.pokematch.Application;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Pokemon {
    private long id;
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int hashName(){
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id && Objects.equals(name, pokemon.name) /*&& Objects.equals(sprites, pokemon.sprites)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name/*, sprites*/);
    }

/*    @JsonProperty("id")
    private long uid;
    @JsonProperty("name")
    private String name;

    //@JsonProperty("sprites")
    //private Sprites sprites;


    public Pokemon() {}

    //@JsonProperty("sprites")
    //public Sprites getSprites() {
    //    return sprites;
    //}

    //public void setSprites(Sprites sprites) {
    //    this.sprites = sprites;
    //}

    @JsonProperty("id")
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
        //", url image =" + sprites.getUrl() +
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
        return uid == pokemon.uid && Objects.equals(name, pokemon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name);
    }*/
}
