package org.jesperancinha.thevalidationcompany.fiveminutes.lists

import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Size

data class AccountListAssertsDto(
    val postAddress: String?,
    val street: String?,
    val houseNumber: Long?,
    @field:Size(min = 6, max = 6)
    @field:Size(min = 3, max = 3, groups = [Group1::class])
    @field:Size(min = 4, max = 4, groups = [Group2::class])
    val postCode: String
) {
    @AssertTrue(message = "Or a street or a post address")
    fun isStreetOrPostAddress() = street != null
            || postAddress != null

    @AssertTrue(message = "Or street and house number or both null")
    fun isStreetAndHouseNumberOrNull() = street != null && houseNumber != null
            || street == null && houseNumber == null
}

interface Group2

interface Group1
