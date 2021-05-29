package org.jesperancinha.smtd.furniture

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
open class FurnitureKShopRunner(
    @Value("\${management.endpoints.web.exposure.include}")
    val healthOrder: String
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
       ConsolerizerComposer.outSpace()
           .black()
           .bgCyan(healthOrder)
           .reset()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(FurnitureKShopRunner::class.java, *args)
}