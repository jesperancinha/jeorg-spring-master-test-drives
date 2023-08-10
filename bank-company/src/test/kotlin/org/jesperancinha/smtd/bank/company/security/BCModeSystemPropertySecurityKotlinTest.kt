package org.jesperancinha.smtd.bank.company.security

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.context.SecurityContextHolder

@SpringBootTest
internal class BCModeSystemPropertySecurityKotlinTest {
    @Test
    fun `should load context`() {
        SecurityContextHolder.clearContext()
        ConsolerizerComposer.outSpace()
            .magenta(System.getProperty(SecurityContextHolder.SYSTEM_PROPERTY))
        val securityContext = SecurityContextHolder.getContext()
        securityContext.shouldNotBeNull()
        SecurityContextHolder.getContextHolderStrategy()
            .toString().should {
                listOf(
                    it.startsWith("org.springframework.security.core.context.InheritableThreadLocalSecurityContextHolderStrategy"),
                    it.startsWith("org.springframework.security.core.context.GlobalSecurityContextHolderStrategy")
                ).shouldContainAll(true, false)
            }
        securityContext.authentication.shouldBeNull()
    }

    @AfterEach
    fun tearDown() {
        BCModeTestUtils.initializationCount()
    }

    companion object {
        init {
            System.setProperty(SecurityContextHolder.SYSTEM_PROPERTY, SecurityContextHolder.MODE_GLOBAL)
        }

        @JvmStatic
        @BeforeAll
        fun setup() {
            System.setProperty(SecurityContextHolder.SYSTEM_PROPERTY, SecurityContextHolder.MODE_GLOBAL)
            SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL)
        }
    }
}