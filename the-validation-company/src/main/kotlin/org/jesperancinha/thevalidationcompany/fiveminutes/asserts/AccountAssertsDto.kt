package org.jesperancinha.thevalidationcompany.fiveminutes.asserts

import jakarta.validation.constraints.AssertTrue

data class AccountAssertsDto(
    val postAddress: String?,
    val street: String?,
    val houseNumber: Long?,
    val postCode: String
) {
    @AssertTrue(message = "Or a street or a post address")
    fun isStreetOrPostAddress() = street != null || postAddress != null

    @AssertTrue(message = "Or street and house number or both null")
    fun isStreetAndHouseNumberOrNull() = street != null && houseNumber != null || street == null && houseNumber == null
}
