package org.jesperancinha.thevalidationcompany.rest.fiveminutes;

import jakarta.validation.ConstraintViolation
import jakarta.validation.Payload
import jakarta.validation.Valid
import jakarta.validation.Validator
import org.jesperancinha.thevalidationcompany.fiveminutes.payload.AccountPayloadDto
import org.jesperancinha.thevalidationcompany.fiveminutes.payload.ErrorLength
import org.jesperancinha.thevalidationcompany.fiveminutes.payload.WarningLength
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("5minutes")
class FiveMinutesControllerPayload {

    @Autowired
    lateinit var validator: Validator

    @PostMapping("payload")
    fun postRequestPayload(@RequestBody @Valid accountPayloadDto: AccountPayloadDto) =
        ResponseEntity.ok(accountPayloadDto)

    @PostMapping("payload/programmatic")
    fun postRequestProgrammaticPayload(@RequestBody accountPayloadDto: AccountPayloadDto) =
        run {
            val violations = validator.validate(accountPayloadDto)
            fun handleViolation(violation: ConstraintViolation<AccountPayloadDto>): ResponseEntity<Any>? {
                val descriptor = violation.constraintDescriptor
                val payload: MutableSet<Class<out Payload>> = descriptor.payload
                if (payload.contains(ErrorLength::class.java)) {
                    return ResponseEntity.badRequest().body(accountPayloadDto)
                }
                if (payload.contains(WarningLength::class.java)) {
                    return ResponseEntity.status(199).body(accountPayloadDto)
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
                                .ok(accountPayloadDto)
                        }
                }
        }
}
