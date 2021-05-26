package org.jesperancinha.smtd.bank.company.security;

import org.jesperancinha.smtd.bank.company.model.BankCompanyUser;
import org.jesperancinha.smtd.bank.company.repository.BankCompanyUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BankCompanyUserDetailsService implements UserDetailsService {

    private final BankCompanyUserRepository bankCompanyUserRepository;

    public BankCompanyUserDetailsService(BankCompanyUserRepository bankCompanyUserRepository) {
        this.bankCompanyUserRepository = bankCompanyUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String bankCompanyUserName) throws UsernameNotFoundException {
        final BankCompanyUser byName = bankCompanyUserRepository.findByName(bankCompanyUserName);
        return new BankCompanyUserDetails(byName);
    }
}
