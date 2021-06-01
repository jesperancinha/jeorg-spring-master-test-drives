package org.jesperancinha.smtd.furniture.repository

import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.model.Chair
import org.springframework.data.jpa.repository.JpaRepository

interface CaseRepository : JpaRepository<Case, Long>