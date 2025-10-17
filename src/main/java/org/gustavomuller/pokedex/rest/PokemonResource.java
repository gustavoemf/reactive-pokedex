package org.gustavomuller.pokedex.rest;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.gustavomuller.pokedex.model.Pokemon;
import org.gustavomuller.pokedex.service.PokemonService;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

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
        return service.findAllPokemons()
                .invoke(pokemons -> Log.debugf("Total number of heroes: %d", pokemons.size()));
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
    public Uni<Response> createPokemon(@NotNull @Valid Pokemon pokemon, @Context UriInfo uriInfo) {
        return service.persistPokemon(pokemon)
                .map(p -> {
                    var uri = uriInfo.getAbsolutePathBuilder().path(p.id.toString()).build();
                    Log.debugf("New Pokemon created with URI %s", uri.toString());
                    return Response.created(uri).build();
                });
    }

    @GET
    @Path("/hello")
    @Produces(TEXT_PLAIN)
    @NonBlocking
    public String hello() {
        Log.debug("Hello Pokemon Resource");
        return "Hello Pokemon Resource";
    }
}
