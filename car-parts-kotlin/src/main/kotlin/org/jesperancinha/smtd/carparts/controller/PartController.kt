package org.jesperancinha.smtd.carparts.controller

import org.jesperancinha.smtd.carparts.model.jpa.Part
import org.jesperancinha.smtd.carparts.services.PartServiceTimeout
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class PartController(private val partServiceTimeout: PartServiceTimeout) {
    @RequestMapping("/parts")
    fun postNewPart(
        @RequestBody part: Part?
    ) {
        partServiceTimeout.createPart(part!!)
    }
}
