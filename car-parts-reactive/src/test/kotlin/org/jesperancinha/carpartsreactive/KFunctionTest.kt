package org.jesperancinha.carpartsreactive

import org.junit.jupiter.api.Test
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.jvm.isAccessible


@Configuration
class AppConfig {
    @Bean
    fun name(): String = "World"

    @Bean
    fun myService(name: String = "World"): MyService {
        return MyService(name)
    }
}

class MyService(val name: String) {
    fun greet(): String = "Hello, $name!"
}

class KFunctionTest {
    @Test
    fun `should explore the KFunction`() {
        val config = AppConfig()
        val kFunction: KFunction<*> = AppConfig::class.declaredFunctions.first { it.name == "myService" }
        kFunction.isAccessible = true
        println("Function name: ${kFunction.name}")
        println("Parameters: ${kFunction.parameters.map { it.name to it.type }}")
        val instanceParam = kFunction.instanceParameter!!
        val parameters = mapOf(instanceParam to config)
        val service = kFunction.callBy(parameters) as MyService
        println(service.greet())
    }
}
