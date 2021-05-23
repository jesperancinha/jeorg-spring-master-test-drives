package org.jesperancinha.smtd.carparts.repos;

import org.jesperancinha.smtd.carparts.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartRepository extends JpaRepository<Part, Long> {
}
