package org.jesperancinha.smtd.bank.company.repository;

import org.jesperancinha.smtd.bank.company.model.BankCompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCompanyUserRepository extends JpaRepository<BankCompanyUser, Long> {
    BankCompanyUser findByName(String name);
}
