package org.jesperancinha.thevalidationcompany.rest;

import jakarta.validation.Valid;
import org.jesperancinha.thevalidationcompany.fiveminutes.custom.AccountCustomDto;
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("5minutes")
class FiveMinutesController {

    @PostMapping("custom")
    fun postRequestCustom(@RequestBody @Valid accountCustomDto:AccountCustomDto) = ResponseEntity.ok(accountCustomDto)
}
