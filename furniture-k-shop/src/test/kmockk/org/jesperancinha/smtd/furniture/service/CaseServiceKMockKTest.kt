package org.jesperancinha.smtd.furniture.service

import io.kotest.assertions.throwables.shouldThrow
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.jesperancinha.smtd.furniture.exceptions.CaseException
import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.repository.CaseRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class CaseServiceKMockKTest {

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    private var caseRepository: CaseRepository = mockk(relaxed = true)

    @Test
    fun insertCaseStartOneTransactional() {
        val caseService = CaseService(caseRepository)
        val case = Case(
            id = 1L,
            designation = "Weaved Chair",
            weight = 4000L
        )

        every { caseRepository.save(any()) } returns case
        shouldThrow<CaseException> {
            caseService.insertCaseStartOneTransactional(case)
        }

        verify(exactly = 2) { caseRepository.save(case) }
    }
}