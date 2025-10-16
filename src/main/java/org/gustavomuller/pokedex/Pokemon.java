package org.gustavomuller.pokedex;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
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
    public String name;

    @NotBlank
    public String type;

    @NotNull
    @Positive
    public Integer level;
}
