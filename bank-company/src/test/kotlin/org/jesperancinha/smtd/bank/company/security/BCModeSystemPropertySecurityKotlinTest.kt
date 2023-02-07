package org.jesperancinha.smtd.bank.company.security

import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import io.kotest.matchers.string.shouldStartWith
import org.assertj.core.api.Assertions
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.context.SecurityContextHolder

@SpringBootTest
internal class BCModeSystemPropertySecurityKotlinTest {
    @Test
    fun testContext() {
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
                ).shouldHaveSingleElement(true)
            }
        securityContext.authentication.shouldNotBeNull()
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