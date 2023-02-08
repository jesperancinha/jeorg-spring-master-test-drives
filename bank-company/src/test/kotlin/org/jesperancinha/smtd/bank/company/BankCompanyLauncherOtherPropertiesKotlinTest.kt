package org.jesperancinha.smtd.bank.company

import io.kotest.matchers.nulls.shouldNotBeNull
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment

@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = ["environment=Great👍", "spring.config.location=classpath:/bank.properties"]
)
class BankCompanyLauncherOtherPropertiesKotlinTest {
    /**
     * Properties and environment variables
     */
    @Value("\${environment}")
    private lateinit var environment: String

    @Value("\${jeorg.bank.banking}")
    private lateinit var banking: String

    @Value("\${jeorg.bank.customer}")
    private lateinit var customer: String

    @Value("\${jeorg.bank.sa.name}")
    private lateinit var name: String

    @Value("\${jeorg.bank.sa.surname}")
    private lateinit var surname: String
    @Test
    fun contextLoads() {
        banking.shouldNotBeNull()
        customer.shouldNotBeNull()
        name.shouldNotBeNull()
        surname.shouldNotBeNull()
        ConsolerizerComposer.outSpace()
            .none()
            .cyan(environment)
            .newLine()
            .magenta("Banking is:")
            .red(banking)
            .magenta("!")
            .newLine()
            .magenta("Customer is:")
            .red(customer)
            .magenta("!")
            .newLine()
            .magenta("I am ")
            .red(name)
            .orange(surname)
            .green(". \"What more can I say ?\"")
            .magenta("!")
            .reset()
    }
}