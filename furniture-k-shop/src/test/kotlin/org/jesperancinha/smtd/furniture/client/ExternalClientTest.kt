package org.jesperancinha.smtd.furniture.client

import org.assertj.core.api.Assertions.assertThat
import org.jesperancinha.smtd.furniture.configuration.FurnitureConfiguration
import org.jesperancinha.smtd.furniture.model.Chair
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.client.ExpectedCount.once
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.support.RestGatewaySupport


@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [FurnitureConfiguration::class, ExternalClient::class])
open class ExternalClientTest(
) {

    private lateinit var mockServer: MockRestServiceServer

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Autowired
    private lateinit var externalClient: ExternalClient

    @BeforeEach
    fun setup() {
        val gateway = RestGatewaySupport()
        gateway.restTemplate = restTemplate
        mockServer = MockRestServiceServer.createServer(gateway)
    }

    @Test
    fun externalChairs() {
        mockServer.expect(once(), requestTo("http://localhost:9001"))
            .andRespond(withSuccess("[]", MediaType.APPLICATION_JSON))

        val result: List<Chair> = externalClient.externalChairs()
        println("externalChairs: $result")

        mockServer.verify()
        assertThat(result).hasSize(0)
    }
}