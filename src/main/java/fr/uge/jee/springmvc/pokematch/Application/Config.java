package fr.uge.jee.springmvc.pokematch.Application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Bean
    WebClient getWebClient(WebClient.Builder defaultBuilder) {
        return defaultBuilder.exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(16 * 1024 * 1024)).build()).build();
    }

    @Bean
    List<Pokemon> pokemonListField(RequestGraphQL myClass){
        return myClass.requestAllPoke();
    }

    @Bean
    PokemonList pokemonListOb(){
        return new PokemonList();
    }

    @Bean
    Map<Pokemon, Integer> resultList(){
        return new HashMap<>();
    }

    @Bean
    Result resultOb(){
        return new Result();
    }

    @Bean
    List<RankedPokemon> rank(){
        return new ArrayList<>();
    }

    @Bean
    Map<Pokemon, PokemonForm> createCacheField(){
        return new HashMap<>();
    }

    @Bean
    Cache createCache(){
        return new Cache();
    }
}
