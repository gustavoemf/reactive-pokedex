package org.gustavomuller.pokedex;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Entity class for a Pokemon.
 */
@Entity
public class Pokemon extends PanacheEntity {

    @NotBlank
    @Column(unique = true)
    public String identifier;

    @NotNull
    @Positive
    public Integer pokedexNumber;

    @NotBlank
    public String type1;

    public String type2;

    @NotNull
    @Positive
    public Integer totalStats;
}
