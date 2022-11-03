package fr.uge.jee.springmvc.pokematch.Application;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Pokemon {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
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
        return id == pokemon.id && Objects.equals(name, pokemon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
