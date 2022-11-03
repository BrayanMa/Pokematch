package fr.uge.jee.springmvc.pokematch.Application;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class MyClass {

    MyClass(GraphQLWebClient graphQLWebClient) {

    }


    public List<PokeBis> test(){
        ObjectMapper objectMapper = new ObjectMapper();

        WebClient webClient = WebClient.builder()
                .baseUrl("https://beta.pokeapi.co/graphql/v1beta")//url of graphql instance
                .build();

        GraphQLWebClient graphqlClient = GraphQLWebClient.newInstance(webClient, objectMapper);

        var response = graphqlClient.post(GraphQLRequest.builder().resource("query1.graphql").build())
                .block();

        return Objects.requireNonNull(response).getFirstList(PokeBis.class);

    }

    public PokemonFormBis test2(long id){
        ObjectMapper objectMapper = new ObjectMapper();

        WebClient webClient = WebClient.builder()
                .baseUrl("https://beta.pokeapi.co/graphql/v1beta")//url of graphql instance
                .build();

        GraphQLWebClient graphqlClient = GraphQLWebClient.newInstance(webClient, objectMapper);

        var response = graphqlClient.post(GraphQLRequest.builder().resource("query2.graphql")
                        .variables(Map.of("varid", 1)).build())
                .block();

        List<PokemonFormBis> entityList = Objects.requireNonNull(response).getFirstList(PokemonFormBis.class);

        var test = entityList.get(0).getSprites().split(":", 2)[1].split(",")[0].replaceAll("\"","");
        entityList.get(0).setSprites(test);

        return entityList.stream().findFirst().get();
    }
}
