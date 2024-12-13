package org.jesperancinha.carpartsreactive

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.jesperancinha.carpartsreactive.rest.CarController
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.config.WebFluxConfigurer
import java.util.*

@SpringBootTest
class CarPartsReactiveApplicationTests {

    @Configuration
    class WebFluxConfig : WebFluxConfigurer {
        @Bean
        fun objectMapper(): ObjectMapper =
            ObjectMapper().registerModule(KotlinModule.Builder().build())

        @Bean
        fun jackson2JsonDecoder(objectMapper: ObjectMapper) =
            Jackson2JsonDecoder(objectMapper)

        @Bean
        fun jackson2JsonEncoder(objectMapper: ObjectMapper) =
            Jackson2JsonEncoder(objectMapper)
    }

    @Test
    fun contextLoads() {
    }

}

@SpringJUnitConfig(classes = [PostControllerTest.TestConfig::class])
class PostControllerTest {
    @Configuration(proxyBeanMethods = false)
    @ComponentScan(basePackageClasses = [CarController::class])
    internal class TestConfig {

        @Bean
        fun extensionBean(): String = "I'm an extension bean"

        @Bean
        @Primary
        fun String.postRepository(): CarPartRepository = println(this).run{ mockk<CarPartRepository>() }
    }

    @Autowired
    lateinit var carPartRepository: CarPartRepository

    private lateinit var client: WebTestClient

    @BeforeEach
    fun setup() {
        client = WebTestClient.bindToController(CarController(carPartRepository))
            .configureClient()
            .build()
    }

    @AfterEach
    fun teardown() {
        clearAllMocks()
    }

    @Test
    fun `get post by id`() = runTest {
        val id = UUID.randomUUID().toString()
        coEvery { carPartRepository.findById(any<String>()) } returns
                CarPart(
                    id = id,
                    name = "wow"
                )
        client.get().uri("/parts/first")
            .exchange()
            .expectStatus().isOk
            .expectBody().jsonPath("$.name").isEqualTo("wow")

        coVerify(exactly = 1) { carPartRepository.findById(any()) }
    }

}
