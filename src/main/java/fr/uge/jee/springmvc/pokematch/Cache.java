package fr.uge.jee.springmvc.pokematch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {

    @Autowired
    private Map<Pokemon, Sprites> cache = new HashMap<>();
}
