package fr.uge.jee.springmvc.pokematch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class Cache {

    @Autowired
    private Map<Pokemon, PokemonForm> cache = new HashMap<>();
   @Autowired
   private ApplicationContext applicationContext;

    public void add(Pokemon pokemon, PokemonForm pokemonForm){
        Objects.requireNonNull(pokemon);
        Objects.requireNonNull(pokemonForm);
        cache.put(pokemon, pokemonForm);
    }

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

    private static PokemonForm requestToAPI(Pokemon pokemon, ApplicationContext applicationContext){
        WebClient webClient = (WebClient) applicationContext.getBean("getWebClient");
        return webClient.get()
                .uri("https://pokeapi.co/api/v2/pokemon-form/"+pokemon.getUid())
                .retrieve()
                .bodyToMono(PokemonForm.class)
                .block();
    }


}
