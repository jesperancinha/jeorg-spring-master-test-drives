package org.jesperancinha.smtd.furniture

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JSR310Module
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.autoconfigure.health.HealthProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
open class FurnitureKShopRunner(
    @Value("\${management.endpoints.web.exposure.include}")
    val healthOrder: String,
    @Autowired
    val healthProperties: HealthProperties
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        ConsolerizerComposer.outSpace()
            .black()
            .bgCyan(healthOrder)
            .reset()
        ConsolerizerComposer.outSpace()
            .black()
            .bgCyan()
            .jsonPrettyPrint(
                ObjectMapper().findAndRegisterModules().writeValueAsString(healthProperties))
            .reset()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(FurnitureKShopRunner::class.java, *args)
}