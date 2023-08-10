package org.jesperancinha.smtd.bank.company.security

import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.jesperancinha.smtd.bank.company.model.BankCompanyUser
import org.jesperancinha.smtd.bank.company.repository.BankCompanyUserRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class BankCompanyUserDetailsServiceKotlinTest {
    @Test
    fun loadUserByUsername(
        @MockK bankCompanyUserRepository: BankCompanyUserRepository
    ) {
        val bankCompanyUserDetailsService = BankCompanyUserDetailsService(bankCompanyUserRepository)
        val companyTest = "Company Test"
        val password = "12345"
        val roles = "roles"
        val bankCompanyUser = BankCompanyUser
            .builder()
            .name(companyTest)
            .password(password)
            .roles(roles)
            .build()
        every { bankCompanyUserRepository.findByName(companyTest) } returns bankCompanyUser
        val userDetails = bankCompanyUserDetailsService.loadUserByUsername(companyTest)
        userDetails.username shouldBe companyTest
        userDetails.password shouldBe password
        val optionalGrantedAuthority = userDetails.authorities.stream().findFirst()
        optionalGrantedAuthority.isPresent.shouldBeTrue()
        optionalGrantedAuthority.get().toString() shouldBe "ROLE_roles"
        verify { bankCompanyUserRepository.findByName(companyTest) }
    }
}