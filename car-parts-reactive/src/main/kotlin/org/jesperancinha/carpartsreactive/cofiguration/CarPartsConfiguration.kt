package org.jesperancinha.carpartsreactive.cofiguration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.config.WebFluxConfigurer

/**
 * Car parts configuration
 *
 * This class illustrates what happens in the background, but it is normally not needed.
 * @constructor Create empty Car parts configuration
 */
@Configuration
class CarPartsConfiguration : WebFluxConfigurer {
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