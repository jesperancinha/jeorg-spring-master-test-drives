package org.jesperancinha.smtd.carparts.configuration.conditionals;

import lombok.Builder;
import lombok.Data;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.carparts.beans.Garage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * A class called MarsBase needs to be on the classpath in order for {@link PartConfigurationNotDone} to be initialized
 * <p>
 * This just demonstrates that it never happens
 */
@Builder
@Data
@Configuration
@ConditionalOnClass(name = "MarsBase")
public class PartConfigurationNotDone {

    @ConditionalOnClass(Garage.class)
    @Bean
    public PartConfigurationNotDone partConfigurationNotDone() {
        ConsolerizerComposer.outSpace().red("If this happens we exit. This is not supposed to occur")
                .reset();
        System.exit(1);
        return PartConfigurationNotDone.builder().build();
    }
}
