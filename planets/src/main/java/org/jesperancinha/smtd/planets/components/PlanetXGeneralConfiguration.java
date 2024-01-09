package org.jesperancinha.smtd.planets.components;

import org.jesperancinha.smtd.planets.dto.Planet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicReference;

@Configuration
public class PlanetXGeneralConfiguration {
    @Bean
    public AtomicReference<String> atmosphere(){
        return new AtomicReference<>("dense");
    }

    @Bean
    public AtomicReference<String> temperature(){
        return new AtomicReference<>( "hot");
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
