package org.gustavomuller.pokedex.service;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.gustavomuller.pokedex.Pokemon;
import org.gustavomuller.pokedex.repository.PokemonRepository;

import java.util.List;

@ApplicationScoped
public class PokemonService {

    private final PokemonRepository repository;

    @Inject
    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public Uni<List<Pokemon>> findAllPokemons() {
        return repository.listAll();
    }
}
