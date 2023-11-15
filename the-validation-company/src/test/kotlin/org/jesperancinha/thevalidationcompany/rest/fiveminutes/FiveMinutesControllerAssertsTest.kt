package org.jesperancinha.thevalidationcompany.rest.fiveminutes

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.equality.shouldBeEqualUsingFields
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.string.shouldContain
import org.jesperancinha.thevalidationcompany.fiveminutes.asserts.AccountAssertsDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class FiveMinutesControllerAssertsTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val objectMapper by lazy { ObjectMapper() }
    var typeRef: TypeReference<HashMap<String, Any>> = object : TypeReference<HashMap<String, Any>>() {}

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
            ).contentType(APPLICATION_JSON)
        )
            .andExpect(status().is4xxClientError)
            .andReturn()
            .response.errorMessage
            .shouldNotBeNull() shouldContain "Invalid request content"

    }

    @Test
    fun `should post asserts request and success with street and houseNumber`() {
        val objectString = objectMapper.writeValueAsString(
            AccountAssertsDto(
                postAddress = null,
                houseNumber = 10,
                street = "Up the street",
                postCode = "1234AA"
            )
        )
        mockMvc.perform(
            post(
                "/5minutes/asserts",

                ).content(
                objectString
            ).contentType(APPLICATION_JSON)
        )

            .andExpect(status().isOk)
            .andReturn()
            .response.contentAsString
            .shouldNotBeNull()
            .let {
                val expected = objectMapper
                    .readValue(objectString, typeRef)
                    .apply {
                        remove("streetAndHouseNumberOrNull")
                        remove("streetOrPostAddress")
                    }
                objectMapper.readValue(it, typeRef)
                    .shouldBeEqual(expected)}

    }

    @Test
    fun `should post asserts request and success with street only and no house number`() {
        val accountAssertsDto = AccountAssertsDto(
            postAddress = null,
            houseNumber = 1,
            street = "Up the street",
            postCode = "1234AA"
        )
        val objectString = objectMapper
            .writeValueAsString(accountAssertsDto)
        mockMvc.perform(
            post(
                "/5minutes/asserts/programmatic",

                )
                .content(
                    objectString
                ).contentType(APPLICATION_JSON)
        )

            .andExpect(status().isOk)
            .andReturn()
            .response.contentAsString
            .shouldNotBeNull()
            .let {
                val expected = objectMapper
                    .readValue(objectString, typeRef)
                    .apply {
                        remove("streetAndHouseNumberOrNull")
                        remove("streetOrPostAddress")
                    }
                objectMapper.readValue(it, typeRef)
                .shouldBeEqual(expected)}


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
            ).contentType(APPLICATION_JSON)
        )
            .andExpect(status().is4xxClientError)
            .andReturn()
            .response.shouldNotBeNull()
            .run {
                contentAsString.shouldNotBeNull()
                    .run { println(this) }
                errorMessage.shouldBeNull()
            }

    }
}