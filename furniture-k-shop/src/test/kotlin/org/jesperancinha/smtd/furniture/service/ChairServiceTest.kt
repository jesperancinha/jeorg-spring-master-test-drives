package org.jesperancinha.smtd.furniture.service

import org.assertj.core.api.Assertions.assertThat
import org.jesperancinha.smtd.furniture.exceptions.ChairException
import org.jesperancinha.smtd.furniture.model.Chair
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
internal open class ChairServiceTest {

    @Autowired
    lateinit var chairService: ChairService

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    @Transactional
    open fun insertChair() {
        val chair = Chair(
            id = 0L,
            designation = "armchair",
            weight = 100L
        )

        val (id, designation, weight) = chairService.insertChair(chair)

        assertThat(id).isGreaterThan(0L)
        assertThat(designation).isEqualTo("armchair")
        assertThat(weight).isEqualTo(100L)
    }

    @Test
    @Transactional
    open fun insertChairFail() {
        val chair = Chair(
            id = 0L,
            designation = "armchair",
            weight = 100L
        )

        assertThrows<ChairException> { chairService.insertChairFail(chair) }
        val all = chairService.getAll()
        assertThat(all).hasSize(0)
    }
}