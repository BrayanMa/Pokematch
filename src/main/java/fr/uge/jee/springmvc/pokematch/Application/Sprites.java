package fr.uge.jee.springmvc.pokematch.Application;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {

    @JsonProperty("front_default")
    private String url;

    public Sprites() {
    }

    @JsonProperty("front_default")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
