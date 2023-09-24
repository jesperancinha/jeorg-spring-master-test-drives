package org.jesperancinha.smtd.furniture.service

import org.assertj.core.api.Assertions.assertThat
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.furniture.model.Case
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("aspectj")
@SpringBootTest(webEnvironment = RANDOM_PORT)
open class CaseServiceAspectJTest(
    @Autowired
    val caseService: CaseService
) {

    @Test
    fun insertCaseStartNonTransactional() {
        try {
            caseService.insertCaseStartOneTransactional(
                Case(
                    id = 100L,
                    designation = "Book case",
                    weight = 230
                )
            )
        } catch (exception: Exception) {
            ConsolerizerComposer.outSpace()
                .yellow(exception)
                .reset()
        }

        assertThat(caseService.getAll()).hasSize(1);
    }
}