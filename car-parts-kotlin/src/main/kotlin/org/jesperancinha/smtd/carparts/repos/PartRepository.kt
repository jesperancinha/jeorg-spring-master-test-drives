package org.jesperancinha.smtd.carparts.repos

import org.jesperancinha.smtd.carparts.model.jpa.Part
import org.springframework.data.jpa.repository.JpaRepository

interface PartRepository : JpaRepository<Part?, Long?>