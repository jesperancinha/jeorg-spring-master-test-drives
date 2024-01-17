package org.jesperancinha.smtd.carparts.services

import org.jesperancinha.smtd.carparts.model.jpa.Part
import org.jesperancinha.smtd.carparts.repos.PartRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PartServiceTimeout(private val partRepository: PartRepository) {
    fun createPart(part: Part): Part {
        return partRepository.save(part)
    }
}
