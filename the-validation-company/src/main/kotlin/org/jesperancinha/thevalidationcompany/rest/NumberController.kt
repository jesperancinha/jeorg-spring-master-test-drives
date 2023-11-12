package org.jesperancinha.thevalidationcompany.rest

import org.jesperancinha.thevalidationcompany.dto.AccountNumbersDto
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("number")
class NumberController {

    @GetMapping("info")
    fun info() = "The endpoints on this path are resrved for number validations exclusively"

    @PostMapping(path =["create/account"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createNumberAccountPayload(@RequestBody accountNumbersDto: AccountNumbersDto) = ResponseEntity.ok("OK")
}