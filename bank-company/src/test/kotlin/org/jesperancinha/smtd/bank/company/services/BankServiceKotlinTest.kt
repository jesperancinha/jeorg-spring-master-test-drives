package org.jesperancinha.smtd.bank.company.services

import com.ninjasquad.springmockk.MockkBean
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.bank.company.configuration.BankCompanyTestForLazyConfiguraton
import org.jesperancinha.smtd.bank.company.model.Bank
import org.jesperancinha.smtd.bank.company.repository.BankCompanyBankRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Lazy
import org.springframework.test.context.ContextConfiguration

@Lazy
@SpringBootTest
@ContextConfiguration(classes = [BankService::class, BankCompanyTestForLazyConfiguraton::class])
class BankServiceKotlinTest @Autowired constructor(
    private val bankService: BankService,
    @Lazy
    @Autowired
    private val bank: Bank

) {
    @MockkBean(relaxed = true)
    lateinit var bankCompanyBankRepository: BankCompanyBankRepository

    @BeforeEach
    fun setup() {
        ConsolerizerComposer.outSpace().magenta("We just started our unit test").reset()
    }

    @Test
    fun testCountBanksWhenCalleThenGetExpectedCount() {
        every { bankCompanyBankRepository.countAllByIdAfter(0L) } returns 5L
        val locationCount = bankService.countLocations()
        ConsolerizerComposer.outSpace().magenta("We are in the middle of our test").reset()
        locationCount shouldBe 5L
        bank.shouldNotBeNull()
    }

    @Test
    fun testCountBanksWhenCalleThenGetExpectedCountVersion2() {
        every { bankCompanyBankRepository.countAllByIdAfter(0L) } returns 5L
        val locationCount = bankService.countLocations()
        ConsolerizerComposer.outSpace().magenta("We are in the middle of our test").reset()
        locationCount shouldBe 5L
    }
}