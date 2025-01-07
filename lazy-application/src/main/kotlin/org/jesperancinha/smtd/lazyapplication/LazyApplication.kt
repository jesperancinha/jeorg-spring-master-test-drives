package org.jesperancinha.smtd.lazyapplication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class ThisIsLoaded(val value: String) {
    fun performAction() {
        println("Performing $value")
    }
}


@Configuration
class AppConfiguration {
    @Bean
    fun eagerBean() = ThisIsLoaded("Eager bean").also { println(it) }

    @Bean
    @Lazy
    fun lazyBean() = ThisIsLoaded("Lazy bean").also { println(it) }
}

@SpringBootApplication
class LazyApplication


@RestController
class TestController(@Autowired val lazyBean: ThisIsLoaded) {
    @GetMapping("/trigger")
    fun triggerLazyBean(): ThisIsLoaded = lazyBean
}


@RestController
class TestControllerEager {
    @Autowired
    private val eagerBean: ThisIsLoaded? = null

    @GetMapping("/triggereager")
    fun triggerLazyBean(): ThisIsLoaded? {
        return eagerBean
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(LazyApplication::class.java, *args)
}