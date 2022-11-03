package fr.uge.jee.springmvc.pokematch.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class Cache {

    @Autowired
    private RequestGraphQL requestGraphQL;
    @Autowired
    private Map<Pokemon, PokemonForm> cache = new HashMap<>();
   @Autowired
   private ApplicationContext applicationContext;

    public PokemonForm get(Pokemon pokemon){
        Objects.requireNonNull(pokemon);
        var pokemonForm = cache.get(pokemon);
        if(Objects.isNull(pokemonForm)){
            PokemonForm requestPokeForm = requestToAPI(pokemon, applicationContext);
            cache.put(pokemon, requestPokeForm);
            return requestPokeForm;
        }
        return pokemonForm;
    }

    private PokemonForm requestToAPI(Pokemon pokemon, ApplicationContext applicationContext){
        return requestGraphQL.requestSprites(pokemon.getId());
    }


}
