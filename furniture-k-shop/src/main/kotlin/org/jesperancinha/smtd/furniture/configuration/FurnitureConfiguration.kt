package org.jesperancinha.smtd.furniture.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class FurnitureConfiguration {

    @Bean
    open fun restTemplate(): RestTemplate = RestTemplate()
}