package org.jesperancinha.smtd.furniture.repository

import org.jesperancinha.smtd.furniture.model.Case
import org.springframework.data.jpa.repository.JpaRepository

interface CaseRepository : JpaRepository<Case, Long>