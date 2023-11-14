package org.jesperancinha.thevalidationcompany.rest.fiveminutes

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.jesperancinha.thevalidationcompany.fiveminutes.lists.AccountListAssertsDto
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
class FiveMinutesControllerListAssertsTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val objectMapper by lazy { ObjectMapper() }

    @Test
    fun `should post lists request and fail when neither street or postAddress are filled in`() {
        mockMvc.perform(
            post(
                "/5minutes/lists",

                ).content(
                objectMapper.writeValueAsString(
                    AccountListAssertsDto(
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
    fun `should post lists request and success with street and houseNumber`() {
        mockMvc.perform(
            post(
                "/5minutes/lists",

                ).content(
                objectMapper.writeValueAsString(
                    AccountListAssertsDto(
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
    fun `should post lists request and success with street only and no house number`() {
        mockMvc.perform(
            post(
                "/5minutes/lists/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountListAssertsDto(
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
    fun `should post lists request and fail with a longer postcode than with 6 characters programmatically`() {
        mockMvc.perform(
            post(
                "/5minutes/lists/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountListAssertsDto(
                        postAddress = null,
                        houseNumber = 1,
                        street = "Up the street",
                        postCode = "1234AAA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )

            .andExpect(status().isBadRequest)
            .andReturn()
            .run { response }
            .run {
                contentAsString.shouldNotBeNull()
                errorMessage.shouldBeNull()
            }

    }

    @Test
    fun `should post lists request and fail with a longer postcode than with 6 characters`() {
        mockMvc.perform(
            post(
                "/5minutes/lists",

                ).content(
                objectMapper.writeValueAsString(
                    AccountListAssertsDto(
                        postAddress = null,
                        houseNumber = 1,
                        street = "Up the street",
                        postCode = "1234AAA"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )

            .andExpect(status().isBadRequest)
            .andReturn()
            .run { response }
            .run {
                contentAsString.shouldNotBeNull()
                errorMessage shouldBe "Invalid request content."
            }

    }

    @Test
    fun `should post lists request and fail with street null and house number`() {
        mockMvc.perform(
            post(
                "/5minutes/lists/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountListAssertsDto(
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

    @Test
    fun `should post lists request and success with street only and no house number with postcode on group1`() {
        mockMvc.perform(
            post(
                "/5minutes/lists/programmatic/group1",

                ).content(
                objectMapper.writeValueAsString(
                    AccountListAssertsDto(
                        postAddress = null,
                        houseNumber = 1,
                        street = "Up the street",
                        postCode = "123"
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
    fun `should post lists request and success with street only and no house number with postcode on group2`() {
        mockMvc.perform(
            post(
                "/5minutes/lists/programmatic/group2",

                ).content(
                objectMapper.writeValueAsString(
                    AccountListAssertsDto(
                        postAddress = null,
                        houseNumber = 1,
                        street = "Up the street",
                        postCode = "1234"
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )

            .andExpect(status().isOk)
            .andReturn()
            .run { response.contentAsString }
            .run { shouldNotBeNull() }

    }
}