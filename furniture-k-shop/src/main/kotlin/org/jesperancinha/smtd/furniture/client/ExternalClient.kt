package org.jesperancinha.smtd.furniture.client

import org.jesperancinha.smtd.furniture.model.Chair
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class ExternalClient(
    private val restTemplate: RestTemplate
) {

    fun externalChairs(): List<Chair> =
        restTemplate.getForObject("http://localhost:9001", Array<Chair>::class.java)
            ?.toList() ?: emptyList()
}