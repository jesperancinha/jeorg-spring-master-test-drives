package org.jesperancinha.thevalidationcompany.rest;

import jakarta.validation.ConstraintViolation
import jakarta.validation.Payload
import jakarta.validation.Valid
import jakarta.validation.Validator
import org.jesperancinha.thevalidationcompany.fiveminutes.asserts.AccountAssertsDto
import org.jesperancinha.thevalidationcompany.fiveminutes.custom.MandatoryPostAddressPayload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("5minutes")
class FiveMinutesControllerAsserts {

    @Autowired
    lateinit var validator: Validator

    @PostMapping("asserts")
    fun postRequestAsserts(@RequestBody @Valid accountAssertsDto: AccountAssertsDto) =
        ResponseEntity.ok(accountAssertsDto)

    @PostMapping("asserts/programmatic")
    fun postRequestProgrammaticAsserts(@RequestBody accountAssertsDto: AccountAssertsDto) =
        run {
            val violations = validator.validate(accountAssertsDto)
            violations
                .takeIf { it.isNotEmpty() }?.let { ResponseEntity
                    .badRequest()
                    .body(it.map(ConstraintViolation<AccountAssertsDto>::getMessage)) }
                ?: run {
                    ResponseEntity
                        .ok(accountAssertsDto)
                }
        }

}
