package org.gustavomuller.pokedex.rest;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.gustavomuller.pokedex.Pokemon;
import org.gustavomuller.pokedex.service.PokemonService;

import java.util.List;

/**
 * API endpoints.
 */
@Path("/api/pokemons")
@ApplicationScoped
public class PokemonResource {

    private final PokemonService service;

    @Inject
    public PokemonResource(PokemonService service) {
        this.service = service;
    }

    @GET
    public Uni<List<Pokemon>> getAll() {
        return service.findAllPokemons();
    }
}
