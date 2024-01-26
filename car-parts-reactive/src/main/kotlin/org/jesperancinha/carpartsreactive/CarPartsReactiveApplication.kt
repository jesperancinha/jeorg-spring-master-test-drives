package org.jesperancinha.carpartsreactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

@SpringBootApplication
@EnableR2dbcRepositories
class CarPartsReactiveApplication

fun main(args: Array<String>) {
    runApplication<CarPartsReactiveApplication>(*args)
}

data class CarPart(
    val id: String,
    val name: String
)

interface CarPartRepository : CoroutineCrudRepository<CarPart, String>