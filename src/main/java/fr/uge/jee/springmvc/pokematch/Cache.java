package fr.uge.jee.springmvc.pokematch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@Component
public class Cache {

    @Autowired
    private RequestGraphQL requestGraphQL;
    @Autowired
    private Map<Pokemon, byte[]> cache = new HashMap<>();

    private static byte[] getImageFromUrl(String sprite) throws IOException {
        URL url = new URL(sprite);
        BufferedImage bImage = ImageIO.read(url);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String format = sprite.substring(sprite.lastIndexOf(".") + 1);
        ImageIO.write(bImage, format, bos);
        return bos.toByteArray();
    }

    private PokemonForm requestToAPI(Pokemon pokemon){
        return requestGraphQL.requestSprites(pokemon.getId());
    }

    public byte[] get(Pokemon pokemon) throws IOException {
        Objects.requireNonNull(pokemon);
        var pokemonForm = cache.get(pokemon);
        if(Objects.isNull(pokemonForm)){
            PokemonForm requestPokeForm = requestToAPI(pokemon);
            var image = getImageFromUrl(requestPokeForm.getSprites());
            cache.put(pokemon, image);
            return image;
        }
        return pokemonForm;
    }
}
