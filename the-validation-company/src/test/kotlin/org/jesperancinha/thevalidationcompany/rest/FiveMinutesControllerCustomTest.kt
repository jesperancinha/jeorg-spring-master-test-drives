package org.jesperancinha.thevalidationcompany.rest

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.string.shouldContain
import org.jesperancinha.thevalidationcompany.fiveminutes.custom.AccountCustomDto
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
class FiveMinutesControllerCustomTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val objectMapper by lazy { ObjectMapper() }

    @Test
    fun `should post custom request and fail when neither street or postAdress are filled in`() {
        mockMvc.perform(
            post(
                "/5minutes/custom",

                ).content(
                objectMapper.writeValueAsString(
                    AccountCustomDto(
                        postAddress = null,
                        houseNumber = null,
                        street = null,
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )

            .andExpect(status().is4xxClientError)
            .andReturn()
            .run {this.response.errorMessage }
            .run { this shouldContain "Invalid request content" }

    }
    @Test
    fun `should post custom request and success with street and houseNumber`() {
        mockMvc.perform(
            post(
                "/5minutes/custom",

                ).content(
                objectMapper.writeValueAsString(
                    AccountCustomDto(
                        postAddress = null,
                        houseNumber = 10,
                        street = "Up the street",
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )

            .andExpect(status().isOk)
            .andReturn()
            .run {this.response.contentAsString }
            .run { this.shouldNotBeNull() }

    }
    @Test
    fun `should post custom request and success with street only and no house number`() {
        mockMvc.perform(
            post(
                "/5minutes/custom/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountCustomDto(
                        postAddress = "P.O.BOX WHATEVER HUGS",
                        houseNumber = null,
                        street = "Up the street",
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )

            .andExpect(status().isOk)
            .andReturn()
            .run {this.response.contentAsString }
            .run { this.shouldNotBeNull() }

    }
}