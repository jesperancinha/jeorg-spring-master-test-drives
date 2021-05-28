package org.jesperancinha.smtd.furniture

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
open class FurnitureKShopRunner {
    fun main(args: Array<String>) {
        SpringApplication.run(FurnitureKShopRunner::class.java, *args)
    }
}