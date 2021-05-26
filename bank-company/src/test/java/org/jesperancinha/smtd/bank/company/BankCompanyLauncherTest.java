package org.jesperancinha.smtd.bank.company;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BankCompanyLauncherTest {

    @Test
    public void contextLoads() {
        BankCompanyLauncher.main(new String[0]);
    }
}