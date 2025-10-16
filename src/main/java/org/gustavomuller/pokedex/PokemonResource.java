package org.gustavomuller.pokedex;

import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pokemons")
@ApplicationScoped
public class PokemonResource {

    @GET
    public Uni<List<Pokemon>> getAll() {
        return Pokemon.listAll(Sort.by("name"));
    }
}
