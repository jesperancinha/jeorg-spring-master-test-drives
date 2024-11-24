package org.jesperancinha.smtd.furniture.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.function.RequestPredicates.GET
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.RouterFunctions
import org.springframework.web.servlet.function.ServerResponse
import java.lang.invoke.VarHandle.AccessMode.GET

@Configuration
open class FurnitureConfiguration {

    @Bean
    open fun restTemplate(): RestTemplate = RestTemplate()


    @Bean
    open fun routes(): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(GET("/hello")) { ServerResponse.ok().body("Hello, World!") }
            }
}