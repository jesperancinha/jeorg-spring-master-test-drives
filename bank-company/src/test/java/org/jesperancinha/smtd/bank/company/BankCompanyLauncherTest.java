package org.jesperancinha.smtd.bank.company;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, properties = "environment=Great👍")
public class BankCompanyLauncherTest {

    /**
     * Properties and environment variables
     */
    @Value("${environment}")
    private String environment;

    @Test
    public void contextLoads() {
        BankCompanyLauncher.main(new String[0]);
        ConsolerizerComposer.outSpace()
                .cyan(environment)
                .newLine()
                .reset();
    }
}