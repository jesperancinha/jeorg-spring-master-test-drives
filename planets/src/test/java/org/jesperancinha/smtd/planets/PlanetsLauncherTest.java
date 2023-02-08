package org.jesperancinha.smtd.planets;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PlanetsLauncherTest {

    /**
     * We start the context and we never forget that the Spring Boot Starter Test module, provides:
     * JUnit
     * JUnit Jupiter
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
    }
}