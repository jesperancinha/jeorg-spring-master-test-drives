package org.jesperancinha.smtd

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import java.util.*


@SpringBootApplication
class GMClient {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
        return builder.build()
    }
    @Bean
    fun myCommandLineRunner(registry: ObservationRegistry?, restTemplate: RestTemplate): CommandLineRunner {
        val highCardinalityValues = Random()
        val lowCardinalityValues: List<String> =
            listOf("userType1", "userType2", "userType3")
        return CommandLineRunner {
            val highCardinalityUserId: String = java.lang.String.valueOf(highCardinalityValues.nextLong(100000))
            Observation.createNotStarted(
                "my.observation",
                registry
            )
                .lowCardinalityKeyValue(
                    "userType",
                    randomUserTypePicker(lowCardinalityValues)
                )
                .highCardinalityKeyValue(
                    "userId",
                    highCardinalityUserId
                )
                .contextualName("command-line-runner")
                .observe {
                    log.info("Will send a request to the server")
                    val response = restTemplate.getForObject(
                        "http://localhost:7654/user/{userId}",
                        String::class.java, highCardinalityUserId
                    )
                    log.info("Got response [{}]", response)
                }
        }
    }

    var randomUserTypePicker: Random = Random()
    private fun randomUserTypePicker(lowNumberOfValues: List<String>): String {
        return lowNumberOfValues[randomUserTypePicker.nextInt(2)]
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(GMClient::class.java)
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(GMClient::class.java, *args)
        }
    }
}