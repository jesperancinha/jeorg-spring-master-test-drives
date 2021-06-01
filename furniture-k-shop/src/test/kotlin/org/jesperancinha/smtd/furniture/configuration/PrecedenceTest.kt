package org.jesperancinha.smtd.furniture.configuration

import org.assertj.core.api.Assertions.assertThat
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.furniture.repository.CaseRepository
import org.jesperancinha.smtd.furniture.repository.ChairRepository
import org.jesperancinha.smtd.furniture.service.ChairService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration


@SpringBootTest
@ContextConfiguration(classes = [PrecedenceTest.InnerPrecedenceConfiguration::class])
@ComponentScan(basePackages = ["org.jesperancinha.smtd.furniture"])
open class PrecedenceTest(
    @Autowired(required = false)
    val chairService: ChairService?,
    @Autowired(required = false)
    val chairRepository: ChairRepository?,
    @Autowired(required = false)
    val caseRepository: CaseRepository?,
    @Autowired(required = false)
    val innerPrecedenceConfiguration: InnerPrecedenceConfiguration?

) {

    @Test
    fun testBeanExistsWhenProfileBigAndSmallThenNull() {
        assertThat(chairService).isNotNull
        assertThat(chairRepository).isNotNull
        assertThat(chairRepository).isSameAs(innerPrecedenceConfiguration?.chairRepository)
        assertThat(caseRepository).isSameAs(innerPrecedenceConfiguration?.caseRepository)
        ConsolerizerComposer.outSpace()
            .blue("In this test, we are proving that a configuration inner class has precedence for the main class in an integration test")
            .green("Meaning that we actually only scan for the service package. The rest must be mocked in order to be able to run")
            .reset()
    }

    @Configuration
    @ComponentScan(basePackages = ["org.jesperancinha.smtd.furniture.service"])
    open class InnerPrecedenceConfiguration {
        @MockBean
        lateinit var chairRepository : ChairRepository
        @MockBean
        lateinit var caseRepository: CaseRepository
    }
}