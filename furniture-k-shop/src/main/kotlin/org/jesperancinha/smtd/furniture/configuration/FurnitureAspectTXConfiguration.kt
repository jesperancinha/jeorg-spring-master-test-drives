package org.jesperancinha.smtd.furniture.configuration

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.transaction.annotation.EnableTransactionManagement


@Profile("aspectj")
@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
open class FurnitureAspectTXConfiguration {
    init {
        ConsolerizerComposer.outSpace()
            .yellow("Created ASPECTJ Configuration")
            .reset()
    }
}
