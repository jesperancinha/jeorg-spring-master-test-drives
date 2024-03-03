package org.jesperancinha.smtd.furniture.service

import io.kotest.assertions.any
import io.kotest.matchers.collections.shouldContainAnyOf
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldHave
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
        val case = Case(
            id = -1L,
            designation = "Book case",
            weight = 230
        )
        try {
            caseService.insertCaseStartOneTransactional(
                case
            )
        } catch (exception: Exception) {
            ConsolerizerComposer.outSpace()
                .yellow(exception)
                .reset()
        }

        val all = caseService.getAll()
        all.shouldContainAnyOf(case)
        all.filter { it.designation == "Book case" }.shouldHaveSize(1)
    }
}