package org.jesperancinha.smtd.planets.repository;

import org.jesperancinha.smtd.planets.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
