package org.jesperancinha.smtd.bank.company.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;

/**
 * Using TestConfiguration we get properties from both production and test
 * It does not get automatically scanned
 */
@Data
@TestConfiguration
@AllArgsConstructor
@NoArgsConstructor
public class BankCompanyTestOnlyConfiguration {

    @Value("${jeorg.bank.testing:fail}")
    public String value;

    @Value("${info.app.name:fail}")
    public String appName;

}
