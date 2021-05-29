package org.jesperancinha.smtd.bank.company.repository;

import org.jesperancinha.smtd.bank.company.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCompanyBankRepository extends JpaRepository<Bank, Long> {
    Long countAllByIdAfter(Long id);
}
