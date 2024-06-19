package org.jesperancinha.smtd.furniture.configuration

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.transaction.annotation.EnableTransactionManagement


/**
 * Furniture aspect t x configuration
 * Needs review
 * TODO: Momentarily disabled due to error. A new review needs to be made of Aspect J
 * @constructor Create empty Furniture aspect t x configuration
 */
@Profile("aspectj")
@Configuration
//@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
open class FurnitureAspectTXConfiguration {
    init {
        ConsolerizerComposer.outSpace()
            .yellow("Created ASPECTJ Configuration")
            .reset()
    }
}
