package org.jesperancinha.smtd.bank.company

import org.assertj.core.api.Assertions
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
    private val environment: String? = null

    @Value("\${jeorg.bank.banking}")
    private val banking: String? = null

    @Value("\${jeorg.bank.customer}")
    private val customer: String? = null

    @Value("\${jeorg.bank.sa.name}")
    private val name: String? = null

    @Value("\${jeorg.bank.sa.surname}")
    private val surname: String? = null
    @Test
    fun contextLoads() {
        Assertions.assertThat(banking).isNotNull
        Assertions.assertThat(customer).isNotNull
        Assertions.assertThat(name).isNotNull
        Assertions.assertThat(surname).isNotNull
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