package org.jesperancinha.smtd.planets.components;

import jakarta.annotation.PostConstruct;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Component;

@Component
public class PlanetXSimple {

    private final String atmosphere;

    private final String temperature;

    public PlanetXSimple(String temperature, String atmosphere) {
        ConsolerizerComposer.outSpace()
                .yellow("PlanetXSimple constructor")
                .orange("In the constructor we have no info when using FIELD injection")
                .none()
                .orange("Our planet atmosphere is")
                .blue(atmosphere)
                .orange("and the temperature is")
                .blue(temperature)
                .newLine()
                .reset();
        this.temperature = temperature;
        this.atmosphere = atmosphere;
    }

    @PostConstruct
    public void postConstruct(){
        ConsolerizerComposer.outSpace()
                .yellow("PlanetXSimple#postConstruct")
                .orange("It is not advised to used FIELD injection. Instead, we should use contructor injection or parameter injection")
                .orange("The reason for this is mostly because we cannot inject immutable instances this way.")
                .none()
                .orange("Our planet atmosphere is")
                .blue(atmosphere)
                .orange("and the temperature is")
                .blue(temperature)
                .newLine()
                .reset();
    }
}
