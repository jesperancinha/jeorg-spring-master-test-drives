package org.jesperancinha.smtd.planets

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
internal class PlanetsLauncherKotlinTest {
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
    fun `should load context`() {
    }
}