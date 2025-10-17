package org.gustavomuller.pokedex.service;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.quarkus.logging.Log;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.gustavomuller.pokedex.model.Pokemon;

import java.util.List;

/**
 * Service class containing business methods.
 */
@ApplicationScoped
public class PokemonService {

    public Uni<List<Pokemon>> findAllPokemons() {
        Log.debug("Getting all pokemons");
        return Pokemon.listAll(Sort.by("identifier"));
    }

    public Uni<Pokemon> findPokemonById(Long id) {
        Log.debugf("Getting pokemon by id = %d", id);
        return Pokemon.findById(id);
    }

    @WithTransaction
    public Uni<Pokemon> persistPokemon(@NotNull @Valid Pokemon pokemon) {
        Log.debugf("Persisting pokemon %s", pokemon);
        return Pokemon.persist(pokemon).replaceWith(pokemon);
    }
}
