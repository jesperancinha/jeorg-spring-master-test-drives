package org.jesperancinha.smtd.bank.company.services;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.bank.company.repository.BankCompanyBankRepository;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private final BankCompanyBankRepository bankCompanyBankRepository;

    public BankService(BankCompanyBankRepository bankCompanyBankRepository) {
        this.bankCompanyBankRepository = bankCompanyBankRepository;
        ConsolerizerComposer.outSpace()
                .yellow("BankService constructor completed!")
                .reset();
    }

    public Long countLocations(){
       return this.bankCompanyBankRepository.countAllByIdAfter(0L);
    }

}
