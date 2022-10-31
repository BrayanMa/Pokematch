package fr.uge.jee.springmvc.pokematch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@PropertySource("classpath:result.properties")
public class Config {

    @Bean
    WebClient getWebClient(WebClient.Builder defaultBuilder) {
        return defaultBuilder.exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(16 * 1024 * 1024)).build()).build();
    }

    Mono<Pokemon> getStudent(int id, ApplicationContext applicationContext){
        //WebClient webClient = WebClient.create();
        WebClient webClient = (WebClient) applicationContext.getBean("getWebClient");
        return webClient.get()
                //.uri("https://pokeapi.co/api/v2/pokemon-form/"+id)
                .uri("https://pokeapi.co/api/v2/pokemon/"+id)
                .retrieve()
                .bodyToMono(Pokemon.class);
    }

    @Bean
    List<Pokemon> pokemonListField(ApplicationContext applicationContext){
        List<Mono<Pokemon>> monos = Flux.range(1, 	40).map(x -> this.getStudent(x, applicationContext)).collect(Collectors.toList()).block();
        Flux<Pokemon> flux = Flux.merge(Objects.requireNonNull(monos));
        return flux.toStream().collect(Collectors.toList());
        //students.forEach(x -> System.out.println(x.toString()));
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
