package org.jesperancinha.carpartsreactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.coroutines.coroutineContext

@SpringBootApplication
class CarPartsReactiveApplication

fun main(args: Array<String>) {
	runApplication<CarPartsReactiveApplication>(*args)
}

@RestController
@RequestMapping
class CarController(){

	@GetMapping("/parts")
	suspend fun getParts(): List<String> {
		println(coroutineContext)
		return listOf("breaks", "keys", "lights")
	}
}