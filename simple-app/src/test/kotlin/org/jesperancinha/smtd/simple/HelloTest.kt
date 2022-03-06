package org.jesperancinha.smtd.simple

import io.kotest.core.spec.style.WordSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldNotBe
import org.jesperancinha.smtd.simple.service.Service
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@AutoConfigureWebTestClient
@ContextConfiguration(classes = [(Service::class)])
class HelloTest(service: Service) : WordSpec() {

    override fun extensions() = listOf(SpringExtension)

    init {
        "SpringExtension" should {
            "have autowired the service" {
                service shouldNotBe null
            }
        }
    }
}
