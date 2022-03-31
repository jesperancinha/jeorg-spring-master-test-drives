package org.jesperancinha.smtd.docker.boxing.old

import org.jesperancinha.smtd.docker.boxing.old.BoxingOldRunnerTest.BoxerInitializer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import java.io.File

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
                .withOptions("--compatibility")
                .withExposedService("adopt_1", 8080, Wait.defaultWaitStrategy())
                .withLocalCompose(true)
                .also { it.start() }
        }

        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            dockerCompose.getServiceHost("adopt_1", 8080)

        }
    }
}