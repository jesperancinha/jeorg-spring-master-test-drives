package org.jesperancinha.thevalidationcompany.rest.fiveminutes

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.string.shouldContain
import org.jesperancinha.thevalidationcompany.fiveminutes.asserts.AccountAssertsDto
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
class FiveMinutesControllerAssertsTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val objectMapper by lazy { ObjectMapper() }

    @Test
    fun `should post asserts request and fail when neither street or postAddress are filled in`() {
        mockMvc.perform(
            post(
                "/5minutes/asserts",

                ).content(
                objectMapper.writeValueAsString(
                    AccountAssertsDto(
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
            .run { response.errorMessage }
            .run { this shouldContain "Invalid request content" }

    }

    @Test
    fun `should post asserts request and success with street and houseNumber`() {
        mockMvc.perform(
            post(
                "/5minutes/asserts",

                ).content(
                objectMapper.writeValueAsString(
                    AccountAssertsDto(
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
            .run { response.contentAsString }
            .run { shouldNotBeNull() }

    }

    @Test
    fun `should post asserts request and success with street only and no house number`() {
        mockMvc.perform(
            post(
                "/5minutes/asserts/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountAssertsDto(
                        postAddress = null,
                        houseNumber = 1,
                        street = "Up the street",
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )

            .andExpect(status().isOk)
            .andReturn()
            .run { response.contentAsString }
            .run { shouldNotBeNull() }

    }

    @Test
    fun `should post asserts request and fail with street null and house number`() {
        mockMvc.perform(
            post(
                "/5minutes/asserts/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountAssertsDto(
                        postAddress = null,
                        houseNumber = 1,
                        street = null,
                        postCode = "1234AA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().is4xxClientError)
            .andReturn()
            .run { response }
            .run {
                contentAsString.shouldNotBeNull()
                    .run { println(this) }
                errorMessage.shouldBeNull()
            }

    }
}