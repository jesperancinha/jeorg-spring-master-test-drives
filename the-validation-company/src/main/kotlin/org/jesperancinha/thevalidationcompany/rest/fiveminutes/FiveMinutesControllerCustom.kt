package org.jesperancinha.thevalidationcompany.rest.fiveminutes;

import jakarta.validation.ConstraintViolation
import jakarta.validation.Payload
import jakarta.validation.Valid
import jakarta.validation.Validator
import org.jesperancinha.thevalidationcompany.fiveminutes.custom.AccountCustomDto
import org.jesperancinha.thevalidationcompany.fiveminutes.custom.MandatoryPostAddressPayload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("5minutes")
class FiveMinutesControllerCustom {

    @Autowired
    lateinit var validator: Validator

    @PostMapping("custom")
    fun postRequestCustom(@RequestBody @Valid accountCustomDto: AccountCustomDto) = ResponseEntity.ok(accountCustomDto)

    @PostMapping("custom/programmatic")
    fun postRequestProgrammaticCustom(@RequestBody accountCustomDto: AccountCustomDto) =
        run {
            val violations = validator.validate(accountCustomDto)
            fun handleViolation(violation: ConstraintViolation<AccountCustomDto>): ResponseEntity<List<String>>? {
                val descriptor = violation.constraintDescriptor
                val payload: MutableSet<Class<out Payload>> = descriptor.payload
                if (payload.contains(MandatoryPostAddressPayload::class.java)) {
                    return ResponseEntity.badRequest().body(violations.map { it.message })
                }
                return null
            }
            violations
                .mapNotNull(::handleViolation)
                .sortedByDescending { it.statusCode.value() }
                .let {
                    it.takeIf { it.isNotEmpty() }?.first()
                        ?: run {
                            ResponseEntity
                                .ok(accountCustomDto)
                        }
                }
        }
}
