package org.jesperancinha.carpartsreactive.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange

@RestController
@RequestMapping("/client")
class CarClientController {
    val webClient = WebClient.create("https://jsonplaceholder.typicode.com")

    @GetMapping("/direct")
    suspend fun getDirectCars(): String = webClient
        .get()
        .uri("/todos/1")
        .retrieve()
        .awaitBody()

    @GetMapping("/exchange")
    suspend fun getExchangeCars(): String = webClient
        .get()
        .uri("/todos/1")
        .awaitExchange { clientResponse ->
            if (clientResponse.statusCode().is2xxSuccessful) {
                val body = clientResponse.awaitBody<String>()
                body
            } else {
                "Error: ${clientResponse.statusCode()}"
            }
        }

    @GetMapping("/empty")
    suspend fun empty(): String? = null
}