package org.gustavomuller.pokedex;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Entity class for a Pokemon.
 */
@Entity
public class Pokemon extends PanacheEntity {

    @NotBlank
    @Size(min = 3, max = 50)
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

    public String sprite;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(Integer pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public Integer getTotalStats() {
        return totalStats;
    }

    public void setTotalStats(Integer totalStats) {
        this.totalStats = totalStats;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + this.id +
                ", identifier='" + this.identifier + '\'' +
                ", pokedexNumber='" + this.pokedexNumber + '\'' +
                ", type1=" + this.type1 +
                ", type2='" + this.type2 + '\'' +
                ", totalStatus='" + this.totalStats + '\'' +
                ", sprite='" + this.sprite + '\'' +
                '}';
    }
}
