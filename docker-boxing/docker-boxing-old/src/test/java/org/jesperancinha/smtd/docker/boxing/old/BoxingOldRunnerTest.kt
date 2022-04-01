package org.jesperancinha.smtd.docker.boxing.old

import org.jesperancinha.smtd.docker.boxing.old.BoxingOldRunnerTest.BoxerInitializer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import java.io.File
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

/**
 * Check other example of using test containers here
 *
 * @see <a href="https://github.com/jesperancinha/vma-archiver/blob/master/vma-service-backend/src/test/kotlin/org/jesperancinha/vma/utils/AbstractVmaTest.kt">AbstractVmaTest.kt</a>
 */
@SpringBootTest
@ContextConfiguration(initializers = [BoxerInitializer::class])
internal class BoxingOldRunnerTest {

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun `should start test Containers`() {

    }

    private class DockerCompose(files: List<File>) : DockerComposeContainer<DockerCompose>(files)

    class BoxerInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        private val dockerCompose by lazy {
            DockerCompose(listOf(File("docker-compose.yml")))
                .withExposedService("adopt-old-1_1", 8080, Wait.defaultWaitStrategy())
                .withExposedService("adopt-old-2_1", 8080, Wait.defaultWaitStrategy())
                .withLocalCompose(true)
                .also { it.start() }
        }

        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            logger.info("Starting IT -> ${LocalDateTime.now()}")
            logger.info("Starting service 1 at ${dockerCompose.getServiceHost("adopt-old-1_1", 8080)}")
            logger.info("Starting service 2 at ${dockerCompose.getServiceHost("adopt-old-2_1", 8080)}")
            logger.info("End IT -> ${LocalDateTime.now()}")
            logger.info("Time Elapsed IT -> ${ChronoUnit.MILLIS.between(startup, LocalDateTime.now())} ms")

        }

        companion object {
            val logger: Logger = LoggerFactory.getLogger(BoxingOldRunnerTest::class.java)
            val startup = LocalDateTime.now()
        }
    }
}