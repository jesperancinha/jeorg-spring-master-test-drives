package org.jesperancinha.thevalidationcompany.rest.fiveminutes;

import jakarta.validation.ConstraintViolation
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
    fun postRequestJson(@RequestBody @Valid accountAssertsJsonDto: AccountAssertsJsonDto) =
        ResponseEntity.ok(accountAssertsJsonDto)

    @PostMapping("asserts/json/programmatic")
    fun postRequestProgrammaticJson(@RequestBody accountAssertsJsonDto: AccountAssertsJsonDto) =
        run {
            val violations = validator.validate(accountAssertsJsonDto)
            violations
                .takeIf { it.isNotEmpty() }?.let { ResponseEntity
                    .badRequest()
                    .body(it.map(ConstraintViolation<AccountAssertsJsonDto>::getMessage)) }
                ?: run {
                    ResponseEntity
                        .ok(accountAssertsJsonDto)
                }
        }

}
