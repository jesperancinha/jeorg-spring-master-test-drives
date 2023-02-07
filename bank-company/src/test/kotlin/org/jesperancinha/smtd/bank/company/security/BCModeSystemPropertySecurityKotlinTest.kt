package org.jesperancinha.smtd.bank.company.security

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
        Assertions.assertThat(securityContext).isNotNull
        Assertions.assertThat(SecurityContextHolder.getContextHolderStrategy().toString())
            .startsWith("org.springframework.security.core.context.InheritableThreadLocalSecurityContextHolderStrategy")
        val authentication = securityContext.authentication
        Assertions.assertThat(authentication).isNull()
    }

    @AfterEach
    fun tearDown() {
        BCModeTestUtils.initializationCount()
    }

    companion object {
        init {
            System.setProperty(SecurityContextHolder.SYSTEM_PROPERTY, SecurityContextHolder.MODE_GLOBAL)
        }

        @BeforeAll
        fun setup() {
            System.setProperty(SecurityContextHolder.SYSTEM_PROPERTY, SecurityContextHolder.MODE_GLOBAL)
            SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL)
        }
    }
}