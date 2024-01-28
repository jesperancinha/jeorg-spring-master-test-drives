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


    /**
     * The use of suspend is wrong in this case
     * The reason it is being used here is for educational purposes only
     * The Flow interface already uses suspend functions in its collector
     */
    @GetMapping(
        "/parts/suspend",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    suspend fun getPartsUsingFlow(): Flow<String> {
        println(coroutineContext)
        return flow {
            emit("breaks")
            emit("keys")
            emit("lights")
        }
    }


    /**
     * The Flow interface already uses suspend functions for its collector
     * This way, a call to this method is non-blocking with or without the usage of the suspend keyword
     * The suspend keyword would only be necessary if we perform other operations between the entry point and the flow return value
     */
    @GetMapping(
        "/parts/correct",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getPartsUsingFlowWithoutSuspend(): Flow<String> {
        // This wold never work because the call isn't suspending
        // This will not trigger Spring to use a coroutine here
        // println(coroutineContext)
        return flow {
            println(this::class::members.get())
            println(coroutineContext)
            emit("breaks")
            emit("keys")
            emit("lights")
        }
    }

    @GetMapping("/break")
    suspend fun getBreak(): String {
        println("Current Coroutine Context -> $coroutineContext")
        println("Current Coroutine Job -> ${coroutineContext.job}")
        println("Main Coroutine Context -> ${currentCoroutineContext()}")
        println("Main Coroutine Job -> ${currentCoroutineContext().job}")
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