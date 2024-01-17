package org.jesperancinha.smtd.carparts

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
class CarPartsKotlinLauncher
fun main(args: Array<String>) {
    SpringApplication.run(CarPartsKotlinLauncher::class.java, *args)
}