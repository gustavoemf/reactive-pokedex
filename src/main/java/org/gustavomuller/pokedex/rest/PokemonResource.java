package org.gustavomuller.pokedex.rest;

import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.gustavomuller.pokedex.Pokemon;
import org.gustavomuller.pokedex.repository.PokemonRepository;

import java.util.List;

@Path("/api/pokemons")
@ApplicationScoped
public class PokemonResource {

    private final PokemonRepository repository;

    @Inject
    public PokemonResource(PokemonRepository repository) {
        this.repository = new PokemonRepository();
    }

    @GET
    public Uni<List<Pokemon>> getAll() {
        return repository.listAll(Sort.by("name"));
    }
}
