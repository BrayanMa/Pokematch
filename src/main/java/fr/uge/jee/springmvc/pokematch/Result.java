package fr.uge.jee.springmvc.pokematch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Result {
    @Autowired
    private Map<Pokemon, Integer> result;

    @Autowired
    private List<RankedPokemon> rank;
    @Value("${result.numberDisplay}")
    private int maxSize;

    private int maxIndex;

    private final Object lock = new Object();

    private void sortingRank(){
        rank.sort(Comparator.comparing(RankedPokemon::getOcc).reversed());
    }


    public void add(Pokemon pokemon){
        Objects.requireNonNull(pokemon);
        synchronized (lock){
            int value = result.compute(pokemon, (k, v) -> (v == null) ? 1 : v + 1);
            if(rank.isEmpty()){
                rank.add(new RankedPokemon(pokemon, value));
                maxIndex = 0;
                return;
            }

            var rankedPokemon = rank.stream().map(RankedPokemon::getPokemon).collect(Collectors.toList());

            if(rankedPokemon.contains(pokemon)) {
                rank.set(rankedPokemon.indexOf(pokemon), new RankedPokemon(pokemon, value));
                sortingRank();
            } else {
                if(maxIndex < maxSize - 1){
                    rank.add(new RankedPokemon(pokemon, value));
                    maxIndex += 1;
                    sortingRank();
                } else if(rank.get(maxIndex).getOcc() < value){
                    rank.set(maxIndex, new RankedPokemon(pokemon, value));
                    sortingRank();
                }
            }
        }
    }

    public List<RankedPokemon> getResult(){
        return rank;
    }

}
