package org.jesperancinha.smtd.carparts.controller

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import org.jesperancinha.smtd.carparts.model.jpa.Part
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PartControllerKotlinIT(
    @Autowired
    private val testRestTemplate: TestRestTemplate
) {
    @Test
    fun testPostNewPartWhenSendingNoTimeoutReturnGoodOk() {
        val engine = Part.builder().name("Engine").build()
        val partResponseEntity = testRestTemplate.postForEntity("/parts", engine, Part::class.java)
        partResponseEntity.shouldNotBeNull()
        partResponseEntity.body.shouldBeNull()
    }
}