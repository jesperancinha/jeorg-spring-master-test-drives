package org.jesperancinha.smtd.the.vault.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vault")
class TheVaultController {

    @GetMapping("/silver/box/1")
    fun getSilverBox1(): String {
        return "Silver Box 1"
    }

    @GetMapping("/silver/box/2")
    fun getSilverBox2(): String {
        return "Silver Box 2"
    }

    @GetMapping("/silver/box/3")
    fun getSilverBox3(): String {
        return "Silver Box 3"
    }

    @GetMapping("/silver/test")
    fun getSilverTest(): String {
        return "Silver Test"
    }
}