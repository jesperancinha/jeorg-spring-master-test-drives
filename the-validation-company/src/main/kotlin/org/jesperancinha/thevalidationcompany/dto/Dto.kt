package org.jesperancinha.thevalidationcompany.dto

data class AccountNumbersDto (
    val accountNumberLong:Long,
    val accountNumberNullable: Long?,
    val accountNumber: Int,
    val accountNumberEven: Int,
    val accountNumberOdd: Int
)