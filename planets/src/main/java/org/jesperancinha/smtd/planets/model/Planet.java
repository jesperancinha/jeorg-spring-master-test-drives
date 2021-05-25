package org.jesperancinha.smtd.planets.model;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Planet {
    String name;

    String scientificName;

    Long area;
}
