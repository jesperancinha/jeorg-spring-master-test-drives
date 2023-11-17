package org.jesperancinha.thevalidationcompany.rest.fiveminutes

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.string.shouldContain
import org.jesperancinha.thevalidationcompany.fiveminutes.payload.AccountPayloadDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class FiveMinutesControllerPayloadTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val objectMapper by lazy { ObjectMapper() }

    @Test
    fun `should post payload request and fail when postAddress is longer than 20 and shorter than 25 for payload endpoint`() {
        mockMvc.perform(
            post("/5minutes/payload").content(
                objectMapper.writeValueAsString(
                    AccountPayloadDto(
                        postAddress = "P.O.BOX WHATEVER HUGZZ",
                        houseNumber = null,
                        street = null,
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().is4xxClientError)
            .andReturn()
            .response
            .errorMessage shouldContain "Invalid request content"

    }

    @Test
    fun `should post payload request and success with warning with length higher then 20 but less then 25 for the programmatic endpoint`() {
        mockMvc.perform(
            post(
                "/5minutes/payload/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountPayloadDto(
                        postAddress = "P.O.BOX WHATEVER HUGZZ",
                        houseNumber = 10,
                        street = "Up the street",
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )

            .andExpect(status().`is`(199))
            .andReturn()
            .response
            .shouldNotBeNull()
            .contentAsString
            .shouldNotBeNull()

    }

    @Test
    fun `should post payload with fail when length is above the forbidden limit of 25 for the payload endpoint`() {
        mockMvc.perform(
            post(
                "/5minutes/payload",

                ).content(
                objectMapper.writeValueAsString(
                    AccountPayloadDto(
                        postAddress = "P.O.BOX WHATEVER HUGZZZZZZZZZZZ",
                        houseNumber = null,
                        street = "Up the street",
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().is4xxClientError)
            .andReturn()
            .response
            .shouldNotBeNull()
            .errorMessage
            .shouldNotBeNull() shouldContain "Invalid request content"
    }

    @Test
    fun `should post payload with fail when length is above the forbidden limit of 25 for the programmatic endpoint`() {
        mockMvc.perform(
            post(
                "/5minutes/payload/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountPayloadDto(
                        postAddress = "P.O.BOX WHATEVER HUGZZZZZZZZZZZ",
                        houseNumber = null,
                        street = "Up the street",
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().is4xxClientError)
            .andReturn()
            .response
            .shouldNotBeNull()
            .errorMessage
            .shouldBeNull()

    }
}