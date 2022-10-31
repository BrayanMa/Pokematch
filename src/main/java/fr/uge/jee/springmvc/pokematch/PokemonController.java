package fr.uge.jee.springmvc.pokematch;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PokemonController implements WebMvcConfigurer {
    private final PokemonList pokemonList;
    private final Result result;

    public PokemonController(PokemonList pokemonList, Result result) {
        this.pokemonList = pokemonList;
        this.result = result;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/pokemon").setViewName("pokeResult");
    }

    @GetMapping("/pokemon")
    public String getPokemon(Model model) {
        model.addAttribute("pokeList", pokemonList.getPokemonListField());
        model.addAttribute("result", result);
        if(!model.containsAttribute("user"))
            model.addAttribute("user", new User());
        return "pokeForm";
    }

    @PostMapping("/pokemon")
    public String getUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "pokeForm";
        }

        Map<Integer, Pokemon> pokemonMap = pokemonList.getPokemonListField().stream().collect(Collectors.toMap(Pokemon::hashName, x -> x));
        var optionalHashcode = pokemonMap.keySet().stream().min(Comparator.comparingInt(f -> Math.abs(f - user.hashCode())));
        if(optionalHashcode.isPresent()){
            var pokemon = pokemonMap.get(optionalHashcode.get());
            model.addAttribute("pokemon", pokemon);
            result.add(pokemon);
        }else {
            model.addAttribute("pokemon", "Pokemon not found");
        }
        model.addAttribute("first_name", user.getFirstName());
        model.addAttribute("last_name", user.getLastName());
        return "pokeResult";
    }
}
