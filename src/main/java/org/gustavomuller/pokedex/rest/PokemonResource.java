package org.gustavomuller.pokedex.rest;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.gustavomuller.pokedex.Pokemon;
import org.gustavomuller.pokedex.service.PokemonService;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * API endpoints.
 */
@Path("/api/pokemons")
@Produces(APPLICATION_JSON)
public class PokemonResource {

    private final PokemonService service;

    public PokemonResource(PokemonService service) {
        this.service = service;
    }

    @GET
    public Uni<List<Pokemon>> getAll() {
        return service.findAllPokemons();
    }

    @GET
    @Path("/{id}")
    public Uni<Response> getPokemonById(@PathParam("id") Long id) {
        return service.findPokemonById(id)
                .onItem().ifNotNull().transform(p -> {
                    Log.debugf("Found pokemon: %s", p);
                    return Response.ok(p).build();
                })
                .replaceIfNullWith(() -> {
                    Log.debugf("No pokemon found with id %d", id);
                    return Response.status(Response.Status.NOT_FOUND).build();
                });
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Uni<Response> createPokemon(@NotNull @Valid Pokemon pokemon) {
        return service.persistPokemon(pokemon)
                .onItem().ifNotNull().transform(p -> {
                    Log.debugf("New pokemon created: %s", p);
                    return Response.ok(p).build();
                });
    }
}
