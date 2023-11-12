package org.jesperancinha.thevalidationcompany.dto

import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Negative
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class AccountNumbersDto(
    val accountNumberLong: Long,
    val accountNumberNullable: Long?,
    val accountNumber: Int,
    val accountNumberEven: Int,
    val accountNumberOdd: Int
)

data class AccountNumbersPassiveDto(
    @field:NotNull
    val accountNumberLong: Long?,
    val accountNumberNullable: Long?,
    val accountNumber: Int,
    val accountNumberEven: Int,
    val accountNumberOdd: Int,
    @field:Positive
    val accountNumberPositive: Int,
    @field:Negative
    val accountNumberNegative: Int
) {
    @AssertTrue(message = "accountNumberEven should be even")
    fun isEvenEven() = accountNumberEven % 2 == 0

    @AssertTrue(message = "accountNumberOdd should be odd")
    fun isOddOdd() = accountNumberOdd % 2 != 0
}