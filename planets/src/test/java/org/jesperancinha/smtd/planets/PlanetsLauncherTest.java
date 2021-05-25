package org.jesperancinha.smtd.planets;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlanetsLauncherTest {

    /**
     * We start the context and we never forget that the Spring Boot Starter Test module, provides:
     * JUnit
     * JUnit JUpiter
     * Hamcrest
     * AssertJ
     * Mockito
     * JSONAssert
     * JsonPath
     * Spring Boot Test
     * Spring Test
     */
    @Test
    void testContext() {
        PlanetsLauncher.main(new String[0]);
    }
}