package org.jesperancinha.smtd.bank.company.security;

import org.jesperancinha.smtd.bank.company.model.BankCompanyUser;
import org.jesperancinha.smtd.bank.company.repository.BankCompanyUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankCompanyUserDetailsServiceTest {

    @Test
    public void loadUserByUsername(
            @Mock
            final BankCompanyUserRepository bankCompanyUserRepository) {
        final var bankCompanyUserDetailsService = new BankCompanyUserDetailsService(bankCompanyUserRepository);
        final var companyTest = "Company Test";
        final var password = "12345";
        final var roles = "roles";
        final var bankCompanyUser = BankCompanyUser
                .builder()
                .name(companyTest)
                .password(password)
                .roles(roles)
                .build();
        when(bankCompanyUserRepository.findByName(companyTest)).thenReturn(bankCompanyUser);
        final var userDetails = bankCompanyUserDetailsService.loadUserByUsername(companyTest);

        assertThat(userDetails.getUsername()).isEqualTo(companyTest);
        assertThat(userDetails.getPassword()).isEqualTo(password);
        final var optionalGrantedAuthority = userDetails.getAuthorities().stream().findFirst();
        assertThat(optionalGrantedAuthority.isPresent()).isTrue();
        assertThat(optionalGrantedAuthority.get().toString()).isEqualTo("ROLE_roles");
        verify(bankCompanyUserRepository, only()).findByName(companyTest);
    }
}