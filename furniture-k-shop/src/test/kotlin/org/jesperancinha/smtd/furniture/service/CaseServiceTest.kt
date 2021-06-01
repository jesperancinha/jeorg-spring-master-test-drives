package org.jesperancinha.smtd.furniture.service

import org.assertj.core.api.Assertions.assertThat
import org.jesperancinha.smtd.furniture.model.Case
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("aspectj")
@SpringBootTest(webEnvironment = RANDOM_PORT)
open class CaseServiceTest(
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

        }

        assertThat(caseService.getAll()).hasSize(2);
    }
}