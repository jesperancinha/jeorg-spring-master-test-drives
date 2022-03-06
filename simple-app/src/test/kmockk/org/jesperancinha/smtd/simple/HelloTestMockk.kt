package org.jesperancinha.smtd.simple

import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldNotBe
import io.mockk.impl.annotations.MockK
import org.jesperancinha.smtd.simple.service.Service
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@AutoConfigureWebTestClient
@ContextConfiguration(classes = [(Service::class)])
class HelloTestMockk : StringSpec() {

    override fun extensions() = listOf(SpringExtension)

    @MockK(relaxed = true)
    lateinit var service: Service

    init {
        "should have autowired the service" {
            service shouldNotBe null
        }
    }
}

