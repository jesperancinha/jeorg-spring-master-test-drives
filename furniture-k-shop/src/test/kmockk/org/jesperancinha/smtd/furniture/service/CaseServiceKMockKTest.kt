package org.jesperancinha.smtd.furniture.service

import io.mockk.MockKAnnotations
import org.jesperancinha.smtd.furniture.exceptions.CaseException
import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.repository.CaseRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CaseServiceKMockKTest {

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    var caseRepository: CaseRepository = mock(CaseRepository::class.java)

    @Test
    fun insertCaseStartOneTransactional() {
        val caseService = CaseService(caseRepository)
        val case = Case(
            id = 1L,
            designation = "Weaved Chair",
            weight = 4000L
        )

        assertThrows<CaseException> {
            caseService.insertCaseStartOneTransactional(case)
        }

        verify(caseRepository, times(2)).save(case)
    }
}