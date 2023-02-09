package org.jesperancinha.smtd.rest

import org.jesperancinha.smtd.service.GMService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
internal class GMController(val gmService: GMService) {
    @GetMapping("/user/{userId}")
    fun userName(@PathVariable("userId") userId: String?): String {
        log.info("Got a request")
        return gmService.userName(userId)
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(GMController::class.java)
    }
}