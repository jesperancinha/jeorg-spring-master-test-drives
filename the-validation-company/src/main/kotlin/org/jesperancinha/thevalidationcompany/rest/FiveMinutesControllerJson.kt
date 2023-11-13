package org.jesperancinha.thevalidationcompany.rest;

import jakarta.validation.Valid
import jakarta.validation.Validator
import org.jesperancinha.thevalidationcompany.fiveminutes.json.AccountAssertsJsonDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("5minutes")
class FiveMinutesControllerJson {

    @Autowired
    lateinit var validator: Validator

    @PostMapping("asserts/json")
    fun postRequestCustom(@RequestBody @Valid accountAssertsJsonDto: AccountAssertsJsonDto) =
        ResponseEntity.ok(accountAssertsJsonDto)

    @PostMapping("asserts/json/programmatic")
    fun postRequestProgrammaticCustom(@RequestBody accountAssertsJsonDto: AccountAssertsJsonDto) =
        run {
            val violations = validator.validate(accountAssertsJsonDto)
            violations
                .takeIf { it.isNotEmpty() }?.let { ResponseEntity
                    .badRequest()
                    .body(it.map { it.message }) }
                ?: run {
                    ResponseEntity
                        .ok(accountAssertsJsonDto)
                }
        }

}
