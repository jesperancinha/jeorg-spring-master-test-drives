package org.jesperancinha.smtd.simple

import io.kotest.core.spec.style.WordSpec
import io.kotest.core.test.TestCase
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldNotBe
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.jesperancinha.smtd.simple.service.Service
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [(Service::class)])
class HelloTestMockk : WordSpec() {

    override fun extensions() = listOf(SpringExtension)

    @MockK
    lateinit var service: Service

    override fun beforeAny(testCase: TestCase) {
        MockKAnnotations.init(this, relaxUnitFun = true)
        super.beforeAny(testCase)
    }

    init {
        "SpringExtension" should {
            "have autowired the service" {
                service shouldNotBe null
            }
        }
    }
}


