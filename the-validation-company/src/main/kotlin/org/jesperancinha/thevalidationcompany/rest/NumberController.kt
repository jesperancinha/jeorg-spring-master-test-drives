package org.jesperancinha.thevalidationcompany.rest

import jakarta.validation.ConstraintViolation
import jakarta.validation.Valid
import jakarta.validation.Validator
import org.jesperancinha.thevalidationcompany.dto.AccountNumbersDto
import org.jesperancinha.thevalidationcompany.dto.AccountNumbersPassiveDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("number")
class NumberController {

    @Autowired
    lateinit var validator: Validator

    @GetMapping("info")
    fun info() = "The endpoints on this path are reserved for number validations exclusively"

    @PostMapping(path = ["create/account"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createNumberAccountPayload(@RequestBody accountNumbersDto: AccountNumbersDto): ResponseEntity<AccountNumbersDto> =
        ResponseEntity.ok(accountNumbersDto)

    @PostMapping(path = ["create/account/programmatic"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createNumberAccountPayloadProgrammatically(@RequestBody accountNumbersDto: AccountNumbersPassiveDto) =
        run {
            val violations = validator.validate(accountNumbersDto)
            violations
                .takeIf { it.isNotEmpty() }?.let { ResponseEntity
                    .badRequest()
                    .body(it.map(ConstraintViolation<AccountNumbersPassiveDto>::getMessage)) }
                ?: run {
                    ResponseEntity
                        .ok(accountNumbersDto)
                }
        }


    @PostMapping(path = ["create/account/automatic"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createNumberAccountPayloadAutomatically(@RequestBody @Valid accountNumbersDto: AccountNumbersPassiveDto): ResponseEntity<AccountNumbersPassiveDto> =
        ResponseEntity.ok(accountNumbersDto)

}