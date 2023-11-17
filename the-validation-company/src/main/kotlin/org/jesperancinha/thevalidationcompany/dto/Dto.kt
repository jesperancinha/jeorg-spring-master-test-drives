package org.jesperancinha.thevalidationcompany.dto

import jakarta.validation.constraints.*
import java.math.BigDecimal

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
    @field:DecimalMax(value = "10")
    @field:DecimalMin(value = "5")
    val accountNumber: BigDecimal,
    val accountNumberEven: Int,
    val accountNumberOdd: Int,
    @field:Positive
    val accountNumberPositive: Int,
    @field:Negative
    val accountNumberNegative: Int,
    @field:DecimalMax(value = "5", groups =  [LowProfile::class])
    @field:DecimalMax(value = "10", groups = [MiddleProfile::class])
    @field:DecimalMax(value = "15", groups = [HighProfile::class])
    @field:DecimalMax(value = "20")
    val accountNumberMaxList:Int
) {
    interface LowProfile
    interface MiddleProfile
    interface HighProfile

    @AssertTrue(message = "accountNumberEven should be even")
    fun isEvenEven() = accountNumberEven % 2 == 0

    @AssertTrue(message = "accountNumberOdd should be odd")
    fun isOddOdd() = accountNumberOdd % 2 != 0
}


