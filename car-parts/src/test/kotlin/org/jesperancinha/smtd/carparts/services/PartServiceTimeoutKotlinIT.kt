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
        val engine = Part.builder().name("Engine").build()
        val part = partServiceTimeout.createPart(engine)
        part.shouldNotBeNull()
            .name shouldBe "Engine"
    }

    @Test
    fun testCreatePartTimeoutWhenCreatePartTimoutThenFail() {
        val engine = Part.builder().name("Engine").build()
        org.junit.jupiter.api.Assertions.assertThrows(JpaSystemException::class.java) {
            partServiceTimeout.createPartTimeout(
                engine
            )
        }
    }

    @Test
    fun testCreatePartMixWhenCreatePartMixThenSave2TimesCorrectly() {
        val engine = Part.builder().name("Engine").build()
        val partMix = partServiceTimeout.createPartMix(engine)
        partMix.shouldNotBeNull()
            .name shouldBe "Engine"
    }

    @Test
    fun testCreatePartExtraWhenCreatePartThenFail() {
        val engine = Part.builder().name("Engine").build()
        shouldThrow<JpaSystemException> {
            partServiceTimeout.createPartExtra(
                engine
            )
        }
    }
}