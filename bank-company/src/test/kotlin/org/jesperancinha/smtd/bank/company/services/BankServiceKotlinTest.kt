package org.jesperancinha.smtd.bank.company.services

import org.assertj.core.api.Assertions
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.bank.company.configuration.BankCompanyTestForLazyConfiguraton
import org.jesperancinha.smtd.bank.company.model.Bank
import org.jesperancinha.smtd.bank.company.repository.BankCompanyBankRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Lazy
import org.springframework.test.context.ContextConfiguration

@Lazy
@SpringBootTest
@ContextConfiguration(classes = [BankService::class, BankCompanyTestForLazyConfiguraton::class])
class BankServiceKotlinTest {
    @MockBean
    private val bankCompanyBankRepository: BankCompanyBankRepository? = null

    @Autowired
    private val bankService: BankService? = null

    @Lazy
    @Autowired(required = false)
    private val bank: Bank? = null
    @BeforeEach
    fun setup() {
        ConsolerizerComposer.outSpace().magenta("We just started our unit test").reset()
    }

    @Test
    fun testCountBanksWhenCalleThenGetExpectedCount() {
        Mockito.`when`(bankCompanyBankRepository!!.countAllByIdAfter(0L)).thenReturn(5L)
        val locationCount = bankService!!.countLocations()
        ConsolerizerComposer.outSpace().magenta("We are in the middle of our test").reset()
        Assertions.assertThat(locationCount).isEqualTo(5L)
        Assertions.assertThat(bank).isNotNull
    }

    @Test
    fun testCountBanksWhenCalleThenGetExpectedCountVersion2() {
        Mockito.`when`(bankCompanyBankRepository!!.countAllByIdAfter(0L)).thenReturn(5L)
        val locationCount = bankService!!.countLocations()
        ConsolerizerComposer.outSpace().magenta("We are in the middle of our test").reset()
        Assertions.assertThat(locationCount).isEqualTo(5L)
    }
}