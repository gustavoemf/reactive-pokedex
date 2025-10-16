package org.gustavomuller.pokedex.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gustavomuller.pokedex.Pokemon;

@ApplicationScoped
public class PokemonRepository implements PanacheRepository<Pokemon> {
}
