package fr.uge.jee.springmvc.pokematch.AppConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.uge.jee.springmvc.pokematch.Pokemons.Pokemon;
import fr.uge.jee.springmvc.pokematch.Pokemons.PokemonForm;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class RequestGraphQL {

    /* Code repris du lien présent dans le rapport */
    public List<Pokemon> requestAllPoke(){
        ObjectMapper objectMapper = new ObjectMapper();
        WebClient webClient = WebClient.builder()
                .baseUrl("https://beta.pokeapi.co/graphql/v1beta")//url of graphql instance
                .build();
        GraphQLWebClient graphqlClient = GraphQLWebClient.newInstance(webClient, objectMapper);
        var response = graphqlClient
                .post(GraphQLRequest.builder().resource("graphql/query1.graphql").build())
                .block();
        return Objects.requireNonNull(response).getFirstList(Pokemon.class);
    }

    public PokemonForm requestSprites(long id){
        ObjectMapper objectMapper = new ObjectMapper();
        WebClient webClient = WebClient.builder()
                .baseUrl("https://beta.pokeapi.co/graphql/v1beta")//url of graphql instance
                .build();
        GraphQLWebClient graphqlClient = GraphQLWebClient.newInstance(webClient, objectMapper);
        var response = graphqlClient.post(GraphQLRequest.builder()
                        .resource("graphql/query2.graphql")
                        .variables(Map.of("varid", id))
                        .build())
                .block();
        List<PokemonForm> entityList = Objects.requireNonNull(response).getFirstList(PokemonForm.class);
        var test = entityList.get(0).getSprites().split(":", 2)[1].split(",")[0].replaceAll("\"","");
        entityList.get(0).setSprites(test);
        return entityList.stream().findFirst().get();
    }

}
