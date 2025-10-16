package org.gustavomuller.pokedex.rest;

import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.gustavomuller.pokedex.Pokemon;
import org.gustavomuller.pokedex.repository.PokemonRepository;
import org.gustavomuller.pokedex.service.PokemonService;

import java.util.List;

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
