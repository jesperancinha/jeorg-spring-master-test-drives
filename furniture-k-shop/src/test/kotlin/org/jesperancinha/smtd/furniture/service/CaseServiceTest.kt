package org.jesperancinha.smtd.furniture.service

import org.jesperancinha.smtd.furniture.exceptions.CaseException
import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.repository.CaseRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CaseServiceTest {

    @Test
    fun insertCaseStartOneTransactional(@Mock caseRepository: CaseRepository) {
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