package org.jesperancinha.smtd.furniture.configuration

import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.model.Chair
import org.jesperancinha.smtd.furniture.repository.ChairRepository
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration

@TestConfiguration
@ContextConfiguration(classes = [ChairRepository::class])
open class ChairConfigurationTest {
    @Bean
    open fun chairList(): List<Chair> = mutableListOf()
}
