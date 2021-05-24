package org.jesperancinha.smtd.carparts.configuration.conditionals;

import lombok.Builder;
import lombok.Data;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.carparts.beans.Garage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * A class called MarsBase needs to be on the classpath in order for {@link PartConfigurationDone} to be initialized
 * <p>
 * This just demonstrates that it never happens
 */
@Builder
@Data
@Configuration
@ConditionalOnClass(name = "org.jesperancinha.smtd.carparts.beans.Garage")
public class PartConfigurationDone {

    @Bean
    @ConditionalOnClass(Garage.class)
    public PartConfigurationDone partConfigurationDone2() {
        ConsolerizerComposer.outSpace().green("We are able to create PartConfigurationDone, because the Garage exists")
                .green("If we want to use the class name as a string, we have to use the canonical form.")
                .green("The short form won't work.")
                .reset();
        return PartConfigurationDone.builder().build();
    }
}
