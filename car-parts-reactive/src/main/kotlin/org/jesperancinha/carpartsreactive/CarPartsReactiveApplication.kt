package org.jesperancinha.carpartsreactive

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.job
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.web.bind.annotation.*
import kotlin.coroutines.coroutineContext

@SpringBootApplication
@EnableR2dbcRepositories
class CarPartsReactiveApplication

fun main(args: Array<String>) {
    runApplication<CarPartsReactiveApplication>(*args)
}

@RestController
@RequestMapping
class CarController(
    val carPartRepository: CarPartRepository
) {

    @GetMapping("/parts")
    suspend fun getParts(): List<String> {
        println(coroutineContext)
        return listOf("breaks", "keys", "lights")
    }

    @GetMapping("/break")
    suspend fun getBreak(): String {
        println("Current Coroutine Context -> $coroutineContext")
        println("Current Coroutine Context -> ${coroutineContext.job}")
        println("Main Coroutine Context -> ${currentCoroutineContext()}")
        println("Main Coroutine Context -> ${currentCoroutineContext().job}")
        println("Current Thread -> ${Thread.currentThread()}")
        return "break"
    }

    @GetMapping("/keys")
    fun getKeys(): String {
        return "keys"
    }

    @GetMapping("/parts/correct")
    fun getPartsCorrect(): Flow<String> {
        return listOf("breaks", "keys", "lights").asFlow()
    }

    @GetMapping("/parts/{id}")
    suspend fun getPartsCorrect(
        @PathVariable("id") id:String
    ): CarPart? = carPartRepository.findById(id)

    @PostMapping("/parts")
    suspend fun createPart(@RequestBody carPart: CarPart) {
        println(coroutineContext)
        println(carPartRepository)
    }
}

data class CarPart(
    val id: String,
    val name: String
)

interface CarPartRepository : CoroutineCrudRepository<CarPart, String>