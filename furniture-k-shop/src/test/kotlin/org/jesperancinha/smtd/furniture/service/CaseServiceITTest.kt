package org.jesperancinha.smtd.furniture.service

import io.kotest.matchers.nulls.shouldNotBeNull
import org.jesperancinha.smtd.furniture.exceptions.CaseException
import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.model.Chair
import org.jesperancinha.smtd.furniture.repository.CaseRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal open class CaseServiceITTest {

    @Autowired
    lateinit var caseService: CaseService

    @Test
    open fun `should insert a case and read it back from the database`(){
        val case = Case(
            id = null,
            designation = "Weaved Chair",
            weight = 4000L
        )
        val insertedCase = caseService.insertCase(case)

        insertedCase.id.shouldNotBeNull()
    }
}