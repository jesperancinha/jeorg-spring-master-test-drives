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
import org.mockito.*

@ExtendWith(MockKExtension::class)
class PartServiceTimeoutKotlinTest {
    @InjectMockKs
    lateinit var partServiceTimeout: PartServiceTimeout

    @MockK(relaxed = true)
    lateinit var partRepository: PartRepository

    @Test
    fun testCreatePartWhenCreatePartThenSaveCorrectly() {
        val engine = Part.builder().name("Engine").build()
        every { partRepository.save(engine) } returns engine
        val part = partServiceTimeout.createPart(engine)
        part.shouldNotBeNull()
            .name shouldBe "Engine"
        verify { partRepository.save(engine) }
    }

    /**
     * Since this is just a unit test, no timeout will be generated
     * The annotation [org.springframework.transaction.annotation.Transactional], has no effect in this case.
     */
    @Test
    fun testCreatePartTimeoutWhenCreatePartTimoutThenOK() {
        val engine = Part.builder().name("Engine").build()
        every { partRepository.save(engine) } returns engine
        val part = partServiceTimeout.createPartTimeout(engine)
        part.shouldNotBeNull()
            .name shouldBe "Engine"
        verify { partRepository.save(engine) }
    }

    @Test
    fun testCreatePartMixWhenCreatePartMixThenSave2TimesCorrectly() {
        val engine = Part.builder().name("Engine").build()
        every { partRepository.save(engine) } returns engine
        val partMix = partServiceTimeout.createPartMix(engine)
        partMix.shouldNotBeNull()
            .name shouldBe "Engine"
        val slotParts = mutableListOf<Part>()
        verify { partRepository.save(capture(slotParts)) }
        slotParts.shouldNotBeNull()
            .shouldHaveSize(2)
            .toList()
            .should { allValues ->
                allValues[0] shouldBe engine
                allValues[1] shouldBe engine
            }
    }

    /**
     * Since this is just a unit test, no timeout will be generated
     * The annotation [org.springframework.transaction.annotation.Transactional], has no effect in this case.
     */
    @Test
    fun testCreatePartExtraWhenCreatePartThenOk() {
        val engine = Part.builder().name("Engine").build()
        every { partRepository.save(engine) } returns engine
        val part = partServiceTimeout.createPartExtra(engine)
        part.shouldNotBeNull()
            .name shouldBe "Engine"
        verify { partRepository.save(engine) }
    }
}