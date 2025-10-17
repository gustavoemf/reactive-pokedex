package org.gustavomuller.pokedex.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.gustavomuller.pokedex.rest.PokemonResource;

/**
 * HeathCheck to ping the Pokemon service
 */
@Liveness
public record PingPokemonResourceHealthCheck(PokemonResource resource) implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        var response = this.resource.hello();

        return HealthCheckResponse.named("Ping Pokemon REST Endpoint")
                .withData("Response", response)
                .up()
                .build();
    }
}
