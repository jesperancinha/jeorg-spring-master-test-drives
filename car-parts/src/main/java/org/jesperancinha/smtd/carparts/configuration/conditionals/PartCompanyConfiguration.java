package org.jesperancinha.smtd.carparts.configuration.conditionals;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jesperancinha.smtd.carparts.beans.AutoFixCompany;
import org.jesperancinha.smtd.carparts.beans.Garage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnClass(name = {
        "org.jesperancinha.smtd.carparts.beans.AutoFixCompany",
        "org.jesperancinha.smtd.carparts.beans.Garage"
})
@ConditionalOnBean(type = {"AutoFixCompany", "Garage"})
@Configuration
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartCompanyConfiguration {

    private AutoFixCompany autoFixCompany;

    private Garage garage;


    @Bean
    public PartCompanyConfiguration partCompanyConfigurationMain(
            final AutoFixCompany autoFixCompany,
            final Garage garage
    ){
       return PartCompanyConfiguration
               .builder()
               .autoFixCompany(autoFixCompany)
               .garage(garage)
               .build();
    }
}
