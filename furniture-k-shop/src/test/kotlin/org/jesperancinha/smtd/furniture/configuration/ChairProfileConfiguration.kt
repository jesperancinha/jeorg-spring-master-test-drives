package org.jesperancinha.smtd.furniture.configuration

import org.jesperancinha.smtd.furniture.model.Chair
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile

@Profile("big", "!small")
@TestConfiguration
open class ChairProfileConfiguration {

    @Bean
    open fun chairBigSmall(): Chair {
        return Chair(
            id= 124,
            designation = "arm chair",
            weight = 100L
        )
    }
}

