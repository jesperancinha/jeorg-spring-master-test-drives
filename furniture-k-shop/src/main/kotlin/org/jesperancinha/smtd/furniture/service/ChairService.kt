package org.jesperancinha.smtd.furniture.service

import org.jesperancinha.smtd.furniture.exceptions.ChairException
import org.jesperancinha.smtd.furniture.model.Chair
import org.jesperancinha.smtd.furniture.repository.ChairRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation.REQUIRES_NEW
import org.springframework.transaction.annotation.Transactional

@Service
open class ChairService(
    open val chairRepository: ChairRepository
) {

    fun getAll(): MutableList<Chair> = chairRepository.findAll()

    fun getById(id: Long): Chair? = chairRepository.findByIdOrNull(id)

    @Transactional(readOnly = true, propagation = REQUIRES_NEW)
    open fun insertChair(chair: Chair) = chairRepository.save(chair)

    @Transactional(
        readOnly = true,
        propagation = REQUIRES_NEW,
        rollbackFor = [ChairException::class]
    )
    open fun insertChairFail(chair: Chair): Nothing {
        chairRepository.save(chair)
        throw ChairException("fail!")
    }

    fun deleteChair(id: Long) = chairRepository.deleteById(id)

    fun updateChair(chair: Chair) = chairRepository.save(chair)

    fun weightOfAllChairs(): Long {
        val chairs = getAll()
        return chairs.map { it.weight }.fold(0L) { sum, item -> sum + (item ?: 0) }
    }
}