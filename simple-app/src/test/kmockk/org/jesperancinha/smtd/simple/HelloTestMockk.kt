package org.jesperancinha.smtd.simple

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldNotBe
import org.jesperancinha.smtd.simple.service.Service
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@AutoConfigureWebTestClient
@ContextConfiguration(classes = [(Service::class)])
class HelloMockkTest : StringSpec() {

    override fun extensions() = listOf(SpringExtension)

    @MockkBean
    lateinit var service: Service

    init {
        "should have autowired the service" {
            service shouldNotBe null
        }
    }
}

