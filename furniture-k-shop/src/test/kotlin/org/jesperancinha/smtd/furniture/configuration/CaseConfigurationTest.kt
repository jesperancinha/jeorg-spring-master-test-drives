package org.jesperancinha.smtd.furniture.configuration

import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.repository.CaseRepository
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration

@TestConfiguration
@ContextConfiguration(classes = [CaseRepository::class])
open class CaseConfigurationTest {
    @Bean
    open fun caseList(): List<Case> = mutableListOf()
}
