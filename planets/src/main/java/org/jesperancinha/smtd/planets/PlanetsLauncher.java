package org.jesperancinha.smtd.planets;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.planets.configuration.PlanetConfiguration;
import org.jesperancinha.smtd.planets.dto.Planet;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableConfigurationProperties(PlanetConfiguration.class)
public class PlanetsLauncher implements ApplicationRunner {

    private final PlanetConfiguration planetConfiguration;

    private final Planet planet;

    public PlanetsLauncher(PlanetConfiguration planetConfiguration, Planet planet) {
        this.planetConfiguration = planetConfiguration;
        this.planet = planet;
    }

    public static void main(String[] args) {
        SpringApplication.run(PlanetsLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        ConsolerizerComposer.outSpace()
                .none()
                .orange("This is a planet configuration of planet").blue(planetConfiguration.getName())
                .newLine()
                .orange("We can call this planet differently as").blue(planetConfiguration.getScientific())
                .newLine()
                .orange("The planet as an area of").blue(planetConfiguration.getArea()).orange("km2")
                .newLine()
                .orange("This planet has a diameter of").blue(planetConfiguration.getDiameter()).orange("km")
                .newLine()
                .orange("And a volume of").blue(planetConfiguration.getVolume()).orange("km3")
                .newLine()
                .orange("We don't know if it is habitable(this is our unknown field")
                .newLine()
                .orange("We don't know the volume(this is our invalid field. it was given with the value volume")
                .reset();

        ConsolerizerComposer.outSpace()
                .blue("Planet X is:")
                .cyan()
                .jsonPrettyPrint(planet)
                .newLine()
                .reset();
    }
}
