package org.jesperancinha.thevalidationcompany.fiveminutes.payload

import jakarta.validation.Payload
import jakarta.validation.constraints.Size


interface ErrorLength : Payload
interface WarningLength : Payload

data class AccountPayloadDto(
    @field:Size(min = 5, max = 25, payload = [ErrorLength::class])
    @field:Size(min = 10, max = 20, payload = [WarningLength::class])
    val postAddress: String?,
    val street: String?,
    val houseNumber: Long?,
    val postCode: String
)
