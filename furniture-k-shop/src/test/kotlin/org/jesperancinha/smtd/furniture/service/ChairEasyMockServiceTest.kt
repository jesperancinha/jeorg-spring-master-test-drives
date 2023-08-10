package org.jesperancinha.smtd.furniture.service

import org.assertj.core.api.Assertions.assertThat
import org.easymock.EasyMock.*
import org.easymock.EasyMockExtension
import org.jesperancinha.smtd.furniture.model.Chair
import org.jesperancinha.smtd.furniture.repository.ChairRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

/**
 * This class is being used to test some basic EasyMock features
 * It is important to note that although Spring Test and Spring Boot Test, support EasyMock, none of them actually provide it as a dependency.
 */
@ExtendWith(EasyMockExtension::class)
internal open class ChairEasyMockServiceTest {

    private val chairRepository: ChairRepository = mock(ChairRepository::class.java)

    private var chairService: ChairService = ChairService(chairRepository)

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    open fun weightOfAllChairs() {
        val chair1 = Chair(
            id = 0L,
            designation = "armchair",
            weight = 22L
        )
        val chair2 = Chair(
            id = 0L,
            designation = "armchair",
            weight = 78L
        )

        val listOfChairs = listOf(chair1, chair2)
        expect(chairRepository.findAll()).andReturn(listOfChairs)
        replay(chairRepository)


        val weightOfAllChairs = chairService.weightOfAllChairs()

        assertThat(weightOfAllChairs).isEqualTo(100L)
    }
}