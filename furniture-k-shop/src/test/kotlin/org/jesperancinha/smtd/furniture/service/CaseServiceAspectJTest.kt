package org.jesperancinha.smtd.furniture.service

import io.kotest.matchers.collections.shouldHaveSize
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.furniture.model.Case
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("aspectj")
@SpringBootTest(webEnvironment = RANDOM_PORT)
open class CaseServiceAspectJTest @Autowired constructor(
    private val caseService: CaseService
) {

    /**
     * All transactions fail because they all rollback due to exception.
     * The expected result is 0 Books with the designation inserted into the database.
     */
    @Test
    open fun insertCaseStartNonTransactional() {
        val case = Case(
            id = -1L,
            designation = "Book case 2",
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
        all.filter { it.designation == "Book case 2" }.shouldHaveSize(0)
    }
}