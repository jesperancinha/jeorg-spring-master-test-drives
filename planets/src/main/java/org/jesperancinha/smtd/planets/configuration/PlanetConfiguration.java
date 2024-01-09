package org.jesperancinha.smtd.planets.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * This is a good example on why we cannot use final with a @Configuration file in Spring.
 * Since it does not implement an interface, it needs to use CGLIB proxies, which in turn do not allow final methods to get proxied.
 */

@Data
@ConfigurationProperties(prefix = "smtd.earth",
        ignoreUnknownFields = true,
        ignoreInvalidFields = true)
public class PlanetConfiguration {
    private String name;
    private String scientific;
    private Long area;
    private Long diameter;
    private Long volume;
}
