package org.jesperancinha.smtd.the.vault

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity
open class TheVaultRunner

fun main(args: Array<String>) {
    SpringApplication.run(TheVaultRunner::class.java, *args)
}