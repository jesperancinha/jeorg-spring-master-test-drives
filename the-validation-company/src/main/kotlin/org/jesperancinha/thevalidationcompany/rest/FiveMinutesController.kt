package org.jesperancinha.thevalidationcompany.rest;

import jakarta.validation.*
import org.jesperancinha.thevalidationcompany.fiveminutes.custom.AccountCustomDto
import org.jesperancinha.thevalidationcompany.fiveminutes.custom.MandatoryPostAddressPayload
import org.jesperancinha.thevalidationcompany.fiveminutes.payload.AccountPayloadDto
import org.jesperancinha.thevalidationcompany.fiveminutes.payload.ErrorLength
import org.jesperancinha.thevalidationcompany.fiveminutes.payload.WarningLength
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("5minutes")
class FiveMinutesController {

    @Autowired
    lateinit var validator: Validator

    @PostMapping("custom")
    fun postRequestCustom(@RequestBody @Valid accountCustomDto: AccountCustomDto) = ResponseEntity.ok(accountCustomDto)

    @PostMapping("custom/programmatic")
    fun postRequestProgrammaticCustom(@RequestBody accountCustomDto: AccountCustomDto) =
        run {
            val violations = validator.validate(accountCustomDto)
            fun handleViolation(violation: ConstraintViolation<AccountCustomDto>): ResponseEntity<AccountCustomDto>? {
                val descriptor = violation.constraintDescriptor
                val payload: MutableSet<Class<out Payload>> = descriptor.payload
                if (payload.contains(MandatoryPostAddressPayload::class.java)) {
                    return ResponseEntity.badRequest().body(accountCustomDto)
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


    @PostMapping("payload")
    fun postRequestPayload(@RequestBody @Valid accountPayloadDto: AccountPayloadDto) =
        ResponseEntity.ok(accountPayloadDto)

    @PostMapping("payload/programmatic")
    fun postRequestProgrammaticCustom(@RequestBody accountPayloadDto: AccountPayloadDto) =
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
