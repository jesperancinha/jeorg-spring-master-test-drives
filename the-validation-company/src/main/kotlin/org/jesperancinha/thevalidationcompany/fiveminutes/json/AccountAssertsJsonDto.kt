package org.jesperancinha.thevalidationcompany.fiveminutes.json

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.validation.constraints.AssertTrue

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
data class AccountAssertsJsonDto(
    val postAddress: String?,
    val street: String?,
    val houseNumber: Long?,
    val postCode: String
) {
    @JsonIgnore
    @AssertTrue(message = "Or a street or a post address")
    fun isStreetOrPostAddress() = street != null || postAddress != null

    @JsonIgnore
    @AssertTrue(message = "Or street and house number or both null")
    fun isStreetAndHouseNumberOrNull() = street != null && houseNumber != null || street == null && houseNumber == null
}
