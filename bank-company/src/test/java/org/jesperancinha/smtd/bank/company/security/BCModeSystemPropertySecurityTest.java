package org.jesperancinha.smtd.bank.company.security;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.smtd.bank.company.security.BCModeTestUtils.initializationCount;
import static org.springframework.security.core.context.SecurityContextHolder.MODE_GLOBAL;
import static org.springframework.security.core.context.SecurityContextHolder.SYSTEM_PROPERTY;

@SpringBootTest
class BCModeSystemPropertySecurityTest {

    static {
        System.setProperty(SYSTEM_PROPERTY, MODE_GLOBAL);
    }

    @BeforeAll
    public static void setup() {
        System.setProperty(SYSTEM_PROPERTY, MODE_GLOBAL);
        SecurityContextHolder.setStrategyName(MODE_GLOBAL);
    }

    @Test
    public void testContext() {
        SecurityContextHolder.clearContext();
        ConsolerizerComposer.outSpace()
                .magenta(System.getProperty(SYSTEM_PROPERTY));
        final var securityContext = SecurityContextHolder.getContext();
        assertThat(securityContext).isNotNull();
        assertThat(SecurityContextHolder.getContextHolderStrategy().toString())
                .startsWith("org.springframework.security.core.context.GlobalSecurityContextHolderStrategy");
        final var authentication = securityContext.getAuthentication();
        assertThat(authentication).isNull();
    }


    @AfterEach
    public void tearDown() {
        initializationCount();
    }
}