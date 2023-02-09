package org.jesperancinha.smtd

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class GMLauncher

fun main(args: Array<String>) {
    SpringApplication.run(GMLauncher::class.java, *args)
}