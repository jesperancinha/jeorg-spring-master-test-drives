package org.jesperancinha.smtd.planets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Table
@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
}
