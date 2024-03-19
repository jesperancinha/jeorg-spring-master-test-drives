package org.jesperancinha.thevalidationcompany.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.BigIntegerNode
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.string.shouldContain
import org.jesperancinha.thevalidationcompany.dto.AccountNumbersPassiveDto
import org.jesperancinha.thevalidationcompany.fiveminutes.asserts.AccountAssertsDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.math.BigDecimal

@SpringBootTest
@AutoConfigureMockMvc
class NumberControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val objectMapper by lazy { ObjectMapper() }

    @Test
    fun `should post account numbers with success`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post(
                "/number/create/account/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountNumbersPassiveDto(
                        accountNumberLong = 123456789L,
                        accountNumber = BigDecimal.valueOf(5),
                        accountNumberEven = 2,
                        accountNumberOdd = 3,
                        accountNumberPositive = 5,
                        accountNumberNegative = -1,
                        accountNumberMaxList = 20,
                        accountNumberNullable = null
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun `should post too high account number and fail`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post(
                "/number/create/account/programmatic",

                ).content(
                objectMapper.writeValueAsString(
                    AccountNumbersPassiveDto(
                        accountNumberLong = 123456789L,
                        accountNumber = BigDecimal.valueOf(15),
                        accountNumberEven = 2,
                        accountNumberOdd = 3,
                        accountNumberPositive = 5,
                        accountNumberNegative = -1,
                        accountNumberMaxList = 20,
                        accountNumberNullable = null
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is4xxClientError)
    }
}