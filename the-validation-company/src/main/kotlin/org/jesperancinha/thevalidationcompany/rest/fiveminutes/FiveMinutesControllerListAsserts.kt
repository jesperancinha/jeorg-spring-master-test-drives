package org.jesperancinha.thevalidationcompany.rest.fiveminutes;

import jakarta.validation.Valid
import jakarta.validation.Validator
import org.jesperancinha.thevalidationcompany.fiveminutes.lists.AccountListAssertsDto
import org.jesperancinha.thevalidationcompany.fiveminutes.lists.Group1
import org.jesperancinha.thevalidationcompany.fiveminutes.lists.Group2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("5minutes")
class FiveMinutesControllerListAsserts {

    @Autowired
    lateinit var validator: Validator

    @PostMapping("lists")
    fun postRequestListAsserts(@RequestBody @Valid accountListAssertsDto: AccountListAssertsDto) =
        ResponseEntity.ok(accountListAssertsDto)

    @PostMapping("lists/programmatic")
    fun postRequestProgrammaticListAsserts(@RequestBody accountListAssertsDto: AccountListAssertsDto) =
        run {
            validator.validate(accountListAssertsDto)
                .takeIf { it.isNotEmpty() }?.let {
                    ResponseEntity
                        .badRequest()
                        .body(it.map { it.message })
                }
                ?: run {
                    ResponseEntity
                        .ok(accountListAssertsDto)
                }
        }


    @PostMapping("lists/programmatic/group1")
    fun postRequestProgrammaticListAssertsGroup1(@RequestBody accountListAssertsDto: AccountListAssertsDto) =
        run {
            validator.validate(accountListAssertsDto, Group1::class.java)
                .takeIf { it.isNotEmpty() }?.let {
                    ResponseEntity
                        .badRequest()
                        .body(it.map { it.message })
                }
                ?: run {
                    ResponseEntity
                        .ok(accountListAssertsDto)
                }
        }

    @PostMapping("lists/programmatic/group2")
    fun postRequestProgrammaticListAssertsGroup2(@RequestBody accountListAssertsDto: AccountListAssertsDto) =
        run {
            validator.validate(accountListAssertsDto, Group2::class.java)
                .takeIf { it.isNotEmpty() }?.let {
                    ResponseEntity
                        .badRequest()
                        .body(it.map { it.message })
                }
                ?: run {
                    ResponseEntity
                        .ok(accountListAssertsDto)
                }
        }

}
