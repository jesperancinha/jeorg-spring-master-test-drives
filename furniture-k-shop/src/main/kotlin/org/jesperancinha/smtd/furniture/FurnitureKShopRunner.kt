package org.jesperancinha.smtd.furniture

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class FurnitureKShopRunner {
    fun main(args: Array<String>) {
        SpringApplication.run(FurnitureKShopRunner::class.java, *args)
    }
}