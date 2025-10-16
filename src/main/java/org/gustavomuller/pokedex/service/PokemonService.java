package org.gustavomuller.pokedex.service;

import io.quarkus.logging.Log;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.gustavomuller.pokedex.Pokemon;

import java.util.List;

/**
 * Service class containing business methods.
 */
@ApplicationScoped
public class PokemonService {

    public Uni<List<Pokemon>> findAllPokemons() {
        Log.debug("Getting all pokemons");
        return Pokemon.listAll(Sort.by("name"));
    }

    public Uni<Pokemon> findPokemonById(Long id) {
        Log.debugf("Getting pokemon by id = %d", id);
        return Pokemon.findById(id);
    }
}
