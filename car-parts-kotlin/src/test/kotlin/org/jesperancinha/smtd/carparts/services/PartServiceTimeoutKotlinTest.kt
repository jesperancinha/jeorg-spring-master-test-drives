package org.jesperancinha.smtd.carparts.services

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.jesperancinha.smtd.carparts.model.jpa.Part
import org.jesperancinha.smtd.carparts.repos.PartRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class PartServiceTimeoutKotlinTest {
    @InjectMockKs
    lateinit var partServiceTimeout: PartServiceTimeout

    @MockK
    lateinit var partRepository: PartRepository

    @Test
    fun testCreatePartWhenCreatePartThenSaveCorrectly() {
        val engine = Part(name ="Engine")
        every { partRepository.save(engine) } returns engine
        val part = partServiceTimeout.createPart(engine)
        part.shouldNotBeNull()
            .name shouldBe "Engine"
        verify { partRepository.save(engine) }
    }
}