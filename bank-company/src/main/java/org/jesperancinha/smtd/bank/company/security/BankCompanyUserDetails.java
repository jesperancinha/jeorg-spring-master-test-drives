package org.jesperancinha.smtd.bank.company.security;

import org.jesperancinha.smtd.bank.company.model.BankCompanyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class BankCompanyUserDetails implements UserDetails {
    private BankCompanyUser bankCompanyUser;

    public BankCompanyUserDetails(BankCompanyUser bankCompanyUser) {
        this.bankCompanyUser = bankCompanyUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(bankCompanyUser.getRoles().split(","))
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return bankCompanyUser.getPassword();
    }

    @Override
    public String getUsername() {
        return bankCompanyUser.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
