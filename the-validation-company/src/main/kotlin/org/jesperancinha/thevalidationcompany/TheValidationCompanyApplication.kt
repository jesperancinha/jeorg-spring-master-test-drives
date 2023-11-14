package org.jesperancinha.thevalidationcompany

import jakarta.validation.Validation
import jakarta.validation.Validator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import


@SpringBootApplication
@Import(TheValidationCompanyConfiguration::class)
class TheValidationCompanyApplication

fun main(args: Array<String>) {
	runApplication<TheValidationCompanyApplication>(*args)
}


@Configuration
class TheValidationCompanyConfiguration {
	@Bean
	fun validator() : Validator = Validation.buildDefaultValidatorFactory().validator
}