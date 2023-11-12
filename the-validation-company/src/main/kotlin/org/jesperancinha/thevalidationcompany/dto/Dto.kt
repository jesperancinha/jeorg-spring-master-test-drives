package org.jesperancinha.thevalidationcompany.dto

import com.fasterxml.jackson.annotation.JsonSetter
import jakarta.validation.constraints.NotNull
import org.springframework.lang.NonNull

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
    val accountNumberOdd: Int
)