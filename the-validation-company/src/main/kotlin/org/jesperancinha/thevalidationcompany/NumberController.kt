package org.jesperancinha.thevalidationcompany

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("number")
class NumberController {

    @GetMapping("info")
    fun info() = "The endpoints on this path are resrved for number validations exclusively"
}