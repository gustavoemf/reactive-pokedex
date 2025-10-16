package org.gustavomuller.pokedex;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Pokemon extends PanacheEntity {
    @Id
    @GeneratedValue
    public Long id;

    @NotBlank
    public String name;

    @NotBlank
    public String type;

    @NotNull
    @Positive
    public Integer level;
}
