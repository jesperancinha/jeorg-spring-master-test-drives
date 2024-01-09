package org.jesperancinha.smtd.planets.components;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicReference;

@Configuration
public class PlanetXConfiguration {

    private final String atmosphere;

    PlanetXConfiguration(
            @Autowired
            @Qualifier("atmosphere") final AtomicReference<String> atmosphere) {
        ConsolerizerComposer.outSpace()
                .yellow("PlanetXConfiguration constructor")
                .orange("We can also initialize our beans atmosphere")
                .orange("These constructor gets called just after the %s phase and just before the %s phase", "phase1", "phase2")
                .none().orange("The planet's atmosphere is").blue(atmosphere)
                .newLine()
                .reset();

        this.atmosphere = atmosphere.get();
    }


    @Autowired
    public void setupAtmosphere(@Qualifier("atmosphere") final AtomicReference<String> atmosphere) {
        ConsolerizerComposer.outSpace()
                .yellow("PlanetXConfiguration#setupAtmosphere method")
                .orange("We get the planet's data via method injection")
                .orange("These methods get initialized just after the %s phase and just before the %s phase", "phase1", "phase2")
                .none().orange("The planet's atmosphere is").blue(atmosphere)
                .newLine()
                .reset();
    }
}
