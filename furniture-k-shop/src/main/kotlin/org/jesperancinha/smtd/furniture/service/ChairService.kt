package org.jesperancinha.smtd.furniture.service

import org.jesperancinha.smtd.furniture.model.Chair
import org.jesperancinha.smtd.furniture.repository.ChairRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class ChairService {
    @Autowired
    lateinit var chairRepository: ChairRepository

    fun getAll(): MutableList<Chair> = chairRepository.findAll()

    fun getById(id: Long): Chair? = chairRepository.findByIdOrNull(id)

    @Transactional(readOnly = true)
    open fun insertChair(chair: Chair) = chairRepository.save(chair)

    fun deleteChair(id: Long) = chairRepository.deleteById(id)

    fun updateChair(chair: Chair) = chairRepository.save(chair)
}