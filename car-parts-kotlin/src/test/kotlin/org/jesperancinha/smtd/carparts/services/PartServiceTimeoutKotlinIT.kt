package org.jesperancinha.smtd.carparts.services

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.jesperancinha.smtd.carparts.model.jpa.Part
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.orm.jpa.JpaSystemException

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PartServiceTimeoutKotlinIT @Autowired constructor(
    private val partServiceTimeout: PartServiceTimeout
) {
    @Test
    fun testCreatePartWhenCreatePartThenSaveCorrectly() {
        val engine = Part(name ="Engine")
        val part = partServiceTimeout.createPart(engine)
        part.shouldNotBeNull().name shouldBe "Engine"
    }
}