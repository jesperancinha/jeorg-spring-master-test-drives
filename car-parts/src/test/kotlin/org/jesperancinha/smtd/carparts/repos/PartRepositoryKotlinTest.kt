package org.jesperancinha.smtd.carparts.repos

import io.kotest.matchers.nulls.shouldNotBeNull
import org.jesperancinha.smtd.carparts.repos.PartRepository.InternalPartRepository
import org.junit.jupiter.api.Test

/**
 * Creating nested classes in java interfaces
 *
 * @author jofisaes
 */
class PartRepositoryKotlinTest {
    @Test
    fun testInnerNestedClassInInterface() {
        InternalPartRepository().shouldNotBeNull()
    }
}