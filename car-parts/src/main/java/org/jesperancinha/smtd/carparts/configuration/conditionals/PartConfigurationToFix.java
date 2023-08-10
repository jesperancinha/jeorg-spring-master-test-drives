package org.jesperancinha.smtd.carparts.configuration.conditionals;

import lombok.Builder;
import lombok.Data;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * A class called MarsBase needs to be on the classpath in order for {@link PartConfigurationToFix} to be initialized
 * <p>
 * This just demonstrates that it never happens
 */
@Builder
@Data
@Configuration
@ConditionalOnBean(name = "partConfigurationDone2")
public class PartConfigurationToFix {

    @Bean
    @ConditionalOnBean(PartConfigurationDone.class)
    public PartConfigurationToFix partConfigurationToFix2() {
        ConsolerizerComposer.outSpace().green("We are able to create PartConfigurationToFix, because one PartConfigurationDone exists")
                .green("We can use the bean name in this case.")
                .reset();
        return PartConfigurationToFix.builder().build();
    }
}
