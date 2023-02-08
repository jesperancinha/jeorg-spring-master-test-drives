package org.jesperancinha.smtd.bank.company

import io.kotest.matchers.shouldBe
import jakarta.inject.Named
import org.assertj.core.api.Assertions
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.bank.company.configuration.BankCompanyTestOnlyConfiguration
import org.jesperancinha.smtd.bank.company.model.Bank
import org.jesperancinha.smtd.bank.company.repository.BankCompanyUserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.beans.factory.support.GenericBeanDefinition
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

/**
 * Since
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = ["environment=Great👍"])
@ActiveProfiles("test")
@ContextConfiguration(classes = [BankCompanyTestOnlyConfiguration::class])
class BankCompanyLauncherKotlinTest @Autowired constructor(
    /**
     * Properties and environment variables
     */
    @Value("\${environment}")
    private val environment: String,
    private val beanFactory: BeanFactory,
    private val defaultListableBeanFactory: DefaultListableBeanFactory,
    private val bankCompanyTestOnlyConfiguration: BankCompanyTestOnlyConfiguration,
    @Named("bank1")
    private val bank: Bank
) {
    @Test
    fun contextLoads() {
        val bankCompanyUserRepository = beanFactory.getBean("bankCompanyUserRepository") as BankCompanyUserRepository
        ConsolerizerComposer.outSpace()
            .green("bankCompanyUserRepository")
            .black()
            .bgGreen(bankCompanyUserRepository)
            .reset()
        defaultListableBeanFactory.registerBeanDefinition("myBean", GenericBeanDefinition())
        ConsolerizerComposer.outSpace()
            .green("bankCompanyUserRepository")
            .black()
            .bgGreen(bankCompanyUserRepository)
            .reset()
        BankCompanyLauncher.main(arrayOfNulls(0))
        ConsolerizerComposer.outSpace()
            .cyan(environment)
            .newLine()
            .reset()
        ConsolerizerComposer.outSpace()
            .cyan("We do get the test variable value")
            .blue(bankCompanyTestOnlyConfiguration.value)
            .cyan("And we can also get variable names in production")
            .blue(bankCompanyTestOnlyConfiguration.appName)
            .magenta("@TestConfiguration Does not get auto-scanned")
            .reset()
        ConsolerizerComposer.outSpace()
            .red(bank)
            .reset()
        bank.name shouldBe "Bank 1"
    }
}