package org.jesperancinha.carpartsreactive.rest

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.job
import org.jesperancinha.carpartsreactive.CarPart
import org.jesperancinha.carpartsreactive.CarPartRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import kotlin.coroutines.coroutineContext

@RestController
@RequestMapping
class CarController(
    val carPartRepository: CarPartRepository
) {

    @GetMapping("/parts/list", "/parts")
    suspend fun getParts(): List<String> {
        println(coroutineContext)
        return listOf("breaks", "keys", "lights")
    }

    @GetMapping("/parts/suspend", produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun getPartsUsingFlow(): Flow<String> {
        println(coroutineContext)
        return flow {
            println(coroutineContext)
            emit("breaks")
            emit("keys")
            emit("lights")
        }
    }

    @GetMapping("/parts/correct", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPartsUsingFlowWithoutSuspend(): Flow<String> {
        return flow {
            println(coroutineContext)
            emit("breaks")
            emit("keys")
            emit("lights")
        }
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


    @GetMapping("/parts/{id}")
    suspend fun getPartsCorrect(
        @PathVariable("id") id: String
    ): CarPart? = carPartRepository.findById(id)

    @PostMapping("/parts")
    suspend fun createPart(@RequestBody carPart: CarPart) {
        println(coroutineContext)
        println(carPartRepository)
    }
}