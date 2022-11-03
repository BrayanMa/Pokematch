package fr.uge.jee.springmvc.pokematch.Application;

import java.util.Objects;

public class PokeBis {

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
        PokeBis pokemon = (PokeBis) o;
        return id == pokemon.id && Objects.equals(name, pokemon.name) /*&& Objects.equals(sprites, pokemon.sprites)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name/*, sprites*/);
    }
}
