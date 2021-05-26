package org.jesperancinha.smtd.planets.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Data
@Table
@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
}
