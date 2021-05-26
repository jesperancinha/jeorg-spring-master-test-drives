package org.jesperancinha.smtd.planets.components;

import org.jesperancinha.smtd.planets.dto.Planet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanetXGeneralConfiguration {
    @Bean
    public String atmosphere(){
        return "dense";
    }

    @Bean
    public String temperature(){
        return "hot";
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Planet planet(){
        return Planet
                .builder()
                .name("Jupiter")
                .scientificName("Jupiter")
                .area(6.1419E10)
                .build();
    }
}
