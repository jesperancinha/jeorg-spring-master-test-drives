package org.jesperancinha.smtd.planets.components;

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
}
